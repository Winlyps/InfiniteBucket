package winlyps.infiniteBucket

import org.bukkit.plugin.java.JavaPlugin

class InfiniteBucket : JavaPlugin() {

    override fun onEnable() {
        // Register commands
        getCommand("infwater")?.setExecutor(InfiniteBucketCommand(this, true))
        getCommand("inflava")?.setExecutor(InfiniteBucketCommand(this, false))

        // Register event listener
        server.pluginManager.registerEvents(InfiniteBucketListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
