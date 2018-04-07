package com.builtbroken.sunburn;

import net.minecraftforge.fml.common.Mod;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 07/04/2018.
 */
@Mod(modid = Sunburn.DOMAIN, name = "[SBM] Sunburn", version = Sunburn.VERSION)
@Mod.EventBusSubscriber
public class Sunburn {

    public static final String DOMAIN = "sunburn";
    public static final String PREFIX = DOMAIN + ":";

    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String MC_VERSION = "@MC@";
    public static final String VERSION = MC_VERSION + "-" + MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

}
