import random
import re
origin_pos = [0,1,0]
player = "lava shark"
spawned_location = "the underwater coral reefs"

# 第一摄影
# 第二特效

class Sentence:
    def __init__(self, content_str, actor_str, anim_str, subject_str = []):
        self.content_str = content_str # 字符串，句子的内容
        self.actor_str = actor_str # 有哪些成员？字符串数组
        self.subject_str = subject_str
        self.anim_str = anim_str
        self.next_sentence = []
        self.auto_pos = True
        self.auto_camera = True
        
    def SetPos(self, start_pos, end_pos, start_look, end_look):
        self.auto_pos = False
        self.start_pos = start_pos
        self.end_pos = end_pos
        self.start_look = start_look
        self.end_look = end_look
        
        
def Vec3Add(a,b):
    return [a[0] + b[0], a[1] + b[1], a[2] + b[2]]

class Camera:
    def __init__(self, pos_list, look_list, time):
        self.pos_list = pos_list
        self.look_list = look_list
        self.time = time
        
    def get_str(self):
        the_str = ""
        rl = len(self.pos_list)
        for i in range(rl):
            if i == rl - 1:
                the_str += "[cameraf] [anim]"
            else:
                the_str += "[camera] [anim]"
            
            ca_st_p = " [" + str(self.pos_list[i][0]) + "," + str(self.pos_list[i][1]) + "," + str(self.pos_list[i][2]) + "]"
            ca_st_l = " [" + str(self.look_list[i][0]) + "," + str(self.look_list[i][1]) + "," + str(self.look_list[i][2]) + "]"
            ca_t = "[0," + str(self.time) + "]"
            the_str += ca_st_p + ca_st_p + ca_st_l +  ca_st_l + ca_t + "\n"
        return the_str
            
        
spawn_camera = [Camera([[0,4,0],[0,1.1,0],[0,1,0]], [[0,0,0],[0,0,0], [0,0,0]], 100), Camera([[2,2,-10],[0,2,-9],[0,1,0]], [[0,0,0],[0,0,10],[0,0,-10]], 100)]
spawn_family_camera = [Camera([[-1,2,5],[-1,2,5]], [[224, 30, 0], [222, 35, 0]], 100)]

# talk 都是相对的
talk_camera = [Camera([[-1.5,1.5,-1.5],[-1,1.5,-1]], [[-40,0,0],[-50,0,0]], 100),Camera([[-1,1.5,-1],[-1,1.5,-1]], [[-40,0,0],[-50,0,0]], 100),
               Camera([[-4,1,1],[-4,1,1]], [[-70,0,0],[-80,0,0]], 100), Camera([[1,1,-4],[1,1,-1]], [[0,0,-10],[0,0,10]], 100)]
runaway_camera = [Camera([[-2,6,3],[-2,6,-7]], [[-160,40,0],[-160,40,0]], 100), Camera([[1,3,-7],[3,6,-16],[5,10,-26]], [[5,43,0],[10,46,0],[20,50,0]], 100),
                  Camera([[-2,1,3],[-2,1,-7]], [[-160,0,0],[-160,0,0]], 100)
                  ]

lookaround_camera = [Camera([[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]], [[3,-2,0],[-81,-1,0],[-91,-1,0],[-165,1,0],[-172,1,0]], 100)]

charge_in_camera = [Camera([[2,4,6],[0,1.5,12]], [[2, 27, 0], [3, 20, 0]], 100)]

def RandomElement(str_list):
    if len(str_list) > 0:
        r = random.randint(0,len(str_list) - 1)
        return str_list[r]
    return ""

def GetCamera(anim):
    if anim == "spawn":
        return RandomElement(spawn_camera)
    elif anim == "talk":
        return RandomElement(talk_camera)
    elif anim == "run_away" or anim == "run":
        return RandomElement(runaway_camera)
    elif anim == "spawn_family":
        return RandomElement(spawn_family_camera)
    elif anim == "charge_in":
        return RandomElement(charge_in_camera)
    return RandomElement(talk_camera)


        
