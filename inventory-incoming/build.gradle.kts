plugins {
    id("quarkus-conventions")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("io.quarkus:quarkus-smallrye-reactive-messaging-amqp")
    implementation("io.quarkus:quarkus-redis-client")
}

group = "org.acme"
version = "1.0.0"
