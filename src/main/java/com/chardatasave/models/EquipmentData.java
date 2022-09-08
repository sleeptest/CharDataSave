package com.chardatasave.models;

import lombok.Getter;
import net.runelite.api.ItemID;
import net.runelite.api.kit.KitType;

import java.util.HashMap;
import java.util.Map;

public enum EquipmentData
{
    // Non-LMS items:
    DRAGON_CROSSBOW(ItemID.DRAGON_CROSSBOW),
    DRAGON_HUNTER_CROSSBOW(ItemID.DRAGON_HUNTER_CROSSBOW),
    LIGHT_BALLISTA(ItemID.LIGHT_BALLISTA),
    MAGIC_SHORTBOW(ItemID.MAGIC_SHORTBOW),
    MAGIC_SHORTBOW_I(ItemID.MAGIC_SHORTBOW_I),
    TOXIC_BLOWPIPE(ItemID.TOXIC_BLOWPIPE),
    VOLATILE_NIGHTMARE_STAFF(ItemID.VOLATILE_NIGHTMARE_STAFF),
    SMOKE_BATTLESTAFF(ItemID.SMOKE_BATTLESTAFF),
    TOME_OF_FIRE(ItemID.TOME_OF_FIRE), // (charged tome)
    VOID_MAGE_HELM(ItemID.VOID_MAGE_HELM),
    VOID_RANGE_HELM(ItemID.VOID_RANGER_HELM),
    VOID_MELEE_HELM(ItemID.VOID_MELEE_HELM),
    VOID_ELITE_BODY(ItemID.ELITE_VOID_TOP),
    VOID_ELITE_LEGS(ItemID.ELITE_VOID_ROBE),
    VOID_GLOVES(ItemID.VOID_KNIGHT_GLOVES),
    VOID_BODY(ItemID.VOID_KNIGHT_TOP),
    VOID_LEGS(ItemID.VOID_KNIGHT_ROBE),
    CRYSTAL_HELM(ItemID.CRYSTAL_HELM),
    CRYSTAL_BODY(ItemID.CRYSTAL_BODY),
    CRYSTAL_LEGS(ItemID.CRYSTAL_LEGS),
    BOW_OF_FAERDHINEN(ItemID.BOW_OF_FAERDHINEN, ItemID.BOW_OF_FAERDHINEN_C, ItemID.BOW_OF_FAERDHINEN_C_25869, ItemID.BOW_OF_FAERDHINEN_C_25884, ItemID.BOW_OF_FAERDHINEN_C_25886, ItemID.BOW_OF_FAERDHINEN_C_25888, ItemID.BOW_OF_FAERDHINEN_C_25890, ItemID.BOW_OF_FAERDHINEN_C_25892, ItemID.BOW_OF_FAERDHINEN_C_25894, ItemID.BOW_OF_FAERDHINEN_C_25896),
    CRYSTAL_BOW(ItemID.CRYSTAL_BOW_FULL, ItemID.CRYSTAL_BOW, ItemID.CRYSTAL_BOW_110, ItemID.CRYSTAL_BOW_210, ItemID.CRYSTAL_BOW_310, ItemID.CRYSTAL_BOW_410, ItemID.CRYSTAL_BOW_510, ItemID.CRYSTAL_BOW_610, ItemID.CRYSTAL_BOW_710, ItemID.CRYSTAL_BOW_810, ItemID.CRYSTAL_BOW_910),
    CRYSTAL_BOW_I(ItemID.CRYSTAL_BOW_FULL_I, ItemID.CRYSTAL_BOW_110_I, ItemID.CRYSTAL_BOW_210_I, ItemID.CRYSTAL_BOW_310_I, ItemID.CRYSTAL_BOW_410_I, ItemID.CRYSTAL_BOW_510_I, ItemID.CRYSTAL_BOW_610_I, ItemID.CRYSTAL_BOW_710_I, ItemID.CRYSTAL_BOW_810_I, ItemID.CRYSTAL_BOW_910_I),

    // LMS items:
    RUNE_CROSSBOW(ItemID.RUNE_CROSSBOW, ItemID.RUNE_CROSSBOW_23601),
    ARMADYL_CROSSBOW(ItemID.ARMADYL_CROSSBOW, ItemID.ARMADYL_CROSSBOW_23611),
    DARK_BOW(ItemID.DARK_BOW, ItemID.DARK_BOW_20408, ItemID.DARK_BOW_12765, ItemID.DARK_BOW_12766, ItemID.DARK_BOW_12767, ItemID.DARK_BOW_12768),
    HEAVY_BALLISTA(ItemID.HEAVY_BALLISTA, ItemID.HEAVY_BALLISTA_23630),

