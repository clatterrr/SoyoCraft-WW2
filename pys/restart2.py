
import random
from VoicGenerator import TextToSpeech


actor_desc = [["i", "me", "my", "myself", "lava shark", "the lava shark"],
              ["he", "him", "his", "himself", "tiger", "the tiger"]
              ]

def VecNeg(a):
    return [-a[0],-a[1], -a[2]]

def Vec3Add(a,b):
    return [a[0] + b[0], a[1] + b[1], a[2] + b[2]]

def Vec3Sub(a,b):
    return [a[0] - b[0], a[1] - b[1], a[2] - b[2]]

oriloc = [-118,94,-1]
specloc = Vec3Sub([-118,94,-1], oriloc)
specloc2 = Vec3Sub([-111,98,0], oriloc)

class Location:
    def __init__(self, start_pos, end_pos, start_look, end_look):
        self.start_pos = start_pos
        self.end_pos = end_pos
        self.start_look = start_look
        self.end_look = end_look
        
class Effect:
    def __init__(self, effect_name, start_pos, end_pos, start_look, end_look):
        self.effect_name = effect_name
        self.start_pos = start_pos
        self.end_pos = end_pos
        self.start_look = start_look
        self.end_look = end_look
        
    def get_str(self):
        the_str = "[" + str(self.effect_name) + "] [anim] [" + str(self.start_pos[0]) + "," + str(self.start_pos[1]) + "," + str(self.start_pos[2]) + "] [0,0,0] [0,0,0] [0,0,0]"
        return the_str
        
class Camera:
    def __init__(self, pos_list, look_list, time):
        self.pos_list = pos_list
        self.look_list = look_list
        self.time = time
        
    def get_str(self, t0, t1):
        the_str = ""
        rl = len(self.pos_list)
        for i in range(rl):
            if i == rl - 1:
                the_str += "[cameraf] [anim]"
            else:
                the_str += "[camera] [anim]"
            
            ca_st_p = " [" + str(self.pos_list[i][0]) + "," + str(self.pos_list[i][1]) + "," + str(self.pos_list[i][2]) + "]"
            ca_st_l = " [" + str(self.look_list[i][0]) + "," + str(self.look_list[i][1]) + "," + str(self.look_list[i][2]) + "]"
            ca_t = "[" + str(t0) + "," + str(t1) + "]"
            the_str += ca_st_p + ca_st_p + ca_st_l +  ca_st_l + ca_t + "\n"
        return the_str
    
    def UpdateRelative(self, pos):
        for s in self.pos_list:
            s = Vec3Add(s, pos)
    
def RandomElement(str_list):
    if len(str_list) > 0:
        r = random.randint(0,len(str_list) - 1)
        return str_list[r]
    return "" 

location_spec = [Location([specloc, specloc2], [specloc, specloc2], [Vec3Sub(specloc2,specloc), Vec3Sub(specloc,specloc2)], [Vec3Sub(specloc2,specloc), Vec3Sub(specloc,specloc2)])]
location_one_at = [Location([[0,0,1]], [[0,0,1]], [[0,0,-1]], [[0,0,-1]])]
location_two_at = [Location([[2,0,0],[0,0,0]], [[2,0,0],[0,0,0]], [[-1,0,0],[1,0,0]], [[-1,0,0],[1,0,0]])]

location_two_at_spawn = [Location([[5,0,0],[0,0,0]], [[5,0,0],[0,0,0]], [[-1,0,0],[1,0,0]], [[-1,0,0],[1,0,0]])]
location_charge = [Location([[0,0,20]], [[0,0,10]], [[0,0,-1]], [[0,0,-1]])]
location_two_at_neg = [Location([[-2,0,0],[0,0,0]], [[-2,0,0],[0,0,0]], [[-1,0,0],[1,0,0]], [[-1,0,0],[1,0,0]])]

spawn_camera = [Camera([[0,4,0],[0,1.1,0],[0,1,0]], [[0,0,0],[0,0,0], [0,0,0]], 100), Camera([[2,2,-10],[0,2,-9],[0,1,0]], [[0,0,0],[0,0,10],[0,0,-10]], 100)]
spawn_family_camera = [Camera([[-1,2,5],[-1,2,5]], [[224, 30, 0], [222, 35, 0]], 100)]

