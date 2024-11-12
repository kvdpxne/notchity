package me.kvdpxne.notchity;

/**
 * Represents a version number as an integer, where higher values signify more recent versions.
 * This class provides methods for comparing different versions and retrieving the internal integer
 * representation of the version. It is designed to be immutable and thread-safe.
 *
 * <p>Instances of this class can be compared with each other using the {@link Comparable} interface
 * or by using provided utility methods to determine whether one version is newer, older, or equal
 * to another.</p>
 *
 * @since 0.1.0
 */
public final class Version implements Comparable<Version> {

  /**
   * The internal integer value representing the version number. Higher values correspond
   * to more recent versions.
   *
   * @since 0.1.0
   */
  private final int value;

  /**
   * Constructs a new {@link Version} instance with the specified integer value.
   *
   * @param value The integer value representing the version number. Must be non-negative.
   * @throws IllegalArgumentException if {@code value} is negative.
   * @since 0.1.0
   */
  Version(final int value) {
    if (0 > value) {
      throw new IllegalArgumentException("Version number cannot be negative.");
    }
    this.value = value;
  }

  /**
   * Checks if this version is later than the specified integer version.
   *
   * @param other The integer version to compare with.
   * @return {@code true} if this version is greater than the provided integer version.
   * @since 0.1.0
   */
  public boolean isLaterThan(final int other) {
    return this.value > other;
  }

  /**
   * Checks if this version is later than the specified {@link Version} instance.
   *
   * @param other The {@link Version} instance to compare with.
   * @return {@code true} if this version is greater than the specified version,
   *         {@code false} if {@code other} is null or if this version is not greater.
   * @since 0.1.0
   */
  public boolean isLaterThan(final Version other) {
    return null != other && this.isLaterThan(other.value);
  }

  /**
   * Checks if this version is later than or equal to the specified integer version.
   *
   * @param other The integer version to compare with.
   * @return {@code true} if this version is greater than or equal to the provided integer version.
   * @since 0.1.0
   */
  public boolean isLaterThanOrEqual(final int other) {
    return this.value >= other;
  }

  /**
   * Checks if this version is later than or equal to the specified {@link Version} instance.
   *
   * @param other The {@link Version} instance to compare with.
   * @return {@code true} if this version is greater than or equal to the specified version,
   *         {@code false} if {@code other} is null or if this version is not greater or equal.
   * @since 0.1.0
   */
  public boolean isLaterThanOrEqual(final Version other) {
    return null != other && this.isLaterThanOrEqual(other.value);
  }

  /**
   * Checks if this version is equal to the specified integer version.
   *
   * @param other The integer version to compare with.
   * @return {@code true} if this version is equal to the specified integer version.
   * @since 0.1.0
   */
  public boolean isEqual(final int other) {
    return this.value == other;
  }

  /**
   * Checks if this version is equal to the specified {@link Version} instance.
   *
   * @param other The {@link Version} instance to compare with.
   * @return {@code true} if both versions have the same value, {@code false} if {@code other} is null.
   * @since 0.1.0
   */
  public boolean isEqual(final Version other) {
    return null != other && this.isEqual(other.value);
  }

  /**
   * Checks if this version is older than the specified integer version.
   *
   * @param other The integer version to compare with.
   * @return {@code true} if this version is less than the provided integer version.
   * @since 0.1.0
   */
  public boolean isOlderThan(final int other) {
    return this.value < other;
  }

  /**
   * Checks if this version is older than the specified {@link Version} instance.
   *
   * @param other The {@link Version} instance to compare with.
   * @return {@code true} if this version is less than the specified version,
   *         {@code false} if {@code other} is null or if this version is not less.
   * @since 0.1.0
   */
  public boolean isOlderThan(final Version other) {
    return null != other && this.isOlderThan(other.value);
  }

  /**
   * Checks if this version is older than or equal to the specified integer version.
   *
   * @param other The integer version to compare with.
   * @return {@code true} if this version is less than or equal to the provided integer version.
   * @since 0.1.0
   */
  public boolean isOlderThanOrEqual(final int other) {
    return this.value <= other;
  }

  /**
   * Checks if this version is older than or equal to the specified {@link Version} instance.
   *
   * @param other The {@link Version} instance to compare with.
   * @return {@code true} if this version is less than or equal to the specified version,
   *         {@code false} if {@code other} is null or if this version is not less or equal.
   * @since 0.1.0
   */
  public boolean isOlderThanOrEqual(final Version other) {
    return null != other && this.isOlderThanOrEqual(other.value);
  }

  /**
   * Returns the integer value representing this version number.
   *
   * @return The integer value of this version.
   * @since 0.1.0
   */
  public int getNumber() {
    return this.value;
  }

  /**
   * Compares this version with another {@link Version} for ordering.
   *
   * @param other The {@link Version} instance to compare with.
   * @return A negative integer if this version is less than {@code other},
   *         zero if equal, or a positive integer if greater.
   * @see Comparable
   * @since 0.1.0
   */
  @Override
  public int compareTo(final Version other) {
    return Integer.compare(this.value, other.value);
  }

  /**
   * Indicates whether this object is "equal to" another object.
   *
   * @param o The reference object with which to compare.
   * @return {@code true} if this object is the same as {@code o} or if both are
   *         {@link Version} instances with the same version value, {@code false} otherwise.
   * @since 0.1.0
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (null == o || this.getClass() != o.getClass()) {
      return false;
    }

    final Version that = (Version) o;
    return this.value == that.value;
  }

  /**
   * Returns a hash code value for this version.
   *
   * @return A hash code based on the version number.
   * @since 0.1.0
   */
  @Override
  public int hashCode() {
    return this.value;
  }

  /**
   * Returns a string representation of this {@link Version} instance.
   *
   * @return A string in the format "Version{value="versionNumber"}".
   * @since 0.2.0
   */
  @Override
  public String toString() {
    return "Version{value=\"" + this.value + "\"}";
  }
}
