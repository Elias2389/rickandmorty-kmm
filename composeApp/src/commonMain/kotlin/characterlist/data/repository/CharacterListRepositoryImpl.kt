package characterlist.data.repository

import characterlist.data.datasource.CharacterListRemoteDataSource
import characterlist.domain.model.CharacterModel
import characterlist.domain.repository.CharacterListRepository
import common.Outcome
import kotlinx.coroutines.flow.Flow


class CharacterListRepositoryImpl(
    private val dataSource: CharacterListRemoteDataSource
) : CharacterListRepository {
    override fun getAllCharacterListRemote(): Flow<Outcome<CharacterModel>> =
        dataSource.getAllCharacterListRemote()
}