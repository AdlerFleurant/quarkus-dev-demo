package org.acme.quarkus.inventory.resource

import io.quarkus.redis.client.RedisClient
import io.quarkus.redis.client.reactive.ReactiveRedisClient
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam


@Path("entry")
class EntryResource {

    @Inject
    lateinit var client: RedisClient

    @Inject
    lateinit var reactiveClient: ReactiveRedisClient

    @GET
    @Path("/{title}")
    fun get(@PathParam("title") title: String): Int {
        return client.get(title).toInteger()
    }

    @GET
    fun keys(): Uni<List<String>> {
        return reactiveClient
            .keys("*")
            .map { response ->
                response.map { it.toString() }
            }
    }
}