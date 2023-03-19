//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.events;

import net.minecraftforge.fml.relauncher.*;
import net.minecraftforge.fml.common.gameevent.*;
import com.mayakplay.cscase.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class KeyHandler
{
    @SubscribeEvent
    public void KeyPress(final InputEvent.KeyInputEvent event) {
        if (CasesMain.KeyTest.isPressed()) {
            Minecraft.getMinecraft().player.sendChatMessage("/mpcaseshop");
        }
    }
}
