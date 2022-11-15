package fr.gwengwen49.ghs.registry;

import fr.gwengwen49.ghs.GHS;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "ghs");
    public static final RegistryObject<Item> GASOLINE_GENERATOR_ITEM_BLOCK = ITEMS.register("gasoline_generator", () -> new BlockItem(Blocks.GASOLINE_GENERATOR.get(), new Item.Properties().rarity(Rarity.EPIC)));

    //tungsten group
    public static final RegistryObject<Item> TUNGSTEN_ORE = ITEMS.register("tungsten_ore",() -> new BlockItem(Blocks.TUNGSTEN_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_TUNGSTEN_ORE = ITEMS.register("deepslate_tungsten_ore", () -> new BlockItem(Blocks.DEEPSLATE_TUNGSTEN_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",() ->  new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    //titanium group
    public static final RegistryObject<Item> TITANIUM_ORE = ITEMS.register("titanium_ore", () -> new BlockItem(Blocks.TITANIUM_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_TITANIUM_ORE = ITEMS.register("deepslate_titanium_ore", () -> new BlockItem(Blocks.DEEPSLATE_TITANIUM_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    //tin group
    public static final RegistryObject<Item> TIN_ORE = ITEMS.register("tin_ore", () -> new BlockItem(Blocks.TIN_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_TIN_ORE = ITEMS.register("deepslate_tin_ore", () -> new BlockItem(Blocks.DEEPSLATE_TIN_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    //aluminium group
    public static final RegistryObject<Item> ALUMINIUM_ORE = ITEMS.register("aluminium_ore", () -> new BlockItem(Blocks.ALUMINIUM_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_ALUMINIUM_ORE = ITEMS.register("deepslate_aluminium_ore", () -> new BlockItem(Blocks.DEEPSLATE_ALUMINIUM_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_ALUMINIUM = ITEMS.register("raw_aluminium", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    //nickel group
    public static final RegistryObject<Item> NICKEL_ORE = ITEMS.register("nickel_ore", () -> new BlockItem(Blocks.NICKEL_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_NICKEL_ORE = ITEMS.register("deepslate_nickel_ore", () -> new BlockItem(Blocks.DEEPSLATE_NICKEL_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_NICKEL = ITEMS.register("raw_nickel", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    //silver group
    public static final RegistryObject<Item> SILVER_ORE = ITEMS.register("silver_ore", () -> new BlockItem(Blocks.SILVER_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_SILVER_ORE = ITEMS.register("deepslate_silver_ore", () -> new BlockItem(Blocks.DEEPSLATE_SILVER_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    //zinc group
    public static final RegistryObject<Item> ZINC_ORE = ITEMS.register("zinc_ore", () -> new BlockItem(Blocks.ZINC_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_ZINC_ORE = ITEMS.register("deepslate_zinc_ore", () -> new BlockItem(Blocks.DEEPSLATE_ZINC_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    //lead group
    public static final RegistryObject<Item> LEAD_ORE = ITEMS.register("lead_ore", () -> new BlockItem(Blocks.LEAD_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> DEEPSLATE_LEAD_ORE = ITEMS.register("deepslate_lead_ore", () -> new BlockItem(Blocks.DEEPSLATE_LEAD_ORE.get(), new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));

    //alloys
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(Items.SC_TAB)));


    public static final CreativeModeTab SC_TAB = new CreativeModeTab("ghs") {
        @Override
        public ItemStack makeIcon() {

            return Items.GASOLINE_GENERATOR_ITEM_BLOCK.get().getDefaultInstance();
        }
    };
}
