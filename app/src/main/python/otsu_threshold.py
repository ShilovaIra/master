import numpy as np
import matplotlib.pyplot as plt
from PIL import Image
from os.path import dirname, join
import os
import cv2

max_delta2 = 0
threshold = 0

def find_mu(mu, i, hist_norm):
    return mu + i * hist_norm


def find_threshold(T, hist_norm):
    global max_delta2, threshold
    mu0 = 0
    mu1 = 0
    omega0 = np.sum(hist_norm[0:T + 1])
    omega1 = 1 - omega0

    for i in range(T + 1):
        mu0 = mu0 + i * hist_norm[i]

    if omega0 != 0:
        mu0 = mu0 / omega0

    for i in range(T + 1, 256):
        mu1 = mu1 + i * hist_norm[i]

    if omega1 != 0:
        mu1 = mu1 / omega1

    delta2 = omega0 * omega1 * (mu0 - mu1) ** 2
    if max_delta2 < delta2:
        max_delta2 = delta2
        threshold = T
    return threshold


def apply(path) -> None:
    img = Image.open(path)
    img = img.convert('L')
    initial = img
    img = np.array(img)
    plt.figure(1)
    plt.imshow(img, 'gray')
    plt.title('Grey-scale Map')

    # show histogaram
    bins = np.arange(256)
    hist, _ = np.histogram(img, np.hstack((bins, np.array([256]))))
    plt.figure(2)
    plt.bar(bins, hist)
    plt.title('Histogram')

    # solve otsu threshold
    N = img.size
    hist_norm = hist / N

    global threshold

    for T in range(255):
        threshold = find_threshold(T, hist_norm)


    print('the otsu threshold is', threshold)

    print('the otsu time in threshold is', threshold)
    print('the otsu time in img is', img)

    img[img > threshold] = 255
    img[img != 255] = 0
    plt.figure(3)
    plt.imshow(img, 'gray')
    plt.title('Segmentation Picture')

    filtered = np.where(img == 255, img, initial) #apply mask

    filename = join(dirname(__file__), "./images/foo2.png")
    plt.axis('off')
    f = plt.imshow(img, 'gray')
    plt.title("filtered")
    plt.savefig(filename)

    #filename = join(dirname(__file__), "./images/filtered_otsu.png")
    filename2 = join(dirname(__file__), "./images/filtered_otsu_without_titile.png")
    plt.axis('off')
    plt.imshow(filtered, 'gray')
    cv2.imwrite(filename2, filtered)
    #plt.title("filtered")
    #plt.savefig(filename)

    filename = join(dirname(__file__), "./images/foo.png")
    plt.figure(4)
    plt.imshow(img, 'gray')
    plt.title('segmented')
    plt.show()
    plt.savefig(filename)
    # show all


def execute_otsu(a):
    print(join(os.environ["HOME"]))
    print(join(dirname(__file__), "./images/3.png"))
    path = join(dirname(__file__), "./images/3.png")
    plt.figure(1)
    out = np.zeros(5)
    apply(path)
    return "Hello " + str(a)