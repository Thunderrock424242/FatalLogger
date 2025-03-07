package com.thunder.fatallogger.MainModClass;

import com.thunder.fatallogger.ExtendedLogger;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.LoggerFactory;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FatalLoggerMainModClass.MOD_ID)
public class FatalLoggerMainModClass {
        /**
         * The constant LOGGER.
         */
        public static final ExtendedLogger LOGGER = (ExtendedLogger)
                LoggerFactory.getLogger(FatalLoggerMainModClass.class);

        public static final String MOD_ID = "FatalLogger";



        public FatalLoggerMainModClass(IEventBus modEventBus, ModContainer container) {
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