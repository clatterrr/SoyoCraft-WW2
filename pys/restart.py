import random
import re
origin_pos = [0,1,0]
actor_name = "lava shark"
spawned_location = "the underwater coral reefs"

# 摄像机自顶向上
# actor 的位置就是 the underwater coral reefs 的位置
# 但是仍然可以标注少量的顶点，
s1 = ["on day one I spawned in as a baby " + actor_name + " inside of " + spawned_location]

# 在选择随机数前就准备好

class Sentence:
    def __init__(self, content_str, actor_str, anim_str):
        self.content_str = content_str # 字符串，句子的内容
        self.actor_str = actor_str # 有哪些成员？字符串数组
        self.anim_str = anim_str
        
def Vec3Add(a,b):
    return [a[0] + b[0], a[1] + b[1], a[2] + b[2]]

class Camera:
    def __init__(self, start_pos, end_pos, start_look, end_look, time):
        self.start_pos = start_pos
        self.end_pos = end_pos
        self.start_look = start_look
        self.end_look = end_look
        self.time = time
        
tag_positions = {}
line_count = 0
cameras = []
# 打开文件（假设文件名为 example.txt）
with open('D:/CameraSetting.txt', 'r', encoding='utf-8') as file:
    # 遍历文件的每一行
    for line in file:
        # 查找行中的标签
        tags = [tag for tag in line.split() if tag.startswith('[') and tag.endswith(']')]
        # 记录每个标签出现的行数
        if all(re.search('[a-zA-Z]', tag) for tag in tags):
            for tag in tags:
                if tag not in tag_positions:
                    tag_positions[tag] = []
                tag_positions[tag].append(line_count)
        else:
            numbers = [int(num) for tag in tags for num in tag.strip('[]').split(',')]
            camera = Camera([numbers[0], numbers[1], numbers[2]], [numbers[3], numbers[4], numbers[5]], [numbers[6], numbers[7], numbers[8]], [numbers[9], numbers[10], numbers[11]], [numbers[12], numbers[13]])
            cameras.append(camera)
        line_count += 1

# 将结果转换为数组
result = [(tag, positions) for tag, positions in tag_positions.items()]


def RandomElement(str_list):
    if len(str_list) > 0:
        r = random.randint(0,len(str_list) - 1)
        return str_list[r]
    return ""
        
global_actor_list = []
global_actor_pos = []
        
# 随机数生成，生成数组
class SentencePlus:
    def __init__(self, sentence, camera_str):
        self.content_str = sentence.content_str # 字符串，句子的内容
        self.actor_str = sentence.actor_str # 有哪些成员？字符串数组
        self.anim_str = sentence.anim_str
        self.start_pos = [""] * len(self.actor_str)
        self.end_pos = [""] * len(self.actor_str)
        index = RandomElement(tag_positions.get(camera_str)) / 2
        self.camera = cameras[int(index)]
        
        for i in range(len(self.actor_str)):
            actor = self.actor_str[i]
            find = False
            for j in range(len(global_actor_list)):
                if actor == global_actor_list[j]:
                    self.start_pos[i] = global_actor_pos[j]
                    find = True
            if find == False:
                if(len(global_actor_list) > 0):
                    self.start_pos[i] = Vec3Add(global_actor_pos[0],[2,0,0])
                    global_actor_list.append(actor)
                    global_actor_pos.append(self.start_pos[i])
                else:
                    self.start_pos[i] = origin_pos
                    global_actor_list.append(actor)
                    global_actor_pos.append(origin_pos)
                    
        
        for i in range(len(self.actor_str)):
            actor = self.actor_str[i]
            if self.anim_str[i] == "run":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,10])
            elif self.anim_str[i] == "attack":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-0.1])
            elif self.anim_str[i] == "charge_in":
                self.start_pos[i] = [0,1,10]
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-5])
            elif self.anim_str[i] == "was":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-0.1])
            elif self.anim_str[i] == "talk":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-0.1])
            else:
                self.end_pos[i] = self.start_pos[i]
            for j in range(len(global_actor_list)):
                if actor == global_actor_list[j]:
                    global_actor_pos[j] = self.end_pos[i]
                    
    def get_str(self):
        the_str = ""
        for i in range(len(self.actor_str)):
            the_str += "[" + str(self.actor_str[i]) + "] [" + str(self.anim_str[i]) + "] " + str(self.start_pos[i]) + " " + str(self.end_pos[i]) + " [0,0,0] [0,0,0]\n"
        ca_st_p = " [" + str(self.camera.start_pos[0]) + "," + str(self.camera.start_pos[1]) + "," + str(self.camera.start_pos[2]) + "]"
        ca_ed_p = " [" + str(self.camera.end_pos[0]) + "," + str(self.camera.end_pos[1]) + "," + str(self.camera.end_pos[2]) + "]"
        ca_st_l = " [" + str(self.camera.start_look[0]) + "," + str(self.camera.start_look[1]) + "," + str(self.camera.start_look[2]) + "]"
        ca_ed_l = " [" + str(self.camera.end_look[0]) + "," + str(self.camera.end_look[1]) + "," + str(self.camera.end_look[2]) + "]"
        ca_t = "[" + str(self.camera.time[0]) + "," + str(self.camera.time[1]) + "]"
        the_str += "[camera] [anim]" + ca_st_p + ca_ed_p + ca_st_l + ca_ed_l + ca_t
        return the_str
            
                    
                    
                    
                        




