package com.ReanKR.rTutorialReloaded.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import com.ReanKR.rTutorialReloaded.rTutorialProgress;
import com.ReanKR.rTutorialReloaded.rTutorialReloaded;

public class PlayerListener
{
	private rTutorialProgress TP = new rTutorialProgress((rTutorialReloaded)rTutorialReloaded.plugin);
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e)
	{
		TP.TutorialCooldown(e.getPlayer());
	}
}
