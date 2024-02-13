package core.di

import characterlist.data.datasource.CharacterListRemoteDataSource
import characterlist.data.datasource.CharacterListRemoteDataSourceImpl
import characterlist.data.repository.CharacterListRepositoryImpl
import characterlist.data.service.CharacterService
import characterlist.domain.repository.CharacterListRepository
import characterlist.domain.usecase.FetchCharacterListUseCase
import characterlist.presentation.viewmodel.CharacterViewModel
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun appModule() = module {
    single<CharacterService> {
        Ktorfit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .httpClient(HttpClient {
                install(ContentNegotiation) {
                    json(Json { isLenient = true; ignoreUnknownKeys = true })
                }
            })
            .build()
            .create<CharacterService>()
    }

    single<CharacterListRemoteDataSource> { CharacterListRemoteDataSourceImpl(service = get<CharacterService>()) }
    single<CharacterListRepository> { CharacterListRepositoryImpl(dataSource = get()) }
    single { FetchCharacterListUseCase(repository = get()) }
    factory { CharacterViewModel(useCase = get()) }
}