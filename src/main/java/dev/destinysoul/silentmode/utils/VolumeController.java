package dev.destinysoul.silentmode.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.sound.SoundCategory;

public class VolumeController {
    public static void setMasterVolume(float volume) {
        if (volume < 0.0f || volume > 1.0f) {
            throw new IllegalArgumentException("Volume must be between 0.0 and 1.0");
        }

        MinecraftClient client = MinecraftClient.getInstance();
        GameOptions options = client.options;
        options.getSoundVolumeOption(SoundCategory.MASTER).setValue((double) volume);
    }
    public static void  muteMasterVolume() {
        setMasterVolume(0.0f);
    }
    public static void  unmuteMasterVolume() {
        setMasterVolume(1.0f);
    }
    public static int toggleMasterVolume() {
        MinecraftClient client = MinecraftClient.getInstance();
        GameOptions options = client.options;
        double volume = options.getSoundVolumeOption(SoundCategory.MASTER).getValue();
        if (volume == 0.0) {
            unmuteMasterVolume();
            return 0;
        } else {
            muteMasterVolume();
            return 1;
        }
    }
}
