package com.neonfish.dragonheadmod.mixins;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.neonfish.dragonheadmod.DragonHeadModel;
import com.neonfish.dragonheadmod.ItemUtilsSBA;
import com.neonfish.dragonheadmod.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;

@Mixin({TileEntitySkullRenderer.class})
public class MixinTileEntitySkullRenderer {
    @Shadow
    ModelBase lvt_9_1_;
    @Shadow
    protected void bindTexture(ResourceLocation p_bindTexture_1_) {}
    @Inject(method = "renderSkull", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableCull()V", shift = At.Shift.AFTER))
   public void renderSkull(/*float p_renderSkull_1_, float p_renderSkull_2_, float p_renderSkull_3_, EnumFacing p_renderSkull_4_, float p_renderSkull_5_, int p_renderSkull_6_, GameProfile p_renderSkull_7_, int p_renderSkull_8_, */CallbackInfo ci) {
            this.bindTexture(Main.DRAGON_HEAD_LOCATION);
            lvt_9_1_ = new DragonHeadModel();
    }
}
