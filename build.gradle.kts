plugins {
  id("java")
  id("maven-publish")
}

group = "me.kvdpxne"
version = "0.1"

dependencies {
  implementation("org.spigotmc:spigot-api:1.20.6-R0.1-SNAPSHOT")
}

publishing {
  publications {
    register("mavenJava", MavenPublication::class) {
      groupId = "me.kvdpxne"
      artifactId = "notchity"
      version = "0.1.0"

      from(components["java"])
    }
  }
}

tasks.test {
  useJUnitPlatform()
}