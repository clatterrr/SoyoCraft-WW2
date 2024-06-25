package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.*;
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
import org.checkerframework.checker.units.qual.A;
import team.creative.cmdcam.common.math.point.CamPoint;
import team.creative.cmdcam.common.scene.CamScene;
import team.creative.cmdcam.client.CMDCamClient;
import team.creative.creativecore.common.util.math.vec.Vec3d;
import team.creative.creativecore.common.util.registry.exception.RegistryException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

enum CameraMovementEnum{
    STATIC,
    FOLLOW,
    CUSTOM,
}
class ActorInfo {
    public String name;


    public String anim;
    public Vec3 startPos;
    public Vec3 endPos;
    public Vec3 startLook;
    public Vec3 endLook;

    public ActorInfo(String name, String anim, Vec3 startPos, Vec3 endPos, Vec3 startLook, Vec3 endLook) {
        this.name = name;
        this.anim = anim;
        this.startPos = startPos;
        this.endPos = endPos;
        this.startLook = startLook;
        this.endLook = endLook;
    }

}

class SceneInfo {
    public Vector<ActorInfo> actorInfos;
    public int frameStart;
    public int frameEnd;

    public SceneInfo(int frameStart, int frameEnd) {
        this.actorInfos = new Vector<ActorInfo>();
        this.frameStart = frameStart;
        this.frameEnd = frameEnd;
    }
}
class CameraMovement {
    // Fields
    public CameraMovementEnum movement;
    public Vec3 startPos;
    public Vec3 endPos;

    public Vec3 startLookAt;

    public Vec3 endLookAt;


    public CameraMovement(CameraMovementEnum movement, Vec3 startPos, Vec3 endPos, Vec3 startLookAt, Vec3 endLookAt) {
        this.movement = movement;
        this.startPos = startPos;
        this.endPos = endPos;
        this.startLookAt = startLookAt;
        this.endLookAt = endLookAt;
    }

}
public class SliverCoinItem extends Item {

    public SliverCoinItem(Properties p_41383_) {
        super(p_41383_);
    }

    public Vector<Entity> globalActors = new Vector<Entity>();
    public Vector<String> globalActorsName = new Vector<String>();
    public Vector<Vec3> globalPos = new Vector<Vec3>();
    private Vector<SceneInfo> sceneInfos = new Vector<SceneInfo>();
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
    public int usedTime = 0;


    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();

