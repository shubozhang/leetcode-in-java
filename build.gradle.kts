plugins {
    java
    groovy
}

group = "com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.spockframework:spock-core:2.1-groovy-3.0")
    testImplementation("org.codehaus.groovy:groovy-all:3.0.10")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}