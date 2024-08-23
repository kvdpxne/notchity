plugins {
  id("java")
  id("maven-publish")
}

group = "me.kvdpxne"
version = "0.1.0"

dependencies {
  implementation("org.spigotmc:spigot-api:1.20.6-R0.1-SNAPSHOT")
}

val targetJavaVersion = 21

java {
  val javaVersion = JavaVersion.toVersion(targetJavaVersion)

  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion

  if (JavaVersion.current() < javaVersion) {
    toolchain.languageVersion = JavaLanguageVersion.of(targetJavaVersion)
  }
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

tasks {

  wrapper {
    distributionType = Wrapper.DistributionType.ALL
  }

  withType<JavaCompile> {
    if (10 <= targetJavaVersion || JavaVersion.current().isJava10Compatible) {
      options.release.set(targetJavaVersion)
    }
  }

  withType<Test> {
    useJUnitPlatform()
  }
}