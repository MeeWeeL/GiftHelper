package com.meeweel.features.search

import androidx.lifecycle.viewModelScope
import com.meeweel.base.MviViewModel
import com.meeweel.domain.api.GetGiftListUseCase
import com.meeweel.domain.models.LoadResult
import com.meeweel.features.search.SearchContract.Effect
import com.meeweel.features.search.SearchContract.Event
import com.meeweel.features.search.SearchContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getGiftList: GetGiftListUseCase,
) : MviViewModel<Event, State, Effect>() {

    override fun setInitialState() = State()

    init {
        viewModelScope.launch {
            when (val result = getGiftList.invoke()) {
                is LoadResult.Done -> setState { it.copy(giftList = result.result) }
                is LoadResult.Error -> setEffect { Effect.ShowErrorMessage(result.message) }
                else -> setEffect { Effect.ShowErrorMessage("Unknown error") }
            }
        }
    }

    override fun handleEvents(event: Event) {
        when (event) {

            else -> {}
        }
    }
}