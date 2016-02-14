package com.ReanKR.rTutorialReloaded.Util;

import java.util.ArrayList;
import java.util.HashMap;

import com.ReanKR.rTutorialReloaded.rTutorialReloaded;

public class VariableManager
{
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void InitAllVariable()
	{
		rTutorialReloaded.ExceptionCommands = new ArrayList();
		rTutorialReloaded.ResultCommands = new ArrayList();
		rTutorialReloaded.ResultItems = new ArrayList();
		rTutorialReloaded.LocationMethod = new ArrayList();
		rTutorialReloaded.MessageMethod = new ArrayList();
		rTutorialReloaded.SystemMessage = new HashMap();
		rTutorialReloaded.TutorialStatus = new HashMap();
		rTutorialReloaded.TutorialComplete = new HashMap();
		rTutorialReloaded.ProgressingTutorial = new HashMap();
		rTutorialReloaded.MainMessage = new HashMap();
		rTutorialReloaded.SubMessage = new HashMap();
		rTutorialReloaded.IsCreateNewLocation = new HashMap();
		rTutorialReloaded.SavedNewLocation = new HashMap();
		rTutorialReloaded.CreatingCount = new HashMap();
		rTutorialReloaded.ErrorReporting = new ArrayList();
	}
}
