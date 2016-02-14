package com.ReanKR.rTutorialReloaded.File;

import com.ReanKR.rTutorialReloaded.rTutorialReloaded;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileSection
{
	public static YamlConfiguration LoadFile(String Path)
	{
		if (!Path.endsWith(".yml"))
	    {
	      Path = Path + ".yml";
	    }
	    File file = new File("plugins/rTutorialReloaded/" + Path);
	    if(!file.exists())
	    {
	      try
	      {
	        rTutorialReloaded.plugin.saveResource(Path, true);
	        Bukkit.getConsoleSender().sendMessage(rTutorialReloaded.Prefix + "Create New File " + file.getAbsolutePath());
	      }
	      catch (NullPointerException e)
	      {
	        e.printStackTrace();
	        Bukkit.getConsoleSender().sendMessage(rTutorialReloaded.Prefix + "Cannot save " + Path);
	        return null;
	      }
	    }
	    YamlConfiguration Config = YamlConfiguration.loadConfiguration(file);
	    return Config;
	  }

	public static ConfigurationSection PlusSelect(ConfigurationSection CS, String Name)
	{
	  return CS.getConfigurationSection(Name);
	}
}
