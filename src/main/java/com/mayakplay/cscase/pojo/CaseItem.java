//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.pojo;

import net.minecraft.item.*;

public class CaseItem
{
    private final ItemStack item;
    private final int rarity;
    
    public CaseItem(final ItemStack item, final int rarity) {
        this.item = item;
        this.rarity = rarity;
    }
    
    public ItemStack getItemStack() {
        return this.item;
    }
    
    public int getRarity() {
        return this.rarity;
    }
}
