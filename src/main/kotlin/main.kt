import basket.domain.interactors.BasketGetBasketUseCase
import domain.shared.interactors.FacilityServiceId
import domain.shared.interactors.GetBasketUseCase
import domain.shared.interactors.SwitchFacilityServiceUseCase
import kotlinx.coroutines.runBlocking
import service.domain.interactors.BasketSwitchFacilityServiceUseCase

fun main(): Unit = runBlocking {
    // In :basket
    println("#----- Switch facility in :basket module. -----#")
    val basketSwitchFacilityServiceUseCase = BasketSwitchFacilityServiceUseCase() // Injected
    with(basketSwitchFacilityServiceUseCase(FacilityServiceId("ABC"))) { println(this) }
    println() ; println("#----- Get basket in :basket module. -----#")
    val basketGetBasketUseCase = BasketGetBasketUseCase()
    with(basketGetBasketUseCase()) { println(this) }

    // In any module that know from :domain-shared
    println() ; println("#----- Switch facility from ANY module. -----#")
    val switchFacilityServiceUseCase: SwitchFacilityServiceUseCase = BasketSwitchFacilityServiceUseCase() // Injected
    with(switchFacilityServiceUseCase(FacilityServiceId("DEF"))) { println(this) }
    println() ; println("#----- Get basket from ANY module. -----#")
    val getBasketUseCase: GetBasketUseCase = BasketGetBasketUseCase() // Injected
    with(getBasketUseCase()) { println(this) }
}