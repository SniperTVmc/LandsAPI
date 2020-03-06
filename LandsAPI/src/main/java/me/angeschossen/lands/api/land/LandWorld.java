package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LandWorld {

    @NotNull
    List<? extends Land> getTopLands();

    @NotNull List<String> printTopLands(int page);

    /**
     * Check can execute action in wilderness
     * @param player Player
     * @param roleSetting Setting
     * @param sendMessage Send deny message?
     * @return Result
     */
    boolean canWildernessSetting(@NotNull Player player,@NotNull RoleSetting roleSetting, boolean sendMessage);

    /**
     * Check can execute action in wilderness
     * @param player Player
     * @param landsAction Setting
     * @return Result
     */
    boolean canActionWithResponse(@NotNull Player player,@NotNull  Location location, RoleSetting landsAction);

    boolean canActionWithResponse(@NotNull Player player,@NotNull  Location location, @Nullable Material material, RoleSetting landsAction);

    boolean hasLandSetting(@NotNull Location location,@NotNull  LandSetting landSetting);

    boolean canAction(@NotNull Player player,@NotNull  Location location,@NotNull  RoleSetting landsAction);

    /**
     * Check if player can action. This also contains the setting disallow-wilderness.
     *
     * @param player      Player
     * @param location    Location
     * @param landsAction Action
     * @return Will return false if he can't do this.
     */
    boolean canAction(@NotNull Player player,@NotNull  Location location, @Nullable Material material,@NotNull  RoleSetting landsAction);

    /**
     * Get name of world.
     *
     * @return Name of world
     */
    @NotNull
    String getName();

    /**
     * Get world
     *
     * @return World
     */
    @NotNull
    World getWorld();

    /**
     * Get land
     *
     * @param landName Name of land
     * @return Will return null if this land does not exist.
     */
    @Nullable
    Land getLand(@NotNull String landName);

    /**
     * Get land by iD
     *
     * @param iD Id of land.
     * @return Will return null if this land does not exist.
     */
    @Nullable
    Land getLand(@NotNull int iD);

    /**
     * Get loaded landChunk
     *
     * @param chunkX X identifier
     * @param chunkZ Z identifier
     * @return LandChunk or null, if not cached
     */
    @Nullable
    LandChunk getLandChunk(@NotNull int chunkX, @NotNull int chunkZ);

    /**
     * Is landChunk loaded?
     *
     * @param x X identifier
     * @param z Z identifier
     * @return Loaded
     */
    @NotNull
    boolean isChunkLoaded(@NotNull int x, @NotNull int z);
}
