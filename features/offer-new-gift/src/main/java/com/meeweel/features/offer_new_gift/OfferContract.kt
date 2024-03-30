package com.meeweel.features.offer_new_gift

import android.graphics.Bitmap
import androidx.core.graphics.BitmapCompat
import com.meeweel.base.MviEffect
import com.meeweel.base.MviEvent
import com.meeweel.base.MviState

object OfferContract {

    sealed interface Event : MviEvent {
        data object OnSendOffer : Event
        data class OnChangeTitle(val value: String, ) : Event
        data class OnChangeDescription(val value: String, ) : Event
        data class OnChangePrice(val value: String, ) : Event
        data class OnChangeOzonUrl(val value: String, ) : Event
        data class OnSetImage(val bitmap: Bitmap?) : Event
    }

    data class State(
        val title: String = "",
        val description: String = "",
        val price: String = "",
        val image: Bitmap? = null,
        val ozonUrl: String = "",
    ) : MviState

    sealed interface Effect : MviEffect {
        data object ShowOfferSent : Effect
        data class ShowErrorMessage(val message: String) : Effect
        sealed interface Navigate : Effect
    }
}