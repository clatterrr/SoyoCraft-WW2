# -*- coding: utf-8 -*-
"""
Created on Tue Jul  2 23:28:57 2024

@author: 16143
"""

import random
from VoicGenerator import TextToSpeech

speech = TextToSpeech()
time = []
with open("D://sentences.txt", 'r', encoding='utf-8') as file:
            # 逐行读取文件内容并输出
            for line in file:
                dur = speech.save_audio(line.strip())
                time.append(dur)
                
thestr = ""
for t in time:
    thestr += str(t) + "\n"
    
with open("D://sentences_time.txt", 'w', encoding='utf-8') as file:
            # 写入字符串内容
            file.write(thestr)
            
            
# 问chatgpt 这句话中实体有啥

'''


"我在街上走路"，实体为“我”，动作为“走路”。输出json是"{实体：我} {动作：走路}"。“我在餐厅吃饭”。实体是什么？动作是什么？输出对应的json

然后有mootion 生成动作


'''