package dev.destinysoul.silentmode;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Silentmode implements ModInitializer {
    public static final String MOD_ID = "silentmode";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Silentmode is initialized");
    }
}
