package characterlist.presentation.model


sealed class ErrorTypeUI {
    data object GeneralError : ErrorTypeUI()
    data object None : ErrorTypeUI()
}
