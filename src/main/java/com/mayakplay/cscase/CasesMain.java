//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase;

import net.minecraft.client.settings.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.relauncher.*;
import com.mayakplay.cscase.network.*;
import net.minecraftforge.fml.common.*;
import com.mayakplay.cscase.events.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.client.registry.*;

@Mod(modid = "teccs", version = "1.0.0", name = "Mayakplay Cases", acceptedMinecraftVersions = "[1.12.2]")
public class CasesMain
{
    public static KeyBinding KeyTest;
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.newSimpleChannel("CasesShopChanel").registerMessage((Class)CasesMainPacket.Handler.class, (Class)CasesMainPacket.class, 0, Side.CLIENT);
        NetworkRegistry.INSTANCE.newSimpleChannel("CasesListChanel").registerMessage((Class)CasesListPacket.Handler.class, (Class)CasesListPacket.class, 0, Side.CLIENT);
        NetworkRegistry.INSTANCE.newSimpleChannel("CasesCurChanel").registerMessage((Class)CasesViewPacket.Handler.class, (Class)CasesViewPacket.class, 0, Side.CLIENT);
        FMLCommonHandler.instance().bus().register((Object)new KeyHandler());
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientRegistry.registerKeyBinding(CasesMain.KeyTest = new KeyBinding("key.friendsgui", 21, "key.categories.oshop"));
    }
}