# talk 都是相对的
camera_talk = [Camera([[-1.5,1.5,-1.5],[-1,1.5,-1]], [[-40,0,0],[-50,0,0]], 100),Camera([[-1,1.5,-1],[-1,1.5,-1]], [[-40,0,0],[-50,0,0]], 100),
               Camera([[-4,1,1],[-4,1,1]], [[-70,0,0],[-80,0,0]], 100), Camera([[1,1,-4],[1,1,-1]], [[0,0,-10],[0,0,10]], 100)]
runaway_camera = [Camera([[-2,6,3],[-2,6,-7]], [[-160,40,0],[-160,40,0]], 100), Camera([[1,3,-7],[3,6,-16],[5,10,-26]], [[5,43,0],[10,46,0],[20,50,0]], 100),
                  Camera([[-2,1,3],[-2,1,-7]], [[-160,0,0],[-160,0,0]], 100)
                  ]

lookaround_camera = [Camera([[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]], [[3,-2,0],[-81,-1,0],[-91,-1,0],[-165,1,0],[-172,1,0]], 100)]

charge_in_camera = [Camera([[2,4,6],[0,1.5,12]], [[2, 27, 0], [3, 20, 0]], 100)]
location_actor_take_item = [Location([[0,0,3],[3,3,6]], [[0,0,3],[1,1,4]], [[0,0,-1],[0,-1,-1]], [[0,0,-1],[0,-1,-1]])]
camera_actor_take_item = [Camera([[0,0.5,-1],[0,0.5,-1]],[[0,0,0],[0,0,0]], 100)]
camera_item_on_ground = [Camera([[0,0.5,-1],[0,0.5,-1]],[[0,0,0],[0,0,0]], 100)]

location_return = [Location([[1,0,10],[0,0,0]], [[1,0,5],[0,0,0]], [[0,0,-1],[0,0,1]], [[0,0,-1],[0,0,1]])]
camera_return = [Camera([[2,1,-2],[2,1,-2]],[[20,0,0],[20,0,0]], 100)]
camera_spawn = [Camera([[-12,1,-2],[-4,1,-1],[-2,2,-1]],[[-56,0,0],[-76,0,0],[-70,0,0]], 100)]
location_look_around = [Location([[0,0,1]], [[0,0,1]], [[0,0,-1]], [[0,0,1]])]

# 应该表明是否沿用上一帧的位置

class Sentence:
    def __init__(self, content, actors = ["i"], anim = ["walk"], location_mode_list = location_one_at, camera_mode_list = camera_talk):
        if len(actors) == 2 and location_mode_list == location_one_at :
            location_mode_list = location_two_at
        self.content = content
        self.actors = actors
        self.anim = anim
        self.location_mode_list = location_mode_list
        self.location_mode_index = random.randint(0, len(location_mode_list) - 1)
        self.camera_mode_list = camera_mode_list
        
        
    def UpdateActor(self, main, sub):
        global actor_desc
        m = actor_desc[main]
        s = actor_desc[sub]
        # 替换 _i 为 main_actor[0]
        self.content = self.content.replace("_i", m[0])
        self.content = self.content.replace("_me", m[1])
        self.content = self.content.replace("_my", m[2])
        self.content = self.content.replace("_myself", m[3])
        self.content = self.content.replace("_ame", m[4])
        self.content = self.content.replace("_theme", m[5])
        self.content = self.content.replace("_he", s[0])
        self.content = self.content.replace("_him", s[1])
        self.content = self.content.replace("_his", s[2])
        self.content = self.content.replace("_himself", s[3])
        self.content = self.content.replace("_ahe", s[4])
        self.content = self.content.replace("_thehe", s[5])
        
    def GetContent(self):
        return self.content
    
    def update_camera(self):
        self.location_mode = RandomElement(self.location_mode_list)
        self.camera_mode = RandomElement(self.camera_mode_list)
        self.camera_mode.UpdateRelative(self.location_mode.start_pos[0])
    
    def get_str(self, camera, t0, t1):
        the_str = ""
        for i in range(len(self.actors)):
            sp = self.location_mode.start_pos[i]
            ep = self.location_mode.end_pos[i]
            sl = self.location_mode.start_look[i]
            el = self.location_mode.end_look[i]
            the_str += "[" + str(self.actors[i]) + "] [" + str(self.anim[i]) + "] " + str(sp) + " " + str(ep) + " " + str(sl) + " " + str(el) + "\n"
            
        if camera == True:
            the_str += self.camera_mode.get_str(t0, t1)
        return the_str
        
