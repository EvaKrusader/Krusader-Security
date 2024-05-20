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
public class Modellilithmask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("krusader_security", "modellilithmask"), "main");
	public final ModelPart Head;

	public Modellilithmask(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition mask = Head.addOrReplaceChild("mask",
				CubeListBuilder.create().texOffs(31, 31).addBox(-5.0F, -33.0F, -4.5F, 10.0F, 10.0F, 0.5F, new CubeDeformation(0.0F)).texOffs(24, 0).addBox(-5.0F, -24.0F, -4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 0)
						.addBox(-5.0F, -33.0F, -4.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 15).addBox(4.0F, -32.0F, -4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 15)
						.addBox(-5.0F, -32.0F, -4.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition maskextra = Head.addOrReplaceChild("maskextra",
				CubeListBuilder.create().texOffs(52, 23).mirror().addBox(-4.0F, -25.75F, -4.75F, 5.75F, 2.75F, 0.25F, new CubeDeformation(0.0F)).mirror(false).texOffs(55, 15)
						.addBox(1.75F, -24.75F, -4.75F, 2.25F, 1.75F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15).addBox(-1.75F, -30.5F, -4.75F, 3.5F, 4.75F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15)
						.addBox(1.75F, -33.0F, -4.75F, 2.25F, 1.5F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15).addBox(1.75F, -30.75F, -4.75F, 2.25F, 1.25F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15)
						.addBox(1.75F, -28.75F, -4.75F, 2.25F, 1.25F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15).addBox(-4.0F, -29.75F, -4.75F, 2.25F, 1.25F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15)
						.addBox(-4.0F, -27.75F, -4.75F, 2.25F, 1.25F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15).addBox(1.75F, -26.75F, -4.75F, 2.25F, 1.25F, 0.25F, new CubeDeformation(0.0F)).texOffs(55, 15)
						.addBox(-4.0F, -33.0F, -4.75F, 5.75F, 2.5F, 0.25F, new CubeDeformation(0.0F)).texOffs(60, 9).addBox(4.0F, -33.0F, -4.75F, 1.0F, 10.0F, 0.25F, new CubeDeformation(0.0F)).texOffs(54, 16).mirror()
						.addBox(-5.0F, -33.0F, -4.75F, 1.0F, 10.0F, 0.25F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
