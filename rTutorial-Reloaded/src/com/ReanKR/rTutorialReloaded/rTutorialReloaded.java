package com.ReanKR.rTutorialReloaded;

import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class rTutorialReloaded extends JavaPlugin implements Listener
{
	// Saved variable loaded by Config.yml
	public static int ConfigVersion;
	public static boolean RunFirstJoinPlayer = false;
	public static boolean BlockMovement = true;
	public static boolean BlockAllCommands = true;
	public static boolean BroadcastCompleteTutorial = false;
	public static boolean EditComplete = false;
	public static int DefaultDelaySeconds = 6;
	public static int DefaultCooldownSeconds = 5;
	public static boolean SoundDisabled = true;
	public static boolean[] CompatiblePlugins;
	public static String[] ExceptionCommands;
	public static boolean RunCommands = true;
	public static boolean RewardItems = true;
	public static List<String> ResultCommands;
	public static List<ItemStack> ResultItems;
	
	// 
	public static rTutorialReloaded rTutorialReloaded;
	public static String Prefix = "」e[」9r」aT」futorial」e]」f ";
	public static Plugin plugin;
	
	//
	@Override
	public void onEnable()
	{
		
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
