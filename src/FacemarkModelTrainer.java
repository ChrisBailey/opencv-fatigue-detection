import org.opencv.core.Core;

public class FacemarkModelTrainer {
    // required to load OpenCV
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String[] args){
        System.out.println("Hello, OpenCV " + Core.VERSION + "!");


    }
}
