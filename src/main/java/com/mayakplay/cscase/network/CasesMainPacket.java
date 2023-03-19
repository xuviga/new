//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.network;

import io.netty.buffer.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import com.mayakplay.cscase.gui.*;

public class CasesMainPacket implements IMessage
{
    String text;
    
    public CasesMainPacket() {
    }
    
    public CasesMainPacket(final String text) {
        this.text = text;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.text = ByteBufUtils.readUTF8String(buf);
    }
    
    public void toBytes(final ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, this.text);
    }
    
    public static class Handler implements IMessageHandler<CasesMainPacket, IMessage>
    {
        public IMessage onMessage(final CasesMainPacket message, final MessageContext ctx) {
            if (message.text.equals("Clear")) {
                Recieve.CASES_LIST = "";
                Recieve.CURRENT_CASE_ITEMS_LIST = "";
                Recieve.WON_ITEM = "";
            }
            if (message.text.equals("ClearLast")) {
                Recieve.CURRENT_CASE_ITEMS_LIST = "";
            }
            if (message.text.equals("Open")) {
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiCasesShop());
            }
            final String[] args = message.text.split(",");
            if (args[0].equals("Viev")) {
                int casePrice = 0;
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiCaseView(Integer.parseInt(args[1]), casePrice));
            }
            if (args[0].equals("SetWon")) {
                Recieve.WON_ITEM = args[1] + "," + args[2] + "," + args[3] + "," + args[4];
            }
            if (args[0].equals("SetMotd")) {
                Recieve.MOTD_IMG = args[1];
                Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiMotd(Recieve.MOTD_IMG));
            }
            if (message.text.equals("RollCase")) {
                Recieve.isRolling = true;
            }
            return null;
        }
    }
}
