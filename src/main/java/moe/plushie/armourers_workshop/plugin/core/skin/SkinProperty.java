package moe.plushie.armourers_workshop.plugin.core.skin;

public class SkinProperty<T> {

    // Properties for all skins.
    public static final SkinProperty<String> ALL_CUSTOM_NAME = normal("customName", "");
    public static final SkinProperty<String> ALL_FLAVOUR_TEXT = normal("flavour", "");

    public static final SkinProperty<String> ALL_AUTHOR_NAME = normal("authorName", "");
    public static final SkinProperty<String> ALL_AUTHOR_UUID = normal("authorUUID", "");

    public static final SkinProperty<String> ALL_KEY_TAGS = normal("tags", "");

    public static final SkinProperty<String> ALL_SIGNATURE = normal("signature", "");

    // Properties.
    @Deprecated
    public static final SkinProperty<Boolean> MODEL_OVERRIDE = normal("armourOverride", false);
    public static final SkinProperty<Boolean> MODEL_OVERRIDE_HEAD = normal("overrideModelHead", false);
    public static final SkinProperty<Boolean> MODEL_OVERRIDE_CHEST = normal("overrideModelChest", false);
    public static final SkinProperty<Boolean> MODEL_OVERRIDE_ARM_LEFT = normal("overrideModelArmLeft", false);
    public static final SkinProperty<Boolean> MODEL_OVERRIDE_ARM_RIGHT = normal("overrideModelArmRight", false);
    public static final SkinProperty<Boolean> MODEL_OVERRIDE_LEG_LEFT = normal("overrideModelLegLeft", false);
    public static final SkinProperty<Boolean> MODEL_OVERRIDE_LEG_RIGHT = normal("overrideModelLegRight", false);

    public static final SkinProperty<Boolean> MODEL_OVERRIDE_CHEST_OF_WINGS = normal("overrideModelChestOfWings", false);

    @Deprecated
    public static final SkinProperty<Boolean> MODEL_HIDE_OVERLAY = normal("armourHideOverlay", false);
    public static final SkinProperty<Boolean> MODEL_HIDE_OVERLAY_HEAD = normal("hideOverlayHead", false);
    public static final SkinProperty<Boolean> MODEL_HIDE_OVERLAY_CHEST = normal("hideOverlayChest", false);
    public static final SkinProperty<Boolean> MODEL_HIDE_OVERLAY_ARM_LEFT = normal("hideOverlayArmLeft", false);
    public static final SkinProperty<Boolean> MODEL_HIDE_OVERLAY_ARM_RIGHT = normal("hideOverlayArmRight", false);
    public static final SkinProperty<Boolean> MODEL_HIDE_OVERLAY_LEG_LEFT = normal("hideOverlayLegLeft", false);
    public static final SkinProperty<Boolean> MODEL_HIDE_OVERLAY_LEG_RIGHT = normal("hideOverlayLegRight", false);

    public static final SkinProperty<Boolean> MODEL_LEGS_LIMIT_LIMBS = normal("limitLimbs", false);

    public static final SkinProperty<String> OUTFIT_PART_INDEXS = normal("partIndexs", "");

    public static final SkinProperty<Boolean> BLOCK_GLOWING = normal("blockGlowing", false);
    public static final SkinProperty<Boolean> BLOCK_LADDER = normal("blockLadder", false);
    public static final SkinProperty<Boolean> BLOCK_NO_COLLISION = normal("blockNoCollision", false);
    public static final SkinProperty<Boolean> BLOCK_SEAT = normal("blockSeat", false);
    public static final SkinProperty<Boolean> BLOCK_MULTIBLOCK = normal("blockMultiblock", false);
    public static final SkinProperty<Boolean> BLOCK_BED = normal("blockBed", false);
    public static final SkinProperty<Boolean> BLOCK_INVENTORY = normal("blockInventory", false);
    public static final SkinProperty<Boolean> BLOCK_ENDER_INVENTORY = normal("blockEnderInventory", false);
    public static final SkinProperty<Integer> BLOCK_INVENTORY_WIDTH = normal("blockInventoryWidth", 9);
    public static final SkinProperty<Integer> BLOCK_INVENTORY_HEIGHT = normal("blockInventoryHeight", 4);

    public static final SkinProperty<Double> WINGS_MAX_ANGLE = multiple("wingsMaxAngle", 75D);
    public static final SkinProperty<Double> WINGS_MIN_ANGLE = multiple("wingsMinAngle", 0D);
    public static final SkinProperty<Double> WINGS_IDLE_SPEED = multiple("wingsIdleSpeed", 6000D);
    public static final SkinProperty<Double> WINGS_FLYING_SPEED = multiple("wingsFlyingSpeed", 350D);
    public static final SkinProperty<String> WINGS_MOVMENT_TYPE = multiple("wingsMovmentType", MovementType.EASE.name());
    public static final SkinProperty<Boolean> WINGS_MATCHING_POSE = multiple("wingsMatchingPose", true);

    public static final SkinProperty<Double> TRANSFORM_TRANSLATE_X = normal("transformTranslateX", 0D);
    public static final SkinProperty<Double> TRANSFORM_TRANSLATE_Y = normal("transformTranslateY", 0D);
    public static final SkinProperty<Double> TRANSFORM_TRANSLATE_Z = normal("transformTranslateZ", 0D);
    public static final SkinProperty<Double> TRANSFORM_ROTATION_X = normal("transformRotationX", 0D);
    public static final SkinProperty<Double> TRANSFORM_ROTATION_Y = normal("transformRotationY", 0D);
    public static final SkinProperty<Double> TRANSFORM_ROTATION_Z = normal("transformRotationZ", 0D);
    public static final SkinProperty<Double> TRANSFORM_SCALE = normal("transformScale", 1D);

    private final String key;
    private final T defaultValue;
    private final boolean multipleKey;

    public SkinProperty(String key, T defaultValue, boolean multipleKey) {
        this.key = key;
        this.defaultValue = defaultValue;
        this.multipleKey = multipleKey;
    }

    public static <T> SkinProperty<T> normal(String key, T defaultValue) {
        return new SkinProperty<>(key, defaultValue, false);
    }

    public static <T> SkinProperty<T> multiple(String key, T defaultValue) {
        return new SkinProperty<>(key, defaultValue, true);
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public String getKey() {
        return key;
    }

    public boolean isMultipleKey() {
        return multipleKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkinProperty<?> that = (SkinProperty<?>) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    public enum MovementType {
        EASE,
        LINEAR
    }
}
