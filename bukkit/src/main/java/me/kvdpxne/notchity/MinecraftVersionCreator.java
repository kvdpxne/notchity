package me.kvdpxne.notchity;

/**
 * @since 0.2.0
 */
public final class MinecraftVersionCreator {

  /**
   * Prevents instantiation of the {@link MinecraftVersionCreator} class. This
   * class is intended for static utility use and should not be instantiated
   * directly.
   *
   * @throws UnsupportedOperationException Always thrown to indicate that
   *                                       instantiation is not supported.
   * @since 0.2.0
   */
  private MinecraftVersionCreator() {
    throw new UnsupportedOperationException(
      "MinecraftVersionCreator is a utility class and cannot be instantiated."
    );
  }

  /**
   * @since 0.2.0
   */
  public static Version getMinecraftVersion() {
    return LazyMinecraftVersionHolder.INSTANCE;
  }

  /**
   * @since 0.2.0
   */
  public static Version getMinecraftRevision() {
    return LazyMinecraftRevisionHolder.INSTANCE;
  }

  /**
   * @since 0.2.0
   */
  private static final class LazyMinecraftVersionHolder {

    /**
     * @since 0.2.0
     */
    private static final Version INSTANCE =
      MinecraftVersionFactory.createMinecraftVersion();
  }

  /**
   * @since 0.2.0
   */
  private static final class LazyMinecraftRevisionHolder {

    /**
     * @since 0.2.0
     */
    private static final Version INSTANCE =
      MinecraftVersionFactory.createMinecraftRevision();
  }
}
