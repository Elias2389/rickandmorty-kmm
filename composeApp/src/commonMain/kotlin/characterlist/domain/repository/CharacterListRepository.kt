package characterlist.domain.repository

import characterlist.domain.model.CharacterModel
import common.Outcome
import kotlinx.coroutines.flow.Flow

interface CharacterListRepository {

    fun getAllCharacterListRemote(): Flow<Outcome<CharacterModel>>
}