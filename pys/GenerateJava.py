

# 替换 "xxx Entity" 为实际的实体名称
entity_name_huge = "PLAYER"
entity_name_big = "Player"  # 这里替换成你实际的实体名称
entity_name_ = "player"  # 这里替换成你实际的实体名称

model_file_cotent = '''package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.XxxEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class XxxModel extends AnimatedGeoModel<XxxEntity> {

    @Override
    public ResourceLocation getModelResource(XxxEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "geo/xxx.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(XxxEntity animatable) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/xxx.png");
    }

    @Override
    public ResourceLocation getAnimationResource(XxxEntity animatable) {
       return new ResourceLocation(ExampleMod.MODID, "animations/xxx.animation.json");
    }
}'''

model_file_name = r'E:\mine\mod1192\src\main\java\com\example\examplemod\entity\client\XxxModel.java'

model_file_cotent = model_file_cotent.replace('Xxx', entity_name_big)
model_file_cotent = model_file_cotent.replace('xxx', entity_name_)
model_file_name = model_file_name.replace('Xxx', entity_name_big)
model_file_name = model_file_name.replace('xxx', entity_name_)
with open(model_file_name, 'w') as file:
    file.write(model_file_cotent)
    
# ------------------------------------ **************************************** --------------------------------------
    
renderer_file_cotent = '''package com.example.examplemod.entity.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entity.custom.XxxEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class XxxRenderer extends GeoEntityRenderer<XxxEntity> {

    public XxxRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new XxxModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(XxxEntity instance) {
        return new ResourceLocation(ExampleMod.MODID, "textures/entity/Xxx.png");
    }

    @Override
    public RenderType getRenderType(XxxEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        //stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}'''

renderer_file_name = r'E:\mine\mod1192\src\main\java\com\example\examplemod\entity\client\XxxRenderer.java'

renderer_file_cotent = renderer_file_cotent.replace('Xxx', entity_name_big)
renderer_file_cotent = renderer_file_cotent.replace('xxx', entity_name_)
renderer_file_name = renderer_file_name.replace('Xxx', entity_name_big)
renderer_file_name = renderer_file_name.replace('xxx', entity_name_)
with open(renderer_file_name, 'w') as file:
    file.write(renderer_file_cotent)
    
print(f"File '{renderer_file_name}' has been created with the specified content.")

# ------------------------------------ **************************************** --------------------------------------

entity_file_cotent = '''package com.example.examplemod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class XxxEntity extends Monster implements IAnimatable {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(XxxEntity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STYLE =
            SynchedEntityData.defineId(XxxEntity.class, EntityDataSerializers.INT);
    private AnimationFactory factory = new AnimationFactory(this);

    public XxxEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        double r = pLevel.random.nextGaussian();
        if(r < 0.4){
            this.setStyle(0);
        }else if(r < 0.6){
            this.setStyle(1);
        }else {
            this.setStyle(2);
        }
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();
    }

    private boolean drop_hand = false;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.xxx.walk", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.xxx.idle", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "smoker_controller",
                0, this::predicate));
    }



    @Override
    public AnimationFactory getFactory() {
        return factory;
    }



    int cool = 0;
    public void tick() {
        super.tick();
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    public void setStyle(int style) {
        this.entityData.set(STYLE, style);
    }

    public int Style() {
        return this.entityData.get(STYLE);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
        this.entityData.define(STYLE, 0);
    }

}
'''

entity_file_name = r'E:\mine\mod1192\src\main\java\com\example\examplemod\entity\custom\XxxEntity.java'

entity_file_cotent = entity_file_cotent.replace('Xxx', entity_name_big)
entity_file_cotent = entity_file_cotent.replace('xxx', entity_name_)
entity_file_name = entity_file_name.replace('Xxx', entity_name_big)
entity_file_name = entity_file_name.replace('xxx', entity_name_)
with open(entity_file_name, 'w') as file:
    file.write(entity_file_cotent)
    
print(f"File '{renderer_file_name}' has been created with the specified content.")


# rs x

# 定义文件路径和要添加的内容
mod_types_file_path = 'E:\mine\mod1192\src\main\java\com\example\examplemod\entity\ModEntityTypes.java'  # 替换为实际的文件路径
mod_types_content = '''
public static final RegistryObject<EntityType<XxxEntity>> XXX =
    ENTITY_TYPES.register("xxx",
            () -> EntityType.Builder.of(XxxEntity::new, MobCategory.MONSTER)
                    .sized(0.4f, 1.5f)
                    .build(new ResourceLocation(ExampleMod.MODID, "xxx").toString()));
'''
mod_types_content = mod_types_content.replace('XXX', entity_name_huge)
mod_types_content = mod_types_content.replace('Xxx', entity_name_big)
mod_types_content = mod_types_content.replace('xxx', entity_name_)
# 读取文件内容
with open(mod_types_file_path, 'r') as file:
    lines = file.readlines()

# 查找特定的代码行
target_line = "DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MODID);"
insert_index = None

for i, line in enumerate(lines):
    if target_line in line:
        insert_index = i + 1
        break

# 如果找到了特定的行，则在下一行插入新内容
if insert_index is not None:
    # 在特定行后插入新内容
    lines.insert(insert_index, mod_types_content)
    # 写回文件
    with open(mod_types_file_path, 'w') as file:
        file.writelines(lines)
    print(f"New content added to the file '{mod_types_file_path}' successfully.")
