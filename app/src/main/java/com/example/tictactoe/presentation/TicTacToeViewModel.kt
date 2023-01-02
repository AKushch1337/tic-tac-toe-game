package com.example.tictactoe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tictactoe.data.GameState
import com.example.tictactoe.data.RealTimeMessagingClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class TicTacToeViewModel @Inject constructor(
    private val client: RealTimeMessagingClient
): ViewModel() {

    val state = client
        .getGameStateStream()
        .onStart { _isConnecting.value = true }
        .onEach { _isConnecting.value = false }
        .catch { t -> _showConnectionError.value = t is ConnectException }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), GameState())

    private val _isConnecting = MutableStateFlow(false)
    val isConnecting = _isConnecting.asStateFlow()

    private val _showConnectionError = MutableStateFlow(false)
    val showConnectionError = _showConnectionError.asStateFlow()
}
