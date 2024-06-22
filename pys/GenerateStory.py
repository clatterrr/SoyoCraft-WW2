from GetSpeechText import TextToSpeech
import random
import re

game_name = "gta5"
actor_name = "Jax"

answered = [False] * 10 # bool 值
all_question = ["what actor looks like", "what hat looks like", ""]
all_answer = [""] * 10
ear1 = [1, 2]

def GetAnswer():
    for i in range(10):
        if answered[i] == True:
            all_answer[i] = input(all_question[i] + " ")



ear_descriptor = "very short" # if any size > 5
face_descriptor = "longer"
ear_index = random.randint(0, 3)
ear_index = 1
if ear_index == 1:
    answered[0] = True
    
def ReadGeo():
    global ear_descriptor
    # 打开文本文件进行读取
    with open('F:\yinxiao\instagram.geo.json', 'r') as file:
        read = False
        for line in file:
            # 去除行末的换行符和多余的空白字符
            line = line.strip()

            # 查是否包含"name"字段
            if "\"name\": \"LeftUpperArm\"" in line:
                read = True

            # 检查是否需要读取"origin"字段并输出
            if read and "origin" in line:
                # 使用正则表达式提取所有8个数字
                pattern = re.compile(r'(-?\d+)')
                numbers = pattern.findall(line)

                # 将数字转换为整数列表
                numbers = list(map(int, numbers))
                
                if  numbers[3] > 4 or numbers[4] > 4 or numbers[5] > 4:
                    ear_descriptor = "very long"
                read = False
                
def GetIntroComment(index):
    if index == 1:
        comment = "let's go to create " + actor_name
        comment = "let's start by turning this into " + actor_name + " the main character of " + game_name 
        comment = "now it's time for everyone's favorite host p and we'll use a villager to make him"

def GetEarComment(index):
    if index == 1:
        comment = actor_name + " is also a " + all_answer[0] + " so he`ll need to have some " + ear_descriptor + " ears "
        
def GetFaceComment(index):
    comment = ""
    if index == 0:
        comment = "the " + actor_name + " needs to be " + face_descriptor
        
    comment = "I added his puffy hair and then I gave him a face and next I added his glasses"
        
def GetHeadComment(index):
    comment = "Crush that head and turn it into the base for the comically large mouth with that shape basically done"
    comment = "well to make the head I think it has to be another color so I'm going to start adding this cube in a more yellowish color and I'm going to stretch here he has a somewhat smiling head"

def GetHatComment(index):
    comment = "I went ahead and gave him his little Top Hat just like this"
    comment = "we'll need to replace the witch head and get to work reshaping this hat"
    comment = "he most iconic part of gummy goo is that little " + all_answer[1] + " hat so let's make it"
    
def GetBodyComment(index):
    comment = "I'm going to create a base for his body here I'll make a square like this and then below a slightly smaller Square"
    comment = "I know he has a belly so his belly will be a slightly different color"
    comment = "i squished the B into a body"
    
def GetToeComment(index):
    comment = "now I'm just going to add the toes another toe and the other toe"

def GetTailComment(index):
    comment = " now just stretch the biggest one and another bigger cube made a little tail for him that later I can animate and rotate any way I want look then I can make a movement when he's walking"

def GetLegComment(index):
    comment = "and then I gave it some legs in a head"
    
def GetClothComment(index):
    comment = "I then gave him a gray shirt and added some detail to the shirt"

ReadGeo()
GetAnswer()
GetEarComment(1)

'''

I'm going to start making the ears add two here on the side to soften the ears
one more here duplicate and rotate stretch one more duplicate again it's
going to be a big ear and lastly a smaller one now it's just me smoothing
from the sides of the ear until it gets round select all of it and duplicate to
the other side
'''

Rotate = ["and spent too much time trying to rotate these pieces"]

Funny = ["I used a dolphin and I copied this piece with a squished dolphin's face on it until I had the shape of a d",
         "Jay looks really sus and I think it's even worse that I decided to make him really big you also can't really do anything except hit him so let's move on",
         "but she is still very annoying like a regular Phantom seriously stop hitting me the clip is over"]

Fits = ["he has these red overalls and super long red pants obviously to fit his size", "he has yellow gloves on his hands or maybe those are mittens eh who knows"]

Fixs = ["we need to fix the creeper body too that's more like it"]

Legs = ["I duplicated the leg to the other side I'm going to duplicate this torso here"]


Eyes = ["pomy also has one red eye and one blue eye that we need to add as well"]

Hairs = ["let's go ahead and give pomy her hair coming out of the hat too"]

osGood = ["this show is so good that's why I decided to remake it here in mine"]

FaceComments = ['I got to say her character and model transitioned into Minecraft very nicely.',
                'she just looks so happy to be here and her colors are so vibrant.',
                "I gave F these really ugly teeth that looked nothing like the original and then I decided to get fancy and rotate his eyes"]

MiscComments = ["let's just hope there's no fudge monsters around ", "if you for some reason attack princess Lou, she will come after you and she will start attacking you"]

details = ["but to make it even more accurate We'll add the stripes"]

Arms = ["now for the body these witch arms are not going to cut it but after some fixing they're looking quite spicy",
        "now I'm going to start making the arms the forearm the wrist and stretch pull the hand the base of the fingers adds a little finger now just duplicate these fingers take the whole arm and duplicate to the other side look the base of him is looking good"]

Legs = [" time for the legs they are basically the same thing as the arms but you know leg shaped",
        "then I'll add a base to start making his leg pull another Cube down here stretch pull one more here another one stretch this leg forward and here to make the sole look it's already looking like a foot"
        ]

Textures = ["obviously we can't just keep the texture looking like a creeper so we're going to make him that candy yellow and green texture"]

Summary = ["after some final detailing pomy is looking amazing", "I think he's ready to rock", "either way ja is complete and ready to rock", "he is looking fabulous"]

# ar = random.randint(0, 1)
# br = random.randint(0, 1)
# subscription_key = "412aa3b510054e959968d5ea4459e829"

# final_text = FaceComments[ar] + MiscComments[br]

# app = TextToSpeech(subscription_key, "sample", final_text)
# app.get_token()
# app.save_audio()

