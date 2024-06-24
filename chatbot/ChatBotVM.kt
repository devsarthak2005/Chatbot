package com.masterborse.chatbot

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotVM : ViewModel(){
    val list by lazy {
        mutableStateListOf<ChatData>()
    }
    private val genAI by lazy {

        GenerativeModel(
            modelName = "gemini-pro", apiKey = "AIzaSyBNiyhG7A34SQnBazPbROouENj8VlmFPGk"
        )

    }

    fun sendMessage(message: String)= viewModelScope.launch {
        val chat = genAI.startChat()

        list.add(ChatData(message,ChatRoleEnum.USER.role))

        chat.sendMessage(
                content(ChatRoleEnum.USER.role){
                    text(message)
                }
        ).text?.let {
            list.add(ChatData(it,ChatRoleEnum.MODEL.role))
        }
    }


}