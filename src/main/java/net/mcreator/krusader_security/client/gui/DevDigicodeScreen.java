package net.mcreator.krusader_security.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.krusader_security.world.inventory.DevDigicodeMenu;
import net.mcreator.krusader_security.procedures.ScreenShowerProcedure;
import net.mcreator.krusader_security.procedures.ScreenRedProcedure;
import net.mcreator.krusader_security.procedures.ScreenGreenProcedure;
import net.mcreator.krusader_security.procedures.Screen5StarsProcedure;
import net.mcreator.krusader_security.procedures.Screen4StarsProcedure;
import net.mcreator.krusader_security.procedures.Screen3StarsProcedure;
import net.mcreator.krusader_security.procedures.Screen2StarsProcedure;
import net.mcreator.krusader_security.network.DevDigicodeButtonMessage;
import net.mcreator.krusader_security.KrusaderSecurityMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DevDigicodeScreen extends AbstractContainerScreen<DevDigicodeMenu> {
	private final static HashMap<String, Object> guistate = DevDigicodeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_4;
	Button button_5;
	Button button_6;
	Button button_7;
	Button button_8;
	Button button_9;
	Button button_0;
	ImageButton imagebutton_buttonv;
	ImageButton imagebutton_buttonx;

	public DevDigicodeScreen(DevDigicodeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 182;
		this.imageHeight = 160;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/dev_digicode.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 182, 160, 182, 160);

		if (ScreenGreenProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/codegreen.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 168, 28, 168, 28);
		}
		if (ScreenRedProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/codered.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 168, 28, 168, 28);
		}
		if (Screen5StarsProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/code4.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 168, 28, 168, 28);
		}
		if (Screen4StarsProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/code3.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 168, 28, 168, 28);
		}
		if (Screen3StarsProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/code2.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 168, 28, 168, 28);
		}
		if (Screen2StarsProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/code1.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 168, 28, 168, 28);
		}
		if (ScreenShowerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("krusader_security:textures/screens/code.png"), this.leftPos + 7, this.topPos + 7, 0, 0, 168, 28, 168, 28);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
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
		button_1 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_1"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(0, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 43, 30, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_2"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(1, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 79, this.topPos + 43, 30, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_3 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_3"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(2, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 133, this.topPos + 43, 30, 20).build();
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		button_4 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_4"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(3, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 70, 30, 20).build();
		guistate.put("button:button_4", button_4);
		this.addRenderableWidget(button_4);
		button_5 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_5"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(4, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 79, this.topPos + 70, 30, 20).build();
		guistate.put("button:button_5", button_5);
		this.addRenderableWidget(button_5);
		button_6 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_6"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(5, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 133, this.topPos + 70, 30, 20).build();
		guistate.put("button:button_6", button_6);
		this.addRenderableWidget(button_6);
		button_7 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_7"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(6, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 97, 30, 20).build();
		guistate.put("button:button_7", button_7);
		this.addRenderableWidget(button_7);
		button_8 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_8"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(7, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 79, this.topPos + 97, 30, 20).build();
		guistate.put("button:button_8", button_8);
		this.addRenderableWidget(button_8);
		button_9 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_9"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(8, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 133, this.topPos + 97, 30, 20).build();
		guistate.put("button:button_9", button_9);
		this.addRenderableWidget(button_9);
		button_0 = Button.builder(Component.translatable("gui.krusader_security.dev_digicode.button_0"), e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(9, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 79, this.topPos + 124, 30, 20).build();
		guistate.put("button:button_0", button_0);
		this.addRenderableWidget(button_0);
		imagebutton_buttonv = new ImageButton(this.leftPos + 133, this.topPos + 124, 30, 20, 0, 0, 20, new ResourceLocation("krusader_security:textures/screens/atlas/imagebutton_buttonv.png"), 30, 40, e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(10, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_buttonv", imagebutton_buttonv);
		this.addRenderableWidget(imagebutton_buttonv);
		imagebutton_buttonx = new ImageButton(this.leftPos + 16, this.topPos + 124, 30, 20, 0, 0, 20, new ResourceLocation("krusader_security:textures/screens/atlas/imagebutton_buttonx.png"), 30, 40, e -> {
			if (true) {
				KrusaderSecurityMod.PACKET_HANDLER.sendToServer(new DevDigicodeButtonMessage(11, x, y, z));
				DevDigicodeButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_buttonx", imagebutton_buttonx);
		this.addRenderableWidget(imagebutton_buttonx);
	}
}