global_actor_list = []
global_actor_pos = []
global_actor_status = []
global_actor_lookat = []

def GetGlobalPos(actor_name):
    for k in range(len(global_actor_list)):
        if global_actor_list[k] == actor_name:
            return global_actor_pos[k]
    return [0,0,0]
        
# 随机数生成，生成数组
class SentencePlus:
    def __init__(self, sentence):
        self.content_str = sentence.content_str # 字符串，句子的内容
        self.actor_str = sentence.actor_str # 有哪些成员？字符串数组
        self.anim_str = sentence.anim_str
        self.start_pos = [""] * len(self.actor_str)
        self.end_pos = [""] * len(self.actor_str)
        self.camera = GetCamera(sentence.anim_str[0])
        

        for i in range(len(global_actor_list)):
            if global_actor_status[i] == "dead":
                global_actor_status[i] = "after_dead"
                global_actor_pos[i] = [100,0,0]
        
        for i in range(len(self.actor_str)):
            actor = self.actor_str[i]
            find = False
            for j in range(len(global_actor_list)):
                if actor == global_actor_list[j]:
                    self.start_pos[i] = global_actor_pos[j]
                    
                    global_actor_status[j] = self.anim_str[i]
                    find = True
            if find == False:
                self.anim_str[i] == "first"
                if(len(global_actor_list) > 0):
                    self.start_pos[i] = Vec3Add(global_actor_pos[0],[2,0,0])
                    global_actor_list.append(actor)
                    global_actor_pos.append(self.start_pos[i])
                    global_actor_status.append(self.anim_str[i])
                    global_actor_lookat.append([0,0,0])
                else:
                    self.start_pos[i] = origin_pos
                    global_actor_list.append(actor)
                    global_actor_pos.append(origin_pos)
                    global_actor_status.append(self.anim_str[i])
                    global_actor_lookat.append([0,0,0])

        if sentence.auto_pos == True:
            
            for i in range(len(self.actor_str)):
                actor = self.actor_str[i]
                if self.anim_str[i] == "run" or self.anim_str[i] == "run_away":
                    self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-10])
                elif self.anim_str[i] == "first":
                     self.start_pos[i] = [6,0,0]
                     self.end_pos[i] = Vec3Add(self.start_pos[i],[-4,0,0])
                elif self.anim_str[i] == "after_dead":
                    self.start_pos[i] = [100,1,3]
                    self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
                elif self.anim_str[i] == "attack":
                    self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
                    for j in range(len(global_actor_list)):
                        if actor != global_actor_list[j]:
                            global_actor_lookat[j] = self.end_pos[i]
                elif self.anim_str[i] == "charge_in":
                    self.start_pos[i] = [0,1,20]
                    self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-5])
                elif self.anim_str[i] == "was" or self.anim_str[i] == "spawn_family" :
                    self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
                elif self.anim_str[i] == "talk":
                    self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
                
                elif self.anim_str[i] == "spawn" or self.anim_str[i] == "dead":
                    self.start_pos[i] = [0,1,3]
                    self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
                else:
                    self.end_pos[i] = self.start_pos[i]
                for j in range(len(global_actor_list)):
                    if actor == global_actor_list[j]:
                        global_actor_pos[j] = self.end_pos[i]
                    
            self.lookat = []
            for i in range(len(sentence.subject_str)):
                subject = sentence.subject_str[i]
                lookat = [0,0,0]
                if self.anim_str[i] == "run" or self.anim_str[i] == "run_away":
                    lookat = Vec3Add(Vec3Add(self.end_pos[i], self.end_pos[i]), [-self.start_pos[i][0],-self.start_pos[i][1],-self.start_pos[i][2]])
                    self.lookat.append(lookat)
                    continue
                for j in range(len(global_actor_list)):
                    if global_actor_list[j] == subject:
                        lookat = global_actor_pos[j]
                        break
                self.lookat.append(lookat)
        else:
            self.start_pos = sentence.start_pos
            self.end_pos = sentence.end_pos
            self.lookat = sentence.start_look
            
        for i in range(len(self.actor_str)):
            actor = self.actor_str[i]
            for j in range(len(global_actor_list)):
                if global_actor_list[j] == actor:
                    global_actor_lookat[j] = self.lookat[i]
                    
        if sentence.anim_str[0] == "talk":
            for i in range(len(self.camera.pos_list)):
                self.camera.pos_list[i] = Vec3Add(self.camera.pos_list[i], [self.start_pos[0][0], 0, self.start_pos[0][2]])
                    
    def get_str(self, camera):
        the_str = ""
        for i in range(len(self.actor_str)):
            the_str += "[" + str(self.actor_str[i]) + "] [" + str(self.anim_str[i]) + "] " + str(self.start_pos[i]) + " " + str(self.end_pos[i]) + " " + str(self.lookat[i]) + " " + str(self.lookat[i]) + "\n"
        
        for i in range(len(global_actor_list)):
            if global_actor_list[i] not in self.actor_str:
                the_str += "[" + str(global_actor_list[i]) + "] [" + str(global_actor_status[i]) + "] " + str(global_actor_pos[i]) + " " + str(global_actor_pos[i]) + " " + str(global_actor_lookat[i]) + " " + str(global_actor_lookat[i]) + "\n"
        
        if camera == True:
            the_str += self.camera.get_str()
        return the_str
            
                    
                    
                    
                        




