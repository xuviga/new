package com.mayakplay.cscase.gui;
import net.minecraftforge.fml.relauncher.*;
import com.mayakplay.cscase.model.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import com.mayakplay.cscase.network.*;
import com.mayakplay.cscase.pojo.*;
import org.lwjgl.opengl.*;
import com.mayakplay.cscase.*;
import java.awt.*;
import java.util.List;

import net.minecraft.client.gui.*;
import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import com.mojang.realmsclient.gui.*;

@SideOnly(Side.CLIENT)
public class GuiCaseView extends MPGui
{
    float rollMove;
    int counter;
    float gridAnim;
    float animation;
    float mainAnimation;
    float fenceAnim;
    float numAnim;
    ModelGuiCase model;
    private final int caseid;
    private boolean isWon;
    private List<CaseItem> ROLLING_ITEMS;
    private boolean isCaseLoading;
    private float caseLoadingRotation;
    private float littleWaiting;
    private float slow;
    private int randStop;
    private final boolean isRolling = false;
    private final boolean useful1 = true;
    private int current;
    private int lastInt;
    private int itemsCount;
    private int casePrice;
    private ItemStack itemStack;
    private int quality;

    public GuiCaseView(final int caseid) {
        this.rollMove = 0.0f;
        this.counter = 0;
        this.gridAnim = 0.0f;
        this.animation = 0.0f;
        this.mainAnimation = 25.0f;
        this.fenceAnim = 0.0f;
        this.numAnim = 0.0f;
        this.model = new ModelGuiCase();
        this.isWon = false;
        this.ROLLING_ITEMS = null;
        this.isCaseLoading = false;
        this.caseLoadingRotation = 160.0f;
        this.littleWaiting = 0.0f;
        this.slow = PacketsDecoder.randFloat(9.38f, 9.42f);
        this.randStop = 0;
        this.current = 0;
        this.lastInt = 0;
        this.caseid = caseid;
    }
    @Override
    public void drawScreen(final int x, final int y, final float ticks) {
        super.drawScreen(x, y, ticks);
        this.drawDefaultBackground();
        final ScaledResolution scaled = new ScaledResolution(this.mc);
        final int factor = scaled.getScaleFactor();
        final int guiX = this.width / 2 - 127;
        final int guiY = this.height / 2 - 113;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturecw.png"));
        this.drawTexturedModalRect(guiX, guiY, 0, 0, 256, 72);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.6f);
        this.drawTexturedModalRect(guiX, guiY, 0, 0, 256, 255);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        this.drawScaledString(Strings.itemsCanDrop, (float)(guiX + 12), (float)(guiY + 63), 0.85f, TextPosition.LEFT);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
        if (!Recieve.isRolling) {
            if (!this.isCaseLoading) {
                if (!this.isHover(guiX + 65, guiY + 39, 125, 14)) {
                    this.drawTexturedModalRect(guiX + 65, guiY + 39, 0, 214, 125, 14);
                }
                else {
                    this.drawTexturedModalRect(guiX + 65, guiY + 39, 0, 228, 125, 14);
                }
                if (this.isClicked(guiX + 65, guiY + 39, 125, 14)) {
                    this.isCaseLoading = true;
                    this.mc.player.sendChatMessage("/rollcase " + this.caseid);
                    this.randStop = PacketsDecoder.randInt(12, 21);
                    this.isClicked = false;
                }
                this.draw3DCase(guiX + 101, guiY + 13, "case" + this.caseid, 160.0f);
                int price = PacketsDecoder.getCases().get(this.caseid).getPrice();
                System.out.println("caseid: " + this.caseid + ", price: " + price);
                this.drawScaledString(Strings.openPrice(price), (float)(guiX + 128), (float)(guiY + 42), 0.92f, TextPosition.CENTER);

            }
            else {
                this.draw3DCase(guiX + 101, guiY + 13, "case" + this.caseid, this.caseLoadingRotation);
                this.caseLoadingRotation += this.delta * 2.0f;
                this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
                this.drawTexturedModalRect(guiX + 65, guiY + 39, 0, 242, 125, 14);
                this.drawScaledString(Strings.opening, (float)(guiX + 81), (float)(guiY + 42), 0.92f, TextPosition.LEFT);
            }
        }
        else {
            if (this.ROLLING_ITEMS == null) {
                this.ROLLING_ITEMS = PacketsDecoder.getRandomItemsForRoll();
            }
            this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
            this.drawTexturedModalRect(guiX + 65, guiY + 39, 0, 242, 125, 14);
            this.drawScaledString(Strings.opening, (float)(guiX + 81), (float)(guiY + 42), 0.92f, TextPosition.LEFT);
            this.drawRollingItems();
        }
        this.drawItemsGrid(x, y, guiX + 8, guiY + 73);
        if (this.isWon) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 400.0f);
            this.drawWonScreen(x, y, ticks);
            GlStateManager.popMatrix();
        }
    }
    
    public void onGuiClosed() {
        Recieve.isRolling = false;
    }
    
    private void drawRollingItems() {
        final ScaledResolution scaled = new ScaledResolution(this.mc);
        final int factor = scaled.getScaleFactor();
        final int guiX = this.width / 2 - 127;
        final int guiY = this.height / 2 - 113;
        GlStateManager.pushMatrix();
        GL11.glEnable(3089);
        GL11.glScissor((guiX + 66) * factor, this.height * factor - (guiY + 7) * factor - 30 * factor, 123 * factor, 30 * factor);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
        for (int i = 0; i < this.ROLLING_ITEMS.size(); ++i) {
            final Color cl = ColorHelper.getColorByRare(this.ROLLING_ITEMS.get(i).getRarity());
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.translate(guiX + this.rollMove + 66.0f + 40.0f * i, (float)(guiY + 8), 0.0f);
            this.drawTexturedModalRect(0, 0, 127, 0, 38, 20);
            final int poop = (int)(guiX + this.rollMove + 66.0f + 40.0f * i);
            final int contact = guiX + 127;
            if (contact >= poop && contact < 40 + poop) {
                this.current = i;
            }
            if (this.lastInt != this.current) {
                this.playSound("rolling");
            }
            this.lastInt = this.current;
            GlStateManager.color(cl.getRed() / 255.0f, cl.getGreen() / 255.0f, cl.getBlue() / 255.0f, 1.0f);
            this.drawTexturedModalRect(0, 20, 127, 20, 38, 8);
            GlStateManager.disableBlend();
            GlStateManager.color(1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
            final ItemStack is = this.ROLLING_ITEMS.get(i).getItemStack();
            this.draw3DGuiItem(is, guiX + this.rollMove + 85.0f + 40.0f * i, (float)(guiY + 26), 30.0f);
            GlStateManager.color(1.0f, 1.0f, 1.0f);
            if (is.getDisplayName().length() > 12) {
                this.drawScaledString(is.getDisplayName().substring(0, 11) + "...", guiX + this.rollMove + 67.0f + 40.0f * i, (float)(guiY + 29), 0.48f, TextPosition.LEFT);
            }
            else {
                this.drawScaledString(is.getDisplayName(), guiX + this.rollMove + 67.0f + 40.0f * i, (float)(guiY + 29), 0.48f, TextPosition.LEFT);
            }
            this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
        }
        GL11.glDisable(3089);
        GlStateManager.blendFunc(770, 771);
        GlStateManager.enableBlend();
        GlStateManager.translate(0.0f, 0.0f, 400.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
        this.drawTexturedModalRect(guiX + 102, guiY + 7, 165, 0, 51, 30);
        GlStateManager.popMatrix();
        if (this.rollMove >= -((this.ROLLING_ITEMS.size() - 4) * 40) + this.randStop) {
            this.rollMove -= this.delta * this.slow;
            if (this.slow >= 0.05f) {
                this.slow -= this.delta / 50.0f;
            }
        }
        else if (this.littleWaiting < 6.0f) {
            this.littleWaiting += this.delta * this.slow;
        }
        else {
            this.itemStack = this.ROLLING_ITEMS.get(57).getItemStack().copy();
            this.itemsCount = this.itemStack.getCount();
            this.quality = this.ROLLING_ITEMS.get(57).getRarity();
            this.isWon = true;
        }
    }
    
    private void drawItemsGrid(final int mouseX, final int mouseY, final int x, final int y) {
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (this.counter < (int)this.gridAnim) {
                    this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
                    this.drawTexturedModalRect(x + 3 + 47 * j, y + 2 + 48 * i, 82, 0, 45, 33);
                    final Color cl = ColorHelper.getColorByRare(PacketsDecoder.getCaseItemsList().get(this.counter).getRarity());
                    GlStateManager.pushMatrix();
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(770, 771);
                    this.drawTexturedModalRect(x + 3 + 47 * j, y + 2 + 48 * i + 33, 82, 33, 45, 12);
                    GlStateManager.color(cl.getRed() / 255.0f, cl.getGreen() / 255.0f, cl.getBlue() / 255.0f, 0.9f);
                    this.drawTexturedModalRect(x + 3 + 47 * j, y + 2 + 48 * i + 33, 82, 33, 45, 12);
                    GlStateManager.disableBlend();
                    GlStateManager.color(1.0f, 1.0f, 1.0f);
                    GlStateManager.popMatrix();
                    final ItemStack is = PacketsDecoder.getCaseItemsList().get(this.counter).getItemStack();
                    this.draw3DGuiItem(is, (float)(x + 25 + 47 * j), (float)(y + 29 + 48 * i), 38.0f);
                    String name = is.getDisplayName();
                    if (PacketsDecoder.getCaseItemsList().get(this.counter).getRarity() == 5) {
                        name = "\u2726 " + name + " \u2726";
                    }
                    if (name.length() > 14) {
                        this.drawScaledString(name.substring(0, 13) + "-", (float)(x + 5 + 47 * j), (float)(y + 36 + 48 * i), 0.5f, TextPosition.LEFT);
                        if (name.length() > 27) {
                            this.drawScaledString(name.substring(13, 26) + "...", (float)(x + 5 + 47 * j), (float)(y + 41 + 48 * i), 0.5f, TextPosition.LEFT);
                        }
                        else {
                            this.drawScaledString(name.substring(13), (float)(x + 5 + 47 * j), (float)(y + 41 + 48 * i), 0.5f, TextPosition.LEFT);
                        }
                    }
                    else {
                        this.drawScaledString(name, (float)(x + 5 + 47 * j), (float)(y + 38 + 48 * i), 0.5f, TextPosition.LEFT);
                    }
                    ++this.counter;
                }
            }
        }
        if (this.gridAnim < PacketsDecoder.getCaseItemsList().size()) {
            this.gridAnim += this.delta / 2.0f;
        }
        if (this.gridAnim > PacketsDecoder.getCaseItemsList().size()) {
            this.gridAnim = (float)PacketsDecoder.getCaseItemsList().size();
        }
        this.counter = 0;
    }
    
    private void drawWonScreen(final int x, final int y, final float ticks) {
        this.drawDefaultBackground();
        final ScaledResolution scaled = new ScaledResolution(this.mc);
        final int factor = scaled.getScaleFactor();
        final int panX = 205;
        final int panY = 105;
        final int guiX = this.width / 2 - panX / 2;
        final int guiY = this.height / 2 - panY / 2;
        final Color color = ColorHelper.getColorByRare(this.quality);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/opctexture.png"));
        this.drawTexturedModalRect(guiX - 7, guiY - 16, 0, 0, 219, 146);
        GlStateManager.color(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, 0.7f);
        this.drawTexturedModalRect(guiX - 7, guiY - 16, 0, 0, 219, 16);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/opctextureu.png"));
        GlStateManager.popMatrix();
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
                this.isWon = false;
                this.isClicked = false;
            }
            this.drawScaledString(Strings.continueOK, (float)(guiX - 5 + 67 + 42), (float)(guiY - 11 + 124), 0.76f, TextPosition.CENTER);
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
        final ItemStack is = this.itemStack.copy();
        is.setItemDamage(this.itemStack.getItemDamage());
        is.setCount(1);
        final EntityItem entityItem = new EntityItem((World)this.mc.world, 0.0, 0.0, 0.0, is);
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
            this.fontRenderer.drawString(ChatFormatting.DARK_GRAY + "" + this.itemsCount, 0, 0, -872415232);
            GlStateManager.popMatrix();
        }
        if (this.mainAnimation <= 8.0f) {
            this.animation += this.delta;
        }
        else {
            this.mainAnimation += -this.delta / 6.0f;
        }
    }
}
