package characterlist.data.mapper

import characterlist.data.model.CharacterResponse
import characterlist.data.model.InfoResponse
import characterlist.data.model.LocationResponse
import characterlist.data.model.OriginResponse
import characterlist.data.model.ResultResponse
import characterlist.domain.model.CharacterModel
import characterlist.domain.model.InfoModel
import characterlist.domain.model.LocationModel
import characterlist.domain.model.OriginModel
import characterlist.domain.model.ResultModel


fun CharacterResponse.toCharacterModel() = CharacterModel(
    info = info.toInfoModel(),
    results = results.map { it.toResultModel() }
)

fun OriginResponse.toOriginModel() = OriginModel(
    name = name,
    url = url
)

fun LocationResponse.toLocationModel() = LocationModel(
    name = name,
    url = url
)

fun ResultResponse.toResultModel() = ResultModel(
    id = id,
    created = created,
    episode = episode,
    gender = gender,
    image = image,
    location = location.toLocationModel(),
    name = name,
    origin = origin.toOriginModel(),
    species = species,
    status = status,
    type = type,
    url = url
)

fun InfoResponse.toInfoModel() = InfoModel(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)