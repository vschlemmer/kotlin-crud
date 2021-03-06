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

    @GetMapping
    fun getAll(): List<Person> {
        return personRepository.findAll()
    }

    @GetMapping("/{personId}")
    fun get(@PathVariable(name = "personId") personId: Long): Person? {
        return personRepository.findById(personId)
                .orElse(null)
    }

    @PostMapping
    fun add(@RequestParam(value = "name", defaultValue = "Unnamed") name: String) {
        personRepository.save(Person(name = name))
    }

    @PutMapping("/{personId}")
    fun update(@PathVariable(name = "personId") personId: Long, @RequestParam(value = "name", defaultValue = "Unnamed") name: String) {
        personRepository.findById(personId).ifPresent {
            it.name = name
            personRepository.save(it)
        }
    }
}