# sentense 中有很多备选

family_list = ["my father", "my mother", "my brother"]
family = RandomElement(family_list)

location_list = ["in front of me", "behind me"]
location = RandomElement(location_list)

enviroment_list = ["desert", "rural" ]
enviroment = RandomElement(enviroment_list)





spawn_family = [Sentence(location + " was " + family, [family, player], ["spawn_family", "was"], [player, family]), 
      Sentence(family + " was " + location, [family, player], ["spawn_family", "was"]),
      # Sentence("and my " + enviroment + " home was heavily under attack", ["my " + enviroment + " home"], ["under_attack"]),
      # Sentence("I quickly noticed that I was inside my " + location + " with all of my people slithering around",  [player], ["was"])
      ]



player = player





bad_guy_num = 2
already_appear = False 
bad_guy_desc = "a"
bad_guy_name = "poacher"
if bad_guy_num > 1:
    bad_guy_desc = "couple"
    bad_guy_name = "poachers"
if already_appear:
    bad_guy_desc = "the"



attacker = "tiger"
friend = 'friend'

defend_d = ["i", "me", "my", player]
attack_d = ["he", "him", "his", "a tiny little elephant"]
target_item = "first diamond"



def GetFollow():
    walk_i_followed = [ Sentence("I followed the lab cat ", ["lab cat", "i"], ["run", "follow"], ["none", "lab cat"]),]
    walk_i_followed[0].SetPos([[0,0,0],[2,0,-2]], [[0,0,-8],[2,0,-10]], [[0,0,-1],[0,0,-1]], [[1,0,0],[-1,0,0]])


    walk_reached = [Sentence("we reached the clearing", ["we"], ["walk"]), 
                    Sentence("the mushroom led me over to a Strang looking Jungle Room", ["mushroom",[player]], ["run","follow"]),
                    Sentence("we entered themushroom's main home", ["i", friend],  ["run","follow"]),
                    
                    # 这三句话是一个意思群
                    Sentence("I found myself in a large Village", [player], ["was"],["village"]),
                    Sentence("I looked around the village and things seemed to be different about this world", [player], ["look"]),
                    Sentence("everything around the village seemed Barren and partially flooded", [player],["look"])]

