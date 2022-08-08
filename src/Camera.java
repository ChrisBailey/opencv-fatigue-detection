import org.opencv.core.*;
import org.opencv.face.Facemark;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.face.Face.createFacemarkKazemi;
import static org.opencv.imgproc.Imgproc.*;
import static org.opencv.imgproc.Imgproc.FILLED;

/**
 * The camera class provides utility methods for accessing the system camera
 * using OpenCV.
 */
public class Camera {
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
     * Detect face landmarks in the currently captured image
     *
     * <p>A cascade classifier is used to perform face detection while a OpenCV
     * Facemark model is used for facial landmark recognition.
     */
    public void detectLandmarks() {
        // TODO: train models
        String cascade_filename = "abc";
        String facemark_filename = "abc";

        // Load model
        CascadeClassifier face_cascade = new CascadeClassifier();
        face_cascade.load(cascade_filename);
        Facemark facemark = createFacemarkKazemi();
        facemark.loadModel(facemark_filename);

        // Perform face detection
        MatOfRect faces = new MatOfRect();
        resize(
                image,
                image,
                new Size(480, 480),
                0,
                0,
                INTER_LINEAR_EXACT
        );

        Mat gray = new Mat();
        if(image.channels() > 1) {
            cvtColor(image, gray, COLOR_BGR2GRAY);
        } else {
            gray = image.clone();
        }
        equalizeHist(gray, gray);

        face_cascade.detectMultiScale(
                gray,
                faces,
                1.1,
                3,
                0,
                new Size(30, 30)
        );

        // Extract facial landmarks and draw face boundaries and landmarks
        List<MatOfPoint2f> shapes = new ArrayList<>();

        if (facemark.fit(image, faces, shapes)) {
            for (int i = 0; i < faces.toArray().length; i++) {
                // draw detected face rectangle
                rectangle(image, faces.toArray()[i], new Scalar(255,0,0));

                for (int j = 0; j < shapes.size(); j++) {
                    circle(
                            image,
                            shapes.get(i).toArray()[j],
                            5,
                            new Scalar(0,0,255),
                            FILLED
                    );
                }
            }
        }
    }

    /**
     * Write the current captured image from the camera
     */
    public void writeImage() {
        String filename = "output.jpg";
        Imgcodecs.imwrite(filename, image);
    }
}