package characterlist.data.datasource

import characterlist.data.service.CharacterService
import characterlist.data.mapper.toCharacterModel
import characterlist.domain.model.CharacterModel
import common.ApiHandler
import common.Outcome
import common.Success
import common.mapSuccess
import common.onException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CharacterListRemoteDataSourceImpl(
    private val service: CharacterService
) : CharacterListRemoteDataSource, ApiHandler {
    override fun getAllCharacterListRemote(): Flow<Outcome<CharacterModel>> =
        flow {
//            val test = service.getAllCharacters()
            val response = handleApi { service.getAllCharacters() }
            emit(response)
        }.mapSuccess { it.toCharacterModel() }.onException()

}