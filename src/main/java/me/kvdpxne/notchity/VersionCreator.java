package me.kvdpxne.notchity;

/**
 * @since 0.1.0
 */
public final class VersionCreator {

  /**
   * Prevents instantiation of the {@link VersionCreator} class. This class is
   * intended to be used as a utility class and should not be instantiated
   * directly.
   *
   * @throws UnsupportedOperationException Always thrown to indicate that
   *                                       instantiation is not supported.
   * @since 0.1.0
   */
  private VersionCreator() {
    throw new UnsupportedOperationException(
      "VersionCreator is a utility class and cannot be instantiated."
    );
  }

  /**
   * @since 0.1.0
   */
  public static Version getBukkitVersion() {
    return BukkitVersionHolder.INSTANCE;
  }

  /**
   * @since 0.1.0
   */
  public static Version getMinecraftReleaseVersion() {
    return MinecraftReleaseVersionHolder.INSTANCE;
  }

  /**
   * @since 0.1.0
   */
  private static final class BukkitVersionHolder {

    /**
     * @since 0.1.0
     */
    static final Version INSTANCE = VersionFactory.getBukkitVersion();
  }

  /**
   * @since 0.1.0
   */
  private static final class MinecraftReleaseVersionHolder {

    /**
     * @since 0.1.0
     */
    static final Version INSTANCE = VersionFactory.getReleaseVersion();
  }
}
