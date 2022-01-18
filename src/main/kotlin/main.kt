import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    // In :basket
    val basketSwitchFacilityServiceUseCase = BasketSwitchFacilityServiceUseCase() // Injected
    basketSwitchFacilityServiceUseCase(FacilityServiceId("ABC"))

    // In any module that know from :domain-shared
    val switchFacilityServiceUseCase: SwitchFacilityServiceUseCase  = BasketSwitchFacilityServiceUseCase() // Injected
    switchFacilityServiceUseCase(FacilityServiceId("DEF"))

    val useCase: UseCaseWithParameter<FacilityServiceId, Unit>  = BasketSwitchFacilityServiceUseCase() // Injected
    useCase(FacilityServiceId("GHI"))

    val iUseCase: IUseCaseWithParameter<FacilityServiceId, Unit>  = BasketSwitchFacilityServiceUseCase() // Injected
    iUseCase(FacilityServiceId("JKL"))
}

/*
    In :basket
 */
class BasketSwitchFacilityServiceUseCase : UseCaseWithParameter<FacilityServiceId, Unit>(), SwitchFacilityServiceUseCase {
    override suspend fun execute(param: FacilityServiceId) {
        println(param.id)
        throw Throwable()
    }
}

/*
    In :domain-shared
 */
interface SwitchFacilityServiceUseCase : IUseCaseWithParameter<FacilityServiceId, Unit>

@JvmInline
value class FacilityServiceId(val id: String)

/*
    In :shared
 */
abstract class UseCaseWithParameter<P, R> : IUseCaseWithParameter<P, R> {
    final override suspend operator fun invoke(param: P): Result<R> = runCatching {
        withContext(Dispatchers.IO) {
            println("Execute on I/O dispatcher.")
            execute(param)
        }
    }
}

interface IUseCaseWithParameter<P, R> {
    suspend operator fun invoke(param: P): Result<R>
    suspend fun execute(param: P): R
}