player = "i"
friend = "friend"



spawn_begin = [Sentence("", [player], ["was"], location_one_at, spawn_camera)]

# 位置一样吗？
spawn_i = [Sentence("on day one I spawned in as a baby _ame inside of the underwater coral reefs", [player,"effect"], ["spawn","spawn"], location_one_at, camera_talk), 
      Sentence("on day one I spawned as a baby _ame ", [player], ["spawn"], location_one_at, camera_talk)]



spawn_talk = [Sentence("my little boy look at you. welcome to your new home", [friend,player], ["talk","talk"], location_two_at, camera_spawn)]

map_travel = [Sentence("_i was heading back to _my base teleporting through the world", ["i"], ["walk"], location_one_at, spawn_camera)]
map_i_arrive = [Sentence("_i found _myself in a large Village", [player], ["was"], location_one_at, spawn_camera),
               Sentence("I arrived at a large Coastal Village", [player], ["was"], location_one_at, spawn_camera),
               Sentence("I was traveling toward the pirate base", [player], ["was"], location_one_at, spawn_camera),
               Sentence("I was traveling toward the pirate base", [player], ["was"], location_one_at, spawn_camera)]
map_i_found = [Sentence("_i spotted a pirate ship nearby and knew that it must be the doing of _thehe and _his men", ["i"], ["walk_around"], location_one_at, camera_talk),
               Sentence("when _i spotted a village, this one looked as though it was starting to flood as well ", ["i"], ["walk_around"], location_one_at, camera_talk),
               Sentence("and saw that it was swarming with _thehe ", ["i"], ["walk_around"], location_one_at, camera_talk)]
map_i_confused = [Sentence("_i looked around the village and things seemed to be different about this world", [player], ["look"], location_one_at, camera_talk)]
talk_friend_superised_happy = [Sentence("_theme is real. we will it be saved", [friend], ["talk"], location_one_at, camera_talk)]
build_find_wool = [Sentence("once I was finished I found a group of sheep and defeated them together Wool", ["i","sheep"], ["kill","dead"], location_two_at, camera_talk)]
build_bed = [Sentence("with the wool I crafted a bed to sleep in", ["i","bed"], ["build","done"], location_two_at, spawn_camera)]
map_noise_in_distance = [Sentence("I was about to go to sleep for the night when I heard screams in the distance", [player], ["heard"], location_one_at, spawn_camera),
                         Sentence("I heard loud howling going off in the distance"),
                         Sentence(" I heard a strange noise from inside the cave"),
                         ]
map_i_search_noise = [Sentence("oh no I need to go and see what's happening", [player], ["talk"], location_one_at, spawn_camera),
                      Sentence("and I began a search to investigate it")]    

talk_hello = [Sentence("I found a strange Enderman creature"),
              
              ]

talk_hello_talk_first = [Sentence("hey who Are You")]
talk_hello_talk_first = [Sentence("hey who Are You")]
talk_hello_talk_first = [Sentence("hey who Are You")]
talk_hello_talk_first = [Sentence("hey who Are You")]

map_drop_map = [Sentence("one of _thehe dropped a map. it looked like the coordinates to the pirate base", ["_map", player], ["drop","walk"], location_actor_take_item, camera_return)] 
map_drop_map_talk = [Sentence("this should come in handy", ["i"], ["take_item"], location_one_at, camera_talk)]
fight_success_cheer = [Sentence("_theme started to cheer for _him and say _thehe was real", [friend], ["cheer"], location_one_at, camera_talk)]

talk_enemy_inner = [Sentence("on top of the ship _i saw _thehe speaking to some of the Pirates and _he was giving them orders _he must find _theme", ["boss","enemy1"], ["talk","talk"], location_one_at, spawn_camera)]

map_report_strong = [Sentence("_i returned to _thehe to show _him _my new upgrades _i was already starting to feel stronger", ["i",friend], ["return","wait"], location_return, camera_return)]
map_sneak = [Sentence("_i used my teleportation abilities to sneak past _him and remain undetected", ["i","enemy"],["sneak","wait"], location_return, camera_return)]
talk_friend_encourge = [Sentence(("_theme assure _him that _he will be able to in time"), [friend, player], ["desc_talk","desc_talk"], location_two_at, camera_talk)]
talk_friend_encourge_talk = [Sentence(("you have a long way to go but you are on your way"), [friend, player], ["talk","talk"], location_two_at, camera_talk)]

