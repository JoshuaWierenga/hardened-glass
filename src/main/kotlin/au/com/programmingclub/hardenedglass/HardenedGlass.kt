package au.com.programmingclub.hardenedglass

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.util.Identifier
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.slf4j.LoggerFactory

object HardenedGlass : ModInitializer {
  private val namespace = "hardenedglass"

  private val logger = LoggerFactory.getLogger(namespace)

  private val HardenedGlassIdentifier = Identifier(namespace, "hardened_glass")
  private val HardenedGlassBlock = Block(
    AbstractBlock.Settings.create()
    .hardness(10f)
    .resistance(9f)
  )
  private val HardenedGlassItem = BlockItem(HardenedGlassBlock, Item.Settings())

  override fun onInitialize() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.
    Registry.register(Registries.BLOCK, HardenedGlassIdentifier, HardenedGlassBlock)
    Registry.register(Registries.ITEM, HardenedGlassIdentifier, HardenedGlassItem)

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register({content ->
      content.add(HardenedGlassItem)
    })
  }
}
