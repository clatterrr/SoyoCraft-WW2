import random
my_name = " elemental snake "
enemy_name = "the boss"
enemy_negative_descritor = "old"
treasure = "lava crystal"

connect = ["not only that but"]

# 定义文件路径
file_path = 'F://DaisyDay//Treasure.txt'

search_text = ["walk", "static", "attack"]
count = []
count.append([])
count.append([])
count.append([])
line_count = 0
with open(file_path, 'r') as file:
    for line in file:
        # 移除行首尾的空白字符
        stripped_line = line.strip()
        # 判断行是否只有一个"walk"
        for i in range(3):
            if search_text[i] in stripped_line:
                count[i].append(line_count)
        line_count += 1
print(count)

scene_info = []

def Find(emo_str):
    index = 0 
    if emo_str == "walk":
        index = 0
    elif emo_str == "static":
        index = 1
    elif emo_str == "attack":
        index = 2
    if(len(count[index]) > 0):
        n = random.randint(0, len(count[index]) - 1)
        scene_info.append(count[index][n])

# 敌人攻击方式，飞 flew into attack

def EnemyAppear():
    comment = ""
    n = random.random()
    index = (int)(n*7.0)
    if index == 0:
        # todo: https://youtu.be/n249aY0x0QY?t=16 
        comment = "charging in entered an army of " + enemy_name + "s"
    elif index == 1:
        comment = "more of the " + enemy_name + "s kept charging through the bushes of the tree"
    elif index == 2:
        comment = "then " + enemy_name + " began to charge after me"
    elif index == 3:
        comment = "I was facing of against the " + enemy_name
    elif index == 4:
        comment = "just then the " + enemy_name + " dropped down in front of me"
    elif index == 5:
        comment = enemy_name + " rushed in and we began to fight"
    elif index == 6:
        comment = "I looked up and saw that " + enemy_name + " was charging towards me"
    elif index == 7:
        comment = "out of nowhere " + enemy_name + " burst through our home and began to attack the area with their brute strength"
    elif index == 8:
        comment = "the two of them then looked at me and flew into to attack"\
    elif index == 9:
        comment = "just then a loud roar sounded off and a " + enemy_name + " swam out from the darkness"
    
    Find("walk")
    
    return comment

def EnemyDescriptor(actor_object, actor_subject, actor_s, enemy_object, enemy_subject, enemy_s): 
    comment = ""
    n = random.random()
    index = (int)(n*5.0)
    if index == 0:
        # todo: https://youtu.be/n249aY0x0QY?t=25
        comment = enemy_object + " were way stronger than " + actor_s + " people and could took " + actor_subject + " out with ease"
    if index == 1:
        comment = "even though " + enemy_object + " was an " + enemy_negative_descritor + " man " + enemy_object + " was tough"
    if index == 2:
        comment = enemy_s + " massive size and speed were far greater than " + actor_subject
    if index == 3:
        comment = enemy_object + " had deadly poisonous gas in " + enemy_s + " Arsenal"
    if index == 4:
        comment = enemy_object + " have the brute strength of nothing everyone had ever faced before"
        
    Find("walk")
    
    return comment
        
def EnemyTalk():
    comment = ""
    n = random.random()
    index = (int)(n*4.0)
    if index == 0:
        comment = "time to die"
    if index == 1:
        comment = "you just don't know when to quit do you"
    if index == 2:
        comment = "I'll squash you look a bug"
    if index == 3:
        comment = "this " + treasure + " is mine"
    if index == 4:
        comment = "an " + my_name + " does exist !perfect! capture them"
    if index == 5:
        comment = "you are not going anywhere"
        
    Find("static")
    return comment
        
