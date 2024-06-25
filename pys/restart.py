import random
import re
origin_pos = [0,1,0]
player = "lava shark"
spawned_location = "the underwater coral reefs"



class Sentence:
    def __init__(self, content_str, actor_str, anim_str, subject_str = []):
        self.content_str = content_str # 字符串，句子的内容
        self.actor_str = actor_str # 有哪些成员？字符串数组
        self.subject_str = subject_str
        self.anim_str = anim_str
        self.next_sentence = []
        
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
            
        
spawn_camera = [Camera([[0,6,0],[0,1,0]], [[0,0,0],[0,0,0]], 100)]



def RandomElement(str_list):
    if len(str_list) > 0:
        r = random.randint(0,len(str_list) - 1)
        return str_list[r]
    return ""

def GetCamera(anim):
    if anim == "spawn":
        return RandomElement(spawn_camera)
    return RandomElement(spawn_camera)
        
global_actor_list = []
global_actor_pos = []
global_actor_status = []
global_actor_lookat = []
        
# 随机数生成，生成数组
class SentencePlus:
    def __init__(self, sentence):
        self.content_str = sentence.content_str # 字符串，句子的内容
        self.actor_str = sentence.actor_str # 有哪些成员？字符串数组
        self.anim_str = sentence.anim_str
        self.start_pos = [""] * len(self.actor_str)
        self.end_pos = [""] * len(self.actor_str)
        self.camera = GetCamera(sentence.anim_str[0])
        
        for i in range(len(self.actor_str)):
            actor = self.actor_str[i]
            find = False
            for j in range(len(global_actor_list)):
                if actor == global_actor_list[j]:
                    self.start_pos[i] = global_actor_pos[j]
                    global_actor_status[j] = self.anim_str[i]
                    find = True
            if find == False:
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
        

        
        for i in range(len(self.actor_str)):
            actor = self.actor_str[i]
            if self.anim_str[i] == "run" or self.anim_str[i] == "run_away":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-10])
            
            elif self.anim_str[i] == "attack":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
                for j in range(len(global_actor_list)):
                    if actor != global_actor_list[j]:
                        global_actor_lookat[j] = self.end_pos[i]
            elif self.anim_str[i] == "charge_in":
                self.start_pos[i] = [0,1,10]
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,-5])
            elif self.anim_str[i] == "was":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
            elif self.anim_str[i] == "talk":
                self.end_pos[i] = Vec3Add(self.start_pos[i],[0,0,0])
            
            elif self.anim_str[i] == "spawn":
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
                lookat = Vec3Add(Vec3Add(self.end_pos[i], self.end_pos[i]), -self.start_pos[i])
                self.lookat.append(lookat)
                continue
            for j in range(len(global_actor_list)):
                if global_actor_list[j] == subject:
                    lookat = global_actor_pos[j]
                    break
            self.lookat.append(lookat)
        for i in range(len(self.actor_str)):
            actor = self.actor_str[i]
            for j in range(len(global_actor_list)):
                if global_actor_list[j] == actor:
                    global_actor_lookat[j] = self.lookat[i]
                    
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

spawn_i = [Sentence("on day one I spawned in as a baby " + player + " inside of the underwater coral reefs", [player], ["spawn"], ["none"]), 
      Sentence("on day one I spawned as a baby " + player, [player], ["spawn"])]



spawn_family = [Sentence(location + " was " + family, [family, player], ["was", "was"], [player, family]), 
      Sentence(family + " was " + location, [family, player], ["was", "was"]),
      # Sentence("and my " + enviroment + " home was heavily under attack", ["my " + enviroment + " home"], ["under_attack"]),
      # Sentence("I quickly noticed that I was inside my " + location + " with all of my people slithering around",  [player], ["was"])
      ]

spawn_talk = [Sentence("my little boy look at you welcome to your new home", [family], ["talk"], [player])]

player = player

