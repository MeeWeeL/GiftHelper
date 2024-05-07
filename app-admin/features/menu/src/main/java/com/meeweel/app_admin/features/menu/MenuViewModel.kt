package com.meeweel.app_admin.features.menu

import com.meeweel.app_admin.features.menu.MenuContract.Effect
import com.meeweel.app_admin.features.menu.MenuContract.Event
import com.meeweel.app_admin.features.menu.MenuContract.State
import com.meeweel.core.base.MviViewModel
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