# me him them
def EnemyAttack(actor_object, actor_subject, actor_s, enemy_object, enemy_subject, enemy_s): 
    comment = ""
    n = random.random()
    index = (int)(n*8.0)
    if index == 0:
        comment = actor_object + " begin to shoot out very powerful fire blasts " + enemy_s + " way"
    if index == 1:
        comment = actor_object + " had control over the plant life around " + actor_subject + " and would trap " + enemy_subject + " in place"
    if index == 2:
        comment = actor_object + " would use " + actor_s + " lava to cut " + enemy_subject + " off from reaching " + actor_subject
    if index == 3:
        comment = actor_object + " came in again and slashed " + enemy_subject + " so hard"
    if index == 4:
        comment = actor_object + " Unleashed " + actor_s + " new lava power which caused the ice between us to crack and " + enemy_object + " to fall into a cavern below"
    if index == 5:
        comment = actor_object + " gained some distance and focused " + actor_s + " energy into one powerful lava power which struck " + enemy_subject + "head on"
    if index == 6:
        comment = actor_object + " used " + actor_s + " ability to burn " + enemy_subject + " down and blast " + enemy_subject + " back with " + actor_s + " solar beam"
    if index == 7:
        comment = actor_object + " angrily began to attack " + enemy_subject
    if index == 8:
        comment = "out of panic " + actor_object + " shot out ice. completely freezing " + enemy_subject
    if index == 9:
        comment = actor_object + " had forgotten " + actor_object + " can control fire now " + actor_object + " fought them back using " + actor_s + " newly mastered element because of this " + enemy_name + " fled"
    if index == 10:
        comment = "before " + actor_object + " was able to say anything though " + enemy_object + " swam at " + enemy_subject + " with the intent to kill"
    if index == 11:
        comment = "the " + enemy_name +  " was doing everything " + enemy_object + " could to take " + actor_subject + "down"
    Find("attack")
    return comment
        
def NoEffect(actor_object, actor_subject, actor_s, enemy_object, enemy_subject, enemy_s):
    comment = ""
    n = random.random()
    index = (int)(n*2.0)
    if index == 0:
        comment = enemy_object + "upgraded form was way too strong"
    if index == 1:
        comment = actor_object + "knew " + enemy_s + " attacks this time and was easily able to dodge " +  enemy_subject
    Find("static")
    return comment
        
def Run(actor_object, actor_subject, actor_s, enemy_object, enemy_subject, enemy_s):
    comment = ""
    n = random.random()
    index = (int)(n*1.0)
    if index == 0:
        comment = actor_object + "ran throughout the hallways and managed to close a door behind " + actor_subject
    return comment
        
def MeTalk():
    comment = ""
    n = random.random()
    index = (int)(n*4.0)
    if index == 0:
        comment = "Stay Away"
    if index == 1:
        comment = "Stop it"
    if index == 2:
        comment = "No"
    if index == 3:
        comment = "take this"
    if index == 4:
        comment = "that's right I'm " + my_name
    if index == 5:
        comment = "I'm sorry but I have to do this I cannot die here"
    Find("static")
    return comment
        
def IwasHurt():
    comment = ""
    n = random.random()
    index = (int)(n*4.0)
    if index == 0:
        comment = "I wanted to fight back but the poison was extremely lethal towards me "
    if index == 1:
        comment = "I had half a heart and was dodging each of its things left and right"
    if index == 2:
        comment = "I was getting extremely low"
    if index == 3:
        comment = "I was knocked down to only one heart"
    if index == 4:
        comment = "I thought I was surely done for"
    if index == 5:
        comment = "the " + enemy_name + " bit right in into me making me lose a ton of Hearts"
    Find("static")
    return comment
        
def Final(actor_object, actor_subject, actor_s, enemy_object, enemy_subject, enemy_s):
    comment = ""
    n = random.random()
    index = (int)(n*1.0)
    if index == 0:
        comment = "before " + enemy_object + " could slash at " + actor_subject + " again " + actor_object + " blasted " + enemy_name + " One Last Time finally taking " + enemy_subject + " down for good"
    Find("attack")
    return comment
        
text = ""
i3 = ["i", "me", "my"]
h3 = ["he", "his", "him"]
text += EnemyAppear() + "\n"
text += EnemyDescriptor(i3[0], i3[1], i3[2], h3[0], h3[1], h3[2]) + "\n"
text += EnemyTalk() + "\n"
text += EnemyAttack(h3[0], h3[1], h3[2], i3[0], i3[1], i3[2]) + "\n"
text += IwasHurt() + "\n"
text += MeTalk() + "\n"
text += EnemyAttack(i3[0], i3[1], i3[2], h3[0], h3[1], h3[2]) + "\n"
text += Final(i3[0], i3[1], i3[2], h3[0], h3[1], h3[2]) 



# 初始化一个空列表来存储每一行
lines = []

# 使用with语句打开文件，确保文件会被正确关闭
with open(file_path, 'r', encoding='utf-8') as file:
    # 逐行读取文件
    for line in file:
        # 移除行尾的换行符并添加到列表中
        lines.append(line.strip())
final_text = ""
for s in scene_info:
    final_text += lines[s + 1] + "\n"
    final_text += lines[s + 2] + "\n"
    final_text += lines[s + 3] + "\n"
    