import re
file_path = 'D://look.txt'

# 初始化一个列表来存储解析的坐标值
armature_pos = []

head_rot = []
neck_rot = [] # static
left_upper_arm_rot = []
left_lower_arm_rot = []
right_upper_arm_rot = []
right_lower_arm_rot = []
spine_rot = []
left_upper_leg_rot = []
left_lower_leg_rot = []
right_upper_leg_rot = []
right_lower_leg_rot = []
temp_rot = []
time_rec = []

time_value = 0.0
# 打开文件并逐行读取
with open(file_path, 'r') as file:
    reading_positions = False
    
    for line in file:
        # 检查是否找到 "m_PositionCurves"
        if "m_RotationCurves:" in line:
            reading_positions = True
            continue  # 跳过当前行，从下一行开始记录
            
        if "spine.001\n" in line and reading_positions:
            spine_rot = temp_rot
        
        if "neck.001\n" in line and reading_positions:
            neck_rot = temp_rot
            
        if "head.001\n" in line and reading_positions:
            head_rot = temp_rot
        
        if "upperarm.001.L\n" in line and reading_positions:
            left_upper_arm_rot = temp_rot
        
        if "lowerarm.001.L\n" in line and reading_positions:
            left_lower_arm_rot = temp_rot
            
        if "upperarm.001.R\n" in line and reading_positions:
            right_upper_arm_rot = temp_rot
            
        if "lowerarm.001.R\n" in line and reading_positions:
            right_lower_arm_rot = temp_rot
        
        if "upperleg.001.L\n" in line and reading_positions:
            left_upper_leg_rot = temp_rot
            
        if "lowerleg.001.L\n" in line and reading_positions:
            left_lower_leg_rot = temp_rot
            
        if "upperleg.001.R\n" in line and reading_positions:
            right_upper_leg_rot = temp_rot
        
        if "lowerleg.001.R\n" in line and reading_positions:
            right_lower_leg_rot = temp_rot
            
        if "m_Curve" in line and reading_positions:
            temp_rot = []
            time_value = 0.0
        
        # 如果已经开始记录，并且行包含value的格式
        if reading_positions:
            
            if "time:" in line:
                pattern = r"time: (\d+\.\d+)"

                match = re.search(pattern, line)
                if match:
                    time_value = float(match.group(1))  # 将匹配的字符串转换为浮点数
                
            # 使用正则表达式匹配x, y, z值
            pattern = r'value:\s*\{\s*x:\s*([-\d.]+),\s*y:\s*([-\d.]+),\s*z:\s*([-\d.]+),\s*w:\s*([-\d.]+)\s*\}'

            # 使用 re.search 查找匹配项
            match = re.search(pattern, line)

            # match = re.search(r'value: {\s*x: ([-\d.]+),\s*y: ([-\d.]+),\s*z: ([-\d.]+)}', line)
            if match:
                # 解析x, y, z值
                x, y, z, w= match.groups()
                temp_rot.append((float(x), float(y), float(z), float(w), time_value))
                
import math

def quaternion_to_euler(w, x, y, z):
    # 滚动 (roll)
    roll = math.atan2(2 * (w * x + y * z), 1 - 2 * (x * x + y * y))
    
    # 俯仰 (pitch)
    pitch = math.asin(2 * (w * y - z * x))
    
    # 航向 (yaw)
    yaw = math.atan2(2 * (w * z + x * y), 1 - 2 * (y * y + z * z))
    
    return yaw / 3.14 * 180, pitch / 3.14 * 180, roll / 3.14 * 180

animation_str = '''
{
	"format_version": "1.8.0",
	"animations": {
		"animation.youtube.idle": {
			"loop": true
		},
		"animation.youtube.walk": {
			"animation_length": 2,
            "bones": {
'''

animation_str += '''
    "LeftLeg": {
    	"rotation": {
'''

for v in spine_rot:
    z, y, x = quaternion_to_euler(v[3], v[0], v[1], v[2])
    
    the_str = "\"" + str(v[4]) + "\": { \n \"vector\": [" + str(x) + "," + str(y) + "," + str(z) + "]\n},\n"
    
    animation_str += the_str
print(animation_str)


    
    
    