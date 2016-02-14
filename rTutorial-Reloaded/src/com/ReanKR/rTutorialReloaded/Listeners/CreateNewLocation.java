package com.ReanKR.rTutorialReloaded.Listeners;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.ReanKR.rTutorialReloaded.Util.SoundCreation;
import com.ReanKR.rTutorialReloaded.Util.SubSection;
import com.ReanKR.rTutorialReloaded.rTutorialReloaded;

public class CreateNewLocation extends JavaPlugin
{
	private SoundCreation SC = new SoundCreation();
	
	@EventHandler
	public void CreateNewMethod(AsyncPlayerChatEvent e)
	{
		if(! rTutorialReloaded.MainMessage.containsKey(e.getPlayer()))
		{
			rTutorialReloaded.MainMessage.put(e.getPlayer(), e.getMessage());
		}
		else
		{
			rTutorialReloaded.SubMessage.put(e.getPlayer(), e.getMessage());
			rTutorialReloaded.IsCreateNewLocation.remove(e.getPlayer());
			rTutorialReloaded.SavedNewLocation.put(e.getPlayer(), true);
			e.getPlayer().sendMessage(rTutorialReloaded.Prefix + rTutorialReloaded.SystemMessage.get("CompleteCreatingMethod"));
			e.getPlayer().sendMessage(rTutorialReloaded.Prefix + SubSection.VariableSub(rTutorialReloaded.SystemMessage.get("ContinueCommand"), "/rt create save"));
		}
	}
	
	@EventHandler
	public void BlockingWhenCreating(PlayerCommandPreprocessEvent e)
	{
		if(rTutorialReloaded.IsCreateNewLocation.get(e.getPlayer()).booleanValue())
		{
			SC.PlayerSound(e.getPlayer(), Sound.ANVIL_LAND, 1.2F, 1.7F);
			e.getPlayer().sendMessage(rTutorialReloaded.Prefix + rTutorialReloaded.SystemMessage.get("BlockCommandWhenCreate"));
			e.getPlayer().sendMessage(rTutorialReloaded.Prefix + SubSection.VariableSub(rTutorialReloaded.SystemMessage.get("CancelCommand"), "/rt create cancel"));
			e.setCancelled(true);
		}
	}
}
