package basket.domain.interactors

import domain.shared.interactors.Basket
import domain.shared.interactors.GetBasketUseCase

class BasketGetBasketUseCase : GetBasketUseCase {
    override suspend fun invoke(): Result<Basket> {
        println("Basket 1234567")
        return Result.success(Basket("1234567"))
    }
}
