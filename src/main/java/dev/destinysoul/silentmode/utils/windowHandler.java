package dev.destinysoul.silentmode.utils;

import net.minecraft.client.MinecraftClient;

public class windowHandler {
    public static void initializeFocusListener() {

        MinecraftClient client = MinecraftClient.getInstance();
        if(!client.isWindowFocused()) {
            VolumeController.unmuteMasterVolume();
        }else if(!client.isWindowFocused()) {
            VolumeController.muteMasterVolume();
        }
    }
}
