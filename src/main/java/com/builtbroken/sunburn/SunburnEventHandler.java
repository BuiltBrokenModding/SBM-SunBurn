package com.builtbroken.sunburn;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 07/04/2018.
 */
@Mod.EventBusSubscriber(modid = Sunburn.DOMAIN)
public class SunburnEventHandler {

    private static final int baseBurnTime = 4;

    @SubscribeEvent
    public static void onPlayerInSunlight(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        World world = entity.world;
        Biome biome = entity.world.getBiome(new BlockPos(entity.posX, entity.posY, entity.posZ));
        Random rand = new Random();

        if (entity instanceof EntityPlayer && world.isDaytime() && !world.isRemote && !entity.isChild() && !((EntityPlayer) entity).isCreative()) {
            float f = entity.getBrightness();
            if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canSeeSky(new BlockPos(entity.posX, entity.posY + (double) entity.getEyeHeight(), entity.posZ))) {
                if (BiomeManager.getBiomes(BiomeManager.BiomeType.WARM).contains(biome) || BiomeManager.getBiomes(BiomeManager.BiomeType.DESERT).contains(biome)) {
                    entity.setFire(baseBurnTime * 4);
                } else if (BiomeManager.getBiomes(BiomeManager.BiomeType.COOL).contains(biome) || BiomeManager.getBiomes(BiomeManager.BiomeType.ICY).contains(biome)) {
                    entity.setFire(baseBurnTime * 2);
                } else {
                    entity.setFire(baseBurnTime);
                }
            }
        }
    }
}
