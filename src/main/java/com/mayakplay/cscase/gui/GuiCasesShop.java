//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.gui;

import net.minecraftforge.fml.relauncher.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import com.mayakplay.cscase.network.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import com.mayakplay.cscase.pojo.*;
import com.mayakplay.cscase.*;
import org.lwjgl.input.*;
import java.io.*;

@SideOnly(Side.CLIENT)
public class GuiCasesShop extends MPGui
{
    int move;
    int maxMove;
    
    public GuiCasesShop() {
        this.move = 0;
        this.maxMove = 0;
    }
    
    @Override
    public void drawScreen(final int x, final int y, final float ticks) {
        super.drawScreen(x, y, ticks);
        final ScaledResolution scaled = new ScaledResolution(this.mc);
        final int factor = scaled.getScaleFactor();
        final int guiX = this.width / 2 - 127;
        final int guiY = this.height / 2 - 113;
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexture.png"));
        this.drawTexturedModalRect(guiX, guiY, 0, 0, 256, 255);
        final int itemsCount = PacketsDecoder.getCases().size();
        final int colsCount = 3;
        final int rowsCount = Math.round(itemsCount / (float)colsCount + 0.2f);
        GlStateManager.pushMatrix();
        GL11.glEnable(3089);
        GL11.glScissor(guiX * factor, this.height * factor - (guiY - 2) * factor - 220 * factor, 247 * factor, 209 * factor);
        this.maxMove = rowsCount * 80 - 208;
        if (this.move >= 0) {
            this.move = 0;
        }
        if (rowsCount > 3) {
            if (this.move <= -this.maxMove) {
                this.move = -this.maxMove;
            }
        }
        else {
            this.move = 0;
        }
        int counter = 0;
        for (int i = 0; i < rowsCount; ++i) {
            for (int j = 0; j < colsCount; ++j) {
                if (counter < itemsCount) {
                    this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
                    this.drawTexturedModalRect(guiX + 10 + j * 78, guiY + 10 + 80 * i + this.move, 0, 0, 76, 78);
                    if (!this.isHover(guiX + 11 + j * 78, guiY + 73 + 80 * i + this.move, 74, 14)) {
                        this.drawTexturedModalRect(guiX + 11 + j * 78, guiY + 73 + 80 * i + this.move, 0, 78, 74, 14);
                    }
                    else {
                        this.drawTexturedModalRect(guiX + 11 + j * 78, guiY + 73 + 80 * i + this.move, 0, 92, 74, 14);
                    }
                    if (this.isClicked(guiX + 11 + j * 78, guiY + 73 + 80 * i + this.move, 74, 14)) {
                        this.mc.player.sendChatMessage("/mpcaseview " + counter);
                        this.isClicked = false;
                    }
                    this.drawScaledString(PacketsDecoder.getCases().get(counter).getName(), (float)(guiX + 12 + j * 78), (float)(guiY + 14 + 80 * i + this.move), 0.85f, TextPosition.LEFT);
                    this.drawScaledString(Strings.price + PacketsDecoder.getCases().get(counter).getPrice(), (float)(guiX + 12 + j * 78), (float)(guiY + 63 + 80 * i + this.move), 0.85f, TextPosition.LEFT);
                    this.drawScaledString(Strings.view, (float)(guiX + 47 + j * 78), (float)(guiY + 76 + 80 * i + this.move), 0.8f, TextPosition.CENTER);
                    this.draw3DCase(guiX + 21 + j * 78, guiY + 32 + 80 * i + this.move, "case" + counter, 160.0f);
                    ++counter;
                }
            }
        }
        GL11.glDisable(3089);
        GlStateManager.popMatrix();
        if (rowsCount > 3) {
            this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexturel.png"));
            this.drawTexturedModalRect(357, 27, 79, 0, 3, 210);
            this.drawTexturedModalRect(357, (int)(27.0f - this.move * (190.0f / this.maxMove)), 76, 0, 3, 20);
            final float gnomik = (float)(190 / this.maxMove);
            if (this.isClicked(357, 27, 3, 210)) {
                this.isClicked = false;
                this.move = -(int)((y - 27) / gnomik);
            }
        }
    }
    
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.move += Mouse.getEventDWheel() / 120 * 4;
    }
    
    @Override
    public void initGui() {
        for (int i = 0; i < PacketsDecoder.getCases().size(); ++i) {
            final String t = PacketsDecoder.getCases().get(i).getTexture();
            this.addTex("case" + i, t);
        }
    }
}
