package domain.shared.interactors

import domain.shared.core.UseCaseWithParameter

interface SwitchFacilityServiceUseCase : UseCaseWithParameter<FacilityServiceId, Unit>

@JvmInline
value class FacilityServiceId(val id: String)
