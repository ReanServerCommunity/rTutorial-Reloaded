package com.ReanKR.rTutorialReloaded.Util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundCreation
{
	@SuppressWarnings("deprecation")
	public void PlayerSound(Player player, Sound sound, float volume, float pitch)
	{
    	if(Bukkit.getOfflinePlayer(player.getName()).isOnline()) player.playSound(player.getLocation(), sound ,volume, pitch);
	}
}
