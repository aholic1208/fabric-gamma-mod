package me.aholic.gammamod.mixin;


import me.aholic.gammamod.api.command.Command;
import me.aholic.gammamod.api.command.CommandManager;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.network.ClientPlayNetworkHandler.class)
public class MixinNetworkManager {

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void sendPackets(Packet<?> packet, CallbackInfo ci) {
        if (packet instanceof ChatMessageC2SPacket) {
            if (((ChatMessageC2SPacket) packet).getChatMessage().startsWith(Command.PREFIX)) {
                CommandManager.runCommand(((ChatMessageC2SPacket) packet).getChatMessage().substring(1));
                ci.cancel();
            }
        }
    }
}
