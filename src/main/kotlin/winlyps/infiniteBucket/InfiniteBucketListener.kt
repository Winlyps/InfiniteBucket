package winlyps.infiniteBucket

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBucketEmptyEvent
import org.bukkit.inventory.ItemStack

class InfiniteBucketListener(private val plugin: InfiniteBucket) : Listener {

    @EventHandler
    fun onPlayerBucketEmpty(event: PlayerBucketEmptyEvent) {
        val itemInHand = event.player.inventory.itemInMainHand
        if (itemInHand.type == Material.WATER_BUCKET || itemInHand.type == Material.LAVA_BUCKET) {
            if (itemInHand.containsEnchantment(Enchantment.LUCK)) {
                // Allow the event to proceed
                // event.isCancelled = true

                // Refill the bucket asynchronously to avoid issues with the event timing
                plugin.server.scheduler.runTask(plugin, Runnable {
                    val newBucket = ItemStack(itemInHand.type)
                    newBucket.addUnsafeEnchantment(Enchantment.LUCK, 1)
                    event.player.inventory.setItemInMainHand(newBucket)
                })
            }
        }
    }
}