# OpenCV Driver Fatigue Detection
This project implements driving fatigue detection, particularly using the OpenCV library.

## OpenCV Console App
The OpenCVConsoleApp class implements an application that reads from a camera and performs drowsiness detection. This is accomplished by applying facial landmark detection to extract the eye regions and computing the eye aspect ratio. A lower ratio indicates closed eyelids.

### Build info
The appropriate opencv-xxx.jar needs to be added to your project as a dependency.