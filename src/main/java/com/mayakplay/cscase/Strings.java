//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase;

public class Strings
{
    public static String itemsCanDrop;
    public static String continueOK;
    public static String opening;
    public static String view;
    public static String price;
    
    public static String openPrice(final int price) {
        return "\u041e\u0442\u043a\u0440\u044b\u0442\u044c - " + price + " \u2726";
    }
    
    static {
        Strings.itemsCanDrop = "\u041f\u0440\u0435\u0434\u043c\u0435\u0442\u044b, \u043a\u043e\u0442\u043e\u0440\u044b\u0435 \u043c\u043e\u0433\u0443\u0442 \u0432\u044b\u043f\u0430\u0441\u0442\u044c:";
        Strings.continueOK = "\u041f\u0440\u043e\u0434\u043e\u043b\u0436\u0438\u0442\u044c";
        Strings.opening = "\u041e\u0442\u043a\u0440\u044b\u0432\u0430\u0435\u043c...";
        Strings.view = "\u041f\u0440\u043e\u0441\u043c\u043e\u0442\u0440";
        Strings.price = "\u0426\u0435\u043d\u0430: ";
    }
}