else:
    print(f"The target line was not found in the file '{mod_types_file_path}'.")
    
# rs y

# 定义文件路径和要添加的内容
mod_events_file_name = 'E:\mine\mod1192\src\main\java\com\example\examplemod\event\ModEvents.java'  # 替换为实际的文件路径
mod_events_content = '''
event.put(ModEntityTypes.XXX.get(), XxxEntity.setAttributes());
'''
mod_events_content = mod_events_content.replace('XXX', entity_name_huge)
mod_events_content = mod_events_content.replace('Xxx', entity_name_big)
mod_events_content = mod_events_content.replace('xxx', entity_name_)
# 读取文件内容
with open(mod_events_file_name, 'r') as file:
    lines = file.readlines()

# 查找特定的代码行
target_line = "public static void entityAttributeEvent(EntityAttributeCreationEvent event) {"
insert_index = None

for i, line in enumerate(lines):
    if target_line in line:
        insert_index = i + 1
        break

# 如果找到了特定的行，则在下一行插入新内容
if insert_index is not None:
    # 在特定行后插入新内容
    lines.insert(insert_index, mod_events_content)
    # 写回文件
    with open(mod_events_file_name, 'w') as file:
        file.writelines(lines)
    print(f"New content added to the file '{mod_types_file_path}' successfully.")
else:
    print(f"The target line was not found in the file '{mod_types_file_path}'.")
    
    
# rs y

# 定义文件路径和要添加的内容
mod_items_file_path = 'E:\mine\mod1192\src\main\java\com\example\examplemod\item\ModItems.java'  # 替换为实际的文件路径
mod_items_content = '''
    public static final RegistryObject<Item> XXX_SPAWN_EGG = ITEMS.register("xxx_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.XXX, 0x22b341, 0x19732e,
                    new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(1)));
'''
mod_items_content = mod_items_content.replace('XXX', entity_name_huge)
mod_items_content = mod_items_content.replace('Xxx', entity_name_big)
mod_items_content = mod_items_content.replace('xxx', entity_name_)
# 读取文件内容
with open(mod_items_file_path, 'r') as file:
    lines = file.readlines()

# 查找特定的代码行
target_line = "public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);"
insert_index = None

for i, line in enumerate(lines):
    if target_line in line:
        insert_index = i + 1
        break

# 如果找到了特定的行，则在下一行插入新内容
if insert_index is not None:
    # 在特定行后插入新内容
    lines.insert(insert_index, mod_items_content)
    # 写回文件
    with open(mod_items_file_path, 'w') as file:
        file.writelines(lines)
    print(f"New content added to the file '{mod_types_file_path}' successfully.")
else:
    print(f"The target line was not found in the file '{mod_types_file_path}'.")
    

example_file_path = 'E:\mine\mod1192\src\main\java\com\example\examplemod\ExampleMod.java'  # 替换为实际的文件路径
example_content = '''
   EntityRenderers.register(ModEntityTypes.XXX.get(), XxxRenderer::new);
'''
example_content = example_content.replace('XXX', entity_name_huge)
example_content = example_content.replace('Xxx', entity_name_big)
example_content = example_content.replace('xxx', entity_name_)
# 读取文件内容
with open(example_file_path, 'r') as file:
    lines = file.readlines()

# 查找特定的代码行
target_line = "public static void onClientSetup(FMLClientSetupEvent event) {"
insert_index = None

for i, line in enumerate(lines):
    if target_line in line:
        insert_index = i + 1
        break

# 如果找到了特定的行，则在下一行插入新内容
if insert_index is not None:
    # 在特定行后插入新内容
    lines.insert(insert_index, example_content)
    # 写回文件
    with open(example_file_path, 'w') as file:
        file.writelines(lines)
    print(f"New content added to the file '{mod_types_file_path}' successfully.")
else:
    print(f"The target line was not found in the file '{mod_types_file_path}'.")
    
spawn_file_path = 'E:/mine/mod1192/src/main/resources/assets/examplemod/lang/en_us.json'  # 替换为实际的文件路径
spawn_content = '''
   "item.examplemod.xxx_spawn_egg" : "XXX",
'''
spawn_content = spawn_content.replace('XXX', entity_name_huge)
spawn_content = spawn_content.replace('xxx', entity_name_)
# 读取文件内容
with open(spawn_file_path, 'r') as file:
    lines = file.readlines()

# 查找特定的代码行
target_line = "{"
insert_index = None

for i, line in enumerate(lines):
    if target_line in line:
        insert_index = i + 1
        break

# 如果找到了特定的行，则在下一行插入新内容
if insert_index is not None:
    # 在特定行后插入新内容
    lines.insert(insert_index, spawn_content)
    # 写回文件
    with open(spawn_file_path, 'w') as file:
        file.writelines(lines)
    print(f"New content added to the file '{mod_types_file_path}' successfully.")
else:
    print(f"The target line was not found in the file '{mod_types_file_path}'.")
    
egg_name = r'E:\mine\mod1192\src\main\resources\assets\examplemod\models\item\xxx_spawn_egg.json'
egg_name = egg_name.replace('xxx', entity_name_)
egg_content = """
{
  "parent": "minecraft:item/template_spawn_egg"
}
"""

# 写入文件
with open(egg_name, 'w') as file:
    file.write(egg_content)

print(f"File '{egg_name}' has been created with the specified content.")
    