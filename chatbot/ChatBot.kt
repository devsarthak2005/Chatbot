package com.masterborse.chatbot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masterborse.chatbot.components.ChatFooter
import com.masterborse.chatbot.components.ChatHeader
import com.masterborse.chatbot.components.ChatList

@Composable
fun ChatBot(
     viewModel: ChatBotVM = viewModel()
)
{
Column(
    verticalArrangement = Arrangement.Center
    , horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize()
) {
ChatHeader()
    Box(modifier = Modifier.weight(1f),
        contentAlignment = Alignment.Center
        ){
        ChatList(list = viewModel.list)

    }
ChatFooter {
     if(it.isNotEmpty()){
        viewModel.sendMessage(it)
     }
}
}
}