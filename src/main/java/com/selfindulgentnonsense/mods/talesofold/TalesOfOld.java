package com.selfindulgentnonsense.mods.talesofold;

import com.selfindulgentnonsense.mods.talesofold.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TalesOfOld implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	public static final String MOD_ID = "talesofold";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Executes when mod gets loaded

		LOGGER.info("Hello Minecraft World! Tales of Old Mod just Initizalized.");

		// load all mod components
		ModLootTableModifiers.registerModLootTableModifiers();
	}
}