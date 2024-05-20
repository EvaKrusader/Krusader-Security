package net.mcreator.krusader_security.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelendo2torso<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("krusader_security", "modelendo_2torso"), "main");
	public final ModelPart Body;
	public final ModelPart armleft;
	public final ModelPart armright;

	public Modelendo2torso(ModelPart root) {
		this.Body = root.getChild("Body");
		this.armleft = root.getChild("armleft");
		this.armright = root.getChild("armright");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 36.0F, 0.0F));
		PartDefinition ribs = Body.addOrReplaceChild("ribs",
				CubeListBuilder.create().texOffs(8, 10).addBox(-3.0F, -6.0F, -0.75F, 6.0F, 1.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(8, 10).addBox(-3.0F, -8.0F, -0.75F, 6.0F, 1.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(8, 10)
						.addBox(-3.0F, -10.0F, -0.75F, 6.0F, 1.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(8, 10).addBox(-4.0F, -12.0F, -0.75F, 8.0F, 1.5F, 1.5F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 13.0F, 0.0F));
		PartDefinition hips = Body.addOrReplaceChild("hips",
				CubeListBuilder.create().texOffs(8, 2).addBox(-2.5F, 10.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, 10.5F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 6)
						.addBox(3.0F, 10.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 6).addBox(-5.0F, 10.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hipbones = hips.addOrReplaceChild("hipbones",
				CubeListBuilder.create().texOffs(28, 0).addBox(-2.5F, -1.75F, -1.5F, 1.0F, 2.25F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 0).addBox(-1.2F, -1.75F, -1.5F, 1.0F, 2.25F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 0)
						.addBox(0.2F, -1.75F, -1.5F, 1.0F, 2.25F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 0).addBox(1.5F, -1.75F, -1.5F, 1.0F, 2.25F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition Spine = Body.addOrReplaceChild("Spine",
				CubeListBuilder.create().texOffs(1, 3).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, 1.25F, -0.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition armleft = partdefinition.addOrReplaceChild("armleft", CubeListBuilder.create().texOffs(8, 6).addBox(9.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition armright = partdefinition.addOrReplaceChild("armright", CubeListBuilder.create().texOffs(8, 6).addBox(-10.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
