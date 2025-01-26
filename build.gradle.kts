plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hibernate.orm:hibernate-core:6.6.4.Final")
    implementation("com.zaxxer:HikariCP:3.4.5")
    implementation ("org.postgresql:postgresql:42.7.2")
    implementation("com.h2database:h2:2.2.224")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}