package com.example.examplemod.item.custom;

import com.example.examplemod.entity.ModEntityTypes;
import com.example.examplemod.entity.custom.NormalZombieEntity;
import com.example.examplemod.entity.custom.GardenRakeEntity;
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
    public Vec3 startPos;
    public Vec3 endPos;
    public Vec3 startLook;
    public Vec3 endLook;

    public ActorInfo(String name, Vec3 startPos, Vec3 endPos, Vec3 startLook, Vec3 endLook) {
        this.name = name;
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

    public Vector<String> globalActors = new Vector<String>();
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


    public void ParseString(){
        String input = "[my mother] [was] [5, 0, 0] [5, 0, 0] [0,0,0] [0,0,0]";

        // Regular expression to match parts of the string
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(input);

        // Lists to store the extracted parts
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<int[]> vectors = new ArrayList<>();

        // Extract and process the matches
        while (matcher.find()) {
            String match = matcher.group(1).trim();
            if (match.matches(".*\\d+.*")) { // Check if the match contains numbers
                // Process as a vector
                String[] parts = match.split(",");
                int[] vector = new int[3];
                for (int i = 0; i < parts.length; i++) {
                    vector[i] = Integer.parseInt(parts[i].trim());
                }
                vectors.add(vector);
            } else {
                // Process as a string
                strings.add(match);
            }
        }

        // Output the results
        System.out.println("Strings:");
        for (String str : strings) {
            System.out.println(str);
        }

        System.out.println("Vectors:");
        for (int[] vector : vectors) {
            System.out.print("[");
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i]);
                if (i < vector.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
    public InteractionResult useOn(UseOnContext context) {
        //ParseString();

        Level world = context.getLevel();
        /*
        //CutDownTree(context.getLevel(), context.getPlayer(), context.getClickedPos());
        NormalZombieEntity zombie = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), context.getLevel());
        BlockPos bp = context.getPlayer().getOnPos();
        zombie.setPos(bp.getX(), bp.getY() + 1, bp.getZ());
        context.getLevel().addFreshEntity(zombie);
        TrackMove(context.getPlayer(), zombie);
*/
        this.sceneInfos = new Vector<SceneInfo>();
        String filePath = "D:/walk2.txt";
        SceneInfo sceneInfo = new SceneInfo(0, 100);
        this.sceneInfos.clear();
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

                                sceneInfo.actorInfos.add(new ActorInfo(strings.get(0), vectors.get(0), vectors.get(1), vectors.get(2), vectors.get(3)));
                                System.out.println("parts " + strings.get(0) + " " + vectors.get(0) + " " + vectors.get(1) + " " + vectors.get(2) + " " + vectors.get(3));
                                if(strings.get(0).equals("camera")){
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

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable[] tasks = new Runnable[this.sceneInfos.size()];
        /*
        for(int info_index = 0; info_index < this.sceneInfos.size(); info_index++){
            SceneInfo info = this.sceneInfos.get(0);
            ActorInfo actor = info.actorInfos.get(0);
            ActorInfo camera = info.actorInfos.get(info.actorInfos.size() - 1);
            Entity entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), context.getLevel());
            if(actor.name.equals("zombie")){
                entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), context.getLevel());
            }
            BlockPos bp = context.getPlayer().getOnPos();
            entity.setPos(new Vec3(bp.getX() + actor.startPos.x , bp.getY() + actor.startPos.y, bp.getZ() + actor.startPos.z));
            context.getLevel().addFreshEntity(entity);
            double dt = (double)(info.frameEnd - info.frameStart);
            Vec3 speed = new Vec3((actor.endPos.x - actor.startPos.x) / dt, (actor.endPos.y - actor.startPos.y) / dt, (actor.endPos.z - actor.startPos.z)/dt);

            Entity finalEntity = entity;
            tasks[info_index] = new Runnable() {
                @Override
                public void run() {
                    TrackMoveSpeed(context.getPlayer(), finalEntity, 5000, speed, camera.startPos, camera.endPos, camera.startLook, camera.endLook);

                }
            };


        }
        */
        for(int info_index = 0; info_index < 2; info_index++){
            SceneInfo info = this.sceneInfos.get(info_index);
            tasks[info_index] = new Runnable() {
                @Override
                public void run() {
                    TrackMoveSpeedGroup(context.getPlayer(), context.getLevel(), info.actorInfos, 5000);

                }
            };


        }

        // 遍历任务数组并调度它们
        for (int i = 0; i < tasks.length; i++) {
            int delay = (i + 1) * 7;  // 计算延迟时间
            scheduler.schedule(tasks[i], delay, TimeUnit.SECONDS);
        }

        // 关闭调度器，防止新的任务提交。当前任务会继续执行
        scheduler.shutdown();
        return InteractionResult.sidedSuccess(world.isClientSide);

    }
    Vec3 ComputeRotation(Vec3 direction){
        return new Vec3(0,0,0);
    }

    void TrackMoveSpeedGroup(Player player, Level level, Vector<ActorInfo> entities, long duration){

        System.out.println(" entities " + entities.size());
        // expect cameras

        for(int i = 0; i < entities.size() - 1; i++){
            Entity entity;
            entity = new NormalZombieEntity(ModEntityTypes.NORMAL_ZOMBIE.get(), level);
            BlockPos bp = player.getOnPos();
            Vec3 startPos = entities.get(i).startPos;
            entity.setPos(new Vec3(bp.getX() + startPos.x, bp.getY() + startPos.y, bp.getZ() + startPos.z));
            level.addFreshEntity(entity);
            System.out.println(" start pos " + startPos);
        }


        ActorInfo c = entities.get(entities.size() - 1);


        CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
        nbt.putLong("duration", duration);
        try {
            //player.sendSystemMessage(Component.literal("hey"));
            CamScene path = new CamScene(nbt);
            CamPoint p1 = new CamPoint(player.getX() + c.startPos.x, player.getY() + c.startPos.y, player.getZ() + c.startPos.z, c.startLook.x, c.startLook.y, c.startLook.z, 70);
            CamPoint p2 = new CamPoint(player.getX() + c.endPos.x, player.getY() + c.endPos.y, player.getZ() + c.endPos.z, c.endLook.x, c.endLook.y, c.endLook.z, 70);
            path.points.clear();
            path.points.add(p1);
            path.points.add(p2);
            CMDCamClient.start(path);
        } catch (RegistryException e) {
            throw new RuntimeException(e);
        }


    }
    void TrackMoveSpeed(Player player, Entity entity, long duration, Vec3 speed, Vec3 cameraStart, Vec3 cameraEnd, Vec3 rs, Vec3 re){

        if(entity instanceof NormalZombieEntity nz){
            //nz.setDmove(speed);
            CompoundTag nbt = CMDCamClient.getScene().save(new CompoundTag());
            nbt.putLong("duration", duration);
            try {
                //player.sendSystemMessage(Component.literal("hey"));
                CamScene path = new CamScene(nbt);

                CamPoint p1 = new CamPoint(player.getX() + cameraStart.x, player.getY() + cameraStart.y, player.getZ() + cameraStart.z,rs.x, rs.y, rs.z, 70);

                CamPoint p2 = new CamPoint(player.getX() + cameraEnd.x, player.getY() + cameraEnd.y, player.getZ() + cameraEnd.z , re.x, re.y, re.z, 70);
                path.points.clear();
                path.points.add(p1);
                path.points.add(p2);
                CMDCamClient.start(path);
            } catch (RegistryException e) {
                throw new RuntimeException(e);
            }
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
