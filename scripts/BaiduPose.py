import base64
import urllib
import requests
import json

def pose_detect(image_path):
        
    url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/body_analysis?access_token=" + get_access_token()
    
    # image 可以通过 get_file_content_as_base64("C:\fakepath\ttu.jpg",True) 方法获取
    image = get_file_content_as_base64("D:/bus.jpg", True)
    payload='image=' + str(image)
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Accept': 'application/json'
    }
    
    response = requests.request("POST", url, headers=headers, data=payload)
    
    # 解析JSON数据
    data = json.loads(response.text)
    
    
    
    # 访问第一个person_info中的body_parts，然后读取nose的x值
    person_num = data['person_num']
    for i in range(person_num):
        nose_x = data['person_info'][0]['body_parts']['nose']['x']
        left_eye_x = data['person_info'][0]['body_parts']['left_eye']['x']
        right_eye_x = data['person_info'][0]['body_parts']['right_eye']['x']
        d0 = abs(nose_x - left_eye_x)
        d1 = abs(nose_x - right_eye_x)
        v = d0 / d1
        if v < 1.1 and v > 0.9:
            print('center')
        elif v >= 1.1:
            print('right')
        else:
            print('left')
            
    

def get_file_content_as_base64(path, urlencoded=False):
    """
    获取文件base64编码
    :param path: 文件路径
    :param urlencoded: 是否对结果进行urlencoded 
    :return: base64编码信息
    """
    with open(path, "rb") as f:
        content = base64.b64encode(f.read()).decode("utf8")
        if urlencoded:
            content = urllib.parse.quote_plus(content)
    return content

def get_access_token():
    """
    使用 AK，SK 生成鉴权签名（Access Token）
    :return: access_token，或是None(如果错误)
    """
    url = "https://aip.baidubce.com/oauth/2.0/token"
    params = {"grant_type": "client_credentials", "client_id": "nxXlSfT6fMvKHkdDxcxhYj84", "client_secret": "FVWkuyhDu42YnOjOEMoJbjwsIdfQb8p1"}
    return str(requests.post(url, params=params).json().get("access_token"))

if __name__ == '__main__':
    main()
