package com.example.moonclient;

import com.example.moonclient.module.ModuleManager;
import net.fabricmc.api.ModInitializer;

public class MoonClient implements ModInitializer {

    public static final String MOD_ID = "moonclient";
    public static ModuleManager moduleManager;

    @Override
    public void onInitialize() {
        moduleManager = new ModuleManager();
        moduleManager.init();
        System.out.println("MoonClient initialized.");
    }
}
