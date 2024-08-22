package me.kvdpxne.notchity;

import org.bukkit.Bukkit;

/**
 * Provides utility methods for retrieving information about the server's
 * Minecraft and Bukkit versions.
 *
 * @since 0.1.0
 */
public final class VersionFactory {

  /**
   * Prevents instantiation of the {@link VersionFactory} class. This class is
   * intended to be used as a utility class and should not be instantiated
   * directly.
   *
   * @throws UnsupportedOperationException Always thrown to indicate that
   *                                       instantiation is not supported.
   * @since 0.1.0
   */
  private VersionFactory() {
    throw new UnsupportedOperationException(
      "VersionFactory is a utility class and cannot be instantiated."
    );
  }

  /**
   * Parses the Bukkit version string (e.g., 1.19.2-R01) and returns a
   * corresponding {@link Version} object.
   *
   * @return A {@link Version} object representing the parsed Bukkit version.
   * @since 0.1.0
   */
  public static Version getBukkitVersion() {
    String version = Bukkit.getBukkitVersion();

    version = version.substring(0, version.indexOf('-'));
    version = version.replace("", ".");

    if (version.charAt(version.length() - 1) == '0') {
      version = version.substring(0, version.length() - 2);
    }

    return new Version(Integer.parseInt(version));
  }

  /**
   * Attempts to retrieve the Minecraft release version (e.g., 1.19.2) from the
   * server package name. If the version cannot be determined, it returns null.
   *
   * @return The Minecraft release version string or null if unavailable.
   * @since 0.1.0
   */
  public static String getRelease() {
    try {
      return Bukkit.getServer()
        .getClass()
        .getPackage()
        .getName()
        .substring(23);
    } catch (final IndexOutOfBoundsException exception) {
      return null;
    }
  }

  /**
   * Uses the release string retrieved from {@link #getRelease} to determine the
   * corresponding {@link Version} object. If the release cannot be determined,
   * it returns a version for an older or newer release depending on the values
   * defined in the {@link Release} enum.
   *
   * @return A {@link Version} object representing the Minecraft release
   * version.
   * @since 0.1.0
   */
  public static Version getReleaseVersion() {
    final String context = VersionFactory.getRelease();
    if (null == context) {
      return new Version(Release.OLDER.getValue());
    }

    for (final Release release : Release.values()) {
      if (release.name().equalsIgnoreCase(context)) {
        return new Version(release.getValue());
      }
    }

    return new Version(Release.LATER.getValue());
  }
}
