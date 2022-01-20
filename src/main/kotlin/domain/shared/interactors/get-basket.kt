package domain.shared.interactors

import domain.shared.UseCase

abstract class GetBasketUseCase(execute: suspend () -> Result<Basket>)
    : UseCase<Basket>(execute)

data class Basket(val id: String)
