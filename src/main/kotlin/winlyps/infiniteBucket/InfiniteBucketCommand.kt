package winlyps.infiniteBucket

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment

class InfiniteBucketCommand(private val plugin: InfiniteBucket, private val isWater: Boolean) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("This command can only be used by players.")
            return true
        }

        val itemStack = ItemStack(if (isWater) Material.WATER_BUCKET else Material.LAVA_BUCKET)
        itemStack.addUnsafeEnchantment(Enchantment.LUCK, 1) // Using LUCK as a placeholder for enchantment

        sender.inventory.addItem(itemStack)
        sender.sendMessage("You received an infinite ${if (isWater) "water" else "lava"} bucket!")
        return true
    }
}