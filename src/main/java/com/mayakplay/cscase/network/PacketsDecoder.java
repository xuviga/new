//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.network;

import com.mayakplay.cscase.pojo.*;
import net.minecraft.item.*;
import java.util.*;

public class PacketsDecoder
{
    public static List<Case> getCases() {
        final List<Case> cases = new ArrayList<Case>();
        final String[] decode = Recieve.CASES_LIST.split(",");
        for (int i = 0; i < decode.length / 3; ++i) {
            final String name = decode[i * 3];
            final int price = Integer.parseInt(decode[i * 3 + 1]);
            final String texture = decode[i * 3 + 2];
            cases.add(new Case(name, price, texture));
        }
        return cases;
    }
    
    public static List<CaseItem> getCaseItemsList() {
        final List<CaseItem> items = new ArrayList<CaseItem>();
        final String[] decode = Recieve.CURRENT_CASE_ITEMS_LIST.split(",");
        for (int i = 0; i < decode.length / 3; ++i) {
            final int id = Integer.parseInt(decode[i * 3]);
            final int meta = Integer.parseInt(decode[i * 3 + 1]);
            final int rarity = Integer.parseInt(decode[i * 3 + 2]);
            final ItemStack is = new ItemStack(Item.getItemById(id));
            is.setItemDamage(meta);
            items.add(new CaseItem(is, rarity));
        }
        return items;
    }
    
    public static List<CaseItem> getRandomItemsForRoll() {
        final List<CaseItem> itemsFin = new ArrayList<CaseItem>();
        final List<CaseItem> items1 = new ArrayList<CaseItem>();
        final List<CaseItem> items2 = new ArrayList<CaseItem>();
        final List<CaseItem> items3 = new ArrayList<CaseItem>();
        final List<CaseItem> items4 = new ArrayList<CaseItem>();
        final List<CaseItem> items5 = new ArrayList<CaseItem>();
        for (int i = 0; i < getCaseItemsList().size(); ++i) {
            switch (getCaseItemsList().get(i).getRarity()) {
                case 1: {
                    items1.add(getCaseItemsList().get(i));
                    break;
                }
                case 2: {
                    items2.add(getCaseItemsList().get(i));
                    break;
                }
                case 3: {
                    items3.add(getCaseItemsList().get(i));
                    break;
                }
                case 4: {
                    items4.add(getCaseItemsList().get(i));
                    break;
                }
                case 5: {
                    items5.add(getCaseItemsList().get(i));
                    break;
                }
            }
        }
        for (int i = 0; i < 47; ++i) {
            itemsFin.add(items1.get(randInt(0, items1.size() - 1)));
        }
        for (int i = 0; i < 7; ++i) {
            itemsFin.add(items2.get(randInt(0, items2.size() - 1)));
        }
        for (int i = 0; i < 3; ++i) {
            itemsFin.add(items3.get(randInt(0, items3.size() - 1)));
        }
        for (int i = 0; i < 1; ++i) {
            itemsFin.add(items4.get(randInt(0, items4.size() - 1)));
        }
        for (int i = 0; i < 1; ++i) {
            itemsFin.add(items5.get(randInt(0, items5.size() - 1)));
        }
        Collections.shuffle(itemsFin);
        final String[] decode = Recieve.WON_ITEM.split(",");
        final ItemStack is = new ItemStack(Item.getItemById(Integer.parseInt(decode[0])), Integer.parseInt(decode[2]));
        is.setItemDamage(Integer.parseInt(decode[1]));
        itemsFin.add(57, new CaseItem(is, Integer.parseInt(decode[3])));
        return itemsFin;
    }
    
    public static int randInt(final int min, final int max) {
        final int randomNum = new Random().nextInt(max - min + 1) + min;
        return randomNum;
    }
    
    public static float randFloat(final float min, final float max) {
        return min + new Random().nextFloat() * (max - min);
    }
}
