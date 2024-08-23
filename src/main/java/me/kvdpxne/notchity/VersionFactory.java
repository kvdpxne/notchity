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
   * Parses a version string in the format "major.minor.patch" and converts it
   * into an integer representation.
   * <p>
   * The integer is calculated as (major * 10 000) + (minor * 100) + (patch). If
   * the version string is invalid, an {@link IllegalArgumentException} is
   * thrown.
   *
   * @param version The version string to parse. It must not be null or empty
   *                and must follow the format "major.minor" or
   *                "major.minor.patch".
   * @return An integer representing the parsed version.
   * @throws IllegalArgumentException If the version string is null, empty, or
   *                                  not in a valid format.
   * @since 0.1.0
   */
  static int parseVersion(
    final String version
  ) {
    if (null == version || version.isEmpty()) {
      throw new IllegalArgumentException(
        "The given version must not be null or be empty."
      );
    }

    final String[] parts = version.split("\\.");
    if (2 > parts.length || 3 < parts.length) {
      throw new IllegalArgumentException(
        "Invalid version format: " + version
      );
    }

    final int major;
    final int minor;
    int patch = 0;

    try {
      major = Integer.parseInt(parts[0]);
      minor = Integer.parseInt(parts[1]);

      if (2 < parts.length) {
        patch = Integer.parseInt(parts[2]);
      }
    } catch (final NumberFormatException exception) {
      throw new IllegalArgumentException(
        "Invalid version format: " + version,
        exception
      );
    }

    return major * 10000 + minor * 100 + patch;
  }

  /**
   * Parses the Bukkit version string (e.g., 1.19.2-R01) and returns a
   * corresponding {@link Version} object.
   *
   * @return A {@link Version} object representing the parsed Bukkit version.
   * @since 0.1.0
   */
  static Version getBukkitVersion() {
    return new Version(VersionFactory.parseVersion(Bukkit.getBukkitVersion()));
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
  static Version getReleaseVersion() {
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
