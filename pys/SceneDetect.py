from scenedetect import VideoManager, SceneManager
from scenedetect.stats_manager import StatsManager
from scenedetect.detectors import ContentDetector
from moviepy.video.io.ffmpeg_tools import ffmpeg_extract_subclip
import cv2
import os

def save_frame(video_path, frame_num, output_path):
    cap = cv2.VideoCapture(video_path)
    cap.set(cv2.CAP_PROP_POS_FRAMES, frame_num)
    ret, frame = cap.read()
    if ret:
        cv2.imwrite(output_path, frame)
    cap.release()

def find_scenes_and_save_clips(video_path, output_dir):
    # Create the output directory if it doesn't exist
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    # Initialize video manager, stats manager, and scene manager
    video_manager = VideoManager([video_path])
    stats_manager = StatsManager()
    scene_manager = SceneManager(stats_manager)

    # Add content detector
    scene_manager.add_detector(ContentDetector())
    
    scene_num = 0

    try:
        video_manager.set_downscale_factor()
        video_manager.start()

        # Detect scenes
        scene_manager.detect_scenes(frame_source=video_manager)

        # Get list of detected scenes
        scene_list = scene_manager.get_scene_list()

        print('List of scenes obtained:')
        frame_str = ""
        for i, scene in enumerate(scene_list):
            scene_num += 1
            start_time = scene[0].get_seconds()
            end_time = scene[1].get_seconds()
            start_frame = scene[0].get_frames()
            end_frame = scene[1].get_frames()
            scene_length = end_frame - start_frame
            print(f'Scene {i + 1}: Start {scene[0].get_timecode()} / Frame {scene[0].get_frames()}, End {scene[1].get_timecode()} / Frame {scene[1].get_frames()}')
            frame_str += f'Scene {i + 1}: {scene[0].get_frames()} {scene[1].get_frames()}\n'
            

            # # Define the output filename for the scene
            # output_filename = os.path.join(output_dir, f'scene_{i + 1}.mp4')

            # # Use moviepy to extract and save the scene as a separate video file
            # ffmpeg_extract_subclip(video_path, start_time, end_time, targetname=output_filename)
            # print(f'Scene {i + 1} saved as {output_filename}')
            
            if scene_length < 20:
                first_frame_path = os.path.join(output_dir, f'scene_{i + 1:03}_1.jpg')
                last_frame_path = os.path.join(output_dir, f'scene_{i + 1:03}_2.jpg')
                save_frame(video_path, start_frame, first_frame_path)
                save_frame(video_path, end_frame - 1, last_frame_path)
                # print(f'Scene {i + 1}: Saved first frame as {first_frame_path} and last frame as {last_frame_path}')
            else:
                fifth_frame_path = os.path.join(output_dir, f'scene_{i + 1:03}_1.jpg')
                fifth_last_frame_path = os.path.join(output_dir, f'scene_{i + 1:03}_2.jpg')
                save_frame(video_path, start_frame + 4, fifth_frame_path)
                save_frame(video_path, end_frame - 5, fifth_last_frame_path)
                # print(f'Scene {i + 1}: Saved 5th frame as {fifth_frame_path} and 5th last frame as {fifth_last_frame_path}')
                
        with open("scene_info.txt", "w") as file:
            file.write(frame_str)

    finally:
        video_manager.release()
        
    return scene_num

if __name__ == '__main__':
    find_scenes_and_save_clips('E://robo//tt.mp4', "E://robo")