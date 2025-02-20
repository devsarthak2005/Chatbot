package com.masterborse.chatbot

sealed interface ChatBotUiState{
    data object Ideal : ChatBotUiState
    data object Loading : ChatBotUiState
    data class Success(val chatData:String):ChatBotUiState
    data class Error(val chatError:String):ChatBotUiState
}