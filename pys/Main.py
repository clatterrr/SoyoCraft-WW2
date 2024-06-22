from ImageDetection import get_text_and_positions
from GetSpeech import TextToSpeech
import pyautogui
import subprocess
import time
import re



'''

Remade 制作流程

第一步：制作模型
第二步：python 模拟鼠标点击，录制模型制作动画
第三步：自动生成代码
第四步：自动生成动作，生成多种多样的动作
第五步：自动录制minecraft 动画
第六步：自动随机生成文案，自动配音，自动剪辑，难听就难听

'''

image_path = 'D://dd.png'
screenshot = pyautogui.screenshot()
screenshot.save(image_path)
text_data = get_text_and_positions(image_path, False)

# todo: 用XYZ 来调整

def ClickPos(x, y, du):
    pyautogui.moveTo(x, y, duration = du)  # duration 参数控制移动的时间
    pyautogui.click()
    
def ToggleVis(i, name):
    if text_data['text'][i].lower() == name.lower():
        next_left = text_data['left'][i + 1]
        next_top = text_data['top'][i + 1]
        next_width = text_data['width'][i + 1]
        next_height = text_data['height'][i + 1]
        ClickPos(next_left + next_width / 2, next_top + next_height / 2, 2.0)
        
def ToggleNow(i, name):
    if text_data['text'][i].lower() == name.lower():
        next_left = text_data['left'][i]
        next_top = text_data['top'][i]
        next_width = text_data['width'][i]
        next_height = text_data['height'][i]
        ClickPos(next_left + next_width / 2, next_top + next_height / 2, 2.0)
        
def GenerateSpeech():
    subscription_key = "412aa3b510054e959968d5ea4459e829"
    app = TextToSpeech(subscription_key, "sample")
    app.get_token()
    app.save_audio()
        
def RecordScreen(time):
    command = "ffmpeg.exe -f gdigrab -i desktop -pix_fmt yuv420p -t " + str(time) + " -y reins.mp4"
    subprocess.Popen(command, shell = True, stdin = subprocess.PIPE)

# RecordScreen(20)

def RotateX():
    # 定义起始位置和结束位置
    start_pos = (1630.0, 970.0)
    pyautogui.moveTo(start_pos[0], start_pos[1])
    time.sleep(0.5)  # 等待0.5秒，确保鼠标移动完成

    pyautogui.mouseDown()
    time.sleep(0.1)  
    steps = 60
    move_time = 1.0  # 总共移动1秒
    interval = move_time / steps
    # 移动鼠标到结束位置
    for i in range(steps):
        pyautogui.move(1, 0)
        time.sleep(interval)

    # 释放鼠标左键
    pyautogui.mouseUp()
    
def PickColor():
    # 定义起始位置和结束位置
    start_pos = (1785, 145)
    # 移动鼠标到起始位置
    pyautogui.moveTo(start_pos[0], start_pos[1])
    time.sleep(0.5)  # 等待0.5秒，确保鼠标移动完成
    pyautogui.click()
    pyautogui.click()

    # 模拟按下6次F键
    for _ in range(6):
        pyautogui.press('f')
    
def FinishColor(x, y):
    start_pos = (13 + 13.6 * x, 110 + 13.6 * y)
    pyautogui.moveTo(start_pos[0], start_pos[1])
    time.sleep(0.5)  # 等待0.5秒，确保鼠标移动完成
    pyautogui.click()

def ReadGeo():
    # 打开文本文件进行读取
    with open('F:\yinxiao\instagram.geo.json', 'r') as file:
        read = False
        for line in file:
            # 去除行末的换行符和多余的空白字符
            line = line.strip()

            # 检查是否包含"name"字段
            if '"name": "LeftArm"' in line:
                read = True

            # 检查是否需要读取"origin"字段并输出
            if read and '"origin"' in line:
                # 使用正则表达式提取所有8个数字
                pattern = re.compile(r'(-?\d+)')
                numbers = pattern.findall(line)

                # 将数字转换为整数列表
                numbers = list(map(int, numbers))

                # 输出结果
                print(numbers[2])
                
                read = False


for i in range(len(text_data['text'])):
    if text_data['text'][i].strip() != "":
        ToggleNow(i, "Body")
        ToggleVis(i, "Body")
        ToggleVis(i, "LeftArm")
        ToggleVis(i, "RightArm")
        ToggleVis(i, "LeftLeg")
        ToggleVis(i, "RightLeg")
        

# 1633
#970

#1785, 145 点两下，选色
# 13 110 左上中心 434 532 右下中心 13.6 13.6