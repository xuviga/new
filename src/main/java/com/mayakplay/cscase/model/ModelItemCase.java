//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\XuViGaN\Desktop\1.12 stable mappings"!

//Decompiled by Procyon!

package com.mayakplay.cscase.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelItemCase extends ModelBase
{
    ModelRenderer _asing_middle_01;
    ModelRenderer _asing_middle_left;
    ModelRenderer _asing_middle_right;
    ModelRenderer Casing_vert_01;
    ModelRenderer Casing_vert_02;
    ModelRenderer Casing_vert_03;
    ModelRenderer Casing_vert_04;
    ModelRenderer Case;
    ModelRenderer _asing_lock_01;
    ModelRenderer _asing_lock_02;
    ModelRenderer Handles;
    
    public ModelItemCase() {
        this(0.0f);
    }
    
    public ModelItemCase(final float par1) {
        (this._asing_middle_01 = new ModelRenderer((ModelBase)this, 72, 110)).setTextureSize(128, 128);
        this._asing_middle_01.addBox(-5.5f, -0.5f, -8.5f, 11, 1, 17);
        this._asing_middle_01.setRotationPoint(0.0f, 13.0f, 0.0f);
        (this._asing_middle_left = new ModelRenderer((ModelBase)this, 1, 72)).setTextureSize(128, 128);
        this._asing_middle_left.addBox(-2.5f, -0.5f, -8.5f, 5, 1, 17);
        this._asing_middle_left.setRotationPoint(13.0f, 13.0f, 0.0f);
        (this._asing_middle_right = new ModelRenderer((ModelBase)this, 0, 94)).setTextureSize(128, 128);
        this._asing_middle_right.addBox(-2.5f, -0.5f, -8.5f, 5, 1, 17);
        this._asing_middle_right.setRotationPoint(-13.0f, 13.0f, 0.0f);
        (this.Casing_vert_01 = new ModelRenderer((ModelBase)this, 1, 1)).setTextureSize(128, 128);
        this.Casing_vert_01.addBox(-0.5f, -6.5f, -8.5f, 1, 13, 17);
        this.Casing_vert_01.setRotationPoint(10.0f, 18.0f, 0.0f);
        (this.Casing_vert_02 = new ModelRenderer((ModelBase)this, 81, 1)).setTextureSize(128, 128);
        this.Casing_vert_02.addBox(-0.5f, -6.5f, -8.5f, 1, 13, 17);
        this.Casing_vert_02.setRotationPoint(-10.0f, 18.0f, 0.0f);
        (this.Casing_vert_03 = new ModelRenderer((ModelBase)this, 41, 1)).setTextureSize(128, 128);
        this.Casing_vert_03.addBox(-0.5f, -6.5f, -8.5f, 1, 13, 17);
        this.Casing_vert_03.setRotationPoint(6.0f, 18.0f, 0.0f);
        (this.Casing_vert_04 = new ModelRenderer((ModelBase)this, 79, 53)).setTextureSize(128, 128);
        this.Casing_vert_04.addBox(-0.5f, -6.5f, -8.5f, 1, 13, 17);
        this.Casing_vert_04.setRotationPoint(-6.0f, 18.0f, 0.0f);
        (this.Case = new ModelRenderer((ModelBase)this, 0, 35)).setTextureSize(128, 128);
        this.Case.addBox(-15.0f, -7.0f, -8.0f, 30, 14, 16);
        this.Case.setRotationPoint(0.0f, 18.0f, 0.0f);
        (this._asing_lock_01 = new ModelRenderer((ModelBase)this, 49, 92)).setTextureSize(128, 128);
        this._asing_lock_01.addBox(-1.0f, -1.5f, -8.5f, 2, 3, 17);
        this._asing_lock_01.setRotationPoint(8.0f, 14.0f, 0.0f);
        (this._asing_lock_02 = new ModelRenderer((ModelBase)this, 49, 70)).setTextureSize(128, 128);
        this._asing_lock_02.addBox(-1.0f, -1.5f, -8.5f, 2, 3, 17);
        this._asing_lock_02.setRotationPoint(-8.0f, 14.0f, 0.0f);
        (this.Handles = new ModelRenderer((ModelBase)this, 1, 118)).setTextureSize(128, 128);
        this.Handles.addBox(-15.5f, -1.0f, -2.5f, 31, 2, 5);
        this.Handles.setRotationPoint(0.0f, 15.0f, 0.0f);
    }
    
    public void renderModel(final float par7) {
        this._asing_middle_01.rotateAngleX = 0.0f;
        this._asing_middle_01.rotateAngleY = 0.0f;
        this._asing_middle_01.rotateAngleZ = 0.0f;
        this._asing_middle_01.renderWithRotation(par7);
        this._asing_middle_left.rotateAngleX = 0.0f;
        this._asing_middle_left.rotateAngleY = 0.0f;
        this._asing_middle_left.rotateAngleZ = 0.0f;
        this._asing_middle_left.renderWithRotation(par7);
        this._asing_middle_right.rotateAngleX = 0.0f;
        this._asing_middle_right.rotateAngleY = 0.0f;
        this._asing_middle_right.rotateAngleZ = 0.0f;
        this._asing_middle_right.renderWithRotation(par7);
        this.Casing_vert_01.rotateAngleX = 0.0f;
        this.Casing_vert_01.rotateAngleY = 0.0f;
        this.Casing_vert_01.rotateAngleZ = 0.0f;
        this.Casing_vert_01.renderWithRotation(par7);
        this.Casing_vert_02.rotateAngleX = 0.0f;
        this.Casing_vert_02.rotateAngleY = 0.0f;
        this.Casing_vert_02.rotateAngleZ = 0.0f;
        this.Casing_vert_02.renderWithRotation(par7);
        this.Casing_vert_03.rotateAngleX = 0.0f;
        this.Casing_vert_03.rotateAngleY = 0.0f;
        this.Casing_vert_03.rotateAngleZ = 0.0f;
        this.Casing_vert_03.renderWithRotation(par7);
        this.Casing_vert_04.rotateAngleX = 0.0f;
        this.Casing_vert_04.rotateAngleY = 0.0f;
        this.Casing_vert_04.rotateAngleZ = 0.0f;
        this.Casing_vert_04.renderWithRotation(par7);
        this.Case.rotateAngleX = 0.0f;
        this.Case.rotateAngleY = 0.0f;
        this.Case.rotateAngleZ = 0.0f;
        this.Case.renderWithRotation(par7);
        this._asing_lock_01.rotateAngleX = 0.0f;
        this._asing_lock_01.rotateAngleY = 0.0f;
        this._asing_lock_01.rotateAngleZ = 0.0f;
        this._asing_lock_01.renderWithRotation(par7);
        this._asing_lock_02.rotateAngleX = 0.0f;
        this._asing_lock_02.rotateAngleY = 0.0f;
        this._asing_lock_02.rotateAngleZ = 0.0f;
        this._asing_lock_02.renderWithRotation(par7);
        this.Handles.rotateAngleX = 0.0f;
        this.Handles.rotateAngleY = 0.0f;
        this.Handles.rotateAngleZ = 0.0f;
        this.Handles.renderWithRotation(par7);
    }
    
    public void render(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this._asing_middle_01.rotateAngleX = 0.0f;
        this._asing_middle_01.rotateAngleY = 0.0f;
        this._asing_middle_01.rotateAngleZ = 0.0f;
        this._asing_middle_01.renderWithRotation(par7);
        this._asing_middle_left.rotateAngleX = 0.0f;
        this._asing_middle_left.rotateAngleY = 0.0f;
        this._asing_middle_left.rotateAngleZ = 0.0f;
        this._asing_middle_left.renderWithRotation(par7);
        this._asing_middle_right.rotateAngleX = 0.0f;
        this._asing_middle_right.rotateAngleY = 0.0f;
        this._asing_middle_right.rotateAngleZ = 0.0f;
        this._asing_middle_right.renderWithRotation(par7);
        this.Casing_vert_01.rotateAngleX = 0.0f;
        this.Casing_vert_01.rotateAngleY = 0.0f;
        this.Casing_vert_01.rotateAngleZ = 0.0f;
        this.Casing_vert_01.renderWithRotation(par7);
        this.Casing_vert_02.rotateAngleX = 0.0f;
        this.Casing_vert_02.rotateAngleY = 0.0f;
        this.Casing_vert_02.rotateAngleZ = 0.0f;
        this.Casing_vert_02.renderWithRotation(par7);
        this.Casing_vert_03.rotateAngleX = 0.0f;
        this.Casing_vert_03.rotateAngleY = 0.0f;
        this.Casing_vert_03.rotateAngleZ = 0.0f;
        this.Casing_vert_03.renderWithRotation(par7);
        this.Casing_vert_04.rotateAngleX = 0.0f;
        this.Casing_vert_04.rotateAngleY = 0.0f;
        this.Casing_vert_04.rotateAngleZ = 0.0f;
        this.Casing_vert_04.renderWithRotation(par7);
        this.Case.rotateAngleX = 0.0f;
        this.Case.rotateAngleY = 0.0f;
        this.Case.rotateAngleZ = 0.0f;
        this.Case.renderWithRotation(par7);
        this._asing_lock_01.rotateAngleX = 0.0f;
        this._asing_lock_01.rotateAngleY = 0.0f;
        this._asing_lock_01.rotateAngleZ = 0.0f;
        this._asing_lock_01.renderWithRotation(par7);
        this._asing_lock_02.rotateAngleX = 0.0f;
        this._asing_lock_02.rotateAngleY = 0.0f;
        this._asing_lock_02.rotateAngleZ = 0.0f;
        this._asing_lock_02.renderWithRotation(par7);
        this.Handles.rotateAngleX = 0.0f;
        this.Handles.rotateAngleY = 0.0f;
        this.Handles.rotateAngleZ = 0.0f;
        this.Handles.renderWithRotation(par7);
    }
}
