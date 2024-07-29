# generate body

import random

# 生成一个0到100之间的随机整数

def r(p0, p1):
    return random.randint(p0, p1)

def ratio100(value, r0, r1):
    return int(value * r(r0, r1) / 100.0) 

class Model:
    def __init__(self, origin, size, uv):
        self.origin = origin
        self.size = size
        self.uv = uv
        
    def set_offset(self, offset):
        temp = self
        temp.origin[0] += offset[0]
        temp.origin[1] += offset[1]
        temp.origin[2] += offset[2]
        return temp
    
    def pack(self):
        word = "{\"origin\": [_ox,_oy,_oz], \"size\": [_px, _py, _pz], \"uv\": [_uvx, _uvy]},\n"
        word = word.replace("_ox", str(self.origin[0]))
        word = word.replace("_oy", str(self.origin[1]))
        word = word.replace("_oz", str(self.origin[2]))
        word = word.replace("_px", str(self.size[0]))
        word = word.replace("_py", str(self.size[1]))
        word = word.replace("_pz", str(self.size[2]))
        word = word.replace("_uvx", str(self.uv[0]))
        word = word.replace("_uvy", str(self.uv[1]))
        return word

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

# 假设你的文件名为 'data.json'
filename = 'C:\\Users\\16143\\Desktop\\goes\\dragon_legs_2.json'

content = []

import re
import copy
# 打开文件
with open(filename, 'r') as file:
    # 逐行读取文件
    for line in file:
        # 检查行中是否包含 "origin"
        if 'origin' in line:
            
            # 使用正则表达式查找所有数字，包括负数和可能的前导零
            numbers = re.findall(r'-?\d+', line)
            
            # 将字符串形式的数字转换为整数
            # 注意：这里我们不使用float，因为字符串中的数字没有小数点
            n = [int(num) for num in numbers]
            content.append(Model([n[0], n[1], n[2]], [n[3], n[4], n[5]], [n[6], n[7]]))

single = ""
for c in content:
    leg1 = copy.copy(c)
    leg1.origin[0] += -bx
    
    leg1.origin[1] += -4
    single += leg1.pack()
    
    leg3 = copy.copy(c)
    leg3.origin[2] += -10
    single += leg3.pack()
    
    leg2 = copy.copy(c)
    leg2.origin[0] += bx * 3
    single += leg2.pack()
    
    leg4 = copy.copy(c)
    leg4.origin[2] += 10
    single += leg4.pack()
single += body.word() 

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