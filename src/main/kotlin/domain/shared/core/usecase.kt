package domain.shared.core

interface UseCase<R> : suspend () -> Result<R>
interface UseCaseWithParameter<P, R> : suspend (P) -> Result<R>