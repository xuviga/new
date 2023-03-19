//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.network;

import io.netty.buffer.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

public class CasesListPacket implements IMessage
{
    String text;
    
    public CasesListPacket() {
    }
    
    public CasesListPacket(final String text) {
        this.text = text;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.text = ByteBufUtils.readUTF8String(buf);
    }
    
    public void toBytes(final ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, this.text);
    }
    
    public static class Handler implements IMessageHandler<CasesListPacket, IMessage>
    {
        public IMessage onMessage(final CasesListPacket message, final MessageContext ctx) {
            if (Recieve.CASES_LIST.equalsIgnoreCase("")) {
                Recieve.CASES_LIST = message.text;
            }
            else {
                Recieve.CASES_LIST = Recieve.CASES_LIST + "," + message.text;
            }
            return null;
        }
    }
}
