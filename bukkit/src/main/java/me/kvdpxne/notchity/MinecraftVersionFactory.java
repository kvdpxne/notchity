package me.kvdpxne.notchity;

import org.bukkit.Bukkit;

final class MinecraftVersionFactory {

  MinecraftVersionFactory() {
  }

  static Version createMinecraftVersion() {
    return VersionParser.parseVersion(Bukkit.getBukkitVersion());
  }

  static Version createMinecraftRevision() {
    final String revision = Bukkit.getServer()
      .getClass()
      .getPackage()
      .getName()
      .split("\\.")[3];

    final String[] parts = revision.substring(1).split("_");
    if (parts.length != 3) {
      throw new IllegalArgumentException("");
    }

    return VersionParser.parseVersion(
      parts[0] + "." + parts[1] + "." + parts[2].substring(1)
    );
  }
}
