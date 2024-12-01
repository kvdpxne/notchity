package me.kvdpxne.notchity;

/**
 * Provides utility methods for retrieving and parsing version information.
 *
 * <p>This class includes methods to check if a version is within a supported
 * range and to parse a version string in the format "major.minor.patch" into
 * an integer representation. It is designed to be used as a utility class and
 * cannot be instantiated.</p>
 *
 * @since 0.1.0
 */
public final class VersionParser {

  /**
   * The maximum supported value for major, minor, and patch version components.
   * Versions with components above this value are considered unsupported.
   *
   * @since 0.2.0
   */
  public static final int MAX_VALUE = 999;

  /**
   * The minimum supported value for major, minor, and patch version components.
   * Versions with components below this value are considered unsupported.
   *
   * @since 0.2.0
   */
  public static final int MIN_VALUE = 0;

  /**
   * Prevents instantiation of the {@link VersionParser} class. This class is
   * intended for static utility use and should not be instantiated directly.
   *
   * @throws UnsupportedOperationException Always thrown to indicate that
   *                                       instantiation is not supported.
   * @since 0.1.0
   */
  private VersionParser() {
    throw new UnsupportedOperationException(
      "VersionParser is a utility class and cannot be instantiated."
    );
  }

  /**
   * Checks if a given version component (major, minor, or patch) is within the
   * supported range defined by {@link #MIN_VALUE} and {@link #MAX_VALUE}.
   *
   * @param version The version component to check.
   * @return {@code true} if the version is within the supported range;
   *         {@code false} otherwise.
   * @since 0.2.0
   */
  public static boolean isInSupportedRange(
    final int version
  ) {
    return MAX_VALUE >= version && MIN_VALUE <= version;
  }

  /**
   * Parses a version string in the format "major.minor.patch" and converts it
   * into an integer representation. This allows version strings to be stored
   * as single integers, where "major" contributes the most significant digits,
   * followed by "minor" and "patch".
   *
   * <p>The integer is calculated as {@code (major * 1,000,000) + (minor * 1,000) + patch}.
   * If the version string is invalid, an {@link IllegalArgumentException} is
   * thrown.</p>
   *
   * <p>For example:</p>
   * <ul>
   *   <li>"1.2.3" would be converted to {@code 1002003}</li>
   *   <li>"1.0" would be converted to {@code 1000000}</li>
   * </ul>
   *
   * @param version The version string to parse. It must not be null or empty
   *                and must follow the format "major.minor" or "major.minor.patch".
   * @return An integer representing the parsed version.
   * @throws IllegalArgumentException If the version string is null, empty, or
   *                                  not in a valid format, or if any part of
   *                                  the version is out of the supported range.
   * @since 0.2.0
   */
  public static int parseVersionToNumber(
    final String version
  ) {
    if (null == version || version.isEmpty()) {
      throw new IllegalArgumentException(
        "The given version must not be null or be empty."
      );
    }

    final String[] parts = version.split("\\.");

    final int major;
    final int minor;
    int patch = 0;

    try {
      // Parse the major version component and check if it's
      // in the supported range.
      major = Integer.parseInt(parts[0]);
      if (!isInSupportedRange(major)) {
        throw new IllegalArgumentException(
          "Major version component is out of the supported range: " + major
        );
      }

      // Parse the minor version component and check if it's
      // in the supported range.
      minor = Integer.parseInt(parts[1]);
      if (!isInSupportedRange(minor)) {
        throw new IllegalArgumentException(
          ""
        );
      }

      // Parse the optional patch version component, handling any suffix.
      if (2 < parts.length) {
        // Remove any suffix (e.g., "-beta") from the patch
        // component if present.
        final int index = parts[2].indexOf('-');
        if (-1 != index) {
          parts[2] = parts[2].substring(0, index);
        }
        patch = Integer.parseInt(parts[2]);
        if (!isInSupportedRange(patch)) {
          throw new IllegalArgumentException(
            "Patch version component is out of the supported range: " + patch
          );
        }
      }
    } catch (final NumberFormatException exception) {
      throw new IllegalArgumentException(
        "Invalid version format: " + version,
        exception
      );
    }

    // Combines major, minor, and patch values into a single integer.
    // Supports versions up to 999.999.999; beyond this, the 32-bit
    // integer limit is exceeded.
    return major * 1_000_000 + minor * 1_000 + patch;
  }

  /**
   * Parses a version string in the format "major.minor.patch" into a {@link Version}
   * object, representing the version as a {@link Version} instance with a numeric value.
   *
   * <p>For example:</p>
   * <ul>
   *   <li>"1.2.3" would result in a {@link Version} instance representing {@code 1002003}</li>
   * </ul>
   *
   * @param version The version string to parse. It must not be null or empty
   *                and must follow the format "major.minor" or "major.minor.patch".
   * @return A {@link Version} object representing the parsed version.
   * @throws IllegalArgumentException If the version string is invalid.
   * @since 0.2.0
   */
  public static Version parseVersion(
    final String version
  ) {
    final int numericVersion = parseVersionToNumber(version);
    return new Version(numericVersion);
  }
}
