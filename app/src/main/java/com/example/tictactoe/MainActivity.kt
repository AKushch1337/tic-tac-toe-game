package com.example.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tictactoe.presentation.TicTacToeViewModel
import com.example.tictactoe.ui.theme.TicTacToeGameTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeGameTheme {
                val viewModel = hiltViewModel<TicTacToeViewModel>()
                val state by viewModel.state.collectAsState()
                val isConnecting by viewModel.isConnecting.collectAsState()
                val showConnectionError by viewModel.showConnectionError.collectAsState()

                if (showConnectionError) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Couldn't connect to the server",
                            color = MaterialTheme.colors.error
                        )
                    }
                    return@TicTacToeGameTheme
                }
                }
            }
        }
    }
