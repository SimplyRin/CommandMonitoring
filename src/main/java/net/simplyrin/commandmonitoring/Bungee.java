package net.simplyrin.commandmonitoring;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by SimplyRin on 2017/3/11.
 */
public class Bungee extends Plugin implements Listener {

	public void onEnable() {
		this.getProxy().getPluginManager().registerListener(this, this);
	}

	@EventHandler
	public void onCommand(ChatEvent event) {
		String command = event.getMessage();
		ProxiedPlayer sender = (ProxiedPlayer) event.getSender();

		if (!event.isCommand()) {
			return;
		}

		for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
			if (player.hasPermission("commandmonitoring.view")) {
				player.sendMessage("§e[§bCMD§e] §b" + sender.getName() + "§b@" + sender.getServer().getInfo().getName() + "§9: §7" + command);
			}
		}
	}

}
