//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.gui;

import net.minecraft.client.gui.*;
import net.minecraftforge.fml.relauncher.*;
import java.util.*;
import java.awt.image.*;
import com.mayakplay.cscase.model.*;
import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.net.*;
import javax.imageio.*;

@SideOnly(Side.CLIENT)
public class MPGui extends GuiScreen
{
    private static final HashMap<String, BufferedImage> images;
    final double tc = 60.0;
    protected boolean isClicked;
    ModelItemCase modelItemCase;
    float delta;
    long lastTime;
    private int MX;
    private int MY;
    private boolean mouse;
    
    public MPGui() {
        this.isClicked = false;
        this.modelItemCase = new ModelItemCase();
        this.delta = 0.0f;
        this.lastTime = System.nanoTime();
        this.MX = 0;
        this.MY = 0;
        this.mouse = false;
    }
    
    public static void bindTexture(final String name) {
        if (MPGui.images.get(name) != null) {
            GlStateManager.bindTexture(new DynamicTexture((BufferedImage)MPGui.images.get(name)).getGlTextureId());
        }
    }
    
    protected void drawScaledString(final String text, final float x, final float y, final float scale, final TextPosition textPosition) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, 0.0f);
        GlStateManager.scale(scale, scale, 0.0f);
        if (textPosition == TextPosition.CENTER) {
            this.drawCenteredString(this.mc.fontRenderer, text, 0, 0, 16777215);
        }
        else if (textPosition == TextPosition.LEFT) {
            this.drawString(this.mc.fontRenderer, text, 0, 0, 16777215);
        }
        else if (textPosition == TextPosition.RIGHT) {
            this.drawString(this.mc.fontRenderer, text, -this.fontRenderer.getStringWidth(text), 0, 16777215);
        }
        GlStateManager.popMatrix();
    }
    
    protected void drawCompleteImage(final int posX, final int posY, final int width, final int height) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 0.0f);
        GL11.glBegin(7);
        GlStateManager.glTexCoord2f(0.0f, 0.0f);
        GlStateManager.glVertex3f(0.0f, 0.0f, 0.0f);
        GlStateManager.glTexCoord2f(0.0f, 1.0f);
        GlStateManager.glVertex3f(0.0f, (float)height, 0.0f);
        GlStateManager.glTexCoord2f(1.0f, 1.0f);
        GlStateManager.glVertex3f((float)width, (float)height, 0.0f);
        GlStateManager.glTexCoord2f(1.0f, 0.0f);
        GlStateManager.glVertex3f((float)width, 0.0f, 0.0f);
        GlStateManager.glEnd();
        GlStateManager.popMatrix();
    }
    
    public boolean isHover(final int xx, final int yy, final int xx1, final int yy1) {
        final int mouseX = this.MX;
        final int mouseY = this.MY;
        return mouseX >= xx && mouseX < xx1 + xx && mouseY >= yy && mouseY < yy1 + yy;
    }
    
    public boolean isClicked(final int xx, final int yy, final int xx1, final int yy1) {
        final int mouseX = this.MX;
        final int mouseY = this.MY;
        return mouseX >= xx && mouseX < xx1 + xx && mouseY >= yy && mouseY < yy1 + yy && this.isClicked;
    }
    
    protected void draw3DCase(final int x, final int y, final String texture, final float rotation) {
        GlStateManager.pushMatrix();
        bindTexture(texture);
        GlStateManager.translate((float)(x + 27), (float)(y - 12), 44.0f);
        GlStateManager.scale(20.0f, 20.0f, 20.0f);
        GlStateManager.rotate(-8.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(rotation, 0.0f, 1.0f, 0.0f);
        GL11.glDisable(2884);
        this.modelItemCase.renderModel(0.0625f);
        GlStateManager.popMatrix();
    }
    
    protected void mouseClicked(final int x, final int y, final int b) throws IOException {
        super.mouseClicked(x, y, b);
        this.isClicked = true;
        final Timing timing = new Timing(100);
        timing.start();
    }
    
    public void drawScreen(final int x, final int y, final float ticks) {
        if (!this.mouse) {
            Minecraft.getMinecraft().mouseHelper.ungrabMouseCursor();
            this.mouse = true;
        }
        this.MX = x;
        this.MY = y;
        final double ns = 1.6666666666666666E7;
        final long now = System.nanoTime();
        this.delta = (float)((now - this.lastTime) / ns);
        this.lastTime = now;
    }
    
    protected void draw3DGuiItem(final ItemStack itemStack, final float x, final float y, final float scale) {
        final ItemStack is = itemStack.copy();
        is.setCount(1);
        itemStack.setItemDamage(itemStack.getItemDamage());
        final EntityItem entityItem = new EntityItem((World)this.mc.world, 0.0, 0.0, 0.0, is);
        entityItem.hoverStart = 0.0f;
        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.translate(x, y, 4.0f);
        GlStateManager.rotate(-11.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(160.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(scale, scale, scale);
        Minecraft.getMinecraft().getRenderManager().renderEntity((Entity)entityItem, 0.0, 0.0, 0.0, 0.2f, 0.2f, false);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    protected void playSound(final String name) {
        this.mc.player.playSound(new SoundEvent(new ResourceLocation("teccs:" + name)), 1.0f, 1.0f);
    }
    
    public void addTex(final String name, final String image) {
        try {
            final BufferedImage image2 = ImageIO.read(new URL(image));
            MPGui.images.put(name, image2);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void initGui() {
        super.initGui();
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int state) {
        super.mouseReleased(mouseX, mouseY, state);
    }
    
    static {
        images = new HashMap<String, BufferedImage>();
    }
    
    enum TextPosition
    {
        LEFT, 
        CENTER, 
        RIGHT;
    }
    
    class Timing extends Thread
    {
        private final int timer;
        
        public Timing(final int timer) {
            this.timer = timer;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(this.timer);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            MPGui.this.isClicked = false;
            this.stop();
        }
    }
}
