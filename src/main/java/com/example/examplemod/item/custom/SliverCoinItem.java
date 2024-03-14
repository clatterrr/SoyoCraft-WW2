package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.DayZombie.NormalZombieEntity;
import com.example.examplemod.entity.custom.Garden.GardenRakeEntity;
import com.example.examplemod.entity.custom.ThePlantEntity;
import com.example.examplemod.entity.custom.TheZombieEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import team.creative.cmdcam.common.math.point.CamPoint;
import team.creative.cmdcam.common.scene.CamScene;
import team.creative.cmdcam.client.CMDCamClient;
import team.creative.creativecore.common.util.registry.exception.RegistryException;

import java.util.List;
import java.util.Random;

public class SliverCoinItem extends Item {

    public SliverCoinItem(Properties p_41383_) {
        super(p_41383_);
    }

    CamPoint moveForward(CamPoint p, double distance) {
        double yaw = p.rotationYaw * Math.PI / 180.0;
        double pitch = p.rotationPitch * Math.PI / 180.0;
        double new_x = p.x - distance * Math.sin(yaw) * Math.cos(pitch);
        double new_y = p.y - distance * Math.sin(pitch);
        double new_z = p.z + distance * Math.cos(yaw) * Math.cos(pitch);
        return new CamPoint(new_x, new_y, new_z, p.rotationYaw, p.rotationPitch, p.roll, p.zoom);
    }

    CamPoint moveRight(CamPoint p, double distance) {
        double yaw = p.rotationYaw * Math.PI / 180.0;
        double new_x = p.x - distance * Math.cos(yaw);
        double new_y = p.y;
        double new_z = p.z - distance * Math.sin(yaw);
        return new CamPoint(new_x, new_y, new_z, p.rotationYaw, p.rotationPitch, p.roll, p.zoom);
    }

    CamPoint moveUp(CamPoint p, double distance) {
        double pitch = p.rotationPitch * Math.PI / 180.0;
        double new_x = p.x;
        double new_y = p.y + distance * Math.sin(pitch);
        double new_z = p.z + distance * Math.cos(pitch);
        return new CamPoint(new_x, new_y, new_z, p.rotationYaw, p.rotationPitch, p.roll, p.zoom);
    }

