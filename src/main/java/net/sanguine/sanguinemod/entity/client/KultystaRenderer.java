package net.sanguine.sanguinemod.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sanguine.sanguinemod.Sanguine;
import net.sanguine.sanguinemod.entity.custom.KultystaEntity;

public class KultystaRenderer extends MobRenderer<KultystaEntity, KultystaModel<KultystaEntity>> {

    public KultystaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new KultystaModel<>(pContext.bakeLayer(ModModelLayers.KULTYSTA_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(KultystaEntity pEntity) {
        return new ResourceLocation(Sanguine.MODID, "textures/entity/kultysta.png");
    }

    @Override
    public void render(KultystaEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
