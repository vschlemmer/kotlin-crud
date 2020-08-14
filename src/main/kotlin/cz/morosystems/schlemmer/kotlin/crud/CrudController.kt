package cz.morosystems.schlemmer.kotlin.crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class CrudController {

    private val counter = AtomicLong()

    @GetMapping("/crud")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
        println("hello $name " + counter.incrementAndGet())
}
