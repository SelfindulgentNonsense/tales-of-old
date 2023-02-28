package com.selfindulgentnonsense.mods.talesofold.util;

import com.selfindulgentnonsense.mods.talesofold.TalesOfOld;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.util.Identifier;

import static com.selfindulgentnonsense.mods.talesofold.TalesOfOld.LOGGER;

public class ModLootTableModifiers {
    /* ---- ADD LOOTTABLES TO GAME ----- */
    public static void modifyLootTable(Identifier id, String lootTablePath) {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, lootTableId, supplier, setter) -> {
            if (id.equals(lootTableId)) {
                LootPool[] pools = lootManager.getTable(new Identifier(TalesOfOld.MOD_ID, lootTablePath)).pools;
                if (pools != null) {
                    for (LootPool pool : pools) {
                        supplier.pool(pool);
                    }
                }
            }
        });
    }

    public static void registerModLootTableModifiers() {
        // Grass block loot table modification
        modifyLootTable(new Identifier("minecraft", "blocks/grass"), "chests/test_table");

        // Igloo chest loot table modification
        modifyLootTable(new Identifier("minecraft", "chests/igloo_chest"), "chests/test_table");

        // Creeper loot table modification
        modifyLootTable(new Identifier("minecraft", "entities/creeper"), "chests/test_table");

        LOGGER.info("Tales Of Old LootTables initialized");
    }
}
