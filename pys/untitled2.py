# 光流追踪
# 光流追踪的前提是：1. 对象的像素强度在连续帧之间不会改变；2. 相邻像素具有相似的运动。
# - cv2.goodFeaturesToTrack() 确定要追踪的特征点
# - cv2.calcOpticalFlowPyrLK() 追踪视频中的特征点

# 取第一帧，检测其中的一些 Shi-Tomasi 角点，使用 Lucas-Kanade 光流迭代跟踪这些点。
# 对于函数 cv2.calcOpticalFlowPyrLK() 传递前一帧、前一个点和下一帧。它返回下一个点以及一些状态编号，如果找到下一个点，则值为 1，否则为零。
# 然后在下一步中迭代地将这些下一个点作为前一个点传递。

# USAGE
# python video_optical_flow.py

import imutils
import numpy as np
import cv2

cap = cv2.VideoCapture('monster1.mp4')

# ShiTomasi角点检测的参数
feature_params = dict(maxCorners=100,
                      qualityLevel=0.3,
                      minDistance=7,
                      blockSize=7)

# Lucas Kanada光流检测的参数
lk_params = dict(winSize=(15, 15),
                 maxLevel=2,
                 criteria=(cv2.TERM_CRITERIA_EPS | cv2.TERM_CRITERIA_COUNT, 10, 0.03))

# 构建随机颜色
color = np.random.randint(0, 255, (100, 3))

# 获取第一帧并发现角点
ret, old_frame = cap.read()
old_gray = cv2.cvtColor(old_frame, cv2.COLOR_BGR2GRAY)
p0 = cv2.goodFeaturesToTrack(old_gray, mask=None, **feature_params)

# 为绘制光流追踪图，构建一个Mask
mask = np.zeros_like(old_frame)

num = 0
while (1):
    ret, frame = cap.read()

    if not ret:
        break

    frame_gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # 使用迭代Lucas Kanade方法计算稀疏特征集的光流
    # - old_gray: 上一帧单通道灰度图
    # - frame_gray: 下一帧单通道灰度图
    # - prePts：p0上一帧坐标pts
    # - nextPts: None
    # - winSize: 每个金字塔级别上搜索窗口的大小
    # - maxLevel: 最大金字塔层数
    # - criteria：指定迭代搜索算法的终止条件，在指定的最大迭代次数criteria.maxCount之后或搜索窗口移动小于criteria.epsilon
    p1, st, err = cv2.calcOpticalFlowPyrLK(old_gray, frame_gray, p0, None, **lk_params)

    # 选择轨迹点
    good_new = p1[st == 1]
    good_old = p0[st == 1]

    # 绘制轨迹
    for i, (new, old) in enumerate(zip(good_new, good_old)):
        a, b = int(new[0]), int(new[1])
        c, d = int(old[0]), int(old[1])
        mask = cv2.line(mask, (a, b), (c, d), color[i].tolist(), 2)
        frame = cv2.circle(frame, (a, b), 5, color[i].tolist(), -1)
    img = cv2.add(frame, mask)

    cv2.imshow('frame', img)
    cv2.imwrite('videoof-imgs/' + str(num) + '.jpg', imutils.resize(img, 500))
    print(str(num))
    num = num + 1
    k = cv2.waitKey(30) & 0xff
    if k == 27:
        break

    # 更新之前的帧和点
    old_gray = frame_gray.copy()
    p0 = good_new.reshape(-1, 1, 2)

cv2.destroyAllWindows()
cap.release()
