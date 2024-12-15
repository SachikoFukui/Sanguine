package net.sanguine.sanguinemod.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationDefinition {

public static final AnimationDefinition PRAY = AnimationDefinition.Builder.withLength(2f).looping()
.addAnimation("glowa",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(2f, KeyframeAnimations.degreeVec(30f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("PrawaReka",
	new AnimationChannel(AnimationChannel.Targets.POSITION,
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("PrawaReka",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-55f, -25f, -20f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(2f, KeyframeAnimations.degreeVec(-55f, -25f, -20f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("LewaReka",
	new AnimationChannel(AnimationChannel.Targets.POSITION,
		new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(1f, KeyframeAnimations.posVec(0f, -1f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("LewaReka",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(-55f, 25f, 20f),
			AnimationChannel.Interpolations.CATMULLROM))).build();
public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(0.6766666f).looping()
.addAnimation("PrawaNoga",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("LewaNoga",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("glowa",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.041676664f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("PrawaReka",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM)))
.addAnimation("LewaReka",
	new AnimationChannel(AnimationChannel.Targets.ROTATION,
		new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.16766666f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.25f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM),
		new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
			AnimationChannel.Interpolations.CATMULLROM))).build();
}