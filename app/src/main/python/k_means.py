import matplotlib.pyplot as plt
import numpy as np
import cv2

import warnings
from matplotlib import MatplotlibDeprecationWarning

warnings.filterwarnings('ignore', category=MatplotlibDeprecationWarning)


def execute_k_means(path):

    sample_image = cv2.imread(path)
    img = cv2.cvtColor(sample_image, cv2.COLOR_BGR2RGB)
    plt.imshow(img)

    twoDimage = img.reshape((-1, 3))
    twoDimage = np.float32(twoDimage)

    criteria = (cv2.TERM_CRITERIA_EPS + cv2.TERM_CRITERIA_MAX_ITER, 10, 1.0)
    K = 2
    attempts=10

    ret,label,center=cv2.kmeans(twoDimage, K, None, criteria, attempts, cv2.KMEANS_PP_CENTERS)
    center = np.uint8(center)
    res = center[label.flatten()]
    result_image = res.reshape(img.shape)

    plt.axis('off')
    plt.imshow(result_image)

    plt.show()
    return 1
