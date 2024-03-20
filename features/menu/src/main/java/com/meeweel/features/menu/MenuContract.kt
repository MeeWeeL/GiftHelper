package com.meeweel.features.menu

import com.meeweel.base.MviEffect
import com.meeweel.base.MviEvent
import com.meeweel.base.MviState

object MenuContract {

    sealed interface Event : MviEvent

    data class State(
        val advertising: String? = null,
    ) : MviState

    sealed interface Effect : MviEffect {
        data class ShowErrorMessage(val message: String) : Effect
        sealed interface Navigate : Effect
    }
}