import cv2
import pytesseract

# 第一步： 识别图片

# 配置 Tesseract 的路径（如果需要）
pytesseract.pytesseract.tesseract_cmd = r'D:\software\blueeye\tesseract.exe'

def get_text_and_positions(image_path, show):
    # 读取图像
    image = cv2.imread(image_path)
    
    # 转换为灰度图像
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    
    # 使用 Tesseract OCR 识别图像中的文字
    custom_config = r'--oem 3 --psm 6'
    data = pytesseract.image_to_data(gray, config=custom_config, output_type=pytesseract.Output.DICT)
    
    n_boxes = len(data['level'])
    for i in range(n_boxes):
        (x, y, w, h) = (data['left'][i], data['top'][i], data['width'][i], data['height'][i])
        text = data['text'][i]
        if text.strip() != "":
            # 在图像上绘制矩形框和文字
            cv2.rectangle(image, (x, y), (x + w, y + h), (0, 255, 0), 2)
            cv2.putText(image, text, (x, y - 10), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 255, 0), 2)

    # 显示图像
    if show:
        cv2.imshow('Image with Detected Text', image)
        cv2.waitKey(0)
        cv2.destroyAllWindows()

    # 返回识别的文字和位置信息
    return data


        

