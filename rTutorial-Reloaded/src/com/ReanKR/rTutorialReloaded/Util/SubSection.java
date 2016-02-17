package com.ReanKR.rTutorialReloaded.Util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.ReanKR.rTutorialReloaded.rTutorialReloaded;

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
	
	public static String GameMsg(String Str)
	{
		String replace = rTutorialReloaded.Prefix + Str;
		return replace;
	}
	
	public static String SubMsg(String MessageMethod, Player player, Boolean Return, Boolean AddPrefix)
	{
	    String Message = (String)rTutorialReloaded.SystemMessage.get(MessageMethod);
	    String Replacement = Message.replaceAll("%player%", player.getName());
	    if(Return)
	    {
	    	if(AddPrefix) return ChatColor.translateAlternateColorCodes('&', rTutorialReloaded.Prefix + Replacement);
	    	else return ChatColor.translateAlternateColorCodes('&', Replacement);
	    }
	    else
	    {
	    	if(AddPrefix) player.sendMessage(ChatColor.translateAlternateColorCodes('&', rTutorialReloaded.Prefix + Replacement));
	    	else player.sendMessage(ChatColor.translateAlternateColorCodes('&', Replacement));
	    }
	    return null;
	}
}
