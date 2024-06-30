'''
After you've set your subscription key, run this application from your working
directory with this command: python TTSSample.py
'''
import os, requests, time
from xml.etree import ElementTree
import wave
# This code is required for Python 2.7
try: input = raw_input
except NameError: pass
from datetime import datetime
'''
If you prefer, you can hardcode your subscription key as a string and remove
the provided conditional statement. However, we do recommend using environment
variables to secure your subscription keys. The environment variable is
set to SPEECH_SERVICE_KEY in our sample.

For example:
subscription_key = "Your-Key-Goes-Here"
'''


    # print('Environment variable for your subscription key is not set.')
    # exit()

class TextToSpeech(object):
    def __init__(self):
        if 'SPEECH_SERVICE_KEY' in os.environ:
            subscription_key = os.environ['SPEECH_SERVICE_KEY']
        else:
            subscription_key = "412aa3b510054e959968d5ea4459e829"
        self.subscription_key = subscription_key
        self.timestr = time.strftime("%Y%m%d-%H%M")
        self.index = 0
        fetch_token_url = "https://japaneast.api.cognitive.microsoft.com/sts/v1.0/issuetoken"
        headers = {
            'Ocp-Apim-Subscription-Key': self.subscription_key
        }
        response = requests.post(fetch_token_url, headers=headers)
        self.access_token = str(response.text)
        

    def save_audio(self, tts):
        self.index += 1
        # japaneast 换成自己的区域节点
        base_url = 'https://japaneast.tts.speech.microsoft.com/'
        path = 'cognitiveservices/v1'
        constructed_url = base_url + path
        headers = {
            'Authorization': 'Bearer ' + self.access_token,
            'Content-Type': 'application/ssml+xml',
            'X-Microsoft-OutputFormat': 'riff-24khz-16bit-mono-pcm',
            'User-Agent': 'YOUR_RESOURCE_NAME'
        }
        xml_body = ElementTree.Element('speak', version='1.0')
        xml_body.set('{http://www.w3.org/XML/1998/namespace}lang', 'en-us')
        voice = ElementTree.SubElement(xml_body, 'voice')
        voice.set('{http://www.w3.org/XML/1998/namespace}lang', 'en-US')
        # zh-CN-YunyeNeural、zh-CN-YunxiNeural 是使用什么声音输出，可以看代码最后一行app.get_voices_list()获取节点支持的语音输出类型，填ShortName
        # voice.set('name', 'zh-CN-YunyeNeural') # Short name for 'Microsoft Server Speech Text to Speech Voice (en-US, Guy24KRUS)'
        voice.set('name', 'en-US-RogerNeural') # Short name for 'Microsoft Server Speech Text to Speech Voice (en-US, Guy24KRUS)'
        voice.text = tts
        body = ElementTree.tostring(xml_body)

        response = requests.post(constructed_url, headers=headers, data=body)
        '''
        If a success response is returned, then the binary audio is written
        to file in your working directory. It is prefaced by sample and
        includes the date.
        '''
        if response.status_code == 200:
            
            
            audeo_file_path = 'index_' + str(self.index) + '.wav'
            
            with open(audeo_file_path, 'wb') as audio:
                audio.write(response.content)
                time_obj = datetime.strptime(str(response.elapsed), "%H:%M:%S.%f")
                milliseconds = (time_obj.hour * 3600 + time_obj.minute * 60 + time_obj.second) * 1000 + time_obj.microsecond / 1000
                return milliseconds
        else:
            print("\nStatus code: " + str(response.status_code) + "\nSomething went wrong. Check your subscription key and headers.\n")
            print("Reason: " + str(response.reason) + "\n")
        return 0

    def get_voices_list(self):
        # japaneast 换成自己的区域节点        
        base_url = 'https://japaneast.tts.speech.microsoft.com/'
        path = 'cognitiveservices/voices/list'
        constructed_url = base_url + path
        headers = {
            'Authorization': 'Bearer ' + self.access_token,
        }
        response = requests.get(constructed_url, headers=headers)
        if response.status_code == 200:
            print("\nAvailable voices: \n" + response.text)
            # 文件路径，可以是相对路径或绝对路径
            file_path = 'example.txt'
            
            # 使用'w'模式打开文件，如果文件不存在则创建，如果文件已存在则覆盖原有内容
            with open(file_path, 'w', encoding='utf-8') as file:
                file.write(response.text)
        else:
            print("\nStatus code: " + str(response.status_code) + "\nSomething went wrong. Check your subscription key and headers.\n")


if __name__ == "__main__":
    app = TextToSpeech()
    app.save_audio("my son, you are very speical")
    # Get a list of voices https://docs.microsoft.com/en-us/azure/cognitive-services/speech-service/rest-text-to-speech#get-a-list-of-voices
    # 查看节点支持的语言类型
    # app.get_voices_list()