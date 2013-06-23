package whoppercraft;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getConfig().options().copyDefaults(getConfig().contains("startID")); {
        saveConfig();
        pl = this;
		}
	}

	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("bhreload"))
			;
		if (sender.hasPermission("bh.reload")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("blockhat.reload"))
					this.reloadConfig();
				sender.sendMessage(ChatColor.GREEN + "Plugin reloaded!");
			}
		}
		if (cmd.getName().equalsIgnoreCase("hat")) {
			;
			if (sender.hasPermission("blockhat.hat")) {
				Hat.setHat((Player) sender);
			}
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "No permission!");
			return true;
		}
		return true;

	}
}