package com.ReanKR.rTutorialReloaded;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.ReanKR.rTutorialReloaded.rTutorialReloaded;
import com.ReanKR.rTutorialReloaded.File.BackupManager;
import com.ReanKR.rTutorialReloaded.Util.SoundCreation;
import com.ReanKR.rTutorialReloaded.Util.SubSection;
import com.connorlinfoot.titleapi.TitleAPI;

import me.confuser.barapi.BarAPI;

public class rTutorialProgress
{
	public Map<String, Integer> taskID = new HashMap<String, Integer>();
	public Map<String, Float> Progress = new HashMap<String, Float>();
	public Map<String, GameMode> PlayerGameMode = new HashMap<String, GameMode>();
	public Map<String, Float> PlayerSpeed = new HashMap<String, Float>();
	public Map<String, Float> PlayerFlySpeed = new HashMap<String, Float>();
	private File PlayerFile = new File("plugins/rTutorial/Player.yml");
	
	private rTutorialReloaded plugin;
	
	public rTutorialProgress(rTutorialReloaded plugin)
	{
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public void TutorialCooldown(final Player p)
	{
		SoundCreation SC = new SoundCreation();
		final int tid = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
		{
			@Override
			public void run()
			{
				if(! plugin.getServer().getOfflinePlayer(p.getName()).isOnline()) // if player leaved server when tutorial progressing
				{
					Bukkit.getConsoleSender().sendMessage("The player leave by server.");
					if(rTutorialReloaded.CompatiblePlugins[0]) BarAPI.removeBar(p);
					BackupManager.SaveUnexpected(p);
					endTask(p, false);
					return;
				}
				
				if(Progress.get(p.getName()) <= 0)
				{
					PlayerGameMode.put(p.getName(), p.getGameMode());
					PlayerSpeed.put(p.getName(), p.getWalkSpeed());
					PlayerFlySpeed.put(p.getName(), p.getFlySpeed());
					endTask(p, false);
					// Working(p);
				}

				else
				{
					if(! rTutorialReloaded.SoundDisabled) SC.PlayerSound(p, Sound.NOTE_PLING, 10.0F, 1.0F);
					
					if(rTutorialReloaded.CompatiblePlugins[0])
					{
						BarAPI.setMessage(p, "rTutorialReloaded v1.0.0" , (Progress.get(p.getName()) / rTutorialReloaded.DefaultCooldownSeconds) * 100);
					}
					
					if(rTutorialReloaded.CompatiblePlugins[1])
					{
						if(Progress.get(p.getName()) >= 2) TitleAPI.sendTitle(p, 0, 0, 30, SubSection.VariableSub(SubSection.SubMsg("LeftSeconds", p, true, false),
								Progress.get(p.getName()).intValue()), "rTutorial " + plugin.getDescription().getVersion());
						else TitleAPI.sendTitle(p, 0, 0, 30, SubSection.VariableSub(SubSection.SubMsg("LeftSeconds", p, true, false),
								Progress.get(p.getName()).intValue()), "Let's go tutorial");
					}
					else
					{
						p.sendMessage(rTutorialReloaded.Prefix + SubSection.VariableSub(SubSection.SubMsg("LeftSeconds", p, true, false), Progress.get(p.getName()).intValue()));
					}
					Progress.put(p.getName(), Progress.get(p.getName()) - 1);
				}
			}

		},0L, 20L);
		taskID.put(p.getName(), tid);
		Progress.put(p.getName(), (float)rTutorialReloaded.DefaultCooldownSeconds);
		rTutorialReloaded.ProgressingTutorial.put(p, "COOLDOWN");
		// FileSection.SetKey(PlayerFile, FS.PlusSelect(YamlConfiguration.loadConfiguration(PlayerFile), p.getUniqueId().toString()), "Status", "Cooldown");
	}

	public void endTask(Player p, boolean CompleteTutorial)
	{
		if(taskID.containsKey(p.getName()))
		{
			int tid = taskID.get(p.getName());
			plugin.getServer().getScheduler().cancelTask(tid);
			taskID.remove(p.getName());
			Progress.remove(p.getName());
		}
		if(CompleteTutorial)
		{
			p.setGameMode(PlayerGameMode.get(p.getName()));
			p.setWalkSpeed(PlayerSpeed.get(p.getName()));
			p.setFlySpeed(PlayerFlySpeed.get(p.getName()));
		}
	}
}
