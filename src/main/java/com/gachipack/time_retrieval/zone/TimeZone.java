package com.gachipack.time_retrieval.zone;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;

public interface TimeZone {
    boolean contains(BlockPos pos);
    CompoundTag save(CompoundTag tag);
    ZoneType getType();
}
