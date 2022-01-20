package service.domain.interactors

import domain.shared.UseCaseWithParameterDelegate
import domain.shared.interactors.FacilityServiceId
import domain.shared.interactors.SwitchFacilityServiceUseCase
import kotlin.random.Random


class BasketSwitchFacilityServiceDelegate : UseCaseWithParameterDelegate<FacilityServiceId, Unit> {
    override suspend fun invoke(param: FacilityServiceId): Result<Unit> {
        println("Facility ID : ${param.id}")
        return if (Random.nextBoolean()) Result.failure(Throwable()) else Result.success(Unit)
    }
}

class BasketSwitchFacilityServiceUseCase : SwitchFacilityServiceUseCase(BasketSwitchFacilityServiceDelegate())
