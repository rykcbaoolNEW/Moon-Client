package com.example.moonclient.module.combat;

import com.example.moonclient.module.Category;
import com.example.moonclient.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.Hand;

public class AutoCrystal extends Module {

    public AutoCrystal() {
        super("AutoCrystal", Category.COMBAT);
    }

    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.world == null) return;

        for (Entity entity : client.world.getEntities()) {
            if (entity instanceof EndCrystalEntity) {
                client.interactionManager.attackEntity(client.player, entity);
                client.player.swingHand(Hand.MAIN_HAND);
                break;
            }
        }
    }
}
