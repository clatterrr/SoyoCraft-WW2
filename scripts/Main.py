from ImageDetection import get_text_and_positions
from GetSpeech import TextToSpeech
import pyautogui
import subprocess





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

RecordScreen(20)

for i in range(len(text_data['text'])):
    if text_data['text'][i].strip() != "":
        ToggleNow(i, "Body")
        ToggleVis(i, "Body")
        ToggleVis(i, "LeftArm")
        ToggleVis(i, "RightArm")
        ToggleVis(i, "LeftLeg")
        ToggleVis(i, "RightLeg")
        

        