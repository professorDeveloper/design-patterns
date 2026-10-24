plugins {
    kotlin("jvm") version "2.4.10"
    // Hibernate/JPA entity'lari uchun no-arg konstruktor va open klasslar
    kotlin("plugin.jpa") version "2.4.10"
}

group = "uz.azamov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

val exposedVersion = "1.6.0"
val hibernateVersion = "7.4.13.Final"
val ktormVersion = "4.2.1"
val jdbiVersion = "3.55.0"

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.5.0")

    // JDBC drayverlar
    implementation("org.postgresql:postgresql:42.7.14")
    implementation("com.mysql:mysql-connector-j:26.7.0")
    implementation("org.xerial:sqlite-jdbc:3.53.4.0")
    implementation("com.h2database:h2:2.5.252")

    // Connection pool
    implementation("com.zaxxer:HikariCP:7.1.0")

    // ORM: Exposed (JetBrains, Kotlin uchun)
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")

    // ORM: Hibernate (JPA)
    implementation("org.hibernate.orm:hibernate-core:$hibernateVersion")
    implementation("org.hibernate.orm:hibernate-hikaricp:$hibernateVersion")

    // ORM: Ktorm
    implementation("org.ktorm:ktorm-core:$ktormVersion")
    implementation("org.ktorm:ktorm-support-postgresql:$ktormVersion")

    // SQL mapper: JDBI
    implementation("org.jdbi:jdbi3-kotlin:$jdbiVersion")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:$jdbiVersion")
    implementation("org.jdbi:jdbi3-postgres:$jdbiVersion")

    // Log (Hibernate, Hikari, Exposed SLF4J ishlatadi)
    implementation("org.slf4j:slf4j-simple:2.0.20")

    testImplementation(kotlin("test"))

}

kotlin {
    jvmToolchain(25)
    // Loyiha manbalari src/ ichida (src/main/kotlin emas)
    sourceSets.main {
        kotlin.srcDirs("src")
    }
}

tasks.test {
    useJUnitPlatform()
}
