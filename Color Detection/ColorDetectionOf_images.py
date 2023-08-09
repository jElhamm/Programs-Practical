# This program is a Python function that takes an image as input and detects the colors present in the image. 
# The function uses OpenCV library for computer vision tasks.

import cv2
import numpy as np

def detectColors(image):
    hsv_image = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)                      # Convert image from RGB to HSV
    colors = {                                                              # Define colors with their HSV ranges
        'Black' : ([0, 0, 0]      , [180, 255, 60]),
        'white' : ([0, 0, 200]    , [180, 50, 255]),
        'Red'   : ([0, 100, 100]  , [10, 255, 255]),
        'Green' : ([60, 100, 100] , [80, 255, 255]),
        'Brown' : ([10, 120, 100] , [30, 200, 200]),
        'Yellow': ([20, 100, 100] , [40, 255, 255]),
        'Orange': ([15, 100, 100] , [35, 255, 255]),
        'Gray'  : ([90, 0, 0]     , [150, 255, 150]),
        'Blue'  : ([90, 100, 100] , [120, 255, 255]),
        'Pink'  : ([140, 100, 100], [160, 255, 255]),
        'Purple': ([120, 100, 100], [140, 255, 255]) 
    }

    detected_colors = []                                                   # Recognition of colors
    for color, (lower, upper) in colors.items():
        mask = cv2.inRange(hsv_image, np.array(lower), np.array(upper))    # Extracting parts of the image where the color is within the specified limits
        if np.any(mask):                                                   # Check if any pixels of the color are present in the image
            detected_colors.append(color)
    return detected_colors

def  banner():
    print("""
        
        *******************************************************************************************************
        *                                      ***   Welcome   ***                                            *   
        *                    you can use this program to recognize the colors in an image.                    *
        *         The colors that the program can recognize are in the range of the following colors:         *
        *                                                                                                     *   
        *                             white     |     Black     |     Red                                     *
        *                             Blue      |     Green     |    Yellow                                   *
        *                             Orange    |     Pink      |     Purple                                  *
        *                             Brown     |     Gray      |     :))                                     *
        *                                                                                                     *
        *******************************************************************************************************
    """)

def main():
    banner()
    imagePath = input("        ===> Please Enter the address of the image:  ")
    image = cv2.imread(imagePath)
    if image is None:
        print("        ===> Error: Failed to open the image. Please check the file path and try again.!")
        return
    colors = detectColors(image)
    print('        ===> The colors present in the image are: ', colors)
    print("        *******************************************************************************************************\n")

if __name__ == '__main__':
    main()