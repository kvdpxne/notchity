plugins {
  id("java")
}

group = "me.kvdpxne"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  mavenLocal()

  maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}
dependencies {
  implementation("org.spigotmc:spigot-api:1.20.6-R0.1-SNAPSHOT")
}

tasks.test {
  useJUnitPlatform()
}