        this.sceneInfos = new Vector<SceneInfo>();
        String filePath = "D:/walk2.txt";
        SceneInfo sceneInfo = new SceneInfo(0, 100);
        this.sceneInfos.clear();
        this.globalActors.clear();
        this.globalActorsName.clear();
        this.globalPos.clear();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Vec3> vectors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 逐行读取文件内容
            while ((line = br.readLine()) != null) {

            // Regular expression to match parts of the string
            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(line);

            // Lists to store the extracted parts

                // Extract and process the matches
                while (matcher.find()) {
                    String match = matcher.group(1).trim();
                    if (match.matches(".*\\d+.*")) { // Check if the match contains numbers
                        // Process as a vector
                        String[] parts = match.split(",");
                        if(parts.length == 3){
                            float vx = Float.parseFloat(parts[0].trim());
                            float vy = Float.parseFloat(parts[1].trim());
                            float vz = Float.parseFloat(parts[2].trim());
                            Vec3 vector = new Vec3(vx, vy, vz);
                            vectors.add(vector);
                            if(vectors.size() == 4){

                                sceneInfo.actorInfos.add(new ActorInfo(strings.get(0), strings.get(1), vectors.get(0), vectors.get(1), vectors.get(2), vectors.get(3)));
                                 // System.out.println("parts " + strings.get(0) + " " + vectors.get(0) + " " + vectors.get(1) + " " + vectors.get(2) + " " + vectors.get(3));
                                if(strings.get(0).equals("cameraf")){
                                    int start = 0;
                                    int end = 100;
                                    sceneInfo.frameStart = start;
                                    sceneInfo.frameEnd = end;
                                    this.sceneInfos.add(sceneInfo);
                                    sceneInfo = new SceneInfo(0, 100);
                                }


                                strings.clear();
                                vectors.clear();
                            }
                        }

                    } else {
                        // Process as a string
                        strings.add(match);
                        vectors.clear();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BlockPos bp = context.getPlayer().getOnPos();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable[] tasks = new Runnable[this.sceneInfos.size()];
        for(int info_index = 0; info_index < this.sceneInfos.size(); info_index++){
            SceneInfo info = this.sceneInfos.get(info_index);
            tasks[info_index] = new Runnable() {
                @Override
                public void run() {
                    TrackMoveSpeedGroup(bp, context.getLevel(), info.actorInfos, 5000);

                }
            };
        }

        // 遍历任务数组并调度它们
        for (int i = 0; i < tasks.length; i++) {
            int delay = i * 5;  // 计算延迟时间
            scheduler.schedule(tasks[i], delay, TimeUnit.SECONDS);
        }

        // 关闭调度器，防止新的任务提交。当前任务会继续执行
        scheduler.shutdown();
        return InteractionResult.sidedSuccess(world.isClientSide);

    }
    Vec3 ComputeRotation(Vec3 direction){
        return new Vec3(0,0,0);
    }

    void TrackMoveSpeedGroup(BlockPos bp, Level level, Vector<ActorInfo> entities, long duration){

        System.out.println(" entities " + entities.size());

        for(int i = 0; i < this.globalActors.size(); i++){
            this.globalActors.get(i).remove(Entity.RemovalReason.DISCARDED);
        }
        this.globalActors.clear();

        for(int i = 0; i < entities.size(); i++){
            if(entities.get(i).name.equals("camera")){
                break;
            }
            Vec3 endPos = entities.get(i).endPos;

            Entity entity;
            if(entities.get(i).name.equals("tiger"))
            {
                entity = new EnemyzombieEntity(ModEntityTypes.ENEMYZOMBIE.get(), level);
            }else{
                entity = new TheplayerEntity(ModEntityTypes.THEPLAYER.get(), level);

            }
            Vec3 startPos = entities.get(i).startPos;
            entity.setPos(new Vec3(bp.getX() + startPos.x, bp.getY() + startPos.y, bp.getZ() + startPos.z));
            float dt = duration / 10;
            Vec3 speed = new Vec3((endPos.x - startPos.x) / dt, (endPos.y - startPos.y) / dt, (endPos.z - startPos.z) / dt);
            Vec3 look = entities.get(i).startLook;
            Vec3 lookat = new Vec3(bp.getX() + look.x, bp.getY() + look.y, bp.getZ() + look.z);
            if(entity instanceof EnemyzombieEntity zombie){
                zombie.SetDeltaMove(speed);
                zombie.SetLookAt(lookat);
                zombie.SetAnimation(entities.get(i).anim);
            }
            if(entity instanceof TheplayerEntity player1){
                player1.SetDeltaMove(speed);
                player1.SetLookAt(lookat);
                player1.SetAnimation(entities.get(i).anim);

            }
            this.globalActors.add(entity);
            level.addFreshEntity(this.globalActors.lastElement());

        }


        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", duration);
        try {
            //player.sendSystemMessage(Component.literal("hey"));
            CamScene path = new CamScene(nbt);
            path.points.clear();
            for(int i = 0; i < entities.size();i++){
                System.out.println(" camera = " + entities.get(i).name);
                if(entities.get(i).name.equals("camera") || entities.get(i).name.equals("cameraf")){
                    ActorInfo c = entities.get(i);
                    CamPoint p1 = new CamPoint(bp.getX() + c.startPos.x, bp.getY() + c.startPos.y + 1, bp.getZ() + c.startPos.z, c.startLook.x, c.startLook.y, c.startLook.z, 70);
                    path.points.add(p1);
                }
            }
            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }

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


}
