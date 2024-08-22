package me.kvdpxne.notchity;

/**
 * Represents a version number. This class provides methods for comparing
 * versions and retrieving the underlying integer value.
 *
 * @since 0.1.0
 */
public final class Version
  implements Comparable<Version> {

  /**
   * The internal integer value representing the version number.
   *
   * @since 0.1.0
   */
  private final int value;

  /**
   * Creates a new {@link Version} object with the specified integer value.
   *
   * @param value The integer value representing the version number.
   * @since 0.1.0
   */
  Version(final int value) {
    this.value = value;
  }

  /**
   * @since 0.1.0
   */
  public boolean isLaterThan(final int other) {
    return this.value > other;
  }

  /**
   * Checks if this version is later than the provided version.
   *
   * @param other The version to compare with.
   * @return True if this version is greater than the other version.
   */
  public boolean isLaterThan(final Version other) {
    return null != other && this.isLaterThan(other.value);
  }

  /**
   * @since 0.1.0
   */
  public boolean isLaterThanOrEqual(final int other) {
    return this.value >= other;
  }

  /**
   * Checks if this version is later than or equal to the provided version.
   *
   * @param other The version to compare with.
   * @return True if this version is greater than or equal to the other version.
   */
  public boolean isLaterThanOrEqual(final Version other) {
    return null != other && this.isLaterThanOrEqual(other.value);
  }

  /**
   * @since 0.1.0
   */
  public boolean isEqual(final int other) {
    return this.value == other;
  }

  /**
   * Checks if this version is equal to the provided version.
   *
   * @param other The version to compare with.
   * @return True if both versions have the same internal value.
   */
  public boolean isEqual(final Version other) {
    return null != other && this.isEqual(other.value);
  }

  /**
   * @since 0.1.0
   */
  public boolean isOlderThan(final int other) {
    return this.value < other;
  }

  /**
   * Checks if this version is older than the provided version.
   *
   * @param other The version to compare with.
   * @return True if this version is less than the other version.
   */
  public boolean isOlderThan(final Version other) {
    return null != other && this.isOlderThan(other.value);
  }

  /**
   * @since 0.1.0
   */
  public boolean isOlderThanOrEqual(final int other) {
    return this.value <= other;
  }

  /**
   * Checks if this version is older than or equal to the provided version.
   *
   * @param other The version to compare with.
   * @return True if this version is less than or equal to the other version.
   */
  public boolean isOlderThanOrEqual(final Version other) {
    return null != other && this.isOlderThanOrEqual(other.value);
  }

  /**
   * Retrieves the internal integer value representing the version number.
   *
   * @return The internal integer value.
   * @since 0.1.0
   */
  public int getNumber() {
    return this.value;
  }

  /**
   * Compares this version with another version for sorting purposes.
   *
   * @param other The version to compare with.
   * @return A negative integer, zero, or a positive integer as this version is
   *         less than, equal to, or greater than the specified version.
   * @since 0.1.0
   * @see Comparable
   */
  @Override
  public int compareTo(final Version other) {
    return Integer.compare(this.value, other.value);
  }

  /**
   * Indicates whether this object is equal to another object.
   *
   * @param o The object to compare with.
   * @return True if the objects are the same instance or both are
   *         {@link Version} instances with the same internal value.
   * @since 0.1.0
   * @see Object
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
   * Returns a hash code value for this object.
   *
   * @return A hash code value based on the internal integer value.
   * @since 0.1.0
   * @see Object
   */
  @Override
  public int hashCode() {
    return this.value;
  }
}
