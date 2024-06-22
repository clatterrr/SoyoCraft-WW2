import ffmpeg as ffmpeg
import os

def extract_frame(video_path, output_path_first, output_path_last_40):
    # 使用 ffmpeg 读取视频文件信息
    probe = ffmpeg.probe(video_path)
    video_info = next(s for s in probe['streams'] if s['codec_type'] == 'video')
    frame_rate = eval(video_info['r_frame_rate'])
    frame_count = int(video_info['nb_frames'])
    
    # 计算视频总时长和倒数第40帧的时间位置
    duration = float(video_info['duration'])
    last_40_frame_time = max(0, duration - 2.0)
    
    # 删除原来的图片（如果存在）
    if os.path.exists(output_path_first):
        os.remove(output_path_first)
    if os.path.exists(output_path_last_40):
        os.remove(output_path_last_40)
    
    # 截取视频的第一帧
    ffmpeg.input(video_path, ss=0.2).output(output_path_first, vframes=1).run()
    
    # 截取视频倒数第40帧
    ffmpeg.input(video_path, ss=last_40_frame_time).output(output_path_last_40, vframes=1).run()
# 循环遍历视频文件
for i in range(1, 5):
    # 视频文件路径
    video_path = f"E://robo//robo-{i}.mp4"
    # 输出三分之一长度处画面的路径
    output_path = f"fr{i}_1.jpg"
    output_path2 = f"fr{i}_2.jpg"
    
    # 提取三分之一长度处的画面
    extract_frame(video_path, output_path, output_path2)  # 这里传入1是示例，实际应根据需求调整
    