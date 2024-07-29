import re

def extract_name_from_line(line):
    """
    Extract the name string from a line that contains 'name'.
    """
    pattern = re.compile(r'"name":\s*"([^"]*)"')
    match = pattern.search(line)
    if match:
        return match.group(1)
    return None

def extract_numbers_from_line(line):
    """
    Extract numbers from a specific JSON-like format line.
    """
    pattern = re.compile(r'[-]?\d+')
    numbers = list(map(int, pattern.findall(line)))
    return numbers

class Parts:
    def __init__ (self, name, origin, size, uv, pivot = [0,0,0], rotation = [0,0,0]):
        
        
        the_str = "{\"origin\": [_ox, _oy, _oz], \"size\": [_sx, _sy, _sz], \"pivot\": [_px, _py, _pz], \"rotation\": [_rx, _ry, _rz], \"uv\": [_ux, _uy]}"
        the_str = the_str.replace("_ox", str(origin[0]))
        the_str = the_str.replace("_oy", str(origin[1]))
        the_str = the_str.replace("_oz", str(origin[2]))
        the_str = the_str.replace('_sx', str(size[0]))
        the_str = the_str.replace('_sy', str(size[1]))
        the_str = the_str.replace('_sz', str(size[2]))
        the_str = the_str.replace('_px', str(pivot[0]))
        the_str = the_str.replace('_py', str(pivot[1]))
        the_str = the_str.replace('_pz', str(pivot[2]))
        the_str = the_str.replace('_rx', str(rotation[0]))
        the_str = the_str.replace('_ry', str(rotation[1]))
        the_str = the_str.replace('_rz', str(rotation[2]))
        the_str = the_str.replace('_ux', str(uv[0]))
        the_str = the_str.replace('_uy', str(uv[1]))
        
        
        
        self.the_str = the_str
        self.the_name = name
        self.exist = False
        
    def add(self, origin, size, uv, pivot = [0,0,0], rotation = [0,0,0]):
        the_str = ",\n{\"origin\": [_ox, _oy, _oz], \"size\": [_sx, _sy, _sz], \"pivot\": [_px, _py, _pz], \"rotation\": [_rx, _ry, _rz], \"uv\": [_ux, _uy]}"
        the_str = the_str.replace("_ox", str(origin[0]))
        the_str = the_str.replace("_oy", str(origin[1]))
        the_str = the_str.replace("_oz", str(origin[2]))
        the_str = the_str.replace('_sx', str(size[0]))
        the_str = the_str.replace('_sy', str(size[1]))
        the_str = the_str.replace('_sz', str(size[2]))
        the_str = the_str.replace('_px', str(pivot[0]))
        the_str = the_str.replace('_py', str(pivot[1]))
        the_str = the_str.replace('_pz', str(pivot[2]))
        the_str = the_str.replace('_rx', str(rotation[0]))
        the_str = the_str.replace('_ry', str(rotation[1]))
        the_str = the_str.replace('_rz', str(rotation[2]))
        the_str = the_str.replace('_ux', str(uv[0]))
        the_str = the_str.replace('_uy', str(uv[1]))
        self.the_str += the_str
        
    def get_full_str(self):
        the_full_str = '''
                        {
        					"name": "_name",
        					"pivot": [0, 28, -2],
        					"cubes": [
        						_info
        					]
        				},
        '''
        the_full_str = the_full_str.replace("_name", str(self.the_name))
        the_full_str = the_full_str.replace("_info", self.the_str + "\n")
        return the_full_str


