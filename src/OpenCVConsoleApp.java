import org.opencv.core.Core;

/**
 * The OpenCVConsoleApp class implements an application that reads from a camera
 * and performs drowsiness detection.
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
        camera.detectLandmarks();
        camera.writeImage();
    }
}


