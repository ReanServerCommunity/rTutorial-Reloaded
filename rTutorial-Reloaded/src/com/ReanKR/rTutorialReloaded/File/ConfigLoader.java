package com.ReanKR.rTutorialReloaded.File;

import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import com.ReanKR.rTutorialReloaded.rTutorialReloaded;
import com.ReanKR.rTutorialReloaded.File.FileSection;

public class ConfigLoader
{
	public static rTutorialReloaded plugin = rTutorialReloaded.RTutorialReloaded;
	public void LoadCfg()
	{
		FileConfiguration ConfigFile = FileSection.LoadFile("config");
		Set<String> Keyword = ConfigFile.getKeys(false);
		for(String Str : Keyword)
		{
			ConfigurationSection MainNode = ConfigFile.getConfigurationSection(Str);
			try
			{
				if(Str.equalsIgnoreCase("Main"))
				{
					if(! MainNode.isSet("Config-Version"))
					{
						rTutorialReloaded.ErrorReporting.add("config.yml - Missing Config Version.");
						plugin.getPluginLoader().disablePlugin(rTutorialReloaded.RTutorialReloaded);
						return;
					}
				}
			}
			catch(NullPointerException e)
			{
				
			}
		}
	}
	    /*
	    try
	    {
	      for (String Str : Keyword)
	      {
	        ConfigurationSection MainNode = ConfigFile.getConfigurationSection(Str);
	        try
	        {
	          boolean ProblemNotFound = true;
	          if (Str.equalsIgnoreCase("Main"))
	          {
	            if (!MainNode.isSet("Config-Version"))
	            {
	              rTutorial.ErrorReporting.add(Str + ",MISSING_CONFIG_VERSION");
	              ProblemNotFound = false;
	            }

	            if (!MainNode.isSet("Run-First-Join-Player"))
	            {
	              rTutorial.ErrorReporting.add(Str + ",MISSING_VALUE_RUN_FIRST_JOIN_PLAYER");
	              ProblemNotFound = false;
	            }

	            if (MainNode.isSet("Block-Movement"))
	            {
	              rTutorial.BlockMovement = MainNode.getBoolean("Block-Movement");
	            }

	            if (MainNode.isSet("Block-All-Commands"))
	            {
	              rTutorial.BlockAllCommands = MainNode.getBoolean("Block-All-Commands");
	            }

	            if (MainNode.isSet("Broadcast-Complete-Tutorial"))
	            {
	              rTutorial.CompleteBroadcast = MainNode.getBoolean("Broadcast-Complete-Tutorial");
	            }

	            if (!MainNode.isSet("Edit-Complete"))
	            {
	              rTutorial.ErrorReporting.add(Str + ",MISSING_VALUE_EDIT_COMPLETE");
	              ProblemNotFound = false;
	            }
	            rTutorial.ConfigVersion = MainNode.getInt("Config-Version");
	            rTutorial.RunFirstJoinPlayer = MainNode.getBoolean("Run-First-Join-Player");
	            rTutorial.EditComplete = MainNode.getBoolean("Edit-Complete");
	            rTutorial.DefaultDelaySeconds = MainNode.getInt("Default-Delay-Seconds");
	            rTutorial.DefaultCooldownSeconds = MainNode.getInt("Default-Cooldown-Seconds");
	            rTutorial.SoundDisabled = MainNode.getBoolean("Sound-Disabled");
	          }
	          if (ProblemNotFound)
	          {
	            if (Str.equalsIgnoreCase("Compatibles"))
	            {
	              rTutorial.CompatiblePlugins[0] = MainNode.getBoolean("TitleAPI");
	              rTutorial.CompatiblePlugins[1] = MainNode.getBoolean("Vault");
	              rTutorial.CompatiblePlugins[2] = MainNode.getBoolean("Economy");
	            }

	            if (!Str.equalsIgnoreCase("Result"))
	              continue;
	            rTutorial.ResultCommands.addAll(MainNode.getStringList("Commands"));

	            ConfigurationSection ResultNode = PlusSelect(MainNode, "Items");
	            Set<String> Results = ResultNode.getKeys(false);
	            for (String ResultKeyword : Results)
	            {
	              if (isNumber(ResultKeyword))
	              {
	                int ID = 0;
	                int Amounts = 0;
	                byte Data = 0;
	                ConfigurationSection ResultNode2 = PlusSelect(ResultNode, ResultKeyword);
	                try
	                {
	                  ID = Integer.valueOf(ResultNode2.getInt("ID")).intValue();
	                  Data = Byte.parseByte(ResultNode2.getString("DATA-VALUE"));
	                  Amounts = Integer.parseInt(ResultNode2.getString("Amounts"));
	                }
	                catch (NullPointerException e)
	                {
	                  rTutorial.ErrorReporting.add(Str + "," + ResultKeyword + ",LOAD_FAILED_ITEM_INFO");
	                  continue;
	                }
	                @SuppressWarnings("deprecation")
					ItemStack item = new MaterialData(ID, Data).toItemStack(Amounts);
	                rTutorial.ResultItems.add(item);
	              }
	              else
	              {
	                rTutorial.ErrorReporting.add(Str + "," + ResultKeyword + ",MUST_INTEGER_METHOD");
	              }
	            }

	          }
	          else
	          {
	            rTutorial.ErrorReporting.add(Str + ",MISSING_REQUIED_CONFIG_VALUE");
	            return;
	          }
	        }
	        catch (NullPointerException e)
	        {
	          e.printStackTrace();
	          rTutorial.ErrorReporting.add(Str + ",MISSING_CONFIG_VALUE");
	        }
	      }

	    }
	    catch (NullPointerException e)
	    {
	      rTutorial.ErrorReporting.add("ConfigFile,MISSING_KEY_VALUE");
	    }
	  }
	  */
}