attacker = "enemy"
fight_attack = [Sentence(" _i begin to shoot out very powerful fire blasts" , ["enemy"], ["attack"]),
      Sentence(" _i had control over the plant life around _me and would trap _him in place", [attacker], ["attack"]),
      Sentence(" _i would use _my lava to cut _him off from reaching _him ", [attacker], ["attack"]),
      Sentence(" _i came in again and slashed _him so hard", [attacker], ["attack"]),
      Sentence(" _i angrily began to attack _him ", [attacker], ["attack"]),
      Sentence(" _i they kept trying to fight _him ", [attacker], ["attack"]),
      Sentence(" _i ran in and started to fend _him off", [attacker], ["attack"]),
      Sentence("that's when  _i noticed a new ability in _my inventory a diamond slash. _i use it on _him", [attacker], ["attack"]),
      Sentence("_i then used a special ability on _me which summoned void spikes from above", [attacker], ["attack"]),
      Sentence("_i even sent out Undead beasts to outnumber _him", ["beast","beast"],["chase", "chase"]),
      Sentence("_he rushed at me and bashed _me with _his claws ouch")
      ] 

fight_i_begin_fight = [Sentence("I began a fight with him using everything I had")]

talk_enemy_threaten = [Sentence("time to die" , ["enemy"], ["talk"], location_one_at, camera_talk),
      Sentence("don`t let him go away" , ["enemy"], ["talk"], location_one_at, camera_talk),
      Sentence("you just don't know when to quit. do you? ", ["enemy"], ["talk"], location_one_at, camera_talk),
      Sentence("I'll squash you like a bug", ["enemy"], ["talk"], location_one_at, camera_talk),
      Sentence("you are not going anywhere", ["enemy"], ["talk"], location_one_at, camera_talk),
      Sentence("you are not going anywhere", ["enemy"], ["talk"], location_one_at, camera_talk),
      Sentence("the boss going to love this new prize we found", ["enemy"], ["talk"], location_one_at, camera_talk),
      Sentence("our conquest for overworld has offically began", ["enemy"], ["talk"], location_one_at, camera_talk),
      ]

i_was_hurt = [
      Sentence("I wanted to fight back but the poison was extremely lethal towards me" , [player], ["desc"]),
            Sentence("I had half a heart and was dodging each of its things left and right", [player], ["desc"]),
            Sentence("I was getting extremely low", [player], ["desc"]),
            Sentence("I was knocked down to only one heart", [player], ["desc"]),
            Sentence("as soon as they hit I was blinded ah", [player], ["desc"]),
            Sentence("I thought I was surely done for", [player], ["desc"])
      ]

fight_final = [Sentence("before _he could slash at _me again _i blasted _him One Last Time finally taking _him down for good" , [player], ["attack"]),
      Sentence("with one more attack _i successfully took _him down", [attacker], ["attack"])
      ]

fight_enemy_chase = [Sentence("his base must be this way then",["boss"],["look_around"],location_look_around, camera_talk)]
            
fight_enemy_charge = [Sentence("charging in entered a _thehe.", [attacker], ["charge_in"], location_charge, charge_in_camera),
      Sentence("I was facing of against the _thehe.", [attacker], ["charge_in"], location_charge, charge_in_camera),
      Sentence("just then the _thehe." + " dropped down in front of me", [attacker], ["charge_in"], location_charge, charge_in_camera),
      Sentence("_thehe rushed in and we began to fight ", [attacker], ["charge_in"], location_charge, charge_in_camera),
      Sentence("I looked up and saw that _thehe." + " was charging towards me ", [attacker], ["charge_in"], location_charge, charge_in_camera),
      Sentence("shortly followed by a bunch of _thehe. they immediately started to run through our kingdom and kill my people", [attacker], ["charge_in"], location_charge, charge_in_camera)
      ]

desc_enemy = [Sentence(attacker + " were way stronger than my people and could took them out with ease" , [attacker, "sbone"], ["attack","dead"]),
      Sentence("even though _thehe." + " was a old man, he was tough", [attacker, "sbone"], ["attack","dead"]),
      Sentence(attacker + "`s massive size and speed were far greater than me", [attacker, "sbone"], ["attack","dead"]),
      Sentence(attacker + " had deadly poisonous gas in his aresnel ", [attacker, "sbone"], ["attack","dead"]),
      Sentence( attacker + " have the brute strength of nothing everyone had ever faced before ", [attacker, "sbone"], ["attack","dead"]),
      Sentence("he had Incredible strength and abilities", [attacker, "sbone"], ["attack","dead"]),
      Sentence("I could tell with my increased strength I was putting up more of a fight")
      ]



