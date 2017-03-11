package net.simplyrin.commandmonitoring;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftBukkit extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		String command = event.getMessage();
		Player player = event.getPlayer();

		Bukkit.getServer().getConsoleSender().sendMessage("§c[§bCM§c] §7- §a" + player.getName() + "§9: §7" + command);

		for (Player players : Bukkit.getServer().getOnlinePlayers()) {
			if (players.hasPermission("commandmonitoring.view")) {
				players.sendMessage("§c[§bCM§c] §7- §a" + player.getName() + "§9: §7" + command);
			}
		}
	}
}
