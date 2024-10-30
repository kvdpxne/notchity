pluginManagement {

  repositories {
    gradlePluginPortal()

    mavenCentral()
    mavenLocal()
  }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {

  repositories {
    mavenCentral()
    mavenLocal()

    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
  }

  repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
}

rootProject.name = "notchity"