    STATIUS_WARHAMMER(ItemID.STATIUSS_WARHAMMER, ItemID.STATIUSS_WARHAMMER_23620),
    VESTAS_LONGSWORD(ItemID.VESTAS_LONGSWORD, ItemID.VESTAS_LONGSWORD_23615, ItemID.VESTAS_BLIGHTED_LONGSWORD),
    ARMADYL_GODSWORD(ItemID.ARMADYL_GODSWORD, ItemID.ARMADYL_GODSWORD_20593, ItemID.ARMADYL_GODSWORD_OR),
    DRAGON_CLAWS(ItemID.DRAGON_CLAWS, ItemID.DRAGON_CLAWS_20784),
    DRAGON_DAGGER(ItemID.DRAGON_DAGGER, ItemID.DRAGON_DAGGER_20407, ItemID.DRAGON_DAGGERP, ItemID.DRAGON_DAGGERP_5680, ItemID.DRAGON_DAGGERP_5698),
    GRANITE_MAUL(ItemID.GRANITE_MAUL, ItemID.GRANITE_MAUL_12848, ItemID.GRANITE_MAUL_20557, ItemID.GRANITE_MAUL_24225, ItemID.GRANITE_MAUL_24227),
    AMULET_OF_FURY(ItemID.AMULET_OF_FURY, ItemID.AMULET_OF_FURY_23640),
    BANDOS_TASSETS(ItemID.BANDOS_TASSETS, ItemID.BANDOS_TASSETS_23646),
    BLESSED_SPIRIT_SHIELD(ItemID.BLESSED_SPIRIT_SHIELD, ItemID.BLESSED_SPIRIT_SHIELD_23642),
    DHAROKS_HELM(ItemID.DHAROKS_HELM, ItemID.DHAROKS_HELM_23639),
    DHAROKS_PLATELEGS(ItemID.DHAROKS_PLATELEGS, ItemID.DHAROKS_PLATELEGS_23633),
    GUTHANS_HELM(ItemID.GUTHANS_HELM, ItemID.GUTHANS_HELM_23638),
    KARILS_TOP(ItemID.KARILS_LEATHERTOP, ItemID.KARILS_LEATHERTOP_23632),
    TORAGS_HELM(ItemID.TORAGS_HELM, ItemID.TORAGS_HELM_23637),
    TORAGS_PLATELEGS(ItemID.TORAGS_PLATELEGS, ItemID.TORAGS_PLATELEGS_23634),
    VERACS_HELM(ItemID.VERACS_HELM, ItemID.VERACS_HELM_23636),
    VERACS_PLATESKIRT(ItemID.VERACS_PLATESKIRT, ItemID.VERACS_PLATESKIRT_23635),
    MORRIGANS_JAVELIN(ItemID.MORRIGANS_JAVELIN, ItemID.MORRIGANS_JAVELIN_23619),
    SPIRIT_SHIELD(ItemID.SPIRIT_SHIELD, ItemID.SPIRIT_SHIELD_23599),
    HELM_OF_NEITIZNOT(ItemID.HELM_OF_NEITIZNOT, ItemID.HELM_OF_NEITIZNOT_23591),
    AMULET_OF_GLORY(ItemID.AMULET_OF_GLORY, ItemID.AMULET_OF_GLORY_20586),
    ABYSSAL_WHIP(ItemID.ABYSSAL_WHIP, ItemID.ABYSSAL_WHIP_20405),
    DRAGON_DEFENDER(ItemID.DRAGON_DEFENDER, ItemID.DRAGON_DEFENDER_23597),
    BLACK_DHIDE_BODY(ItemID.BLACK_DHIDE_BODY, ItemID.BLACK_DHIDE_BODY_20423),
    RUNE_PLATELEGS(ItemID.RUNE_PLATELEGS, ItemID.RUNE_PLATELEGS_20422),
    CLIMBING_BOOTS(ItemID.CLIMBING_BOOTS, ItemID.CLIMBING_BOOTS_20578),
    BARROWS_GLOVES(ItemID.BARROWS_GLOVES, ItemID.BARROWS_GLOVES_23593),
    ELDER_MAUL(ItemID.ELDER_MAUL, ItemID.ELDER_MAUL_21205),
    INFERNAL_CAPE(ItemID.INFERNAL_CAPE, ItemID.INFERNAL_CAPE_23622),
    GHRAZI_RAPIER(ItemID.GHRAZI_RAPIER, ItemID.GHRAZI_RAPIER_23628),

