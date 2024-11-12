plugins {
  id("java")
  id("maven-publish")
}

group = "me.kvdpxne"
version = "0.2.0"

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-engine:5.11.3")
}

val targetJavaVersion = 8

java {
  val javaVersion = JavaVersion.toVersion(targetJavaVersion)

  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion

  if (JavaVersion.current() < javaVersion) {
    toolchain.languageVersion = JavaLanguageVersion.of(targetJavaVersion)
  }
}

afterEvaluate {

  publishing {
    publications {
      register("mavenJava", MavenPublication::class) {
        from(components["java"])
      }
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

    options.compilerArgs.add("-Xlint:-options")
  }

  withType<Test> {
    useJUnitPlatform()
  }
}