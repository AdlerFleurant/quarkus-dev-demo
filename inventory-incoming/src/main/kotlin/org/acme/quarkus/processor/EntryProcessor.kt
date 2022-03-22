package org.acme.quarkus.processor

import io.quarkus.logging.Log
import io.quarkus.redis.client.RedisClient
import io.vertx.core.json.JsonObject
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class EntryProcessor {

    @Inject
    lateinit var client: RedisClient

    @Incoming("entries")
    fun process(entry: JsonObject) {

        val title = entry.getString("name")
        val quantity = entry.getInteger("quantity")

        Log.info("Receiving $quantity of $title.")
        client.incrby(title, quantity.toString())
    }
}