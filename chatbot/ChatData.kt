package com.masterborse.chatbot


    data class ChatData(var message : String ,var role:String)


enum class ChatRoleEnum(val role:String)
{
    USER("user"),
    MODEL("model")


}