i_was_hurt = [
      Sentence("I wanted to fight back but the poison was extremely lethal towards me" , [player], ["desc"], ["none"]),
            Sentence("I had half a heart and was dodging each of its things left and right", [player], ["desc"]),
            Sentence("I was getting extremely low", [player], ["desc"]),
            Sentence("I was knocked down to only one heart", [player], ["desc"]),
            Sentence("as soon as they hit I was blinded ah", [player], ["desc"]),
            Sentence("I thought I was surely done for", [player], ["desc"])
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



attacker = "tiger"
friend = 'friend'

defend_d = ["i", "me", "my", player]
attack_d = ["he", "him", "his", "a tiny little elephant"]
target_item = "first diamond"

talk_friend_sad = [Sentence("without the Elder there is surely no hope in winning this War" , [friend], ["talk"], [player])]
talk_friend_thank = [Sentence("Thanks for saving me, my name is " + friend, [friend], ["talk"], [player]),
                     Sentence("you did it", [friend], ["talk"])]
talk_friend_mission = [Sentence("my family and I were separated from the war and I don't have a home" , [friend], ["talk"], [player]),
                       Sentence("correct. each time it holds a different trial to overcome. find the rest of the Four Diamonds, the sun Diamond, the tiger's eye diamond, the sky diamond, and the Heart of the Jungle Diamond. as a spirit, I reside here. and will help you through your journey. well done Soyo", [friend], ["talk"]),
                       Sentence("this will take you to the first of five special Diamonds, the saber diamond. for each one you collect, the closer you will come to stopping the wolf Nation, do it for me, and end this war" , [family], ["talk"]),
                       Sentence("there is said to be five Warden scales in total each dropped down from past Ward and snake Warriors", [friend], ["talk"])
                       ]# 其实没法判断是谁talk的
talk_treasure = [Sentence("not just any scale a warden scale", ["scale"], ["talk"])] # 这句有问题
fight_noeffect = [Sentence(attack_d[0] + " tried to fight back but " + attack_d[2] + " hits weren't doing anything", [player], ["attack"])]
walk_search = [Sentence("I left the cave knowing I had to find the " + target_item, [player], ["walk"])]
walk_wired = [Sentence("I heard loud howling going off in the distance", [player], ["heard"])] # 这个话的主语不是 i
walk_takecover = [Sentence("as we were running we came across a waterfall an idea then sparked Within Me causing both peanut and I to go through it as a form of cover", [player], ["run"])]
walk_confused = [Sentence("the Wolves showed up confused I could have sworn I heard footsteps", [player], ["talk"])]
walk_runaway = [Sentence("I was running through the forest fast with "  + attack_d[3] + " getting closer", [player], ["run_away"], ["none"])]
walk_new_thing = [Sentence("what is that I ran over only to see" + defend_d[3] + " being attacked by " + attack_d[3], [attack_d[3], defend_d[3]], ["attack", "be_attacked"])]
walk_friend_start = [Sentence(friend + "started to Slither away through " + location, [friend], ["walk"])]
walk_i_followed = [Sentence("hey uh come back", [player], ["talk"])]
walk_reached = [Sentence("we reached the clearing", ["we"], ["walk"])]
walk_treasure = [Sentence("and far off on the other side of it was a scale ", ["scale"], ["object"])]
walk_treasure_pick = [Sentence("I did as ordered and went forward to pick it up", [player], ["pick"])]
misc_growth = [Sentence("because of my victory I grew into an adult-sized tiger I even gained five more Hearts", [player], ["grow"]),
               Sentence("because of this my body began to change I gained five more hearts and turned into a larger Warden snake I even have little Warden antlers ", [player], ["grow"])]
attack_friend_fight = [Sentence("but " + friend + " stepped in the way and started to fight it off", [friend], ["attack"], [attacker])]
attack_friend_talk = [Sentence("leave, now! i love you", [friend], ["talk"], [player])]
attack_friend_dead = [Sentence("I watched as " + attacker + " killed " + friend, [attacker, friend], ["attack", "dead"], ["was", "none"])]
attack_falldown = [Sentence("because of this I accidentally fell down a deep pit", [player], ["fall down"])]

defend_d = ["he", "him", "his", "tiger"]
attack_d = ["i", "me", "my", player]
attacker = player
attack_i = [Sentence(attack_d[0] + " begin to shoot out very powerful fire blasts" , [attacker], ["attack"], [defend_d[3]]),
      Sentence(attack_d[0] + " had control over the plant life around " + attack_d[2] + " and would trap " + defend_d[1] + " in place", [attacker], ["attack"]),
      Sentence(attack_d[0] + " would use " + attack_d[2] + " lava to cut " + defend_d[1] + " off from reaching " + attack_d[1], [attacker], ["attack"]),
      Sentence(attack_d[0] + " came in again and slashed " + defend_d[1] + " so hard", [attacker], ["attack"]),
      Sentence(attack_d[0] + " angrily began to attack " + defend_d[1], [attacker], ["attack"]),
      Sentence(attack_d[0] + " they kept trying to fight " + defend_d[3], [attacker], ["attack"]),
      Sentence(attack_d[0] + "  ran in and started to fend " + defend_d[1] + " off", [attacker], ["attack"]),
      Sentence("that's when " + attack_d[0] + " noticed a new ability in " + attack_d[2] + " inventory a diamond slash " + attack_d[0] + " use it on " + defend_d[3], [attacker], ["attack"]),
      Sentence(attack_d[3] + " then used a special ability on " + attack_d[1] + " which summoned void spikes from above", [attacker], ["attack"])
      ]

attack_d = ["he", "him", "his", "tiger"]
defend_d = ["i", "me", "my", player]
attacker = "tiger"
attack_enemy = [Sentence(attack_d[0] + " begin to shoot out very powerful fire blasts" , [attacker], ["attack"], [player]),
      Sentence(attack_d[0] + " had control over the plant life around " + attack_d[2] + " and would trap " + defend_d[1] + " in place", [attacker], ["attack"]),
      Sentence(attack_d[0] + " would use " + attack_d[2] + " lava to cut " + defend_d[1] + " off from reaching " + attack_d[1], [attacker], ["attack"]),
      Sentence(attack_d[0] + " came in again and slashed " + defend_d[1] + " so hard", [attacker], ["attack"]),
      Sentence(attack_d[0] + " angrily began to attack " + defend_d[1], [attacker], ["attack"]),
      Sentence(attack_d[0] + " they kept trying to fight " + defend_d[3], [attacker], ["attack"]),
      Sentence(attack_d[0] + "  ran in and started to fend " + defend_d[1] + " off", [attacker], ["attack"]),
      Sentence("that's when " + attack_d[0] + " noticed a new ability in " + attack_d[2] + " inventory a diamond slash " + attack_d[0] + " use it on " + defend_d[3], [attacker], ["attack"]),
      Sentence(attack_d[3] + " then used a special ability on " + attack_d[1] + " which summoned void spikes from above", [attacker], ["attack"])
      ]

defend_d = ["he", "him", "his", "tiger"]
attack_d = ["i", "me", "my", player]
attack_final = [Sentence("before " + defend_d[0] + " could slash at " + attack_d[1] + " again " + attack_d[0] + " blasted " + attack_d[1] + " One Last Time finally taking " + attack_d[1] + " down for good" , [player], ["attack"], [defend_d[3]]),
      # Sentence("I let out a powerful Roar which sent " + bad_guy_desc + " " + bad_guy_name + " running away", [player, bad_guy_name], ["send", "run_away"]),
      Sentence("with one more attack " + attack_d[0] + " successfully took " + defend_d[2] +  " down", [attack_d[0]], ["attack"])
      ]
            
attack_enemy_charge = [Sentence("charging in entered a " + attacker, [attacker], ["charge_in"], [player]),
      Sentence("I was facing of against the " + attacker, [attacker], ["charge_in"]),
      Sentence("just then the " + attacker + " dropped down in front of me", [attacker], ["charge_in"]),
      Sentence(attacker + "rushed in and we began to fight ", [attacker], ["charge_in"]),
      Sentence("I looked up and saw that " + attacker + " was charging towards me ", [attacker], ["charge_in"]),
      Sentence("shortly followed by a bunch of " + attacker + " they immediately started to run through our kingdom and kill my people", [attacker], ["charge_in"])
      ]

desc_enemy = [Sentence(attacker + " were way stronger than my people and could took them out with ease" , [attacker], ["was"], ["none"]),
      Sentence("even though " + attacker + " was a old man, he was tough", [attacker], ["was"]),
      Sentence(attacker + "`s massive size and speed were far greater than me", [attacker], ["was"]),
      Sentence(attacker + " had deadly poisonous gas in his aresnel ", [attacker], ["was"]),
      Sentence( attacker + " have the brute strength of nothing everyone had ever faced before ", [attacker], ["was"]),
      Sentence("he had Incredible strength and abilities", [attacker], ["was"])
      ]

talk_enemy = [Sentence("time to die" , [attacker], ["talk"], [player]),
      Sentence("don`t let him go away" , [attacker], ["talk"]),
      Sentence("you just don't know when to quit. do you? ", [attacker], ["talk"]),
      Sentence("I'll squash you like a bug", [attacker], ["talk"]),
      Sentence("you are not going anywhere", [attacker], ["talk"]),
      Sentence("you are not going anywhere", [attacker], ["talk"]),
      Sentence("the boss going to love this new prize we found", [attacker], ["talk"]),
      Sentence("our conquest for overworld has offically began", [attacker], ["talk"])
      ]

talk_i = [
      Sentence("Stay Away" , [player], ["talk"], [attacker]),
      Sentence("You stay away from me", [player], ["talk"]),
            Sentence(" Stop it ", [player], ["talk"]),
            Sentence("No", [player], ["talk"]),
            Sentence("I'm sorry but I have to do this I cannot die here", [player], ["talk"]),
            Sentence("take this", [player], ["talk"]),
            Sentence("I knew I had to do something", [player], ["notalk"]),
            Sentence("I was still small but since I was a " + player + " I can tell they were scared", [player], ["notalk"]),
            Sentence("the wolves have found us we have to go", [player], ["retreat"]),
            Sentence("if they found us, we are done for", [player], ["retreat"]),
      ]

# 保证每个Sentence 角色一致，动作大致相同
        
def storyg(if_story, then_story_list):
    if_story[0].next_sentence = then_story_list
    
    for sentence in if_story:
        sentence.subject_str = if_story[0].subject_str
    
    for branch in then_story_list:
        for sentence in branch:
            sentence.subject_str = branch[0].subject_str

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
current_sentences = [spawn_i]
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


    
     

'''

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

'''




#