package domain.shared

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<R>(private val execute : UseCaseDelegate<R>) {
    suspend operator fun invoke(): Result<R> = runCatching {
        withContext(Dispatchers.IO) {
            println("Execute on I/O dispatcher.")
            execute().getOrThrow()
        }
    }
}

interface UseCaseDelegate<R> : suspend () -> Result<R> {
    override suspend fun invoke() : Result<R>
}

abstract class UseCaseWithParameter<P, R>(private val execute : UseCaseWithParameterDelegate<P, R>) {
    suspend operator fun invoke(param: P): Result<R> = runCatching {
        withContext(Dispatchers.IO) {
            println("Execute on I/O dispatcher.")
            execute(param).getOrThrow()
        }
    }
}

interface UseCaseWithParameterDelegate<P, R> : suspend (P) -> Result<R> {
    override suspend fun invoke(param: P) : Result<R>
}