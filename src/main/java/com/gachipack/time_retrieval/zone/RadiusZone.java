package com.gachipack.time_retrieval.zone;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;

public class RadiusZone implements TimeZone {
    private final int centerX;
    private final int centerZ;
    private final int radius;

    public RadiusZone(BlockPos pos, int radius) {
        this.centerX = pos.getX();
        this.centerZ = pos.getZ();
        this.radius = radius;
    }

    public RadiusZone(CompoundTag tag) {
        this.centerX = tag.getInt("centerX");
        this.centerZ = tag.getInt("centerZ");
        this.radius = tag.getInt("radius");
    }

    @Override
    public boolean contains(BlockPos pos) {
        int currX = pos.getX();
        int currZ = pos.getZ();

        return Math.abs(currX - centerX) <= radius && Math.abs(currZ - centerZ) <= radius;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putInt("centerX", this.centerX);
        tag.putInt("centerZ", this.centerZ);
        tag.putInt("radius", this.radius);

        return  tag;
    }

    @Override
    public ZoneType getType() {
        return ZoneType.RADIUS;
    }
}
