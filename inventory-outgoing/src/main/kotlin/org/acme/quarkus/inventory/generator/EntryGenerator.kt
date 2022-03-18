package org.acme.quarkus.inventory.generator

import com.github.javafaker.Faker
import io.quarkus.logging.Log
import io.quarkus.scheduler.Scheduled
import org.acme.quarkus.inventory.entity.Entry
import org.eclipse.microprofile.reactive.messaging.Outgoing
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class EntryGenerator {

    private val faker = Faker()
    private val random = Random()

    @Outgoing("entries")
    @Scheduled(every = "10s")
    fun generate(): Entry {
        val entry = Entry(faker.book().title(), random.nextInt(1, 10))
        Log.info("Generated book entry title: ${entry.name}, quantity: ${entry.quantity}")
        return entry
    }
}