package me.hephaestus.glow.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GlowCommand implements CommandExecutor {
    // This method is called when the command is executed
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // Check if the command sender is a player
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        // Get the player who executed the command
        Player player = (Player) commandSender;

        // Get the item the player is currently holding in their main hand
        ItemStack item = player.getInventory().getItemInMainHand();

        // Check if the player is holding an item
        if (item.getType() == Material.AIR) {
            player.sendMessage(ChatColor.RED + "You must be holding an item to apply the glow effect.");
            return true;
        }

        // Get the metadata of the item
        ItemMeta itemMeta = item.getItemMeta();

        // Apply the glow effect to the item
        itemMeta.addEnchant(Enchantment.LURE, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Update the item metadata with the glow effect
        item.setItemMeta(itemMeta);

        return true;
    }
}
