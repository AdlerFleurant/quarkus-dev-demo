package org.acme.quarkus.inventory.generator

import com.github.javafaker.Faker
import io.quarkus.logging.Log
import io.quarkus.scheduler.Scheduled
import org.acme.quarkus.inventory.entity.Entry
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import javax.enterprise.context.ApplicationScoped
import kotlin.random.Random

@ApplicationScoped
class EntryGenerator {

    @Channel("entries")
    lateinit var emitter: Emitter<Entry>
    private val faker = Faker()

    @Scheduled(every = "10s")
    fun generate() {
        val entry = Entry(faker.book().title(), Random.nextInt(1, 10))
        Log.info("Generated book entry title: ${entry.name}, quantity: ${entry.quantity}")
        emitter.send(entry)
    }
}