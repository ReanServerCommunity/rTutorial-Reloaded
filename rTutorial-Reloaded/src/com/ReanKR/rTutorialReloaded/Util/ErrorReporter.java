package com.ReanKR.rTutorialReloaded.Util;

import org.bukkit.Bukkit;

import com.ReanKR.rTutorialReloaded.rTutorialReloaded;

public class ErrorReporter
{
	public static void ResultErrorReport()
	{
		if(rTutorialReloaded.ErrorReporting.size() == 0)
		{
		  return;
		}
		Bukkit.getConsoleSender().sendMessage(rTutorialReloaded.Prefix + "」e============ 」cE」frror」cR」feport 」e============");
		int i = 0;
		while (i != rTutorialReloaded.ErrorReporting.size())
		{
		  Bukkit.getConsoleSender().sendMessage(rTutorialReloaded.Prefix + (String)rTutorialReloaded.ErrorReporting.get(i));
		  i++;
		}
		Bukkit.getConsoleSender().sendMessage(rTutorialReloaded.Prefix + "」e============ 」cE」frror」cR」feport 」e============");
	}
}
