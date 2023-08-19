# Color Detection in Images
##  using OpenCV

   This program takes an image as input and detects the colors in the image. 
   The detection is based on HSV (Hue, Saturation, Value) color space. 
   This program uses the OpenCV library for computer vision tasks.

## Installation

   * Install the OpenCV & NumPy libraries. You can install it using (pip):

                                --------------------------------------
                                |     pip install opencv-python      |
                                |     pip install numpy              |
                                --------------------------------------

   * The program can recognize the following colors:

                                -------------------------------------------------------------
                                |    white     |     Black     |     Red      |    Brown    |
                                |    Blue      |     Green     |    Yellow    |     Gray    |
                                |    Orange    |     Pink      |    Purple    |             |
                                -------------------------------------------------------------

## Usage

   1. To use the program, you need to have an image file on which you want to detect colors.
   2. Run the program using the following command:

                                --------------------------------------
                                |     python color_detection.py      |
                                --------------------------------------

   3. Follow the prompts in the terminal:
        * Enter the address of the image file when prompted. Make sure to provide the correct file path.
        * Once the program finishes processing, it will display the colors detected in the image.

## Example Output

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

        ===> Please Enter the address of the image:  /path/to/image.jpg
        ===> The colors present in the image are:  ['Red', 'Green', 'Blue']
        *******************************************************************************************************

## References

   * [opencv-python](https://pypi.org/project/opencv-python/)
   * [numpy](https://pypi.org/project/numpy/)
   * [Detection of a specific color using OpenCV with Python](https://www.geeksforgeeks.org/detection-specific-colorblue-using-opencv-python/)
   * [OpenCV-Python Tutorials](https://docs.opencv.org/4.5.2/d6/d00/tutorial_py_root.html)
   