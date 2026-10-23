package com.gachipack.time_retrieval.zone;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;

public class ColumnZone implements TimeZone {
    private final int minX;
    private final int maxX;
    private final int minZ;
    private final int maxZ;

    public ColumnZone(BlockPos pos1, BlockPos pos2) {
        int pos1X = pos1.getX();
        int pos1Z = pos1.getZ();
        int pos2X = pos2.getX();
        int pos2Z = pos2.getZ();

        this.minX = Math.min(pos1X, pos2X);
        this.maxX = Math.max(pos1X, pos2X);
        this.minZ = Math.min(pos1Z, pos2Z);
        this.maxZ = Math.max(pos1Z, pos2Z);
    }

    public ColumnZone(CompoundTag tag) {
        this.minX = tag.getInt("minX");
        this.maxX = tag.getInt("maxX");
        this.minZ = tag.getInt("minZ");
        this.maxZ = tag.getInt("maxZ");
    }

    @Override
    public boolean contains(BlockPos pos) {
        int currX = pos.getX();
        int currZ = pos.getZ();

        return currX >= minX && currX <= maxX && currZ >= minZ && currZ <= maxZ;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putInt("minX", this.minX);
        tag.putInt("maxX", this.maxX);
        tag.putInt("minZ", this.minZ);
        tag.putInt("maxZ", this.maxZ);

        return  tag;
    }

    @Override
    public ZoneType getType() {
        return ZoneType.COLUMN;
    }
}
