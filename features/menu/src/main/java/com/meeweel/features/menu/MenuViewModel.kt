package com.meeweel.features.menu

import com.meeweel.base.MviViewModel
import com.meeweel.features.menu.MenuContract.Effect
import com.meeweel.features.menu.MenuContract.Event
import com.meeweel.features.menu.MenuContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(

) : MviViewModel<Event, State, Effect>() {

    override fun setInitialState() = State()

    override fun handleEvents(event: Event) {
        when (event) {

            else -> {}
        }
    }
}