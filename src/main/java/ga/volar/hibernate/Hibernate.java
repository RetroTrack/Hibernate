package ga.volar.hibernate;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.apache.commons.lang3.mutable.MutableObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hibernate implements ModInitializer {

	// or /* means working on something/discontinued, because of ways to abuse mod and/or plugin

	public static final Logger LOGGER = LoggerFactory.getLogger("hibernate");
	public static final MutableObject<MinecraftServer> serverReference = new MutableObject<>();
	public static boolean timerEnabled = false;

	@Override
	public void onInitialize() {
		//ModRegistries.registerCommands();
		LOGGER.info("[Hibernate] Mod Started!");
		ServerLifecycleEvents.SERVER_STARTED.register(serverReference::setValue);
		ServerLifecycleEvents.SERVER_STARTED.register(Hibernate::onEnable);
	}

	public static void onEnable(MinecraftServer server) {
		/* Config Stuff

		this.saveDefaultConfig();
		this.config.addDefault("enabled", Boolean.TRUE);
		this.config.addDefault("unloadChunks", Boolean.TRUE);
		this.config.addDefault("sleepMillis", 1000L);
		this.config.options().copyDefaults(true);
		a.a = this.config.getBoolean("enabled");
		a.b = this.config.getBoolean("unloadChunks");
		a.c = this.config.getLong("sleepMillis");
		this.saveConfig(); */

		timerEnabled = true;
		if (Variables.status) {
			b();
		}
	}

	public static void CheckPlayers() {
		if (serverReference.getValue().getCurrentPlayerCount() == 0 && Variables.enabled) {
			try {
				Thread.sleep(Variables.millis);
				b();
			} catch (Exception var1) {
				throw new RuntimeException(var1);
			}
		}
	}

	private static void b() {
		int chunkCount = 0;

		serverReference.getValue().getWorlds().forEach(ServerWorld
				-> ServerWorld.getChunkManager().getTotalChunksLoadedCount());

		for (ServerWorld serverWorld : serverReference.getValue().getWorlds()) {

			int loadedChunkCount = serverWorld.getChunkManager().getLoadedChunkCount();
			for (int chunk = 0; chunk < loadedChunkCount; ++chunk) {
				if (serverWorld.isChunkLoaded(chunk)) {
					++chunkCount;
				}
			}
		}

		if (chunkCount > 0) {
			LOGGER.info(String.format("Unloaded %d chunks", chunkCount));
			long var9 = Runtime.getRuntime().freeMemory();
			System.gc();
			long var13;
			if ((var13 = (Runtime.getRuntime().freeMemory() - var9) / 1024L / 1024L) > 0L) {
				LOGGER.info(String.format("%d MB memory freed using Java garbage collector", var13));
			}
		}

	}
}
