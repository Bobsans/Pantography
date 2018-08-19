package com.wumple.pantography.capability.container;

import com.wumple.pantography.capability.IPantographCap;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiPantograph extends GuiContainer
{
    private static final ResourceLocation guiTextures = new ResourceLocation("pantography", "textures/gui/pantograph.png");
    private IPantographCap tileOwner;

    //private Slot hoveredSlot;

    public GuiPantograph (InventoryPlayer inventory, IPantographCap tileEntity)
    {
        super(new ContainerPantograph(inventory, tileEntity));
        tileOwner = tileEntity;
    }

    @Override
    public void drawScreen (int mouseX, int mouseY, float partialTicks) 
    {
    	super.drawScreen(mouseX, mouseY, partialTicks);
    	this.renderHoveredToolTip(mouseX, mouseY);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
    	GlStateManager.pushAttrib();

        String name = this.tileOwner.hasCustomName() ? this.tileOwner.getName() : I18n.format(this.tileOwner.getName(), new Object[0]);
        this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);

        GlStateManager.popAttrib();
    }

    /*
    @Override
    public void drawScreen (int mouseX, int mouseY, float dt) {
        hoveredSlot = null;
        for (int i = 0, n = inventorySlots.inventorySlots.size(); i < n; i++) {
            Slot slot = inventorySlots.getSlot(i);
            if (isPointInRegion(slot.xPos, slot.yPos, 16, 16, mouseX, mouseY))
                hoveredSlot = slot;
        }
       
        super.drawScreen(mouseX, mouseY, dt);

        this.renderHoveredToolTip(mouseX, mouseY);
    }

    
    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);

        String name = this.tileOwner.hasCustomName() ? this.tileOwner.getName() : I18n.format(this.tileOwner.getName(), new Object[0]);
        this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);

        for (int i = 0, n = inventorySlots.inventorySlots.size(); i < n; i++)
            drawSlotHighlight(inventorySlots.getSlot(i));

        GL11.glPopAttrib();
    }
    */
    
    static final int progressSize = 24;

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
    	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiTextures);
        int halfW = (this.width - this.xSize) / 2;
        int halfH = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(halfW, halfH, 0, 0, this.xSize, this.ySize);

        /*
        if (tileOwner.isActive())
        {
            int timeRemaining = tileOwner.getDecomposeTimeRemainingScaled(progressSize);
            drawTexturedModalRect(halfW + 89, halfH + 34, 176, 0, timeRemaining, 16);
        }
        */
    }

    /*
    protected void drawSlotHighlight (Slot slot) {
        if (hoveredSlot == null || isInPlayerInventory(hoveredSlot) || slot == hoveredSlot)
            return;

        if (mc.player.inventory.getItemStack() == null) {
            if (slot != null && slot.getHasStack() && hoveredSlot.isItemValid(slot.getStack())) {
                zLevel += 100;
                drawGradientRect(slot.xPos, slot.yPos, slot.xPos + 16, slot.yPos + 16, 0x80ffffff, 0x80ffffff);
                zLevel -= 100;
            }
        }
    }

    private boolean isInPlayerInventory (Slot slot) {
        return slot.inventory == mc.player.inventory;
    }
    */
}
