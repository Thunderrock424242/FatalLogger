package com.thunder.neocortex.MainModClass;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(NeoCortexMainModClass.MOD_ID)
public class NeoCortexMainModClass {
        /**
         * The constant LOGGER.
         */
        public static final Logger LOGGER = LogManager.getLogger("neocortex");


    public static final String MOD_ID = "neocortex";



        public NeoCortexMainModClass(IEventBus modEventBus, ModContainer container) {
            LOGGER.info("Fatal Logger initialized.");
            // Register mod setup and creative tabs
            modEventBus.addListener(this::commonSetup);

            // Register global events
            NeoForge.EVENT_BUS.register(this);


        }

        private void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                System.out.println("Fatal Logger setup complete!");
            });
        }
    }