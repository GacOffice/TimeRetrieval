package com.gachipack.time_retrieval.level;

import com.gachipack.time_retrieval.zone.TimeZone;

import net.minecraft.core.BlockPos;

public class TimeLoopEntry {
    TimeZone zone;
    int currentTicks;
    int stage;
    BlockPos anchorPos;
}
