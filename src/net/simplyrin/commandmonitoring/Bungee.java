package net.simplyrin.commandmonitoring;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Bungee extends Plugin implements Listener {
	public void onEnable() {
		BungeeCord.getInstance().getPluginManager().registerListener(this, this);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onCommand(ChatEvent event) {
		String command = event.getMessage();
		ProxiedPlayer player = (ProxiedPlayer) event.getSender();

		if(event.isCommand()) {
			ProxyServer.getInstance().getLogger().info("§e[§bCM§e] §7- §b" + player.getName() + "§b@" + player.getServer().getInfo().getName() + "§9: §7" + command);

			for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
				if (p.hasPermission("commandmonitoring.view")) {
					p.sendMessage("§e[§bCM§e] §7- §b" + player.getName() + "§b@" + player.getServer().getInfo().getName() + "§9: §7" + command);
				}
			}
		}
	}
}
