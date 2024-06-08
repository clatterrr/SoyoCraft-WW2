import os
from PIL import Image, ImageTk, ImageDraw
import tkinter as tk

class ImageAnnotator:
    def __init__(self, image_path, image_files):
        self.image_files = image_files
        self.image_path = image_path
        self.image_index = 0
        self.click_positions = []  # Each entry will be a tuple: (x, y, color)
        self.original_pixels = {}
        self.root = tk.Tk()
        self.canvas = tk.Canvas(self.root, width=1920, height=1080)
        self.canvas.pack()
        self.canvas.bind("<Button-1>", self.on_click_red)
        self.canvas.bind("<Button-3>", self.on_click_green)
        self.root.bind('<c>', self.clear_points)
        self.root.bind('<space>', lambda event: (self.save_clicks_to_file(), self.next_image()))
        self.show_image()
        self.root.mainloop()

    def on_click_red(self, event):
        self.on_click(event, 'red')

    def on_click_green(self, event):
        self.on_click(event, 'green')

    def on_click(self, event, color):
        x, y = event.x, event.y
        self.click_positions.append((x, y, color))
        self.original_pixels[(x, y)] = self.image.getpixel((x, y))
        self.draw_ellipse(x, y, color)

    def draw_ellipse(self, x, y, color):
        draw = ImageDraw.Draw(self.image)
        draw.ellipse((x - 4, y - 4, x + 4, y + 4), fill=color, outline=None)
        photo = ImageTk.PhotoImage(self.image)
        self.canvas.create_image(0, 0, image=photo, anchor='nw')
        self.canvas.img = photo

    def save_clicks_to_file(self):
        image_filename = os.path.basename(self.image_files[self.image_index])
        filename = f"ClickPos//click_positions_{os.path.splitext(image_filename)[0]}.txt"
        
        with open(filename, 'w') as file:
            for x, y, color in self.click_positions:
                file.write(f'{x},{y},{color}\n')
        print(f"Click positions saved to {filename}")

    def load_click_positions(self):
        image_filename = os.path.basename(self.image_files[self.image_index])
        filename = f"ClickPos//click_positions_{os.path.splitext(image_filename)[0]}.txt"
        self.click_positions = []
        self.original_pixels = {}
        if os.path.exists(filename):
            with open(filename, 'r') as file:
                for line in file:
                    x, y, color = line.strip().split(',')
                    x, y = int(x), int(y)
                    self.click_positions.append((x, y, color))
                    for i in range(x-4, x+5):
                        for j in range(y-4, y+5):
                            if (i - x) ** 2 + (j - y) ** 2 <= 25:
                                self.original_pixels[(i, j)] = self.image.getpixel((i, j))

    def next_image(self):
        self.image_index += 1
        if self.image_index >= len(self.image_files):
            self.root.destroy()  # 退出Tkinter主循环，关闭窗口
        else:
            self.click_positions = []
            self.original_pixels = {}
            self.show_image()

    def show_image(self):
        image_path = os.path.join(self.image_path, self.image_files[self.image_index])
        self.image = Image.open(image_path)
        self.load_click_positions()
        photo = ImageTk.PhotoImage(self.image)
        self.canvas.create_image(0, 0, image=photo, anchor='nw', tags='photo')
        self.canvas.img = photo
        for x, y, color in self.click_positions:
            self.draw_ellipse(x, y, color)

    def clear_points(self, event=None):
        self.click_positions = []
        self.original_pixels = {}
        self.show_image()


