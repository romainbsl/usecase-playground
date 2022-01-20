package basket.domain.interactors

import domain.shared.interactors.GetBasketCountUseCase

class BasketGetBasketCountUseCase : GetBasketCountUseCase {
    override suspend fun invoke(): Result<Int> {
        return Result.success(10)
    }
}