plugins {
    id("quarkus-conventions")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("io.quarkus:quarkus-smallrye-reactive-messaging-amqp")
    implementation("io.quarkus:quarkus-scheduler")
    implementation("com.github.javafaker:javafaker:1.0.2"){
        exclude(group = "org.yaml")
    }
    implementation("org.yaml:snakeyaml:1.30")
}

group = "org.acme"
version = "1.0.0"
