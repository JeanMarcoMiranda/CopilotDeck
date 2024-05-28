package com.mrmisti.prueba.presentation.login

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.store.create
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class LoginViewState(
    val displayText: String = ""
)

sealed class LoginIntent {
    data class EnterNumber(val number: Int) : LoginIntent()
    object DeleteLastNumber : LoginIntent()
}

interface LoginStore: Store<LoginIntent, LoginViewState, Nothing>

class LoginStoreFactory(
    private val storeFactory: StoreFactory
) {
    private sealed interface Msg {
        class Value(val displayText: String) : Msg
    }


    fun create(): LoginStore {
        return object : LoginStore, Store<LoginIntent, LoginViewState, Nothing> by storeFactory.create(
            name = "LoginStore",
            initialState = LoginViewState(),
            bootstrapper = BootstrapperImpl(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}
    }

    private object ReducerImpl : Reducer<LoginViewState, Msg> {
        override fun LoginViewState.reduce(msg: Msg): LoginViewState =
            when (msg) {
                is Msg.Value -> copy(displayText = msg.displayText)
            }
    }

    private sealed interface Action {
        class SetValue(val value: Int): Action
    }
    private class BootstrapperImpl : CoroutineBootstrapper<Action>() {
        override fun invoke() {
            scope.launch {
                val initialText = withContext(Dispatchers.Default) {
                    (20)
                }
                dispatch(Action.SetValue(initialText))
            }
        }
    }

    private class ExecutorImpl : CoroutineExecutor<LoginIntent, Action, LoginViewState, Msg, Nothing>() {
        override fun executeAction(action: Action) {
            when (action) {
                is Action.SetValue -> dispatch(Msg.Value("${action.value}"))
            }
        }
        override fun executeIntent(intent: LoginIntent) {
            when (intent) {
                is LoginIntent.EnterNumber -> enterNumber(intent.number)
                is LoginIntent.DeleteLastNumber -> dispatch(Msg.Value(state().displayText.dropLast(1)))
            }
        }

        private fun enterNumber(number: Int) {
            scope.launch {
                val state = state()
                val displayText = withContext(Dispatchers.Default) { state.displayText + number }
                dispatch(Msg.Value(displayText))
            }
        }
    }
}
