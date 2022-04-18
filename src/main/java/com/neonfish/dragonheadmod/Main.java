package com.neonfish.dragonheadmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, clientSideOnly = true)
public class Main
{

    float translateX = 0F;
    float translateY = -1.7f;
    float translateZ = 0.1f;
    //this class is just me trying everything I can to make this work
    public static ResourceLocation DRAGON_HEAD_LOCATION = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    public static final String MODID = "dragonhead";
    public static final String VERSION = "1.0";
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    public static String DRAGON_HEAD_TAG = "SKULL_ITEM:5";
  //  @SubscribeEvent
   // public void onRenderEntity(RenderLivingEvent.Pre<EntityLivingBase> event) {
   //     if (event.entity instanceof EntityPlayer) {
           /* ItemStack helmet = event.entity.getCurrentArmor(3);
            if (helmet != null) {
                if (DRAGON_HEAD_TAG.equals(
                        ItemUtilsSBA.getSkyblockItemID(helmet))
                ) {*/
                 //   new DragonHeadRenderer(((ModelPlayer) event.renderer.getMainModel()));
           //     }
          //  }
  //      }
  //  }

  /*  @SubscribeEvent
    public void renderPlayer(RenderPlayerEvent.Pre event) {
        DragonHeadRenderer e = new DragonHeadRenderer();
        Minecraft.getMinecraft().getTextureManager().bindTexture(DRAGON_HEAD_LOCATION);
        GlStateManager.pushMatrix();
        GlStateManager.rotate(180F, 1F, 0F, 0F);
        GlStateManager.rotate(event.entityPlayer.getRotationYawHead(), 0F, 0.017453292F, 0F);
        GlStateManager.translate(translateX, translateY,  translateZ);
        e.doRenderLayer((AbstractClientPlayer) event.entityPlayer, 0, 0, 0, 0, 0, 0, 0);
        GlStateManager.popMatrix();
    }
    @SubscribeEvent
    public void chat(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (!msg.contains("unacceptable")) return;
        int importantPart = 0;
        try {
            importantPart = Integer.parseInt(msg.split("unacceptable")[1]);
        } catch (NullPointerException ignored) {

        }
            switch (importantPart) {
                case (11): {
                    translateX += .1f;
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X = " + translateX + ",Y = " + translateY + ",Z = " + translateZ));
                }
                case (12): {
                    translateX -= .1f;
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X = " + translateX + ",Y = " + translateY + ",Z = " + translateZ));
                }
                case (21): {
                    translateY += .1f;
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X = " + translateX + ",Y = " + translateY + ",Z = " + translateZ));
                }
                case (22): {
                    translateY -= .1f;
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X = " + translateX + ",Y = " + translateY + ",Z = " + translateZ));
                }
                case (31): {
                    translateZ += .1f;
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X = " + translateX + ",Y = " + translateY + ",Z = " + translateZ));
                }
                case (32): {
                    translateZ -= .1f;
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("X = " + translateX + ",Y = " + translateY + ",Z = " + translateZ));
                }
            }
    }*/
    @SubscribeEvent
    public void item(ItemTooltipEvent event) {
        event.toolTip.add(event.itemStack.serializeNBT().toString());
    }
}
