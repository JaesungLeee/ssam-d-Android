package com.mashup.domain.repository

import com.mashup.domain.model.chat.ChatDetail
import kotlinx.coroutines.flow.Flow
import com.mashup.domain.model.ChatInfo
import com.mashup.domain.model.Chats
import com.mashup.domain.usecase.chat.GetChatsParam

interface ChatRepository {

    suspend fun getChatInfo(id: Long): ChatInfo

    suspend fun getChats(param: GetChatsParam): Chats

    fun getChatDetail(
        roomId: Long,
        chatId: Long
    ): Flow<ChatDetail>
}
