package com.ReanKR.rTutorialReloaded;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

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

	// Saved variable loaded by Location.yml
	public static List<String> LocationMethod; // World,X,Y,Z,Pitch,Yaw
	public static List<String> MessageMethod; // Main message, Sub message
	public static int MethodAmount = 0; // Location method amount

	// rTutorial Reloaded main variable
	public static List<String> ErrorReporting; // Save error collection
	public static rTutorialReloaded rTutorialReloaded;
	public static String Prefix = "」e[」9r」aT」futorial」e]」f ";
	public static Economy Eco;
	public static Plugin plugin;
	
	//
	private ConsoleCommandSender Server = Bukkit.getConsoleSender();
	
	@Override
	public void onEnable()
	{
		Server.sendMessage(Prefix + "」bM」fade 」bb」fy Rean KR,」9 whitehack97@gmail.com");
		Server.sendMessage(Prefix + "」bD」fevoloper 」bW」febsite 」e: 」fhttp://cafe.naver.com/suserver24");
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