    void ForwardScene(Player player){

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 4000L);
        CamPoint p1 = CamPoint.createLocal();
        //CamPoint p2 = moveForward(p1, -5.0);
        CamPoint p2 = moveUp(p1, 5.0);
            try {
                CamScene path = new CamScene(nbt);
                //path.points.clear();
                path.points.add(p1);
                path.points.add(p2);
                CMDCamClient.start(path);
            } catch (RegistryException e) {
                throw new RuntimeException(e);
            }
            if(player != null) {
                player.sendSystemMessage(Component.literal(nbt.toString()));
            }


    }

    void FiveStarScene(Player player){

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 4000L);
        CamPoint p0 = CamPoint.createLocal();
        CamPoint p00 = moveForward(p0, -1.5);
        float scale = 0.2f;
        CamPoint p1 = new CamPoint(p00.x - scale, p00.y, p00.z, p00.rotationYaw, p00.rotationPitch, p00.roll, p00.zoom);
        CamPoint p2 = new CamPoint(p00.x + scale, p00.y, p00.z, p00.rotationYaw, p00.rotationPitch, p00.roll, p00.zoom);
        CamPoint p3 = new CamPoint(p00.x - scale * 0.6f, p00.y - scale , p00.z, p00.rotationYaw, p00.rotationPitch, p00.roll, p00.zoom);
        CamPoint p4 = new CamPoint(p00.x + scale * 0.6f, p00.y - scale , p00.z, p00.rotationYaw, p00.rotationPitch, p00.roll, p00.zoom);
        CamPoint p5 = new CamPoint(p00.x , p00.y + scale * 0.6f, p00.z, p00.rotationYaw, p00.rotationPitch, p00.roll, p00.zoom);

        try {
            CamScene path = new CamScene(nbt);
            path.points.clear();
            path.points.add(p1);
            path.points.add(p2);
            path.points.add(p3);
            path.points.add(p4);
            path.points.add(p5);
            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        if(player != null) {
            player.sendSystemMessage(Component.literal(nbt.toString()));
        }


    }

    /*
    void ChangeEntityDirection(Player player){
        Player p = context.getPlayer();
        ForwardScene(p);
        BlockPos bp = context.getClickedPos();
        AABB aabb = new AABB(bp);
        List<TheZombieEntity> plants = world.getEntitiesOfClass(TheZombieEntity.class, aabb);
        if(!plants.isEmpty()) {
            for (int i = 0; i < plants.size(); i++) {
                TheZombieEntity z = plants.get(i);
                if(z instanceof NormalZombieEntity nz){
                    nz.towards += 90;
                    if(nz.towards >= 360){
                        nz.towards = 0;
                    }
                }
            }
        }
    }
    */
    int cool_down = 20;
    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {

        if(this.cool_down > 0){
            this.cool_down -= 1;
        }
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        //FiveStarScene(player);
        //ForwardScene(player);
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack item, Player player, LivingEntity entity, InteractionHand hand) {
        //TrackMove(player, entity);
        //ForwardScene(player);
        //TalkMove(player, entity);
        return super.interactLivingEntity(item, player, entity, hand);
    }

    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        CutDownTree(context.getLevel(), context.getPlayer(), context.getClickedPos());
        //TrackMove(context.getLevel(), context.getPlayer(), context.getClickedPos());
        return InteractionResult.sidedSuccess(world.isClientSide);

    }



    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {


            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400), player);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    // 追踪物体运动
    // 首先让这个物体运动
    // 然后摄像机追踪他
    // 只有 x 轴运动
    void TrackMove(Player player, Entity entity){
        player.sendSystemMessage(Component.literal("hey2"));
        if(entity instanceof NormalZombieEntity nz){
            nz.delta_movement = new Vec3(0,0,0.08f);
            CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
            nbt.putLong("duration", 6000L);
            try {
                player.sendSystemMessage(Component.literal("hey"));
                CamScene path = new CamScene(nbt);
                CamPoint p1 = CamPoint.createLocal();
                CamPoint p2 = moveForward(p1, -5.0);
                CamPoint p3 = new CamPoint(p2.x, p2.y, p2.z + 10.0f, p2.rotationYaw, p2.rotationPitch, p2.roll, p2.zoom);
                path.points.clear();
                path.points.add(p2);
                path.points.add(p3);
                CMDCamClient.start(path);
            } catch (RegistryException e) {
                throw new RuntimeException(e);
            }
        }
    }
    // talk scene
    // 1. turn enetity into talk animation
    // 2. five star animation


    // https://youtu.be/zbl6YBFHSJ0?t=588 多种不同的对话形式

    // https://youtu.be/zbl6YBFHSJ0?t=902
    // 单独打斗场景，互相撞

    // 多人打斗场景，追逐

    // 群聚效果，做个三个左右就可以了 https://youtu.be/zbl6YBFHSJ0?t=869，主角看着敌人中心的圆，左右移动

    // https://youtu.be/zbl6YBFHSJ0?t=907 从左从右，主视角

    // https://youtu.be/zbl6YBFHSJ0?t=905 这个可以在ffmpeg 1 分钟之内剪辑完成，视频长度不变, 或者都是6秒左右，固定的格式，或者不固定也行

    // 最难受的是怎么

    Entity talkEntity = null;
    Entity myEntity = null;

    void TalkMove(Level world, Player player, BlockPos bp){
        player.sendSystemMessage(Component.literal("cool" + player.getOnPos() + " and " + bp));
        NormalZombieEntity tz = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
        tz.setPos(bp.getX(), bp.getY() + 1, bp.getZ());
        tz.setYBodyRot(90);
        ;


        NormalZombieEntity tz2 = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
        tz2.setPos(bp.getX() - 5,bp.getY() + 1,bp.getZ() - 5);
        tz2.lookAt(tz, 3.0f, 3.0f);
        tz2.moveTo(tz.position(), tz2.position(), 200.0f);
        tz2.lookTo(tz.position());
        tz2.setYBodyRot(270);


        tz.lookTo(tz2.position());
        world.addFreshEntity(tz);
        world.addFreshEntity(tz2);

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 40000L);
        try {
            player.sendSystemMessage(Component.literal("hey"));
            CamScene path = new CamScene(nbt);
            // yaw 0 正Z
            // yaw 270 正X

            path.points.clear();
            path.points.add(new CamPoint(tz2.position().x - 1, tz2.position().y + 2, tz2.position().z - 2, 270, 30, 0, 70));
            path.points.add(new CamPoint(tz2.position().x + 0, tz2.position().y + 2, tz2.position().z + 1, 250, 30, 0, 70));
            path.points.add(new CamPoint(tz2.position().x + 1, tz2.position().y + 2, tz2.position().z + 4, 230, 30, 0, 70));
            path.points.add(new CamPoint(tz2.position().x + 2, tz2.position().y + 2, tz2.position().z + 6, 210, 30, 0, 70));
            path.points.add(new CamPoint(tz2.position().x + 3, tz2.position().y + 2, tz2.position().z + 5, 190, 30, 0, 70));

            float scale = 0.2f;
            float yaw = 310;
            float pitch = 30;

            Vec3 pp = new Vec3(tz.position().x - 1.4, tz.position().y + 2, tz.position().z - 1.4);
            path.points.add(new CamPoint(pp.x , pp.y , pp.z - scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y, pp.z + scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x, pp.y - scale, pp.z- scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y - scale, pp.z + scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y  + scale * 0.6f, pp.z , yaw, pitch, 0, 70));

            yaw = 280;
            pp = new Vec3(tz.position().x - 2.8, tz.position().y + 2, tz.position().z - 1.7);
            path.points.add(new CamPoint(pp.x , pp.y , pp.z - scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y, pp.z + scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x, pp.y - scale, pp.z- scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y - scale, pp.z + scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y  + scale * 0.6f, pp.z , yaw, pitch, 0, 70));

            pp = new Vec3(tz.position().x - 0.6, tz.position().y + 2, tz.position().z - 0.6);
            yaw = 130;
            path.points.add(new CamPoint(pp.x , pp.y , pp.z - scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y, pp.z + scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x, pp.y - scale, pp.z- scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y - scale, pp.z + scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y  + scale * 0.6f, pp.z , yaw, pitch, 0, 70));
            // 1.4 +- 0.6
            pp = new Vec3(tz.position().x - 0.1 , tz.position().y + 2, tz.position().z + 1.3);
            yaw = 150;
            path.points.add(new CamPoint(pp.x , pp.y , pp.z - scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y, pp.z + scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x, pp.y - scale, pp.z- scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y - scale, pp.z + scale * 0.6f, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pp.x , pp.y  + scale * 0.6f, pp.z , yaw, pitch, 0, 70));

            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
    }

    // 第一天从天上掉下来
    void FallFromSky(Level world, Player player, BlockPos bp){
        NormalZombieEntity entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
        entity.setPos(bp.getX(), bp.getY() + 3, bp.getZ());
        entity.setDeltaMovement(0,0,0);
        entity.setYBodyRot(-45);
        world.addFreshEntity(entity);

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 8000L);
        try {
            player.sendSystemMessage(Component.literal("hey"));
            CamScene path = new CamScene(nbt);
            // yaw 0 正Z
            // yaw 270 正X

            Vec3 pos = new Vec3(bp.getX() + 2, bp.getY() + 2, bp.getZ() + 2);
            float yaw = 135;
            float pitch = 0;
            float scale = 0.2f;
            float scale2 = 0.6f;

            path.points.clear();
            path.points.add(new CamPoint(pos.x - scale, pos.y, pos.z + scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pos.x + scale, pos.y, pos.z - scale, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pos.x - scale * scale2, pos.y - scale, pos.z + scale * scale2, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pos.x + scale * scale2, pos.y - scale, pos.z - scale * scale2, yaw, pitch, 0, 70));
            path.points.add(new CamPoint(pos.x , pos.y + scale * scale2, pos.z , yaw, pitch, 0, 70));

            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        // explore
    }

    void WalkMove(Level world, Player player, BlockPos bp){
        NormalZombieEntity entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
        entity.setPos(bp.getX(), bp.getY() + 1, bp.getZ());
        Vec3 target = new Vec3(bp.getX() + 24, bp.getY() + 1, bp.getZ());
        entity.moveTo(target, entity.position(), 240);
        entity.lookTo(target);
        world.addFreshEntity(entity);

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 8000L);
        try {
            CamScene path = new CamScene(nbt);
            // yaw 0 正Z
            // yaw 270 正X

            Vec3 pos = new Vec3(bp.getX() + 2, bp.getY() + 3, bp.getZ() + 4);
            float yaw = 180;
            float yawRange = 30;
            float pitch = 20;

            path.points.clear();
            path.points.add(new CamPoint(pos.x + 6, pos.y, pos.z , yaw - yawRange, pitch, 0, 70));
            path.points.add(new CamPoint(pos.x + 9 , pos.y , pos.z , yaw + yawRange * 2, pitch, 0, 70));

            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        // explore
    }

    // 通常用于一个Boss站在某处，然后旋转
    void RotateView(Level world, Player player, BlockPos bp){
        NormalZombieEntity entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
        entity.setPos(bp.getX(), bp.getY() + 1, bp.getZ());
        Vec3 target = new Vec3(bp.getX() - 0.1, bp.getY() + 1, bp.getZ() - 2);
        entity.lookTo(target);
        world.addFreshEntity(entity);

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 8000L);
        try {
            CamScene path = new CamScene(nbt);
            // yaw 0 正Z
            // yaw 270 正X

            Vec3 pos = new Vec3(bp.getX() - 6, bp.getY() + 2, bp.getZ() - 6);
            Vec3 target_pos = entity.position();
            Vec3 the_pos = pos;
            double yaw = Math.atan2(target_pos.y - pos.y, target_pos.x - pos.x);
            float yawRange = 30;
            float pitch = 20;

            path.points.clear();

            path.points.add(new CamPoint(pos.x, pos.y, pos.z , yaw , pitch, 0, 70));
            the_pos = new Vec3(pos.x + 4, pos.y, pos.z + 1);
            yaw = Math.atan2(target_pos.y - the_pos.y, target_pos.x - the_pos.x);
            path.points.add(new CamPoint(the_pos.x, the_pos.y, the_pos.z, yaw, pitch, 0, 70));

            the_pos = new Vec3(pos.x + 5, pos.y, pos.z + 2);
            yaw = Math.atan2(target_pos.y - the_pos.y, target_pos.x - the_pos.x);
            path.points.add(new CamPoint(the_pos.x, the_pos.y, the_pos.z, yaw, pitch, 10, 70));

            the_pos = new Vec3(pos.x + 6, pos.y + 1, pos.z + 4);
            yaw = Math.atan2(target_pos.y - the_pos.y, target_pos.x - the_pos.x);
            path.points.add(new CamPoint(the_pos.x, the_pos.y, the_pos.z, yaw, pitch, 20, 70));

            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        // explore
    }

    // 生成随机游走的
    void SpawnMany(Level world, Player player, BlockPos bp){
        Random random = new Random();
        double spawnRange = 24.0f;
        double timeRange = 48.0f;

        // 生成一个0到1之间的随机浮点数
        for(int i = 0; i <= 16; i++){

            double px = random.nextDouble();
            double pz = random.nextDouble();
            double tx = random.nextDouble();
            double tz = random.nextDouble();
            double t = random.nextDouble();
            NormalZombieEntity entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
            entity.setPos(bp.getX() + (px - 0.5f) * spawnRange, bp.getY() + 1, bp.getZ() + (pz - 0.5f) * spawnRange);
            Vec3 target = new Vec3(bp.getX() + (tx - 0.5f) * spawnRange, bp.getY() + 1, bp.getZ() + (tz - 0.5f) * spawnRange);
            entity.moveTo(target, entity.position(), (float) ((0.1f + t * 0.9f) * timeRange * 20));
            entity.lookTo(target);
            world.addFreshEntity(entity);
        }
    }

    // 我被追到角落 https://youtu.be/Ra3SpxTnhMM?t=47

    // 突然有人出现在我的面前

    // 科学家这个 https://youtu.be/Ra3SpxTnhMM?t=116

    // 小门追逐战 https://youtu.be/Ra3SpxTnhMM?t=149

    // 追逐踪迹 https://youtu.be/Ra3SpxTnhMM?t=168

    // footstep https://youtu.be/Ra3SpxTnhMM?t=230

    // 追逐逃离站 https://youtu.be/Ra3SpxTnhMM?t=247

    // 看到敌人，被敌人发现，敌人说话，然后尝试逃离 https://youtu.be/Xuc5si-b-PI?t=64 不知道地形咋做

    // 远景走路 https://youtu.be/Xuc5si-b-PI?t=140
    void FarViewMove(Level world, Player player, BlockPos bp){
        player.setYBodyRot(90);
        /*
        NormalZombieEntity entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), world);
        entity.setPos(bp.getX(), bp.getY() + 1, bp.getZ());
        Vec3 target = new Vec3(bp.getX() + 40, bp.getY(), bp.getZ());
        entity.moveTo2(target,2);
        world.addFreshEntity(entity);
        for(int i = 0; i < 20; i++){

        }

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 8000L);
        try {
            CamScene path = new CamScene(nbt);
            // yaw 0 正Z
            // yaw 270 正X

            Vec3 pos = new Vec3(bp.getX() + 5 , bp.getY() + 5, bp.getZ() + 2);
            float yaw = 90;
            float yawRange = 30;
            float pitch = 40;

            path.points.clear();
            path.points.add(new CamPoint(pos.x, pos.y , pos.z , yaw + yawRange, pitch, 0, 70));
            path.points.add(new CamPoint(pos.x + 20 , pos.y + 2, pos.z + 2, yaw + yawRange * 2, pitch, 0, 70));

            //CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        */
        // explore
    }

    void CutDownTree(Level world, Player player, BlockPos bp){

        GardenRakeEntity entity = new GardenRakeEntity(ModEntityTypes.GARDEN_RAKE.get(), world);
        entity.setPos(bp.getX() + 2, bp.getY() + 1, bp.getZ());
        world.addFreshEntity(entity);

        for(int i = 0; i < 4;i++){
            BlockPos nbp = new BlockPos(bp.getX() + 1, bp.getY() + 1 + i, bp.getZ());
            world.setBlock(nbp, Blocks.OAK_WOOD.defaultBlockState(), 1);
        }
        for(int i = -1;i <= 1; i++){
            for(int j = -1;j <= 1;j++){
                for(int k = -1; k <= 1;k++){

                    BlockPos nbp = new BlockPos(bp.getX() + 1 + i, bp.getY() + 6 + j, bp.getZ() + k);
                    world.setBlock(nbp, Blocks.OAK_LEAVES.defaultBlockState(), 1);
                }
            }
        }

        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", 8000L);
        try {
            CamScene path = new CamScene(nbt);
            // yaw 0 正Z
            // yaw 270 正X

            Vec3 pos = new Vec3(bp.getX() - 2 , bp.getY() + 2, bp.getZ());
            float yaw = 90;
            float pitch = 40;

            path.points.clear();
            path.points.add(new CamPoint(pos.x, pos.y , pos.z , yaw , 30, 0, 70));
            path.points.add(new CamPoint(pos.x + 20 , pos.y + 2, pos.z + 2, yaw , pitch, -30, 70));

            //CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }
        // explore
    }
}
