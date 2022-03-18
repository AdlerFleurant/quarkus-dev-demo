package org.acme.quarkus.processor

import io.quarkus.redis.client.RedisClient
import org.acme.quarkus.inventory.Entry
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class EntryProcessor {

    @Inject
    lateinit var client: RedisClient

    @Incoming("entries")
    fun process(entry: Entry) {
        client.incrby(entry.name, entry.quantity.toString())
    }
}