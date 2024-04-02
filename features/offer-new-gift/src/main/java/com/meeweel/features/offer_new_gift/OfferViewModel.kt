package com.meeweel.features.offer_new_gift

import androidx.lifecycle.viewModelScope
import com.meeweel.core.base.MviViewModel
import com.meeweel.domain.api.SendOfferUseCase
import com.meeweel.features.offer_new_gift.OfferContract.Effect
import com.meeweel.features.offer_new_gift.OfferContract.Event
import com.meeweel.features.offer_new_gift.OfferContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(
    private val sendOffer: SendOfferUseCase,
) : MviViewModel<Event, State, Effect>() {

    override fun setInitialState() = State()

    override fun handleEvents(event: Event) {
        when (event) {
            is Event.OnChangeTitle -> setState { it.copy(title = event.value) }
            is Event.OnChangeDescription -> setState { it.copy(description = event.value) }
            is Event.OnChangePrice -> setState { it.copy(price = event.value) }
            is Event.OnChangeOzonUrl -> setState { it.copy(ozonUrl = event.value) }
            is Event.OnSetImage -> setState { it.copy(image = event.bitmap) }
            Event.OnSendOffer -> handleSendOffer()
        }
    }

    private fun handleSendOffer() {
        viewModelScope.launch(Dispatchers.IO) {
            val state = state.value
            sendOffer.invoke(
                title = state.title,
                description = state.description,
                price = state.price.toInt(),
                ozonUrl = state.ozonUrl,
                image = state.image,
            )
        }
    }
}