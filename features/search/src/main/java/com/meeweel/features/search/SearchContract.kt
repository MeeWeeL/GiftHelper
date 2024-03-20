package com.meeweel.features.search

import com.meeweel.base.MviEffect
import com.meeweel.base.MviEvent
import com.meeweel.base.MviState
import com.meeweel.domain.models.Gift

object SearchContract {

    sealed interface Event : MviEvent

    data class State(
        val giftList: List<Gift>? = null,
    ) : MviState

    sealed interface Effect : MviEffect {
        data class ShowErrorMessage(val message: String) : Effect
        sealed interface Navigate : Effect
    }
}