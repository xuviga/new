//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.gui;

import net.minecraftforge.fml.relauncher.*;
import com.mayakplay.cscase.model.*;
import net.minecraft.item.*;
import java.awt.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.*;

@SideOnly(Side.CLIENT)
public class GuiCaseWon extends MPGui
{
    float animation;
    float mainAnimation;
    float fenceAnim;
    float numAnim;
    ModelGuiCase model;
    private final int itemsCount;
    private final ItemStack itemStack;
    private final int quality;
    
    public GuiCaseWon(final ItemStack itemStack, final int quality) {
        this.animation = 0.0f;
        this.mainAnimation = 25.0f;
        this.fenceAnim = 0.0f;
        this.numAnim = 0.0f;
        this.model = new ModelGuiCase();
        this.quality = quality;
        this.itemsCount = itemStack.getCount();
        this.itemStack = new ItemStack(itemStack.getItem(), 1);
    }
    
    @Override
    public void drawScreen(final int x, final int y, final float ticks) {
        super.drawScreen(x, y, ticks);
        this.drawDefaultBackground();
        final ScaledResolution scaled = new ScaledResolution(this.mc);
        final int factor = scaled.getScaleFactor();
        final int panX = 205;
        final int panY = 105;
        final int guiX = this.width / 2 - panX / 2;
        final int guiY = this.height / 2 - panY / 2;
        Color color = Color.white;
        switch (this.quality) {
            case 1: {
                color = Color.WHITE;
                break;
            }
            case 2: {
                color = Color.GREEN;
                break;
            }
            case 3: {
                color = Color.BLUE;
                break;
            }
            case 4: {
                color = Color.MAGENTA;
                break;
            }
            case 5: {
                color = Color.ORANGE;
                break;
            }
            case 6: {
                color = Color.RED;
                break;
            }
        }
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/opctexture.png"));
        this.drawTexturedModalRect(guiX - 7, guiY - 16, 0, 0, 219, 146);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        this.drawCenteredString(this.fontRenderer, this.itemStack.getDisplayName(), this.width / 2, guiY - 12, 16777215);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/opctexture.png"));
        if (this.fenceAnim == -0.9f) {
            if (!this.isHover(guiX - 7 + 67, guiY - 16 + 124, 85, 17)) {
                this.drawTexturedModalRect(guiX - 7 + 67, guiY - 16 + 124, 0, 146, 85, 17);
            }
            else {
                this.drawTexturedModalRect(guiX - 7 + 67, guiY - 16 + 124, 0, 164, 85, 17);
            }
            if (this.isClicked(guiX - 7 + 67, guiY - 16 + 124, 85, 17)) {
                this.mc.displayGuiScreen((GuiScreen)null);
            }
            this.drawScaledString("\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c", (float)(guiX - 5 + 67 + 42), (float)(guiY - 11 + 124), 0.76f, TextPosition.CENTER);
        }
        if (this.animation >= 360.0f) {
            this.animation = 0.0f;
        }
        if (this.mainAnimation <= 8.0f) {
            this.mainAnimation = 8.0f;
        }
        if (this.mainAnimation <= 15.0f) {
            this.fenceAnim -= this.delta / 90.0f;
        }
        if (this.fenceAnim <= -0.9f) {
            this.fenceAnim = -0.9f;
        }
        if (this.fenceAnim <= -0.8) {
            this.numAnim += this.delta / 60.0f;
        }
        if (this.numAnim >= 0.3f) {
            this.numAnim = 0.3f;
        }
        GlStateManager.pushMatrix();
        final EntityItem entityItem = new EntityItem((World)this.mc.world, 0.0, 0.0, 0.0, this.itemStack);
        entityItem.hoverStart = 0.0f;
        GL11.glEnable(3089);
        GL11.glScissor(guiX * factor, this.height * factor - guiY * factor - panY * factor, panX * factor, panY * factor);
        GL11.glEnable(2929);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GL11.glDisable(2884);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/casesopened.png"));
        GlStateManager.translate((float)(this.width / 2 + 7), (float)(this.height / 2 - 113), 360.0f);
        GlStateManager.scale(118.0f, 118.0f, 1.0f);
        GlStateManager.rotate(270.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(this.mainAnimation, 0.0f, 1.0f, 1.0f);
        this.model.renderModel(0.0625f, this.fenceAnim, this.numAnim);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.translate(-0.5f, 1.35f, 0.0f);
        GlStateManager.scale(1.2f, 1.2f, 1.2f);
        GlStateManager.rotate(8.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(this.animation + 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        Minecraft.getMinecraft().getRenderManager().renderEntity((Entity)entityItem, 0.0, 0.0, 0.0, 0.2f, 0.2f, false);
        GL11.glDisable(3089);
        GlStateManager.popMatrix();
        if (this.numAnim >= 0.22) {
            GlStateManager.pushMatrix();
            if (this.itemsCount >= 10) {
                GlStateManager.translate((float)(this.width / 2 + 77), (float)(this.height / 2 - 37), 400.0f);
            }
            else {
                GlStateManager.translate(this.width / 2 + 77 + 4.6f, (float)(this.height / 2 - 37), 400.0f);
            }
            GlStateManager.scale(1.5f, 1.5f, 1.5f);
            this.fontRenderer.drawString(TextFormatting.DARK_GRAY + "" + this.itemsCount, 0, 0, -872415232);
            GlStateManager.popMatrix();
        }
        if (this.mainAnimation <= 8.0f) {
            this.animation += this.delta;
        }
        else {
            this.mainAnimation += -this.delta / 6.0f;
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
