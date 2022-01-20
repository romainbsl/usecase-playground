package service.domain.interactors

import domain.shared.interactors.FacilityServiceId
import domain.shared.interactors.SwitchFacilityServiceUseCase
import kotlin.random.Random

class BasketSwitchFacilityServiceUseCase : SwitchFacilityServiceUseCase {
    override suspend fun invoke(facilityServiceId: FacilityServiceId): Result<Unit> {
        println("Facility ID : ${facilityServiceId.id}")
        return if (Random.nextBoolean()) Result.failure(Throwable()) else Result.success(Unit)
    }
}
