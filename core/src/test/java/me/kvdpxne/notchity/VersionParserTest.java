package me.kvdpxne.notchity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link VersionParser}.
 */
class VersionParserTest {

  /**
   * Test for parsing valid version strings to integer representations.
   */
  @Test
  void testParseVersionToNumber_validVersions() {
    assertEquals(1002003, VersionParser.parseVersionToNumber("1.2.3"));
    assertEquals(1000000, VersionParser.parseVersionToNumber("1.0"));
    assertEquals(123456007, VersionParser.parseVersionToNumber("123.456.7"));
  }

  /**
   * Test for invalid version format.
   */
  @Test
  void testParseVersionToNumber_invalidVersionFormat() {
    assertThrows(IllegalArgumentException.class, () -> VersionParser.parseVersionToNumber("1..3"));
    assertThrows(IllegalArgumentException.class, () -> VersionParser.parseVersionToNumber("abc"));
  }

  /**
   * Test for version components outside the supported range.
   */
  @Test
  void testParseVersionToNumber_outOfRange() {
    assertThrows(IllegalArgumentException.class, () -> VersionParser.parseVersionToNumber("1000.0.0"));
    assertThrows(IllegalArgumentException.class, () -> VersionParser.parseVersionToNumber("0.-1.0"));
  }

  /**
   * Test for checking if a version component is within the supported range.
   */
  @Test
  void testIsInSupportedRange() {
    assertTrue(VersionParser.isInSupportedRange(999));
    assertTrue(VersionParser.isInSupportedRange(0));
    assertFalse(VersionParser.isInSupportedRange(1000));
    assertFalse(VersionParser.isInSupportedRange(-1));
  }

  /**
   * Test for parsing a version string into a {@link Version} object.
   */
  @Test
  void testParseVersion() {
    Version version = VersionParser.parseVersion("1.2.3");
    assertNotNull(version);
    assertEquals(1002003, version.getNumber());
  }
}
