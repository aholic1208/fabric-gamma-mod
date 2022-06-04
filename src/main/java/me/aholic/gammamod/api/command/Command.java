package me.aholic.gammamod.api.command;

import net.minecraft.client.MinecraftClient;

public abstract class Command {

    protected final static MinecraftClient MC = MinecraftClient.getInstance();

    public static final String PREFIX = ".";

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void runCmd(String s, String[] args);
}
