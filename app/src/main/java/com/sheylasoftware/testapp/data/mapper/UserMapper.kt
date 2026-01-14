package com.sheylasoftware.testapp.data.mapper

import com.sheylasoftware.testapp.data.model.UserDto
import com.sheylasoftware.testapp.domain.model.User

fun UserDto.toDomain(): User? {
    /*
     Reglas:
     - Si id, fullName o age son null → devolver null
     - Mapear fullName → name
     - NO lanzar excepciones
     */
    return if (id != null && fullName != null && age != null) {
        User(id = id, name = fullName, age = age)
    } else {
        null
    }
}