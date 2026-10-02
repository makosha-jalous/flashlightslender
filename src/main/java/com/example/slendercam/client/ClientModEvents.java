package com.example.slendercam.client;

import com.example.slendercam.FlashlightItem;
import com.example.slendercam.SlenderCamMod;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SlenderCamMod.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiOverlaysEvent e) {
        e.registerAboveAll("camera", CameraHud::render);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e) {
        e.enqueueWork(() -> ItemProperties.register(SlenderCamMod.FLASHLIGHT.get(),
                new ResourceLocation(SlenderCamMod.ID, "on"),
                (stack, level, entity, seed) -> FlashlightItem.isOn(stack) ? 1f : 0f));
    }
}
