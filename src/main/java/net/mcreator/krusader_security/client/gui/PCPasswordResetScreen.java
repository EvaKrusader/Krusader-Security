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

import net.mcreator.krusader_security.world.inventory.PCPasswordResetMenu;
import net.mcreator.krusader_security.network.PCPasswordResetButtonMessage;
import net.mcreator.krusader_security.KrusaderSecurityMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PCPasswordResetScreen extends AbstractContainerScreen<PCPasswordResetMenu> {
	private final static HashMap<String, Object> guistate = PCPasswordResetMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox OldPassword;
	EditBox NewPassword;
	Button button_reset_password;

	public PCPasswordResetScreen(PCPasswordResetMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("krusader_security:textures/screens/pc_password_reset.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		OldPassword.render(guiGraphics, mouseX, mouseY, partialTicks);
		NewPassword.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (OldPassword.isFocused())
			return OldPassword.keyPressed(key, b, c);
		if (NewPassword.isFocused())
			return NewPassword.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		OldPassword.tick();
		NewPassword.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		OldPassword = new EditBox(this.font, this.leftPos + 74, this.topPos + 17, 118, 18, Component.translatable("gui.krusader_security.pc_password_reset.OldPassword")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_password_reset.OldPassword").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_password_reset.OldPassword").getString());
				else
					setSuggestion(null);
			}
		};
		OldPassword.setSuggestion(Component.translatable("gui.krusader_security.pc_password_reset.OldPassword").getString());
		OldPassword.setMaxLength(32767);
		guistate.put("text:OldPassword", OldPassword);
		this.addWidget(this.OldPassword);
		NewPassword = new EditBox(this.font, this.leftPos + 74, this.topPos + 62, 118, 18, Component.translatable("gui.krusader_security.pc_password_reset.NewPassword")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_password_reset.NewPassword").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.krusader_security.pc_password_reset.NewPassword").getString());
				else
					setSuggestion(null);
			}
		};
		NewPassword.setSuggestion(Component.translatable("gui.krusader_security.pc_password_reset.NewPassword").getString());
		NewPassword.setMaxLength(32767);
		guistate.put("text:NewPassword", NewPassword);
		this.addWidget(this.NewPassword);
		button_reset_password = Button.builder(Component.translatable("gui.krusader_security.pc_password_reset.button_reset_password"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new PCPasswordResetButtonMessage(0, x, y, z));
				PCPasswordResetButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 82, this.topPos + 106, 98, 20).build();
		guistate.put("button:button_reset_password", button_reset_password);
		this.addRenderableWidget(button_reset_password);
	}
}
