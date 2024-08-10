# -*- coding: utf-8 -*-
"""
Created on Tue Jul  2 23:28:57 2024

@author: 16143
"""
import wave
import random
from VoicGenerator import TextToSpeech
from pydub import AudioSegment

def get_audio_length(file_path):
    # 打开音频文件
    with wave.open(file_path, 'rb') as audio_file:
        # 获取音频文件的帧数
        num_frames = audio_file.getnframes()
        # 获取音频文件的帧率（帧数/秒）
        frame_rate = audio_file.getframerate()
        # 计算音频文件的长度（秒）
        audio_length = num_frames / frame_rate
        return round(audio_length, 2)

def contains_letter(s):
    return any(char.isalpha() for char in s)

line_count = 0
speech = TextToSpeech()
time = []
with open("D://sentences.txt", 'r', encoding='utf-8') as file:
            # 逐行读取文件内容并输出
            for line in file:
                
                if contains_letter(line):
                    speech.save_audio(line.strip())
                    line_count += 1
                else:
                    time.append(float(line)  * 20)
                
                
                


all_audio = AudioSegment.silent(1000)
for t in range(1, line_count + 1):
    audio_file_name = "index_" + str(t) + ".wav"
    audio = AudioSegment.from_file(audio_file_name)
    current_duration = len(audio)  # 当前音频的时长
    required_duration = time[t - 1]  # 10秒，单位是毫秒
    if current_duration < required_duration:
        # 计算需要补充的空白时长
        silence_duration = required_duration - current_duration
        silence = AudioSegment.silent(duration=silence_duration)
        
        # 将音频和空白合并
        all_audio = all_audio + audio + silence
    else:
        # 如果音频已经超过或等于10秒，截取前10秒
        all_audio = all_audio + audio[:required_duration]
        
all_audio.export("all_audio.mp3", format="mp3")

    
    
            
            
# 问chatgpt 这句话中实体有啥

'''


"我在街上走路"，实体为“我”，动作为“走路”。输出json是"{实体：我} {动作：走路}"。“我在餐厅吃饭”。实体是什么？动作是什么？输出对应的json

然后有mootion 生成动作


'''