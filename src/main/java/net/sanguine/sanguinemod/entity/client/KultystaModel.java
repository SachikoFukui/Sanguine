package net.sanguine.sanguinemod.entity.client;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.sanguine.sanguinemod.entity.animations.ModAnimationDefinition;
import net.sanguine.sanguinemod.entity.custom.KultystaEntity;

public class KultystaModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Kultysta;
	private final ModelPart glowa;

	public KultystaModel(ModelPart root) {
		this.Kultysta = root.getChild("Kultysta");
		this.glowa = Kultysta.getChild("glowa");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Kultysta = partdefinition.addOrReplaceChild("Kultysta", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tulow = Kultysta.addOrReplaceChild("tulow", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, -1.0F));

		PartDefinition nogi = Kultysta.addOrReplaceChild("nogi", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition PrawaNoga = nogi.addOrReplaceChild("PrawaNoga", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-2.0F, -12.0F, -1.0F));

		PartDefinition LewaNoga = nogi.addOrReplaceChild("LewaNoga", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, -1.0F));

		PartDefinition glowa = Kultysta.addOrReplaceChild("glowa", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F))
		.texOffs(16, 38).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, -1.0F));

		PartDefinition rece = Kultysta.addOrReplaceChild("rece", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition PrawaReka = rece.addOrReplaceChild("PrawaReka", CubeListBuilder.create().texOffs(32, 48).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-4.0F, -23.0F, -1.0F));

		PartDefinition LewaReka = rece.addOrReplaceChild("LewaReka", CubeListBuilder.create().texOffs(32, 48).addBox(0.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 48).addBox(0.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -23.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinition.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((KultystaEntity) entity).prayState, ModAnimationDefinition.PRAY, ageInTicks, 1f);
//		this.animate(((KultystaEntity) entity).attackAnimationState, ModAnimationDefinition.KULTYSTA_ATAK, ageInTicks, 1f);
	}
	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.glowa.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.glowa.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Kultysta.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Kultysta;
	}
}