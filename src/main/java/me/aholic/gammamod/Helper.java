package me.aholic.gammamod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;

public class Helper {

    public static final MinecraftClient MC = MinecraftClient.getInstance();

    public static void sendLocalMessage(String message) {
        MC.inGameHud.addChatMessage(MessageType.SYSTEM, new LiteralText(message), MC.player.getUuid());
    }

}
