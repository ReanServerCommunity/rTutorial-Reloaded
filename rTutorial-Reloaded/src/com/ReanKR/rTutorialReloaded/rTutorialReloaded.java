package com.ReanKR.rTutorialReloaded;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.ReanKR.rTutorialReloaded.Listeners.EconomyAPI;
import com.ReanKR.rTutorialReloaded.Util.VariableManager;

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
	
	// Saved variable loaded by message.yml 
	public static Map<String, String> MainMessages; // MSG_TYPE, Message
	
	// Saved variable about tutorial system
	public static HashMap<Player, String> TutorialStatus;
	public static HashMap<String, Boolean> TutorialComplete; // Is Player completed tutorial
	public static HashMap<Player, String> ProgressingTutorial; // Showing the player that tutorial progressing method
	public static HashMap<Player, Boolean> IsCreateNewLocation;  // Enabled Blocking AsyncChatEvent when creating new data
	public static HashMap<Player, Boolean> SavedNewLocation;
	public static HashMap<Player, Integer> CreatingNewLocation;
	public static HashMap<Player, String> MainMessage;
	public static HashMap<Player, String> SubMessage;

	// rTutorial Reloaded main variable
	public static List<String> ErrorReporting; // Save error collection
	public static rTutorialReloaded RTutorialReloaded;
	public static Plugin plugin;
	public static String Prefix = "」e[」9r」aT」futorial」e]」f ";
	public static Economy Eco;
	
	// Substituted for the short
	private ConsoleCommandSender Server = Bukkit.getConsoleSender();
	
	@Override
	public void onEnable()
	{
		RTutorialReloaded = this;
		plugin = this;
		VariableManager.InitAllVariable();
		Eco = EconomyAPI.getEconomy();
		Server.sendMessage(Prefix + "」bM」fade 」bb」fy Rean KR,」9 whitehack97@gmail.com");
		Server.sendMessage(Prefix + "」bD」fevoloper 」bW」febsite 」e: 」fhttp://cafe.naver.com/suserver24");
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
