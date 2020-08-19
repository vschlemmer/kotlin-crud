package cz.morosystems.schlemmer.kotlin.crud.repository

import cz.morosystems.schlemmer.kotlin.crud.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {

    fun getByName(name: String): List<Person>
}
