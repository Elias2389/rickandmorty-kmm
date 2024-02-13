package characterlist.data.service

import characterlist.data.model.CharacterResponse
import de.jensklingenberg.ktorfit.Response
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

interface CharacterService {
    /**
     * Get all characters from API
     */
    @GET("character")
    suspend fun getAllCharacters(
    ): Response<CharacterResponse>

    /**
     * Get character by id characters from API
     */
    @GET("character/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int
    ): Response<CharacterResponse>
}