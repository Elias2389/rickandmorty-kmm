package characterlist.data.datasource

import characterlist.domain.model.CharacterModel
import common.Outcome
import kotlinx.coroutines.flow.Flow

interface CharacterListRemoteDataSource {
    /**
     * Method to get all Characters with paged from remote service
     *
     * @return Response from API
     */
    fun getAllCharacterListRemote(): Flow<Outcome<CharacterModel>>
}