# sentense 中有很多备选



s1 = [Sentence("on day one I spawned in as a baby " + actor_name + " inside of the underwater coral reefs", ["i"], ["spawned"]), 
      Sentence("on day one I spawned as a baby " + actor_name, ["i"], ["spawned"])]

helper_list = ["my father", "my mother", "my brother"]
helper = RandomElement(helper_list)

location_list = ["in front of me", "behind me"]
location = RandomElement(location_list)

enviroment_list = ["desert", "rural" ]
enviroment = RandomElement(enviroment_list)

s2 = [Sentence(location + " was " + helper, [helper, "i"], ["was", "was"]), 
      Sentence(helper + " was " + location, [helper, "i"], ["was", "was"]),
      Sentence("and my " + enviroment + " home was heavily under attack", ["my " + enviroment + " home"], ["under attack"]),
      Sentence("I quickly noticed that I was inside my " + location + " with all of my people slithering around",  ["i"], ["was"])
      ]

spawn_talk = [Sentence("my little boy look at you welcome to your new home", [helper], ["talk"])]

attacker = "tiger"        

s3 = [Sentence("charging in entered a " + attacker, [attacker], ["charge_in"]),
      Sentence("I was facing of against the " + attacker, [attacker], ["charge_in"]),
      Sentence("just then the " + attacker + " dropped down in front of me", [attacker], ["charge_in"]),
      Sentence(attacker + "rushed in and we began to fight ", [attacker], ["charge_in"]),
      Sentence("I looked up and saw that " + attacker + " was charging towards me ", [attacker], ["charge_in"]),
      Sentence("shortly followed by a bunch of " + attacker + " they immediately started to run through our kingdom and kill my people", [attacker], ["charge_in"])
      ]

s4 = [Sentence(attacker + " were way stronger than my people and could took them out with ease" , [attacker], ["was"]),
      Sentence("even though " + attacker + " was a old man, he was tough", [attacker], ["was"]),
      Sentence(attacker + "`s massive size and speed were far greater than me", [attacker], ["was"]),
      Sentence(attacker + " had deadly poisonous gas in his aresnel ", [attacker], ["was"]),
      Sentence( attacker + " have the brute strength of nothing everyone had ever faced before ", [attacker], ["was"]),
      Sentence("he had Incredible strength and abilities", [attacker], ["was"])
      ]

