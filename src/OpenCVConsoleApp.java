import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 * The OpenCVConsoleApp class implements an application that reads from a
 * camera and performs drowsiness detection. This is accomplished by applying
 * facial landmark detection to extract the eye regions and computing the eye
 * aspect ratio. A lower ratio indicates closed eyelids.
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

class Camera {
    private VideoCapture capture;
    private Mat image;
    public void captureFrame() {
        // argument is camera index
        capture = new VideoCapture(0);
        image = new Mat();

        capture.read(image);

        String filename = "shot.jpg";
        Imgcodecs.imwrite(filename, image);
    }
}