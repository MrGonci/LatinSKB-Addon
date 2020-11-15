package net.latinplay.skb.Utils.Versions;

import com.sun.istack.internal.NotNull;
import org.bukkit.Server;

import javax.annotation.Nullable;

final class ServerVersion {
    private final Server server;

    public ServerVersion(@NotNull Server s) {
        this.server = s;
    }

    public final String getRealVersion() {
        return this.server.getBukkitVersion();
    }

    public final String getFullVersion() {
        return this.server.getBukkitVersion().split("-")[0];
    }

    public final String getPackageType() {
        return this.server.getBukkitVersion().split("-")[2];
    }

    public final String getPackageBuild() {
        return this.server.getBukkitVersion().split("-")[1];
    }

    public final float getVersion() {
        String[] versionData = this.server.getBukkitVersion().split("-");
        String version_head = versionData[0].split("\\.")[0];
        String version_sub = versionData[0].split("\\.")[1];
        return Float.parseFloat(version_head + "." + version_sub);
    }

    public final int getVersionUpdate() {
        String[] versionData = this.server.getBukkitVersion().split("-");
        String version = versionData[0];
        versionData = version.split("\\.");
        if (versionData.length >= 3)
            return Integer.parseInt(versionData[2]);
        return -1;
    }

    public final Version getV() {
        String full = getFullVersion();
        full = "v" + full.replace(".", "_");
        return Version.valueOf(full);
    }

    @Nullable
    public final Class<?> getNMSClass(@NotNull String clazz) {
        try {
            return Class.forName("net.minecraft.server." + getFullVersion() + "." + clazz);
        } catch (Throwable e) {
            return null;
        }
    }

    @Nullable
    public final Class<?> getObcClass(@NotNull String clazz) {
        try {
            return Class.forName("org.bukkit.craftbukkit." + this.server.getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + clazz);
        } catch (Throwable e) {
            return null;
        }
    }
}
