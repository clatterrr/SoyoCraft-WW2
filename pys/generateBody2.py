# generate body

import random
import re
import copy
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
    
    def minmax(self, themin, themax):
        if self.origin[0] < themin[0]:
            themin[0] = self.origin[0]
        if self.origin[1] < themin[1]:
            themin[1] = self.origin[1]
        if self.origin[2] < themin[2]:
            themin[2] = self.origin[2]
            
        if self.origin[0] + self.size[0] > themax[0]:
            themax[0] = self.origin[0] + self.size[0]
        if self.origin[1] + self.size[0] > themax[1]:
            themax[1] = self.origin[1] + self.size[1]
        if self.origin[2] + self.size[2] > themax[2]:
            themax[2] = self.origin[2] + self.size[2]
            
    def pack_offset(self, offset):
        word = "{\"origin\": [_ox,_oy,_oz], \"size\": [_px, _py, _pz], \"uv\": [_uvx, _uvy]},\n"
        word = word.replace("_ox", str(self.origin[0] + offset[0]))
        word = word.replace("_oy", str(self.origin[1] + offset[1]))
        word = word.replace("_oz", str(self.origin[2] + offset[2]))
        word = word.replace("_px", str(self.size[0]))
        word = word.replace("_py", str(self.size[1]))
        word = word.replace("_pz", str(self.size[2]))
        word = word.replace("_uvx", str(self.uv[0]))
        word = word.replace("_uvy", str(self.uv[1]))
        return word
            
    def pack_reverse_x(self, offset):
        return self.pack_offset([-self.origin[0] - self.origin[0] - self.size[0] + offset[0], offset[1], offset[2]])

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
        

def get_content(file_name):
    file_name = 'C:\\Users\\16143\\Desktop\\goes\\' + file_name

    content = []
    
    # 打开文件
    with open(file_name, 'r') as file:
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
                
    return content
                
def finish(name, word):
    
    part_pre = '''
                {
    					"name": "_name",
    					"pivot": [0, 2, 0],
    					"cubes": [
    '''
    part_pre = part_pre.replace("_name", name)
    
    
    part_post = '''
                                ]
                },'''
    word = re.sub(',[ \t]*$', '', word)
    return part_pre + word + part_post


# 假设你的文件名为 'data.json'
leg_content = get_content('dragon_legs_2.json')
leg_word = ""
for c in leg_content:
    leg_word += c.pack_offset([-bx, -8, 4])
    leg_word += c.pack_offset([bx*2, -8, 4])
    leg_word += c.pack_offset([-bx, -8, -8])
    leg_word += c.pack_offset([bx*2, -8, -8])
    
tail_content = get_content('tail_1.json')
tail_word = ""
for c in tail_content:
    c.origin[2] += - int(body.size[2] / 2) - 15
    tail_word += c.pack()
    
neck_content = get_content('neck_1.json')
neck_word = ""
neck_min = [99,99,99]
neck_max = [0,0,0]
for c in neck_content:
    c.origin[1] += body.cen[1]
    c.origin[2] += int(body.size[2] / 2)
    c.minmax(neck_min, neck_max)
    neck_word += c.pack()
    
head_content = get_content('head_1.json')
head_word = ""
for c in head_content:
    c.origin[1] += neck_max[1]
    c.origin[2] += neck_max[2]
    head_word += c.pack()
    
wing_content = get_content('wing_1.json')
wing_word = ""
for c in wing_content:
    wing_word += c.pack_offset([-int(body.size[0] / 2), body.cen[1], 0])
    wing_word += c.pack_reverse_x([int(body.size[0] / 2), body.cen[1], 0])
    
single = finish("leg",leg_word) +  finish("tail",tail_word) +  finish("neck",neck_word) + finish("head",head_word) + finish("wing",wing_word) # + body.word() 


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
single = re.sub(',[ \t]*$', '', single)
all_text = pre_text + single + post_text

# 打开文件，'w'模式会覆盖原有内容
with open("C:\\Users\\16143\\Desktop\\model.geo.json", 'w') as file:
    file.write(all_text)  # 将字符串写入文件