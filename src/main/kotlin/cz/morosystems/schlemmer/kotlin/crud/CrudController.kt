package cz.morosystems.schlemmer.kotlin.crud

import cz.morosystems.schlemmer.kotlin.crud.entity.Person
import cz.morosystems.schlemmer.kotlin.crud.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

@RestController
class CrudController @Autowired constructor(
        private val personRepository: PersonRepository
) {

    private val counter = AtomicLong()
    private val personId = AtomicInteger()

    @GetMapping("/crud")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            println("hello $name " + counter.incrementAndGet())

    @PostMapping("/add-person")
    fun addPerson(@RequestParam(value = "name", defaultValue = "Vojta") name: String) {
        val person = Person(personId.incrementAndGet(), name)
        personRepository.save(person)
    }

    @GetMapping("/get-persons")
    fun getPersons() {
        personRepository.findAll().forEach {
            println("person: ${it.id} - ${it.name}")
        }
    }
}
