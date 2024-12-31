package dev.destinysoul.silentmode.client;

import dev.destinysoul.silentmode.event.keyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class SilentmodeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        keyInputHandler.register();
    }
}
