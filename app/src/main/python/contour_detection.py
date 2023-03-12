import matplotlib.pyplot as plt
import numpy as np
import cv2
import warnings

from matplotlib import MatplotlibDeprecationWarning

warnings.filterwarnings('ignore', category=MatplotlibDeprecationWarning)


def execute_contour(path):

    sample_image = cv2.imread(path)
    img = cv2.cvtColor(sample_image, cv2.COLOR_BGR2RGB)
    img = cv2.resize(img, (256, 256))
    plt.axis('off');
    plt.imshow(img)


    gray = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
    _,thresh = cv2.threshold(gray, np.mean(gray), 255, cv2.THRESH_BINARY_INV)
    plt.axis('off')
    plt.imshow(thresh)


    edges = cv2.dilate(cv2.Canny(thresh, 0, 255), None)
    plt.axis('off')
    plt.imshow(edges)


    cnt = sorted(cv2.findContours(edges, cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)[-2], key=cv2.contourArea)[-1]
    mask = np.zeros((256, 256), np.uint8)
    masked = cv2.drawContours(mask, [cnt], -1, 255, -1)
    plt.axis('off')
    plt.imshow(masked)


    dst = cv2.bitwise_and(img, img, mask=mask)
    segmented = cv2.cvtColor(dst, cv2.COLOR_BGR2RGB)
    plt.imshow(segmented)
    plt.show()
    return 1

