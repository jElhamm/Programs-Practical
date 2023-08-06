# In this program, a photo file is taken as input from the user and the following operations can be performed on it:
# Reduce Image Size, Convert Image Format, Change Resolution, Combine Images.

from PIL import Image
import imghdr

# Reduce Image Size
def reduce_image_size(imagePath, newImagePath):
    image = Image.open(imagePath)                                                   # Load the image
    newSize = (image.size[0] // 2, image.size[1] // 2)                              # Reduce the image size by half
    resizedImage = image.resize(newSize)
    imageFormat = imghdr.what(imagePath)                                            # Specify the file extension
    newImagePath = change_file_extension(newImagePath, imageFormat)
    print("\n    *********************************************")
    print("    *   ( Image size reduced successfully )     *")
    save_resized_image(resizedImage, newImagePath)                                  # Save the  image

# Convert Image Format
def convert_image_format(imagePath, imageFormat, newImagePath):
    image = Image.open(imagePath)                                                   # Determine the current image format
    image.save(newImagePath, format=imageFormat)                                    # Save the image                              
    print("\n    ***************************************************")
    print("    *   ( Image format converted successfully  )      *")
    save_new_format_image(image, newImagePath)

# Change Resolution
def change_resolution(imagePath, width, height, newImagePath):
    image = Image.open(imagePath)                                                   # Load the image
    newResolution = (width, height)                                                 # Change the resolution of the image
    resizedImage = image.resize(newResolution)
    resizedImage.save(newImagePath)
    print("\n    *************************************************************")
    print("    *   ( Image resolution changed successfully  )              *")
    save_changed_resolution_image(resizedImage, newImagePath)                       # Save the image 

# Combine Images
def combine_images(imagePaths, newImagePath):
    images = []
    for path in imagePaths:
        image = Image.open(path)
        images.append(image)

    widths, heights = zip(*(i.size for i in images))                                # Get the dimensions of each image using the generator expression               
    total_width = sum(widths)
    max_height = max(heights)
    combined_image = Image.new('RGB', (total_width, max_height))                    # Create a new blank image with calculated dimensions

    x_offset = 0
    for image in images:
        combined_image.paste(image, (x_offset, 0))                                  # Pastes the image onto the composite image at the current X-offset
        x_offset += image.width

    print("\n    **********************************************")
    print("    *   ( Images combined successfully  )        *")
    save_combined_image(combined_image, newImagePath)

# Save functions
def save_resized_image(image, newImagePath):
    image.save(newImagePath)
    print("    *   ( Resized image saved successfully )    *")
    print("    *********************************************\n")
    
def save_new_format_image(image, newImagePath):
    image.save(newImagePath)
    print("    *   ( Image in new format saved successfully )    *")
    print("    ***************************************************\n")

def save_changed_resolution_image(image, newImagePath):
    image.save(newImagePath)
    print("    *   ( Image with changed resolution saved successfully )    *")
    print("    *************************************************************\n")

def save_combined_image(image, newImagePath):
    image.save(newImagePath)
    print("    *   ( Combined image saved successfully )    *")
    print("    **********************************************\n")

def change_file_extension(filePath, newExtension):
    # Change the file extension in the given file path
    return filePath[:filePath.rfind('.')] + '.' + newExtension

def banner():
    print("""
    ************************************************
    *  Things you can do with your image:          *
    *                                              *
    *        1. Reduce image size                  *
    *        2. Convert image format               *
    *        3. Change image resolution            *
    *        4. Combine images                     *
    ************************************************
    """)

def main():
    banner()
    UserSelection = input("    ===> Choose an action to perform:  ")
    imagePath = input("    ===> Please enter the address where the image is located: ")

    if UserSelection == '1':
        newImagePath = input("    ===> Enter the path and name of the resized image: ")
        reduce_image_size(imagePath, newImagePath)

    elif UserSelection == '2':
        imageFormat = input("    ===> Enter the desired image format (e.g. png, jpg, etc.): ")
        newImagePath = input("    ===> Enter the path and name of the image in the new format: ")
        convert_image_format(imagePath, imageFormat, newImagePath)

    elif UserSelection == '3':
        width = int(input("    ===> Enter the new width: "))
        height = int(input("    ===> Enter the new height: "))
        newImagePath = input("    ===> Enter the path and name of the image with changed resolution: ")
        change_resolution(imagePath, width, height, newImagePath)

    elif UserSelection == '4':
        numImages = int(input("    ===> Enter the number of images you want to combine: "))
        imagePaths = []
        for i in range(numImages):
            imagePath = input(f"    ===> Enter the path of image {i+1}: ")
            imagePaths.append(imagePath)
        newImagePath = input("    ===> Enter the path and name of the combined image: ")
        combine_images(imagePaths, newImagePath)  # Call the new function to combine images

    else:
        print("        ===> Invalid action! Please choose a valid action !.")

if __name__ == '__main__':
    main()