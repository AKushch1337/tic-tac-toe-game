package com.example.tictactoe.data

import io.ktor.client.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.http.cio.websocket.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class KtorRealTimeMessagingClient(
    private val client: HttpClient,
) : RealTimeMessagingClient {

    private var session: WebSocketSession? = null

    // Listen to websocket messages

    override fun getGameStateStream(): Flow<GameState> {
        return flow {
            session = client.webSocketSession {
                url("ws://192.168.0.168:8080/play")
            }
            val gameStates = session!!
                .incoming
                .consumeAsFlow()
                .filterIsInstance<Frame.Text>()
                .mapNotNull { Json.decodeFromString<GameState>(it.readText()) }

            emitAll(gameStates)
        }
    }

    // Function to send something to server

    override suspend fun sendAction(action: MakeTurn) {
        session?.outgoing?.send(
            Frame.Text("make_turn#${Json.encodeToString(action)}")
        )
    }

    // Close our connection

    override suspend fun close() {
        session?.close()
        session = null
    }
}