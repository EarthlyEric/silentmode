package dev.destinysoul.silentmode.event;

import dev.destinysoul.silentmode.utils.VolumeController;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class keyInputHandler {
    public static final String KEY_CATEGORY_MAIN = "key.category.silentmode.main";
    public static final String KEY_TOGGLE_SILENT_MODE = "key.silentmode.toggle_silent_mode";

    public static KeyBinding toggleSilentMode;

    public  static void registerKeyBindings() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleSilentMode.wasPressed()) {

                Integer state = VolumeController.toggleMasterVolume();
                if (state == 0) {
                    client.player.sendMessage(Text.of("Unmuting master volume"));
                } else {
                    client.player.sendMessage(Text.of("Muting master volume"));
                }
            }
        });
    }
    public static void register() {
        toggleSilentMode = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            KEY_TOGGLE_SILENT_MODE,
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_UNKNOWN,
            KEY_CATEGORY_MAIN
        ));
        registerKeyBindings();
    }
}
