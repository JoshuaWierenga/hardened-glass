package au.com.programmingclub.hardenedglass

import net.fabricmc.api.ModInitializer
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.slf4j.LoggerFactory

object HardenedGlass : ModInitializer {
  private val namespace = "hardenedglass"

  private val logger = LoggerFactory.getLogger(namespace)

  private val HardenedGlassItem = Item(Item.Settings())

  override fun onInitialize() {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.
    Registry.register(Registries.ITEM, Identifier(namespace, "hardened_glass"), HardenedGlassItem)
  }
}
