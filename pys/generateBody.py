# generate body

import random

# 生成一个0到100之间的随机整数

def r(p0, p1):
    return random.randint(p0, p1)

def ratio100(value, r0, r1):
    return int(value * r(r0, r1) / 100.0) 

class Part:
    def __init__(self, origin, size):
        self.origin = origin
        self.size = size
        self.min = origin
        self.cen = [origin[0] + int(size[0]/2), origin[1] + int(size[1]/2), origin[2] + int(size[2]/2)]
        self.max = [origin[0] + size[0], origin[1] + size[1], origin[2] + size[2]]
        

    def word(self):
        word = "{\"origin\": [_ox,_oy,_oz], \"size\": [_px, _py, _pz], \"uv\": [0, 42]}"
        word = word.replace("_ox", str(self.origin[0]))
        word = word.replace("_oy", str(self.origin[1]))
        word = word.replace("_oz", str(self.origin[2]))
        word = word.replace("_px", str(self.size[0]))
        word = word.replace("_py", str(self.size[1]))
        word = word.replace("_pz", str(self.size[2]))
        return word


bx = r(4,5)
bz = r(10,14)
body_origin = [-bx, 0, -bz]
body_size = [bx * 2, r(5,6), bz * 2]
body = Part(body_origin, body_size)



wing_word = ""
wz = ratio100(bz, 120, 160)
for x in range(40):
    result_y = int(wz - 0.5 * x)
    if result_y == 0:
        break
    wing_size = [1,1,result_y]
    wing_origin = [bx + x, body.cen[1],  body.max[2] - wing_size[2]]
    wing1 = Part(wing_origin, wing_size)
    wing_origin = [-bx - x, body.cen[1],  body.max[2] - wing_size[2]]
    wing2 = Part(wing_origin, wing_size)
    wing_word += wing1.word() + ",\n" + wing2.word() + ",\n"

tail_word = ""
tail_size_x = r(1,2)
tail_size_z = r(4,5)
total_z = 0
for x in range(5):
    tail_size = [tail_size_x * 2,tail_size_x*2,tail_size_z]
    total_z += tail_size[2]
    tail_origin = [-tail_size_x, body.cen[1] - tail_size_x, -bz - total_z]
    tail = Part(tail_origin, tail_size)
    tail_word += tail.word() + ",\n"
    

leg_word = ""


leg_size = [r(3,4), r(5,8), r(3,4)]
min_y = body.min[1]  + 2
for x in range(2):
    
    leg_origin = [body.max[0] , min_y - leg_size[1] , body.max[2] - leg_size[2] * 2]
    leg1 = Part(leg_origin, leg_size)
    leg_origin = [body.min[0] - leg_size[0], min_y - leg_size[1], body.max[2] - leg_size[2] * 2]
    leg2 = Part(leg_origin, leg_size)
    leg_origin = [body.max[0] , min_y - leg_size[1], body.min[2] + leg_size[2]]
    leg3 = Part(leg_origin, leg_size)
    leg_origin = [body.min[0] - leg_size[0] , min_y - leg_size[1], body.min[2] + leg_size[2]]
    leg4 = Part(leg_origin, leg_size)

    min_y = leg1.min[1]
    leg_word += leg1.word() + ",\n" + leg2.word() + ",\n" + leg3.word() + ",\n" + leg4.word() + ",\n"

neck_word = ""
neck_size_x = 1
neck_size_z = 2
total_z = 0
for x in range(5):
    neck_size = [neck_size_x * 2,neck_size_x*2,neck_size_z]
    neck_origin = [-neck_size_x, body.cen[1] - neck_size_x, bz + total_z]
    total_z += neck_size[2]
    neck = Part(neck_origin, neck_size)
    neck_word += neck.word() + ",\n"
    
    
head_x = r(2,bx)
head_y = r(3,4)
head_size = [head_x * 2, head_y * 2, r(8,12)]
head_origin = [-head_x , neck.min[1] , bz + total_z]
head = Part(head_origin, head_size)

mouth_x = r(head_x-1,head_x)
mouth_z = r(4,5)
mouth_size = [mouth_x * 2, 2, mouth_z]
top_moutg_origin = [- mouth_x , head.min[1] + mouth_size[1] , head.max[2]]
top_mouth = Part(top_moutg_origin, mouth_size)
bot_moutg_origin = [- mouth_x , head.min[1] , head.max[2]]
bot_mouth = Part(bot_moutg_origin, mouth_size)

ear_size = [r(1,2), r(1,5), r(3,5)]
ear_ox = ratio100(head_x, 80,100)
ear_left_origin = [ear_ox - ear_size[0], head.max[1], head.max[2] - ear_size[2]]
ear_right_origin = [-ear_ox, head.max[1], head.max[2] - ear_size[2]]
ear_left = Part(ear_left_origin, ear_size)
ear_right = Part(ear_right_origin, ear_size)

single = body.word() + ",\n" + wing_word  + tail_word + neck_word + head.word() + ",\n"
single += leg_word + top_mouth.word() + ",\n" + bot_mouth.word() + ",\n" + ear_left.word() + ",\n" + ear_right.word() 

part_pre = '''
            {
					"name": "bone",
					"pivot": [0, 2, 0],
					"cubes": [
'''



part_post = '''
                            ]
            }

'''


pre_text = '''
{
	"format_version": "1.12.0",
	"minecraft:geometry": [
		{
			"description": {
				"identifier": "geometry.unknown",
				"texture_width": 16,
				"texture_height": 16,
				"visible_bounds_width": 2,
				"visible_bounds_height": 1.5,
				"visible_bounds_offset": [0, 0.25, 0]
			},
			"bones": [

'''

post_text = '''
            ]
		}
	]
}

'''

all_text = pre_text + part_pre + single + part_post + post_text

# 打开文件，'w'模式会覆盖原有内容
with open("C:\\Users\\16143\\Desktop\\model.geo.json", 'w') as file:
    file.write(all_text)  # 将字符串写入文件