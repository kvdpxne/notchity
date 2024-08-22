package me.kvdpxne.notchity;

/**
 * Represents different Minecraft release versions.
 *
 * @since 0.1.0
 */
public enum Release {

  /**
   * Represents a Minecraft release version later than the latest supported
   * version.
   *
   * @since 0.1.0
   */
  LATER(Integer.MAX_VALUE),

  V1_8_R3(6),
  V1_8_R2(5),
  V1_8_R1(4),

  V1_7_R4(3),
  V1_7_R3(2),
  V1_7_R2(1),
  V1_7_R1(0),

  V1_6_R3(-1),
  V1_6_R2(-2),
  V1_6_R1(-3),

  V1_5_R3(-4),
  V1_5_R2(-5),
  V1_5_R1(-6),

  /**
   * Represents a Minecraft release version older than the earliest supported
   * version.
   *
   * @since 0.1.0
   */
  OLDER(Integer.MIN_VALUE);

  private final int value;

  Release(final int value) {
    this.value = value;
  }

  /**
   * Retrieves the integer value associated with this release.
   *
   * @return The integer value of the release.
   * @since 0.1.0
   */
  public int getValue() {
    return this.value;
  }
}
