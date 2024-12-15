package net.sanguine.sanguinemod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SOUL = new FoodProperties.Builder()
            .nutrition(0)
            .saturationMod(0.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 4800), 1f )
            .build();
    public static final FoodProperties AMALGAM = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 4800, 2), 1f )
            .build();
}
