package me.kvdpxne.notchity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link Version}.
 */
class VersionTest {

  /**
   * Test for creating a {@link Version} object.
   */
  @Test
  void testVersionConstructor() {
    Version version = new Version(1002003);
    assertNotNull(version);
    assertEquals(1002003, version.getNumber());
  }

  /**
   * Test for comparing two {@link Version} objects.
   */
  @Test
  void testCompareTo() {
    Version version1 = new Version(1002003);
    Version version2 = new Version(1002003);
    Version version3 = new Version(1003000);

    assertEquals(0, version1.compareTo(version2));
    assertTrue(version1.compareTo(version3) < 0);
    assertTrue(version3.compareTo(version1) > 0);
  }

  /**
   * Test for {@link Version#equals(Object)} and {@link Version#hashCode()}.
   */
  @Test
  void testEqualsAndHashCode() {
    Version version1 = new Version(1002003);
    Version version2 = new Version(1002003);
    Version version3 = new Version(1003000);

    assertEquals(version1, version2);
    assertNotEquals(version1, version3);
    assertEquals(version1.hashCode(), version2.hashCode());
  }

  /**
   * Test for invalid version number passed to the {@link Version} constructor.
   */
  @Test
  void testInvalidVersion() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Version(-1);
    });
  }
}