the_hat_name = "winter2"
the_ear_name = "bunny"
the_parts = []
the_name = ""
file_name = "E:\\mine\\mod1192\\src\\main\\resources\\assets\\examplemod\\geo\\enemy_zombie.geo.json"
lines = []
with open(file_name, 'r') as file:
    lines = file.readlines()
    for line in lines:
        # print(line.strip())  # Output each line
        if 'origin' in line:
            numbers = extract_numbers_from_line(line)
            origin = [numbers[0], numbers[1], numbers[2]]
            size = [numbers[3], numbers[4], numbers[5]]

            if the_name == "body":
                tie_size = [2,1,1]
                tie_origin = [origin[0] + size[0] / 2.0 - tie_size[0] / 2.0, origin[1] + size[1], origin[2] ]
                the_parts.append(Parts("tie", tie_origin, tie_size, [0,0]))
                
            if the_name == "head":
                if the_hat_name == "high_hat":
                    hat_size = [2,4,2]
                    hat_origin = [origin[0] + size[0] / 2.0 - hat_size[0] / 2.0, origin[1] + size[1] + 1, origin[2] + size[2] / 2.0 - hat_size[2] / 2.0 ]
                    the_parts.append(Parts("hat", hat_origin, hat_size, [0,0]))
                    hat_edge_size = [4,1,4]
                    hat_edge_origin = [origin[0] + size[0] / 2.0 - hat_edge_size[0] / 2.0, origin[1] + size[1], origin[2] + size[2] / 2.0 - hat_edge_size[2] / 2.0 ]
                    the_parts.append(Parts("hat_edge", hat_edge_origin, hat_edge_size, [0,0]))
                elif the_hat_name == "helmet":
                    hat_size = [size[0],4,size[2]]
                    hat_origin = [origin[0] + size[0] / 2.0 - hat_size[0] / 2.0, origin[1] + size[1], origin[2] + size[2] / 2.0 - hat_size[2] / 2.0 ]
                    the_parts.append(Parts("hat", hat_origin, hat_size, [0,0]))
                    hat_edge_size = [size[0],1,2]
                    hat_edge_origin = [origin[0] + size[0] / 2.0 - hat_edge_size[0] / 2.0, origin[1] + size[1], origin[2] - hat_edge_size[2]]
                    the_parts.append(Parts("hat_edge", hat_edge_origin, hat_edge_size, [0,0]))
                elif the_hat_name == "winter":
                    hat_size = [size[0],4,size[2]]
                    hat_origin = [origin[0] + size[0] / 2.0 - hat_size[0] / 2.0, origin[1] + size[1], origin[2] + size[2] / 2.0 - hat_size[2] / 2.0 ]
                    the_parts.append(Parts("hat", hat_origin, hat_size, [0,0]))
                    hat_edge_size = [1,4,size[2]]
                    hat_edge_origin = [origin[0] - 1 , origin[1] + size[1] - 3 ,  origin[2] + size[2] / 2.0 - hat_edge_size[2] / 2.0 ]
                    the_parts.append(Parts("hat_edge", hat_edge_origin, hat_edge_size, [0,0]))
                    hat_edge_origin = [origin[0] + hat_size[0] , origin[1] + size[1] - 3 ,  origin[2] + size[2] / 2.0 - hat_edge_size[2] / 2.0 ]
                    the_parts.append(Parts("hat_edge2", hat_edge_origin, hat_edge_size, [0,0]))
                    
                    
            if the_name == "head":
                if the_ear_name == "bunny":
                    ear_size = [1,4,1]
                    left_ear_origin = [origin[0] + size[0] / 4.0, origin[1] + size[1], origin[2] + size[2] / 2.0]
                    add_left_ear_pos = [left_ear_origin[0] - 1, left_ear_origin[1], left_ear_origin[2]]
                    part = Parts("left_ear", left_ear_origin, ear_size, [0,0])
                    part.add(add_left_ear_pos, [1,1,1], [0,0])
                    the_parts.append(part)
                    
                    
                    right_ear_origin = [origin[0] + 3.0 * size[0] / 4.0, origin[1] + size[1], origin[2] + size[2] / 2.0]
                    add_right_ear_pos = [right_ear_origin[0] + 1, right_ear_origin[1], right_ear_origin[2]]
                    part = Parts("right_ear", right_ear_origin, ear_size, [0,0])
                    part.add(add_right_ear_pos, [1,1,1], [0,0])
                    the_parts.append(part)
                else the_ear_name == "bunny2":
                    ear_size = [1,4,1]
                    left_ear_origin = [origin[0] + size[0] / 4.0, origin[1] + size[1], origin[2] + size[2] / 2.0]
                    add_left_ear_pos = [left_ear_origin[0] - 1, left_ear_origin[1], left_ear_origin[2]]
                    part = Parts("left_ear", left_ear_origin, ear_size, [0,0])
                    part.add(add_left_ear_pos, [1,1,1], [0,0])
                    the_parts.append(part)
                    
                    
                    right_ear_origin = [origin[0] + 3.0 * size[0] / 4.0, origin[1] + size[1], origin[2] + size[2] / 2.0]
                    add_right_ear_pos = [right_ear_origin[0] + 1, right_ear_origin[1], right_ear_origin[2]]
                    part = Parts("right_ear", right_ear_origin, ear_size, [0,0])
                    part.add(add_right_ear_pos, [1,1,1], [0,0])
                    the_parts.append(part)
            
            print(f"Extracted numbers: {numbers}")
        if 'name' in line:
            the_name = extract_name_from_line(line)
            if the_name:
                print(f"Extracted name: {the_name}")
the_name = ""
insert_index = 0
with open(file_name, 'r') as file:
    lines = file.readlines()
    for line in lines:
        if 'origin' in line:
            for p in the_parts:
                if p.the_name == the_name:
                    lines[insert_index] = p.the_str
                    p.exist = True
        if 'name' in line:
            the_name = extract_name_from_line(line)
            if the_name:
                print(f"Extracted name: {the_name}")
        insert_index += 1

# 查找特定的代码行
target_line = "\"bones\": ["
insert_index = None

for i, line in enumerate(lines):
    if target_line in line:
        insert_index = i + 1
        break

the_str = ""
for p in the_parts:
    if p.exist == False:
        the_str += p.get_full_str()

# 如果找到了特定的行，则在下一行插入新内容
if insert_index is not None:
    # 在特定行后插入新内容
    lines.insert(insert_index, the_str)
    # 写回文件
    with open(file_name, 'w') as file:
        file.writelines(lines)
    print(f"New content added to the file '{file_name}' successfully.")
else:
    print(f"The target line was not found in the file '{file_name}'.")
#3 Example usage:

