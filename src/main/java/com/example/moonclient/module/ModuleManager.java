package com.example.moonclient.module;

import com.example.moonclient.module.combat.AutoTotem;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public void init() {
        // Register modules here
        modules.add(new AutoTotem());

        // Register tick event
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (Module module : modules) {
                if (module.isEnabled()) {
                    module.onTick();
                }
            }
        });
    }

    public List<Module> getModules() {
        return modules;
    }

    public Module getModuleByName(String name) {
        for (Module module : modules) {
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }
}
