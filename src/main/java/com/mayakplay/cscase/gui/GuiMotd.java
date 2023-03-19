//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.gui;

import net.minecraftforge.fml.relauncher.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class GuiMotd extends MPGui
{
    public GuiMotd(final String texture) {
        this.addTex("motd", texture);
    }
    
    @Override
    public void drawScreen(final int x, final int y, final float ticks) {
        super.drawScreen(x, y, ticks);
        this.drawDefaultBackground();
        final int guiX = this.width / 2 - 127;
        final int guiY = this.height / 2 - 113;
        this.drawScaledString("ESC - \u0417\u0430\u043a\u0440\u044b\u0442\u044c", (float)(this.width / 2), 2.0f, 1.6f, TextPosition.CENTER);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("teccs", "textures/gui/caseshoptexture.png"));
        this.drawTexturedModalRect(guiX, guiY, 0, 0, 256, 255);
        MPGui.bindTexture("motd");
        this.drawCompleteImage(guiX + 8, guiY + 8, 239, 210);
    }
    
    @Override
    public void initGui() {
    }
}
