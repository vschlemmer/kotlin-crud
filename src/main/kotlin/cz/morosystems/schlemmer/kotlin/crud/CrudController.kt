package cz.morosystems.schlemmer.kotlin.crud

import cz.morosystems.schlemmer.kotlin.crud.entity.Person
import cz.morosystems.schlemmer.kotlin.crud.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController @Autowired constructor(
        private val personRepository: PersonRepository
) {

    @PostMapping
    fun addPerson(@RequestParam(value = "name", defaultValue = "Unnamed") name: String) {
        personRepository.save(Person(name = name))
    }

    @GetMapping
    fun getPersons(): List<Person> {
        return personRepository.findAll()
    }

    @GetMapping("/{personId}")
    fun getPerson(@PathVariable(name = "personId") personId: Long): Person? {
        return personRepository.findById(personId)
                .orElse(null)
    }
}
