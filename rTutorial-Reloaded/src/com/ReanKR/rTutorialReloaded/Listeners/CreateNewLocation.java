package com.ReanKR.rTutorialReloaded.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.ReanKR.rTutorialReloaded.Util.SoundCreation;
import com.ReanKR.rTutorialReloaded.rTutorialReloaded;

public class CreateNewLocation extends JavaPlugin
{
	private ConsoleCommandSender Server = Bukkit.getConsoleSender();
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
		}
	}
	
	@EventHandler
	public void BlockingWhenCreating(PlayerCommandPreprocessEvent e)
	{
		if(rTutorialReloaded.IsCreateNewLocation.get(e.getPlayer()).booleanValue())
		{
			SC.PlayerSound(e.getPlayer(), Sound.ANVIL_LAND, 1.2F, 1.7F);
			Server.sendMessage(rTutorialReloaded.Prefix + "§c새로운 위치를 만드는 중에는 다른 커맨드를 사용할 수 없습니다.");
			Server.sendMessage(rTutorialReloaded.Prefix + "§c취소하려면  /rt create cancel");
			e.setCancelled(true);
		}
	}
}
