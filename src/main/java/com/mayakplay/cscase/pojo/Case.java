//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.pojo;

public class Case
{
    private final String name;
    private final int price;
    private final String texture;
    
    public Case(final String name, final int price, final String texture) {
        this.name = name;
        this.price = price;
        this.texture = texture;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public String getTexture() {
        return this.texture;
    }
}
