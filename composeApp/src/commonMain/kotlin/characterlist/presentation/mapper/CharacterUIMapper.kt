package characterlist.presentation.mapper

import characterlist.domain.model.CharacterModel
import characterlist.domain.model.InfoModel
import characterlist.domain.model.LocationModel
import characterlist.domain.model.OriginModel
import characterlist.domain.model.ResultModel
import characterlist.presentation.model.CharacterUIModel
import characterlist.presentation.model.InfoUIModel
import characterlist.presentation.model.LocationUIModel
import characterlist.presentation.model.OriginUIModel
import characterlist.presentation.model.ResultUIModel


fun CharacterModel.toCharacterUIModel() = CharacterUIModel(
    info = info.toInfoUIModel(),
    results = results.map { it.toResultUIModel() }
)

fun OriginModel.toOriginUIModel() = OriginUIModel(
    name = name,
    url = url
)

fun LocationModel.toLocationUIModel() = LocationUIModel(
    name = name,
    url = url
)

fun ResultModel.toResultUIModel() = ResultUIModel(
    id = id,
    created = created,
    episode = episode,
    gender = gender,
    image = image,
    location = location.toLocationUIModel(),
    name = name,
    origin = origin.toOriginUIModel(),
    species = species,
    status = status,
    type = type,
    url = url
)

fun InfoModel.toInfoUIModel() = InfoUIModel(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)