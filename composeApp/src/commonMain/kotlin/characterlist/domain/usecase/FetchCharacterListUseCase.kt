package characterlist.domain.usecase

import characterlist.domain.model.CharacterModel
import characterlist.domain.repository.CharacterListRepository
import common.Outcome
import kotlinx.coroutines.flow.Flow

class FetchCharacterListUseCase(
    private val repository: CharacterListRepository
) {
    operator fun invoke(): Flow<Outcome<CharacterModel>> {
        return repository.getAllCharacterListRemote()
    }
}