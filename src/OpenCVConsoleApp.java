import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 * The OpenCVConsoleApp class implements an application that reads from a
 * camera and performs drowsiness detection.
 *
 * <p>This is accomplished by applying facial landmark detection to extract the
 * eye regions and computing the eye aspect ratio. A lower ratio indicates
 * closed eyelids.
 */
public class OpenCVConsoleApp {

    // required to load OpenCV
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String[] args){
        System.out.println("Hello, OpenCV " + Core.VERSION + "!");

        Camera camera = new Camera();
        camera.captureFrame();
    }
}


/**
 * The camera class provides utility methods for accessing the system camera
 * using OpenCV.
 */
class Camera {
    private VideoCapture capture;
    private Mat image;

    public Camera() {
        // argument is camera index
        capture = new VideoCapture(0);

        image = new Mat();
    }

    /**
     * Get a single frame from the camera
     */
    public void captureFrame() {
        capture.read(image);
    }

    /**
     * Write the current captured image from the camera
     */
    public void writeImage() {
        String filename = "shot.jpg";
        Imgcodecs.imwrite(filename, image);
    }
}