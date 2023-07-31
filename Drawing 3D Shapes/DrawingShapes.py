import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np

# Cube
def drawCube(length):
    fig = plt.figure()
    axes3D = fig.add_subplot(111, projection='3d')
    # Shape coordinates
    x = [0, length, length, 0, 0, length, length, 0]
    y = [0, 0, length, length, 0, 0, length, length]
    z = [0, 0, 0, 0, length, length, length, length]

    colors = ['orange', 'orange', 'orange', 'orange', 'orange', 'orange']
    axes3D.plot(x[0:4], y[0:4], z[0:4], color=colors[0])
    axes3D.plot(x[4:8], y[4:8], z[4:8], color=colors[1])
    axes3D.plot([x[0], x[3]], [y[0], y[3]], [z[0], z[3]], color=colors[2])
    axes3D.plot([x[1], x[2]], [y[1], y[2]], [z[1], z[2]], color=colors[3])
    axes3D.plot([x[0], x[1]], [y[0], y[1]], [z[0], z[1]], color=colors[4])
    axes3D.plot([x[3], x[2]], [y[3], y[2]], [z[3], z[2]], color=colors[5])
    axes3D.set_xlabel('X')
    axes3D.set_ylabel('Y')
    axes3D.set_zlabel('Z')
    plt.savefig('cube.png')
    plt.show()
    print("\n  ( The ritual was done.  You can view the output file in this folder. )  ")
    print("--------------------------------------------------------------------------------------\n")

# Cuboid
def drawCuboid(length, width, height):
    fig = plt.figure()
    axes3D = fig.add_subplot(111, projection='3d')
    # Shape coordinates
    x = [0, length, length, 0, 0, length, length, 0]
    y = [0, 0, width, width, 0, 0, width, width]
    z = [0, 0, 0, 0, height, height, height, height]

    colors = ['purple', 'purple', 'purple', 'purple', 'purple', 'purple']
    axes3D.plot(x[:4], y[:4], z[:4], color=colors[0])
    axes3D.plot(x[4:], y[4:], z[4:], color=colors[1])
    axes3D.plot([x[0], x[3]], [y[0], y[3]], [z[0], z[3]], color=colors[2])
    axes3D.plot([x[1], x[2]], [y[1], y[2]], [z[1], z[2]], color=colors[3])
    axes3D.plot([x[0], x[1]], [y[0], y[1]], [z[0], z[1]], color=colors[4])
    axes3D.plot([x[3], x[2]], [y[3], y[2]], [z[3], z[2]], color=colors[5])
    axes3D.set_xlabel('X')
    axes3D.set_ylabel('Y')
    axes3D.set_zlabel('Z')
    plt.savefig('cuboid.png')
    plt.show()
    print("\n  ( The ritual was done.  You can view the output file in this folder. )  ")
    print("--------------------------------------------------------------------------------------\n")

# Sphere
def drawSphere(radius):
    fig = plt.figure()
    axes3D = fig.add_subplot(111, projection='3d')

    Theta = np.linspace(0, 2 * np.pi, 100)
    Heights = np.linspace(0, np.pi, 100)
    x = radius * np.outer(np.cos(Theta), np.sin(Heights))
    y = radius * np.outer(np.sin(Theta), np.sin(Heights))
    z = radius * np.outer(np.ones(np.size(Theta)), np.cos(Heights))
    axes3D.plot_surface(x, y, z, color='r')
    axes3D.set_xlabel('X')
    axes3D.set_ylabel('Y')
    axes3D.set_zlabel('Z')
    plt.savefig('sphere.png')
    plt.show()
    print("\n  ( The ritual was done.  You can view the output file in this folder. )  ")
    print("--------------------------------------------------------------------------------------\n")

