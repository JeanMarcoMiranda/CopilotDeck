package com.example.pruebatheming.presentation.home

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.example.pruebatheming.designsystem.theme.AppTheme

data class HomeViewState(
    val isDarkTheme: Boolean = false,
    val selectExpanded: Boolean = false,
    val selectedTheme: AppTheme = AppTheme.Jacket
)

sealed class HomeIntent {
    data class OnSelectTheme(val theme: AppTheme) : HomeIntent()
    object ToggleDarkTheme : HomeIntent()
    object ToggleSelect : HomeIntent()
}

interface HomeStore: Store<HomeIntent, HomeViewState, Nothing>

class HomeStoreFactory(
    private val storeFactory: StoreFactory
) {
    private sealed interface Msg {
        data object IsDarkTheme : Msg
        data object IsSelectThemeExpanded : Msg
        class SelectedTheme(val theme: AppTheme) : Msg
    }

    fun create(): HomeStore {
        return object : HomeStore, Store<HomeIntent, HomeViewState, Nothing> by storeFactory.create(
            name = "HomeStore",
            initialState = HomeViewState(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}
    }

    private class ExecutorImpl: CoroutineExecutor<HomeIntent, Nothing, HomeViewState, Msg, Nothing>() {
        override fun executeIntent(intent: HomeIntent) {
            when(intent) {
                is HomeIntent.ToggleDarkTheme -> dispatch(Msg.IsDarkTheme)
                is HomeIntent.ToggleSelect -> dispatch(Msg.IsSelectThemeExpanded)
                is HomeIntent.OnSelectTheme -> dispatch(Msg.SelectedTheme(intent.theme))
            }
        }
    }

    private object ReducerImpl : Reducer<HomeViewState, Msg> {
        override fun HomeViewState.reduce(msg: Msg): HomeViewState =
            when (msg) {
                is Msg.SelectedTheme -> copy(selectedTheme = msg.theme)
                is Msg.IsDarkTheme -> copy(isDarkTheme = !isDarkTheme)
                is Msg.IsSelectThemeExpanded -> copy(selectExpanded = !selectExpanded)
            }
    }
}