talk_i = [
      Sentence("Stay Away" , [player], ["talk"]),
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

map_cave = [Sentence("I headed into a nearby cave to search for any oars to craft myself some upgrades with", ["i"], ["walk"], location_two_at, camera_talk)]
map_wrong = [Sentence("I realize that something was wrong", ["i"], ["walk"], location_two_at, camera_talk)]

talk_friend_sad = [Sentence("without the Elder there is surely no hope in winning this War" , [friend], ["talk"])]
talk_friend_thank = [Sentence("Thanks for saving me, my name is " + friend, [friend], ["talk"]),
                     Sentence("you did it", [friend], ["talk"])]
talk_friend_mission = [Sentence("my family and I were separated from the war and I don't have a home" , [friend], ["talk"]),
                       Sentence("correct. each time it holds a different trial to overcome. find the rest of the Four Diamonds, the sun Diamond, the tiger's eye diamond, the sky diamond, and the Heart of the Jungle Diamond. as a spirit, I reside here. and will help you through your journey. well done Soyo", [friend], ["talk"]),
                       Sentence("this will take you to the first of five special Diamonds, the saber diamond. for each one you collect, the closer you will come to stopping the wolf Nation, do it for me, and end this war" , [friend], ["talk"]),
                       Sentence("there is said to be five Warden scales in total each dropped down from past Ward and snake Warriors", [friend], ["talk"]),
                       Sentence("my son. you are very special. when it is time you shall be the one who takes the throne.", [friend], ["talk"])
                       ]# 其实没法判断是谁talk的
talk_treasure = [Sentence("not just any scale a warden scale", ["scale"], ["talk"])] # 这句有问题
fight_noeffect = [Sentence("_i tried to fight back but _my hits weren't doing anything", [player], ["attack"])]
walk_search = [Sentence("I left the cave knowing I had to find the treasure", [player], ["walk"]),
               Sentence("I hesitantly searched through the jungle", [player], ["walk"])]
walk_wired = [Sentence("I heard loud howling going off in the distance", [player], ["heard"])] # 这个话的主语不是 i
walk_takecover = [Sentence("as we were running we came across a waterfall an idea then sparked Within Me causing both peanut and I to go through it as a form of cover", [player], ["run"])]

fight_runaway = [Sentence("_i was running through the forest fast with _him getting closer", [player], ["run_away"])]
walk_new_thing = [Sentence("what is that i ran over only to see _theme being attacked by _thehe", [friend, attacker], ["attack", "be_attacked"])]

walk_treasure = [Sentence("and far off on the other side of it was a scale ", ["scale"], ["object"])]
walk_treasure_pick = [Sentence("I did as ordered and went forward to pick it up", [player], ["pick"])]
misc_growth = [Sentence("because of my victory I grew into an adult-sized tiger I even gained five more Hearts", [player], ["grow"]),
               Sentence("because of this my body began to change I gained five more hearts and turned into a larger Warden snake I even have little Warden antlers ", [player], ["grow"])]
fight_friend_fight = [Sentence("but " + friend + " stepped in the way and started to fight it off", [friend], ["attack"])]
fight_friend_talk = [Sentence("leave, now! i love you", [friend], ["talk"])]
fight_friend_dead = [Sentence("I watched as _thehe." + " killed " + friend, [attacker, friend], ["attack", "dead"])]
fight_falldown = [Sentence("because of this I accidentally fell down a deep pit", [player], ["fall down"])]

friend_ask = [Sentence("I made my way around it and try to ask the villagers what was going on, on one of them spotted me and said", [player], ["talk"])]
friend_thank = [Sentence("the diamond Enderman is real. will it be saved", [friend], ["talk"])]
talk_friend_thank_confused = [Sentence(" save you what's going on how am I supposed to save you", [player], ["talk"])]


global_status_name = []
global_status = []    

camera_start_time = 0
camera_end_time = 0
speech = TextToSpeech()

class Scene:
    def __init__(self, sentences, possible, need_name, need_status, make_name, make_status):
        self.sentences = sentences
        self.possible = possible
        self.need_name = need_name
        self.need_status = need_status
        self.make_name = make_name
        self.make_status = make_status
        
    def check(self):
        # 必须全部找到，然后状态相符
        for i in range(len(self.need_name)):
            local_ok = False
            for j in range(len(global_status_name)):
                if self.need_name[i] == global_status_name[j]:
                    if self.need_status[i] == global_status[j]:
                        local_ok = True
                    break
            if local_ok == False:
                return False
        return True
            
        
    def updateStatus(self):
        for i in range(len(self.make_name)):
            local_ok = False
            for j in range(len(global_status_name)):
                if self.make_name[i] == global_status_name[j]:
                    global_status[j] = self.make_status[i]
                    local_ok = True
                    break
            if local_ok == False:
                global_status_name.append(self.make_name[i])
                global_status.append(self.make_status[i])
        
    def grow(self):
        global camera_start_time, camera_end_time, speech
        the_str_camera = ""
        the_str = ""
        the_content = []
        main_enemy = True
        for i in range(len(self.sentences)):
            r = random.random()
            if r > self.possible[i]:
                continue
            s = RandomElement(self.sentences[i])
            if self.sentences[i] == fight_attack:
                if main_enemy == True:
                    s.UpdateActor(1,0)
                else:
                    s.UpdateActor(0, 1)
                main_enemy = ~main_enemy
            else:
                s.UpdateActor(0, 1)
                
            sentences = s.content.split(".")
            sentences = [s.strip() for s in sentences if s.strip()]
            
            for ss in sentences:
                print(ss)
                newss = Sentence(ss,s.actors,s.anim,s.location_mode_list,s.camera_mode_list)
                newss.update_camera()
                duration = 1000 # speech.save_audio(s.content)
                camera_end_time = camera_start_time + duration
                the_str_camera += newss.get_str(True, camera_start_time, camera_end_time)
                the_str += newss.get_str(False, camera_start_time, camera_end_time)
                camera_start_time = camera_end_time
        return [the_str_camera, the_str, the_content]
            
                
    
all_scene = [Scene([spawn_begin], [1,1], [],[],["begin2"],[True]),
             Scene([map_i_arrive, map_i_found, map_i_confused], [1,0.5,1], ["begin"], [True], ["i_confused","arrive_new_place"], [True, True]),
             Scene([talk_friend_superised_happy], [1,1], ["arrive_new_place"], [True],["happen_build"],[True]),
             Scene([build_find_wool, build_bed], [1,1], ["happen_build"], [True],["happen_noise"],[True]),
             Scene([map_noise_in_distance, map_i_search_noise], [1,1], ["happen_noise"], [True],[],[]),
             Scene([map_drop_map, map_drop_map_talk], [1,1], ["begin"], [True],[],[]),
             Scene([map_report_strong,talk_friend_encourge,talk_friend_encourge_talk],[1,1,1],["begin2"], [True],[],[])
             ]

all_scene = [Scene([spawn_begin], [1,1], [],[],["begin2"],[True]),
             Scene([], 
                   [1,0.5,1,1,1,1,1], ["begin2"],[True],[],[])]

all_scene = [Scene([spawn_begin], [1,1], [],[],["begin2"],[True]),
             Scene([spawn_i, spawn_talk], 
                   [1,1], ["begin2"],[True],[],[]),
            Scene([fight_enemy_charge, talk_enemy_threaten, 
                   desc_enemy, fight_attack, 
                   fight_i_begin_fight, fight_attack, 
                   talk_i, fight_attack, i_was_hurt, 
                   fight_runaway, fight_enemy_chase], 
                  [1,1,1,0.5,1,1,1,1,1,1,1], ["begin2"],[True],[],[])]

# genereate Battle

has_friend = True
my_final_status = "run_away"
friend_final_status = "dead"


current_scene = all_scene[0]
current_scene.updateStatus()
the_str_camera = ""
the_str = ""
total_content = []
for i in range(len(all_scene)):
    if i > 0:
        if all_scene[i].check():
            
            all_scene[i].updateStatus()
            s = all_scene[i].grow()
            the_str_camera += s[0]
            the_str += s[1]
            for r in s[2]:
                total_content.append(r)

print(the_str)



    
with open("D:/output.txt", "w", encoding="utf-8") as file:
    file.write(the_str_camera)
