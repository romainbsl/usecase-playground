package domain.shared.interactors

import domain.shared.core.UseCase

interface GetBasketUseCase : UseCase<Basket>

data class Basket(val id: String)
