import SceneDetect
import os
from EditImage import ImageAnnotator
'''

Monster School 制作流程

第一步：将视频拆分为视频场景
第二步：每个视频场景拆分为前后两个图片
第三步：对图片进行人体姿态估计，可以计算出人的旋转角度
第四步：根据人物检测框，可以知道人离摄像机多远，以及如何旋转的
第五步：如果没有检测到的，手动补充，需要画图画点，以及指定旋转方向。
        可以用三个点完成，下两个点是头顶和嘴巴。最上面的订单指定方向
        比较难的是如何快速补全，删除，以及寻找对应关系
第六步：生成csv文件，进行检测，同时推断人物运动的起止位置
第七步：在Unity 生成，只有不动，步行两种方式
 以后改成 Google 的 https://research.google/blog/on-device-real-time-body-pose-tracking-with-mediapipe-blazepose/

'''

image_path = "E://robo"

scene_len =  SceneDetect.find_scenes_and_save_clips('E://robo//tt.mp4', image_path)

print(" save all images OK")

image_files = []
for i in range(10):
    image_files.append(f'scene_{i + 1:03}_1.jpg')
    image_files.append(f'scene_{i + 1:03}_2.jpg')
    
# 使用示例
annotator = ImageAnnotator(image_path, image_files)