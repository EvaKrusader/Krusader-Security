package net.mcreator.krusader_security.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.krusader_security.world.inventory.PCLogingMenu;
import net.mcreator.krusader_security.procedures.PcAnim8Procedure;
import net.mcreator.krusader_security.procedures.PcAnim7Procedure;
import net.mcreator.krusader_security.procedures.PcAnim6Procedure;
import net.mcreator.krusader_security.procedures.PcAnim5Procedure;
import net.mcreator.krusader_security.procedures.PcAnim4Procedure;
import net.mcreator.krusader_security.procedures.PcAnim3Procedure;
import net.mcreator.krusader_security.procedures.PcAnim2Procedure;
import net.mcreator.krusader_security.procedures.PcAnim1Procedure;
import net.mcreator.krusader_security.network.PCLogingButtonMessage;
import net.mcreator.krusader_security.KrusaderSecurityMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PCLogingScreen extends AbstractContainerScreen<PCLogingMenu> {
	private final static HashMap<String, Object> guistate = PCLogingMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Username;
	EditBox Password;
	Button button_reset;
	Button button_log_in;

	public PCLogingScreen(PCLogingMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Username.render(guiGraphics, mouseX, mouseY, partialTicks);
		Password.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_loging.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 256, 166, 256, 166);

		if (PcAnim1Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim1.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}
		if (PcAnim2Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim2.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}
		if (PcAnim3Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim3.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}
		if (PcAnim4Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim4.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}
		if (PcAnim5Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim5.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}
		if (PcAnim6Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim6.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}
		if (PcAnim7Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim7.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}
		if (PcAnim8Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/pc_login_anim8.png"), this.leftPos + 19, this.topPos + 19, 0, 0, 83, 128, 83, 128);
		}

		guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/adspace_test.png"), this.leftPos + 118, this.topPos + 89, 0, 0, 120, 36, 120, 36);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Username.isFocused())
			return Username.keyPressed(key, b, c);
		if (Password.isFocused())
			return Password.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Username.tick();
		Password.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.krusader_security.pc_loging.label_username"), 118, 16, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.krusader_security.pc_loging.label_password"), 118, 52, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		Username = new EditBox(this.font, this.leftPos + 119, this.topPos + 26, 118, 18, Component.translatable("gui.krusader_security.pc_loging.Username")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_loging.Username").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_loging.Username").getString());
				else
					setSuggestion(null);
			}
		};
		Username.setSuggestion(Component.translatable("gui.krusader_security.pc_loging.Username").getString());
		Username.setMaxLength(32767);
		guistate.put("text:Username", Username);
		this.addWidget(this.Username);
		Password = new EditBox(this.font, this.leftPos + 119, this.topPos + 62, 118, 18, Component.translatable("gui.krusader_security.pc_loging.Password")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_loging.Password").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_loging.Password").getString());
				else
					setSuggestion(null);
			}
		};
		Password.setSuggestion(Component.translatable("gui.krusader_security.pc_loging.Password").getString());
		Password.setMaxLength(32767);
		guistate.put("text:Password", Password);
		this.addWidget(this.Password);
		button_reset = Button.builder(Component.translatable("gui.krusader_security.pc_loging.button_reset"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new PCLogingButtonMessage(0, x, y, z));
				PCLogingButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 118, this.topPos + 133, 51, 20).build();
		guistate.put("button:button_reset", button_reset);
		this.addRenderableWidget(button_reset);
		button_log_in = Button.builder(Component.translatable("gui.krusader_security.pc_loging.button_log_in"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new PCLogingButtonMessage(1, x, y, z));
				PCLogingButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 181, this.topPos + 133, 56, 20).build();
		guistate.put("button:button_log_in", button_log_in);
		this.addRenderableWidget(button_log_in);
	}
}
