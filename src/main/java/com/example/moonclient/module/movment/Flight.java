package com.example.moonclient.module.movement;

import com.example.moonclient.module.Category;
import com.example.moonclient.module.Module;
import net.minecraft.client.MinecraftClient;

public class Flight extends Module {

    public Flight() {
        super("Flight", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        client.player.getAbilities().allowFlying = true;
        client.player.getAbilities().flying = true;
    }

    @Override
    public void onDisable() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        client.player.getAbilities().allowFlying = false;
        client.player.getAbilities().flying = false;
    }
}
