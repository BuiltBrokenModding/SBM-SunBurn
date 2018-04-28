package com.builtbroken.sunburn;

import net.minecraftforge.common.config.Config;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/28/2018.
 */
@Config(modid = Sunburn.DOMAIN, name = "sbm-sunburn")
@Config.LangKey("config.merpig:spawning.title")
public class ConfigMain
{
    @Config.Name("sun_block_ticks")
    @Config.Comment("How long in ticks (20 ticks a second) should the player be immune to sun damage on respawn.")
    public static int SUN_BLOCK_TICKS = 20 /* Ticks */ * 60 /* Seconds */ * 20 /* Mins */; //Defaults to 20mins by request

    @Config.Name("set_fire_time")
    @Config.Comment("How long in seconds to set fire to the player if they are standing in sunlight.")
    public static int TIME_TO_SET_FIRE = 4;
}
