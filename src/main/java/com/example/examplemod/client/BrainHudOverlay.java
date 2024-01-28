package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class BrainHudOverlay {
    private static final ResourceLocation FILLED_BRAIN = new ResourceLocation(ExampleMod.MODID,
            "textures/item/filled_brain.png");
    private static final ResourceLocation EMPTY_BRAIN = new ResourceLocation(ExampleMod.MODID,
            "textures/item/empty_brain.png");

    public static final IGuiOverlay HUD_BRAIN = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, FILLED_BRAIN);
        int brain_num = 5;
        for(int i = 0; i < brain_num; i++) {
            GuiComponent.blit(poseStack,x - 94 + (i * 12), y - 54,0,0,12,12,
                    12,12);
        }

        RenderSystem.setShaderTexture(0, EMPTY_BRAIN);
        for(int i = brain_num; i < 10; i++) {
            GuiComponent.blit(poseStack,x - 94 + (i * 12),y - 54,0,0,12,12,
                    12,12);
        }
    });
}
