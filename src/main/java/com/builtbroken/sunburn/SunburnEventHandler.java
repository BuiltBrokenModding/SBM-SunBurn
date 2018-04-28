package com.builtbroken.sunburn;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 07/04/2018.
 */
@Mod.EventBusSubscriber(modid = Sunburn.DOMAIN)
public class SunburnEventHandler
{
    public static final String NBT_SUN_BLOCK = Sunburn.PREFIX + "sun_block";

    @SubscribeEvent
    public static void onPlayerInSunlight(LivingEvent.LivingUpdateEvent event)
    {
        if (event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            if (canBurn(player))
            {
                float brightness = player.getBrightness();
                if (brightness > 0.5F && !player.isImmuneToFire() && player.world.canSeeSky(new BlockPos(player.posX, player.posY + (double) player.getEyeHeight(), player.posZ)))
                {
                    player.setFire(ConfigMain.TIME_TO_SET_FIRE);
                }
            }
            else if (getSunBlock(player) > 0)
            {
                setSunBlock(player, getSunBlock(player) - 1);
            }
        }
    }

    public static boolean canBurn(EntityPlayer player)
    {
        return player.world.isDaytime() && !player.world.isRemote && !player.isCreative() && getSunBlock(player) <= 0;
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event)
    {
        final EntityPlayer entity = event.player;
        final World world = entity.world;

        if (!world.isRemote && !event.isEndConquered())
        {
            setSunBlock(entity, ConfigMain.SUN_BLOCK_TICKS);
        }
    }

    public static void setSunBlock(EntityPlayer player, int time)
    {
        player.getEntityData().setInteger(NBT_SUN_BLOCK, time);
    }

    public static int getSunBlock(EntityPlayer player)
    {
        return player.getEntityData().getInteger(NBT_SUN_BLOCK);
    }
}