# Cone
def drawCone(height, radius):
    fig = plt.figure()
    axes3D = fig.add_subplot(111, projection='3d')

    Theta = np.linspace(0, 2 * np.pi, 100)
    Heights = np.linspace(0, height, 100)
    Theta, Heights = np.meshgrid(Theta, Heights)
    x = radius * (1 - Heights / height) * np.cos(Theta)
    y = radius * (1 - Heights / height) * np.sin(Theta)
    z = Heights
    axes3D.plot_surface(x, y, z, color='m')
    axes3D.set_xlabel('X')
    axes3D.set_ylabel('Y')
    axes3D.set_zlabel('Z')
    plt.savefig('cone.png')
    plt.show()
    print("\n  ( The ritual was done.  You can view the output file in this folder. )  ")
    print("--------------------------------------------------------------------------------------\n")

# Cylinder
def drawCylinder(height, radius):
    fig = plt.figure()
    axes3D = fig.add_subplot(111, projection='3d')

    Theta = np.linspace(0, 2 * np.pi, 100)
    Heights = np.linspace(0, height, 100)
    Theta, Heights = np.meshgrid(Theta, Heights)
    x = radius * np.cos(Theta)
    y = radius * np.sin(Theta)
    z = Heights
    axes3D.plot_surface(x, y, z, color='c')
    axes3D.set_xlabel('X')
    axes3D.set_ylabel('Y')
    axes3D.set_zlabel('Z')
    plt.savefig('cylinder.png')
    plt.show()
    print("\n  ( The ritual was done.  You can view the output file in this folder. )  ")
    print("--------------------------------------------------------------------------------------\n")

# Frustum
def drawFrustum(height, radius1, radius2):
    fig = plt.figure()
    axes3D = fig.add_subplot(111, projection='3d')

    Theta = np.linspace(0, 2 * np.pi, 100)
    Heights = np.linspace(0, height, 100)
    Theta, Heights = np.meshgrid(Theta, Heights)
    x = (radius2 + (radius1 - radius2) * Heights / height) * np.cos(Theta)
    y = (radius2 + (radius1 - radius2) * Heights / height) * np.sin(Theta)
    z = Heights
    axes3D.plot_surface(x, y, z, color='y')
    axes3D.set_xlabel('X')
    axes3D.set_ylabel('Y')
    axes3D.set_zlabel('Z')
    # plt.savefig('frustum.png')
    plt.show()
    print("\n  ( The ritual was done.  You can view the output file in this folder. )  ")
    print("--------------------------------------------------------------------------------------\n")

def selectShape():
    print("\n--------------------------------------------------------------------------------------")
    shape = input("  Please select a Shape (Cube/Cuboid/Sphere/Cone/Cylinder/Frustum) : ")

    if shape == "cube":
        length = float(input("Enter the length of the cube: "))
        drawCube(length)

    elif shape == "cuboid":
        length = float(input("  Enter the length of the Cuboid: "))
        width = float(input("  Enter the width of the Cuboid: "))
        height = float(input("  Enter the height of the Cuboid: "))
        drawSphere(length, width, height)

    elif shape == "sphere":
        radius = float(input("  Enter the radius of the Sphere: "))
        drawCuboid(radius)

    elif shape == "cone":
        height = float(input("  Enter the height of the Cone: "))
        radius = float(input("  Enter the radius of the Cone: "))
        drawCone(height, radius)

    elif shape == "cylinder":
        height = float(input("  Enter the height of the Cylinder: "))
        radius = float(input("  Enter the radius of the Cylinder: "))
        drawCylinder(height, radius)

    elif shape == "frustum":
        height = float(input("  Enter the height of the Frustum: "))
        radius1 = float(input("  Enter the radius of the Frustum: "))
        radius2 = float(input("  Enter the radius of the Frustum: "))
        drawFrustum(height, radius1, radius2)

    else:
        print("  (  ! Invalid shape selection.  Please try again. !  )  ")
        selectShape()

def main():
    selectShape()

if __name__ == '__main__':
    main()  