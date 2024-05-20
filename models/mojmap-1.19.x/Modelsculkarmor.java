// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsculkarmor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sculkarmor"), "main");
	private final ModelPart Body;
	private final ModelPart ArmsR;
	private final ModelPart ArmsL;
	private final ModelPart LeggingsR;
	private final ModelPart LeggingsL;
	private final ModelPart Head;

	public Modelsculkarmor(ModelPart root) {
		this.Body = root.getChild("Body");
		this.ArmsR = root.getChild("ArmsR");
		this.ArmsL = root.getChild("ArmsL");
		this.LeggingsR = root.getChild("LeggingsR");
		this.LeggingsL = root.getChild("LeggingsL");
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(
				-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition ArmsR = partdefinition.addOrReplaceChild("ArmsR",
				CubeListBuilder.create().texOffs(40, 16)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 32)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition ArmsL = partdefinition.addOrReplaceChild("ArmsL",
				CubeListBuilder.create().texOffs(32, 48)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 48)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LeggingsR = partdefinition.addOrReplaceChild("LeggingsR",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LeggingsL = partdefinition.addOrReplaceChild("LeggingsL",
				CubeListBuilder.create().texOffs(16, 48)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 48)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-5.0F, -9.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(12, 11)
						.addBox(-5.0F, -8.0F, -5.0F, 10.0F, 5.25F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 0)
						.addBox(-2.5F, -2.75F, -5.0F, 5.0F, 2.75F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 57)
						.addBox(-5.0F, -8.0F, 4.0F, 10.0F, 5.25F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 43)
						.addBox(-5.0F, -8.0F, -4.0F, 1.0F, 5.25F, 8.0F, new CubeDeformation(0.0F)).texOffs(46, 43)
						.addBox(4.0F, -8.0F, -4.0F, 1.0F, 5.25F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition hornright = Head.addOrReplaceChild("hornright", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horntrightstart2_r1 = hornright.addOrReplaceChild("horntrightstart2_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.04F, -10.2F, -1.0F, 1.55F, 2.5F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition horntrightstart_r1 = hornright.addOrReplaceChild("horntrightstart_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.55F, -4.5F, -1.0F, 1.55F, 1.25F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1484F));

		PartDefinition hornright2_r1 = hornright.addOrReplaceChild("hornright2_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -17.82F, -2.646F, 2.0F, 7.0F, 1.5F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -1.0472F, -1.5708F, 0.0F));

		PartDefinition hornright_r1 = hornright.addOrReplaceChild("hornright_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -9.75F, -2.25F, 2.0F, 5.0F, 1.5F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -1.1345F, -1.5708F, 0.0F));

		PartDefinition hornleft = Head.addOrReplaceChild("hornleft", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition horntrightstart3_r1 = hornleft.addOrReplaceChild("horntrightstart3_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.04F, -10.2F, -1.0F, 1.55F, 2.5F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition horntrightstart_r2 = hornleft.addOrReplaceChild("horntrightstart_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.55F, -4.5F, -1.0F, 1.55F, 1.25F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1484F));

		PartDefinition hornright3_r1 = hornleft.addOrReplaceChild("hornright3_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -17.82F, -2.646F, 2.0F, 7.0F, 1.5F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -1.0472F, -1.5708F, 0.0F));

		PartDefinition hornright_r2 = hornleft.addOrReplaceChild("hornright_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -9.75F, -2.25F, 2.0F, 5.0F, 1.5F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -1.1345F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ArmsR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ArmsL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeggingsR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeggingsL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}