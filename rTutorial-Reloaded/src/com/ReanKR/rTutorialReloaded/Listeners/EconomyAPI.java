package com.ReanKR.rTutorialReloaded.Listeners;

import com.ReanKR.rTutorialReloaded.rTutorialReloaded;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

public class EconomyAPI
{
  public static Economy getEconomy()
  {
    Economy ecoHook = null;

    RegisteredServiceProvider<Economy> economyProvider = rTutorialReloaded.plugin.getServer().getServicesManager().getRegistration(Economy.class);
    if (economyProvider != null)
    {
      ecoHook = (Economy)economyProvider.getProvider();
    }
    return ecoHook;
  }
}
