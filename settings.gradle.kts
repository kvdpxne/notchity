pluginManagement {

  repositories {
    gradlePluginPortal()

    mavenCentral()
    mavenLocal()
  }
}

dependencyResolutionManagement {

  repositories {
    mavenCentral()
    mavenLocal()

    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
  }
}

rootProject.name = "notchity"

