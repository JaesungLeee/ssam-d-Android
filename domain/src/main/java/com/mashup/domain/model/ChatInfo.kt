package com.mashup.domain.model

import com.mashup.domain.base.DomainModel

data class ChatInfo(
    val id: Long,
    val keywords: List<String>,
    val matchingUserName: String,
    val matchingUserProfileImage: String,
    val chatColor: String,
    val isAlive: Boolean
) : DomainModel

data class Chat(
    val id: Long,
    val content: String,
    val senderName: String,
    val receivedTimeMillis: Long,
    val chatColor: String,
    val isMine: Boolean
) : DomainModel
