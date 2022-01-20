package basket.domain.interactors

import domain.shared.UseCaseDelegate
import domain.shared.interactors.Basket
import domain.shared.interactors.GetBasketUseCase


class BasketGetBasketDelegate : UseCaseDelegate<Basket> {
    override suspend fun invoke() : Result<Basket> {
        println("Basket 1234567")
        return Result.success(Basket("1234567"))
    }
}

class BasketGetBasketUseCase : GetBasketUseCase(BasketGetBasketDelegate())