    ZURIELS_STAFF(ItemID.ZURIELS_STAFF, ItemID.ZURIELS_STAFF_23617),
    STAFF_OF_THE_DEAD(ItemID.STAFF_OF_THE_DEAD, ItemID.STAFF_OF_THE_DEAD_23613),
    KODAI_WAND(ItemID.KODAI_WAND, ItemID.KODAI_WAND_23626),
    AHRIMS_STAFF(ItemID.AHRIMS_STAFF, ItemID.AHRIMS_STAFF_23653),
    MYSTIC_ROBE_TOP(ItemID.MYSTIC_ROBE_TOP, ItemID.MYSTIC_ROBE_TOP_20425),
    MYSTIC_ROBE_BOTTOM(ItemID.MYSTIC_ROBE_BOTTOM, ItemID.MYSTIC_ROBE_BOTTOM_20426),
    AHRIMS_ROBE_TOP(ItemID.AHRIMS_ROBETOP, ItemID.AHRIMS_ROBETOP_20598),
    AHRIMS_ROBE_SKIRT(ItemID.AHRIMS_ROBESKIRT, ItemID.AHRIMS_ROBESKIRT_20599),
    OCCULT_NECKLACE(ItemID.OCCULT_NECKLACE, ItemID.OCCULT_NECKLACE_23654),
    MAGES_BOOK(ItemID.MAGES_BOOK, ItemID.MAGES_BOOK_23652),
    ETERNAL_BOOTS(ItemID.ETERNAL_BOOTS, ItemID.ETERNAL_BOOTS_23644),
    IMBUED_ZAMORAK_CAPE(ItemID.IMBUED_ZAMORAK_CAPE, ItemID.IMBUED_ZAMORAK_CAPE_23605),
    IMBUED_GUTHIX_CAPE(ItemID.IMBUED_GUTHIX_CAPE, ItemID.IMBUED_GUTHIX_CAPE_23603),
    IMBUED_SARADOMIN_CAPE(ItemID.IMBUED_SARADOMIN_CAPE, ItemID.IMBUED_SARADOMIN_CAPE_23607);

    private static final Map<Integer, EquipmentData> itemData = new HashMap<>();

    @Getter
    private final int itemId; // main id to be used for stat lookups
    @Getter
    private final int[] additionalIds; // extra ids that might represent the same item (like LMS versions, or a dragon dagger(p) = dds, or charged items etc)

    EquipmentData(int itemId)
    {
        this.itemId = itemId;
        this.additionalIds = null;
    }

    EquipmentData(int itemId, int... itemIds)
    {
        this.itemId = itemId;
        this.additionalIds = itemIds;
    }

    // Get the saved EquipmentData for a given itemId (could be null)
    public static EquipmentData fromId(int itemId)
    {
        return itemData.get(itemId);
    }

    static
    {
        for (EquipmentData data : EquipmentData.values())
        {
            itemData.putIfAbsent(data.getItemId(), data);
            if (data.additionalIds != null && data.additionalIds.length > 0)
            {
                for (int id : data.additionalIds)
                {
                    itemData.putIfAbsent(id, data);
                }
            }
        }
    }

    // this was used for dps calcs so probably won't be used here. Code may still be useful.
    public enum VoidStyle
    {
        VOID_MELEE(1.1, 1.1),
        VOID_RANGE(1.1, 1.1),
        VOID_MAGE(1.45, 1),
        VOID_ELITE_MELEE(1.1, 1.1),
        VOID_ELITE_RANGE(1.125, 1.125),
        VOID_ELITE_MAGE(1.45, 1.025),
        NONE(1, 1);

        public double accuracyModifier;
        public double dmgModifier;

        VoidStyle(double accuracyModifier, double dmgModifier)
        {
            this.accuracyModifier = accuracyModifier;
            this.dmgModifier = dmgModifier;
        }

        // return a void style for a given PlayerComposition
        public static VoidStyle getVoidStyleFor(int[] playerComposition)
        {
            if (playerComposition == null) { return NONE; }

            EquipmentData gloves = EquipmentData.fromId(playerComposition[KitType.HANDS.getIndex()]);

            if (gloves != EquipmentData.VOID_GLOVES) { return NONE; }

            EquipmentData helm = EquipmentData.fromId(playerComposition[KitType.HEAD.getIndex()]);
            EquipmentData torso = EquipmentData.fromId(playerComposition[KitType.TORSO.getIndex()]);
            EquipmentData legs = EquipmentData.fromId(playerComposition[KitType.LEGS.getIndex()]);

            if (torso == EquipmentData.VOID_BODY && legs == EquipmentData.VOID_LEGS)
            {
                return helm == EquipmentData.VOID_MAGE_HELM ? VOID_MAGE
                        : helm == EquipmentData.VOID_RANGE_HELM ? VOID_RANGE
                        : helm == EquipmentData.VOID_MELEE_HELM ? VOID_MELEE
                        : NONE;
            }
            else if (torso == EquipmentData.VOID_ELITE_BODY && legs == EquipmentData.VOID_ELITE_LEGS)
            {
                return helm == EquipmentData.VOID_MAGE_HELM ? VOID_ELITE_MAGE
                        : helm == EquipmentData.VOID_RANGE_HELM ? VOID_ELITE_RANGE
                        : helm == EquipmentData.VOID_MELEE_HELM ? VOID_ELITE_MELEE
                        : NONE;
            }

            return NONE;
        }
    }
}