s5 = [Sentence("time to die" , [attacker], ["talk"]),
      Sentence("don`t let him go away" , [attacker], ["talk"]),
      Sentence("you just don't know when to quit. do you? ", [attacker], ["talk"]),
      Sentence("I'll squash you like a bug", [attacker], ["talk"]),
      Sentence("you are not going anywhere", [attacker], ["talk"]),
      Sentence("you are not going anywhere", [attacker], ["talk"]),
      Sentence("the boss going to love this new prize we found", [attacker], ["talk"]),
      Sentence("our conquest for overworld has offically began", [attacker], ["talk"])
      ]

defend_d = ["he", "him", "his", "a tiny little elephant"]
attack_d = ["i", "me", "my", "a couple  poachers"]
player = "i"

s6 = [Sentence(attack_d[0] + " begin to shoot out very powerful fire blasts" , [attacker], ["attack"]),
      Sentence(attack_d[0] + " had control over the plant life around " + attack_d[2] + " and would trap " + defend_d[1] + " in place", [attacker], ["attack"]),
      Sentence(attack_d[0] + " would use " + attack_d[2] + " lava to cut " + defend_d[1] + " off from reaching " + attack_d[1], [attacker], ["attack"]),
      Sentence(attack_d[0] + " came in again and slashed " + defend_d[1] + " so hard", [attacker], ["attack"]),
      Sentence(attack_d[0] + " angrily began to attack " + defend_d[1], [attacker], ["attack"]),
      Sentence(attack_d[0] + " they kept trying to fight " + defend_d[3], [attacker], ["attack"]),
      Sentence(attack_d[0] + "  ran in and started to fend " + defend_d[1] + " off", [attacker], ["attack"]),
      Sentence("that's when " + attack_d[0] + " noticed a new ability in " + attack_d[2] + " inventory a diamond slash " + attack_d[0] + " use it on " + defend_d[3], [attacker], ["attack"]),
      Sentence(attack_d[3] + " then used a special ability on " + attack_d[1] + " which summoned void spikes from above", [attacker], ["attack"])
      ]

s7 = [
      Sentence("I wanted to fight back but the poison was extremely lethal towards me" , [player], ["talk"]),
            Sentence("I had half a heart and was dodging each of its things left and right", [player], ["talk"]),
            Sentence("I was getting extremely low", [player], ["talk"]),
            Sentence("I was knocked down to only one heart", [player], ["talk"]),
            Sentence("as soon as they hit I was blinded ah", [player], ["desc"]),
            Sentence("I thought I was surely done for", [player], ["talk"])
      ]

s8 = [
      Sentence("Stay Away" , [player], ["talk"]),
      Sentence("You stay away from me", [player], ["talk"]),
            Sentence(" Stop it ", [player], ["talk"]),
            Sentence("No", [player], ["talk"]),
            Sentence("I'm sorry but I have to do this I cannot die here", [player], ["talk"]),
            Sentence("take this", [player], ["talk"]),
            Sentence("I knew I had to do something", [player], ["notalk"]),
            Sentence("I was still small but since I was a " + actor_name + " I can tell they were scared", [player], ["notalk"]),
            Sentence("the wolves have found us we have to go", [player], ["retreat"]),
            Sentence("if they found us, we are done for", [player], ["retreat"]),
      ]

bad_guy_num = 2
already_appear = False 
bad_guy_desc = "a"
bad_guy_name = "poacher"
if bad_guy_num > 1:
    bad_guy_desc = "couple"
    bad_guy_name = "poachers"
if already_appear:
    bad_guy_desc = "the"

s9 = [Sentence("before " + defend_d[0] + " could slash at " + attack_d[1] + " again " + attack_d[0] + " blasted " + attack_d[1] + " One Last Time finally taking " + attack_d[1] + " down for good" , [player], ["attack"]),
      Sentence("I let out a powerful Roar which sent " + bad_guy_desc + " " + bad_guy_name + " running away", [player, bad_guy_name], ["send", "run_away"]),
      Sentence("with one more attack " + attack_d[0] + " successfully took " + defend_d[2] +  " down", [attack_d[0]], ["attack"])
      ]


