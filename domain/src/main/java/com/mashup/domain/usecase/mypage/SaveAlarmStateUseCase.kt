package com.mashup.domain.usecase.mypage

import com.mashup.domain.repository.UserRepository
import com.mashup.domain.usecase.BaseUseCase

class SaveAlarmStateUseCase(
    private val userRepository: UserRepository
): BaseUseCase<Boolean, Result<Unit>>() {
    override suspend fun invoke(param: Boolean): Result<Unit> {
        return runCatching {
            userRepository.patchAlarm(isAgree = param)
        }
    }
}