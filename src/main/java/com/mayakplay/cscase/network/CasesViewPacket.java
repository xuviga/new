//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.network;

import io.netty.buffer.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

public class CasesViewPacket implements IMessage
{
    String text;
    
    public CasesViewPacket() {
    }
    
    public CasesViewPacket(final String text) {
        this.text = text;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.text = ByteBufUtils.readUTF8String(buf);
    }
    
    public void toBytes(final ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, this.text);
    }
    
    public static class Handler implements IMessageHandler<CasesViewPacket, IMessage>
    {
        public IMessage onMessage(final CasesViewPacket message, final MessageContext ctx) {
            if (Recieve.CURRENT_CASE_ITEMS_LIST.equalsIgnoreCase("")) {
                Recieve.CURRENT_CASE_ITEMS_LIST = message.text;
            }
            else {
                Recieve.CURRENT_CASE_ITEMS_LIST = Recieve.CURRENT_CASE_ITEMS_LIST + "," + message.text;
            }
            return null;
        }
    }
}
