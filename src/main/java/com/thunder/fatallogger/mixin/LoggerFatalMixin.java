package com.thunder.fatallogger.mixin;

import com.thunder.fatallogger.ExtendedLogger;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/**
 * Mixin that makes SLF4J's Logger implement ExtendedLogger,
 * thereby adding "fatal(...)" at runtime.
 */
@Mixin(value = Logger.class, remap = false)
public interface LoggerFatalMixin extends ExtendedLogger {

    @Override
    @Unique
    default void fatal(String msg) {
        // We have to route "fatal" to something SLF4J can actually do.
        error("[FATAL] " + msg);
    }

    @Override
    @Unique
    default void fatal(String msg, Throwable t) {
        error("[FATAL] " + msg, t);
    }

    @Override
    @Unique
    default boolean isFatalEnabled() {
        return isErrorEnabled();
    }
}