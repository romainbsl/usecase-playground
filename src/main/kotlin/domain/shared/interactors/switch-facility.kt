package domain.shared.interactors

import domain.shared.UseCaseWithParameter

abstract class SwitchFacilityServiceUseCase(execute: suspend (FacilityServiceId) -> Result<Unit>)
    : UseCaseWithParameter<FacilityServiceId, Unit>(execute)

@JvmInline
value class FacilityServiceId(val id: String)
