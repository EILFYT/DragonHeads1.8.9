package com.neonfish.dragonheadmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DragonHeadModel extends ModelBiped {
        public final ModelRenderer head;
        private final ModelRenderer jaw;
//vanilla 1.12 dragon head class


        public DragonHeadModel()
        {
            this.textureWidth = 256;
            this.textureHeight = 256;
            this.setTextureOffset("body.body", 0, 0);
            this.setTextureOffset("wing.skin", -56, 88);
            this.setTextureOffset("wingtip.skin", -56, 144);
            this.setTextureOffset("rearleg.main", 0, 0);
            this.setTextureOffset("rearfoot.main", 112, 0);
            this.setTextureOffset("rearlegtip.main", 196, 0);
            this.setTextureOffset("head.upperhead", 112, 30);
            this.setTextureOffset("wing.bone", 112, 88);
            this.setTextureOffset("head.upperlip", 176, 44);
            this.setTextureOffset("jaw.jaw", 176, 65);
            this.setTextureOffset("frontleg.main", 112, 104);
            this.setTextureOffset("wingtip.bone", 112, 136);
            this.setTextureOffset("frontfoot.main", 144, 104);
            this.setTextureOffset("neck.box", 192, 104);
            this.setTextureOffset("frontlegtip.main", 226, 138);
            this.setTextureOffset("body.scale", 220, 53);
            this.setTextureOffset("head.scale", 0, 0);
            this.setTextureOffset("neck.scale", 48, 0);
            this.setTextureOffset("head.nostril", 112, 0);
            float f = -16.0F;
            this.head = new ModelRenderer(this, "head");
            this.head.addBox("upperlip", -6.0F, -1.0F, -24.0F, 12, 5, 16).setRotationPoint(0.0F, 7F, -2.0F);
            this.head.addBox("upperhead", -8.0F, -8.0F, -10.0F, 16, 16, 16).setRotationPoint(0.0F, 7F, -2.0F);
            this.head.mirror = true;
            this.head.addBox("scale", -5.0F, -12.0F, -4.0F, 2, 4, 6).setRotationPoint(0.0F, 7F, -2.0F);
            this.head.addBox("nostril", -5.0F, -3.0F, -22.0F, 2, 2, 4).setRotationPoint(0.0F, 7F, -2.0F);
            this.head.mirror = false;
            this.head.addBox("scale", 3.0F, -12.0F, -4.0F, 2, 4, 6).setRotationPoint(0.0F, 7F, -2.0F);
            this.head.addBox("nostril", 3.0F, -3.0F, -22.0F, 2, 2, 4).setRotationPoint(0.0F, 7F, -2.0F);
            this.jaw = new ModelRenderer(this, "jaw");
            this.jaw.setRotationPoint(0.0F, 4.0F, -8.0F);
            this.jaw.addBox("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16).setRotationPoint(0.0F, 7F, -2.0F);
            this.head.addChild(this.jaw);
            this.head.setRotationPoint(0.0F, 7F, -2.0F);
            Minecraft.getMinecraft().getTextureManager().bindTexture(Main.DRAGON_HEAD_LOCATION);
        }

        public void render(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
        {
            this.jaw.rotateAngleX = (float)(Math.sin((double)(limbSwing * (float)Math.PI * 0.2F)) + 1.0D) * 0.2F;
            this.head.rotateAngleY = netHeadYaw * 0.017453292F;
            this.head.rotateAngleX = headPitch * 0.017453292F;
            GlStateManager.translate(0.0F, -0.374375F, 0.0F);
            GlStateManager.scale(0.75F, 0.75F, 0.75F);
            this.head.render(scale);
        }

}