def GetChased():
    return [Sentence("the Wolves showed up confused I could have sworn I heard footsteps", [player], ["talk"]), 
                              Sentence("when i made it to other side, it was nowhere to be found", [player], ["talk"])]

def GetAttack():
    return 

defend_d = ["he", "him", "his", "tiger"]
attack_d = ["i", "me", "my", player]
attacker = player
attack_i = GetAttack()

attack_d = ["he", "him", "his", "tiger"]
defend_d = ["i", "me", "my", player]
attacker = "tiger"
attack_enemy = GetAttack()

map_enemy_chase_i = ()
map_i_chase_friend = ()
map_not_found = GetChased()
map_confused = ()

defend_d = ["he", "him", "his", "tiger"]
attack_d = ["i", "me", "my", player]


# 保证每个Sentence 角色一致，动作大致相同
        
def storyg(if_story, then_story_list):
    if_story[0].next_sentence = then_story_list
    
    for sentence in if_story:
        sentence.subject_str = if_story[0].subject_str
    
    for branch in then_story_list:
        for sentence in branch:
            sentence.subject_str = branch[0].subject_str
            
# 添加评论

storyg(spawn_i, [spawn_family])
storyg(spawn_family, [spawn_talk])
storyg(spawn_talk, [attack_enemy_charge])
storyg(spawn_family, [attack_enemy_charge])
storyg(attack_enemy_charge, [desc_enemy, attack_enemy])
storyg(desc_enemy, [attack_enemy])
storyg(attack_enemy, [i_was_hurt, attack_friend_fight])
storyg(i_was_hurt, [talk_i, walk_runaway])
storyg(talk_i, [attack_i])
storyg(attack_friend_fight, [attack_friend_talk, attack_final, attack_friend_talk])
storyg(attack_friend_talk, [attack_friend_dead])
storyg(attack_i, [attack_final])
    
        
splus = []
all_str = ""
all_str_camera = ""
current_sentences = [walk_i_followed]
finalBreak = False
for _ in range(10):
    for i in range(10):
        branch_len = len(current_sentences)
        if branch_len == 0:
            finalBreak = True
            break
        branch_index = random.randint(0, branch_len - 1)
        current_branch = current_sentences[branch_index]
        find_error = False
        
        sentences_len = len(current_branch)
        if sentences_len == 0:
            break
        sentence_index = random.randint(0, sentences_len - 1)
        current_s = current_branch[sentence_index]
        
        # 检查是否满足next scene 的要求
        for i in range(len(current_s.actor_str)):
            current_actor = current_s.actor_str[i]
            current_status = current_s.anim_str[i]
            
            # 可以没有，但状态不能错
            for j in range(len(global_actor_list)):
                global_actor = global_actor_list[j]
                if global_actor == current_actor:
                    if global_actor_status == "dead":
                        find_error = True
                    
        if find_error == False:
            print(current_s.content_str)
            sp = SentencePlus(current_s)
            splus.append(sp)
            current_sentences = current_branch[0].next_sentence
            all_str += sp.get_str(False)
            all_str_camera += sp.get_str(True)
            break
        if finalBreak == True:
            break
    if finalBreak == True:
        break
print(all_str)
with open("D:/output.txt", "w", encoding="utf-8") as file:
        
    file.write(all_str_camera)


for s in all_sentence:
    if comfit case in s:
        
     

'''

# 还是需要为每一句话配备特别的位置
# 除了Talk 都不需要特别的位置

场景就这么多吧

idle
talk
walk
melee attack

- 动作
- 人物连续


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

发生了什么事情
我是如何应对的
结果是什么
i found

有的地点还是需要在游戏中标注

Senten 两套Actor
一套是主谓宾，用来组成句子
另一套是actor list，用于生成动作吧  


要先弄清楚现在发生了什么事情，再

其实就不用StoryG这个方法了，直接遍历所有的句子，寻找条件

'''




#