package com.enderdevelopment.plugin;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class PurpurEndDimension {
    private final JavaPlugin plugin;

    public PurpurEndDimension(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void createPurpurEndDimension() {
        WorldCreator worldCreator = new WorldCreator("purpur_end");
        worldCreator.generator(new PurpurEndChunkGenerator());
        worldCreator.environment(World.Environment.THE_END);
        worldCreator.createWorld();
    }

    private class PurpurEndChunkGenerator extends ChunkGenerator {
        @Override
        public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
            ChunkData chunkData = createChunkData(world);
            // Generate Purpur blocks instead of End Stone
            for (int y = 0; y < world.getMaxHeight(); y++) {
                for (int chunkX = 0; chunkX < 16; chunkX++) {
                    for (int chunkZ = 0; chunkZ < 16; chunkZ++) {
                        chunkData.setBlock(chunkX, y, chunkZ, Material.PURPUR_BLOCK);
                    }
                }
            }
            return chunkData;
        }
    }
}