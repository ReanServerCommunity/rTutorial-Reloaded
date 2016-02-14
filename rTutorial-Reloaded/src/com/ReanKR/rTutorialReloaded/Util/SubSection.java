package com.ReanKR.rTutorialReloaded.Util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SubSection
{
	public static String Sub(String str, Player p)
	{
		String replace = str.replaceAll("%player%", p.getName());
		return replace;
	}
	
	public static String VariableSub(String str, Object object)
	{
		String replace = str.replaceAll("%var%", String.valueOf(object));
		return replace;
	}
	
	public static String RepColor(String Str)
	{
		String replace = ChatColor.translateAlternateColorCodes('&', Str);
		return replace;
	}
	
	public static String OutSys(String Str, Object object)
	{
		String replace = ChatColor.translateAlternateColorCodes('&', Str);
		replace = VariableSub(replace, String.valueOf(object));
		return replace;
	}

}