real_s3 = SentencePlus(RandomElement(s3), "[charge_in]")
real_s4 = SentencePlus(RandomElement(s4), "[was]")
real_s5 = SentencePlus(RandomElement(s5), "[talk]")
attack_d = ["he", "him", "his"]
defend_d = ["i", "me", "my"]
real_s6 = SentencePlus(RandomElement(s6), "[attack]")
real_s7 = SentencePlus(RandomElement(s7), "[talk]")
defend_d = ["he", "him", "his"]
attack_d = ["i", "me", "my"]
real_s8 = SentencePlus(RandomElement(s8), "[attack]")
real_s9 = SentencePlus(RandomElement(s9), "[attack]")

print(real_s3.get_str())
print(real_s4.get_str())
print(real_s5.get_str())
print(real_s6.get_str())
print(real_s7.get_str())
print(real_s8.get_str())
print(real_s9.get_str())

with open('D:/output.txt', 'w', encoding='utf-8') as file:
    # 将字符串写入文件
    file.write(real_s3.get_str() + "\n")
    
    file.write(real_s4.get_str() + "\n")
    
    file.write(real_s5.get_str() + "\n")
    
    file.write(real_s6.get_str() + "\n")
    
    file.write(real_s7.get_str() + "\n")
    
    file.write(real_s8.get_str() + "\n")
    
    file.write(real_s9.get_str() + "\n")
    # file.write(real_s2.get_str())


friend = 'younger'

defend_d = ["he", "him", "his", "a tiny little elephant"]
attack_d = ["i", "me", "my", "a couple  poachers"]
target_item = "first diamond"

talk_friend_sad = [Sentence("without the Elder there is surely no hope in winning this War" , [attacker], ["talk"])]
talk_friend_thank = [Sentence("Thanks for saving me, my name is " + friend, [friend], ["talk"]),
                     Sentence("you did it", [friend], ["talk"])]
talk_friend_mission = [Sentence("my family and I were separated from the war and I don't have a home" , [friend], ["talk"]),
                       Sentence("correct. each time it holds a different trial to overcome. find the rest of the Four Diamonds, the sun Diamond, the tiger's eye diamond, the sky diamond, and the Heart of the Jungle Diamond. as a spirit, I reside here. and will help you through your journey. well done Soyo", [friend], ["talk"]),
                       Sentence("this will take you to the first of five special Diamonds, the saber diamond. for each one you collect, the closer you will come to stopping the wolf Nation, do it for me, and end this war" , [helper], ["talk"]),
                       Sentence("there is said to be five Warden scales in total each dropped down from past Ward and snake Warriors", [friend], ["talk"])
                       ]# 其实没法判断是谁talk的
talk_treasure = [Sentence("not just any scale a warden scale", ["scale"], ["talk"])] # 这句有问题
fight_noeffect = [Sentence(attack_d[0] + " tried to fight back but " + attack_d[2] + " hits weren't doing anything", [player], ["attack"])]
walk_search = [Sentence("I left the cave knowing I had to find the " + target_item, ["i"], ["walk"])]
walk_wired = [Sentence("I heard loud howling going off in the distance", ["i"], ["heard"])] # 这个话的主语不是 i
walk_takecover = [Sentence("as we were running we came across a waterfall an idea then sparked Within Me causing both peanut and I to go through it as a form of cover", [player], ["run"])]
walk_confused = [Sentence("the Wolves showed up confused I could have sworn I heard footsteps", [player], ["talk"])]
walk_runaway = [Sentence("I was running through the forest fast with "  + attack_d[3] + " getting closer", ["i"], ["run_away"])]
walk_new_thing = [Sentence("what is that I ran over only to see" + defend_d[3] + " being attacked by " + attack_d[3], [attack_d[3], defend_d[3]], ["attack", "be_attacked"])]
walk_friend_start = [Sentence(friend + "started to Slither away through " + location, [friend], ["walk"])]
walk_i_followed = [Sentence("hey uh come back", ["i"], ["talk"])]
walk_reached = [Sentence("we reached the clearing", ["we"], ["walk"])]
walk_treasure = [Sentence("and far off on the other side of it was a scale ", ["scale"], ["object"])]
walk_treasure_pick = [Sentence("I did as ordered and went forward to pick it up", ["i"], ["pick"])]
misc_growth = [Sentence("because of my victory I grew into an adult-sized tiger I even gained five more Hearts", [player], ["grow"]),
               Sentence("because of this my body began to change I gained five more hearts and turned into a larger Warden snake I even have little Warden antlers ", [player], ["grow"])]
