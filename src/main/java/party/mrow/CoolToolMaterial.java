package party.mrow;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CoolToolMaterial implements ToolMaterial {
    public static final CoolToolMaterial INSTANCE = new CoolToolMaterial();
    @Override
    public int getDurability() {
        return 6969;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 69F;
    }

    @Override
    public float getAttackDamage() {
        return 69F;
    }

    @Override
    public int getMiningLevel() {
        return 69;
    }

    @Override
    public int getEnchantability() {
        return 69;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
