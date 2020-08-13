package net.simplyrin.commandmonitoring;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by SimplyRin on 2017/3/11.
 */
public class CraftBukkit extends JavaPlugin implements Listener {

	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		String command = event.getMessage();
		Player sender = event.getPlayer();

		for (Player players : Bukkit.getServer().getOnlinePlayers()) {
			if (players.hasPermission("commandmonitoring.view")) {
				players.sendMessage("§e[§bCMD§e] §b" + sender.getName() + "§9: §7" + command);
			}
		}
	}

}