attack_friend_fight = [Sentence("but " + friend + " stepped in the way and started to fight it off", [friend], ["attack"])]
attack_friend_talk = [Sentence("leave, now! i love you", [friend], ["attack"])]
attack_friend_dead = [Sentence("I watched as " + attacker + " killed " + friend, [attacker, friend], ["attack", "dead"])]
attack_falldown = [Sentence("because of this I accidentally fell down a deep pit", ["i"], ["fall down"])]

story = ["spawn"]
for i in range(10):
    l = len(story) - 1
    if story[l] == "spawn":
        story.append("attack")
    if story[l] == "attack":
        r = random.randint(0, 1)
        if r == 0:
            story.append("run away")
        else:
            story.append("fight back")
    if story[l] == "run":
        r = random.randint(0, 2)
        if r == 0:
            story.append("find treasure")
        elif r == 1:
            story.append("attack")
        else:
            story.append("friend")
    if story[l] == "find treasure":
        story.append("run away")
    if story[l] == "friend":
        story.append("walk search")
    if story[l] == "fight back":
        story.append("friend mission")
    if story[l] == "run away":
        r = random.randint(0, 1)
        if r == 0:
            story.append("walk search")
        else:
            story.append("friend")
    if story[l] == "walk search":
        story.append("attack")
    if story[l] == "friend mission":
        r = random.randint(0, 1)
        if r == 0:
            story.append("attack")
        else:
            story.append("walk search")
            
            
def storyg(ifstory, appendstory):
    alen = len(appendstory) - 1
    r = random.randint(0, alen)
    l = len(battle_story) - 1
    if battle_story[l] == ifstory:
        battle_story.append(appendstory[r])
        

            
battle_story = ["spawn"]
for i in range(10):
    storyg("spawn", ["charge in"])
    storyg("charge in", ["boss talk"])
    storyg("boss talk", ["boss attack"])
    storyg("boss attack", ["i was low health", "i was blind", "friend attack"])
    storyg("i was blind", ["i fall down a pit"])
    storyg("i fall down a pit", ["i run away"])
    storyg("i was low health", ["i talk", "i run away"])
    storyg("friend attack", ["friend before dead talk", "boss dead final", "friend run away talk"])
    storyg("friend before dead talk", ["friend dead"])
    storyg("friend run away talk", ["friend run away"])
    storyg("friend run away", ["i followed"])
    storyg("friend dead", ["i run away"])
    storyg("i talk", ["i attack"])
    storyg("i attack", ["boss dead final"])
    storyg("boss dead final", ["talk friend thank"])
    
    
    storyg("i run away", ["i heard a noise"])
    storyg("i heard a noise", ["i meet a new friend"])
    storyg("i meet a new friend", ["friend talk"])
    storyg("friend talk", ["friend walk away"])
    storyg("friend walk away", ["i followed"])
    
    storyg("i followed", ["reach new location"])
    storyg("reach new location", ["find treasure"])
    
    # friend thank 这种就随机穿插吧
    
    storyg("find treasure", ["walk i grow"])
    storyg("walk i grow", ["friend mission"]) # 怎么判断有没有friend 呢
    
    # i run away 后随机插入 boss chase talk
    
    
print(battle_story)
'''

走路
- 发现东西
- 遇见朋友
- 遇见敌人
---- 遇见敌人大朋友
- 建造

说话
- 交流感情
- 发布任务
- 和对手互喷
- 


打架
- 2
- 3
- 多

'''




#