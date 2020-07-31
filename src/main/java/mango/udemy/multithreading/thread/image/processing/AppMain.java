package mango.udemy.multithreading.thread.image.processing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppMain {

    /**
     * Here is the testing result which I ran on my working desktop
     * CPU : 6700 4 cores - 8 threads
     * Ram : 32 GB (2 x 16)
     *
     * Number of threads    Processing time
     *     1                    1102
     *     2                    712
     *     4                    492
     *     6                    325
     *     8                    260   <- sweet point
     *     10                   317
     *     12                   264
     */

    public static final String SOURCE_FILE = "./resources/udemy/multithreading/many-flowers.jpg";
    public static final String DESTINATION_FILE = "./bin/many-flowers.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        long startTime = System.currentTimeMillis();

//        recolorSingleThread(originalImage, resultImage);
        int numberOfThreads = 12;
        recolorMultiThread(originalImage, resultImage, numberOfThreads);

        long endTime = System.currentTimeMillis();

        File outputFile = new File(DESTINATION_FILE);
        ImageIO.write(resultImage, "jpg", outputFile);

        System.out.println("Image processing time: " + String.valueOf(endTime - startTime));
    }

    /**
     * Recolor image on single thread
     * @param originalImage
     * @param resultImage
     */
    public static void recolorSingleThread(BufferedImage originalImage, BufferedImage resultImage) {
        recolorImage(originalImage, resultImage, 0, 0, originalImage.getWidth(), originalImage.getHeight());
    }

    /**
     * Re-color image using multi threads
     * @param originalImage
     * @param resultImage
     * @param numberOfThreads the number of thread
     */
    public static void recolorMultiThread(BufferedImage originalImage, BufferedImage resultImage, int numberOfThreads) {
        List<Thread> threads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight() / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadMultiplier = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    int leftCorner = 0;
                    int topCorner = height * threadMultiplier;
                    recolorImage(originalImage, resultImage, leftCorner, topCorner, width,  height);
                }
            });

            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Re-color the image
     * @param originalImage
     * @param resultImage
     * @param leftCorner
     * @param topCorner
     * @param width
     * @param height
     */
    public static void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner, int width, int height) {
        for (int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++) {
            for (int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y++) {
                recolorPixel(originalImage, resultImage, x, y);
            }
        }
    }

    /**
     * Re-color the pixel at coordinates (x, y) in original image to result image
     * @param originalImage
     * @param resultImage
     * @param x
     * @param y
     */
    public static void recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y) {
        int rgb = originalImage.getRGB(x, y);
        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed, newGreen, newBlue;
        if (isShapeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        int newRGB = createRGBFromColors(newRed, newGreen, newBlue);
        setRGB(resultImage, x, y, newRGB);
    }

    /**
     * Set RGB value to coordinates (x, y) of image
     * @param image
     * @param x
     * @param y
     * @param rgb
     */
    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    /**
     * Check is the RGB value is on the shape of gray?
     * @param red
     * @param green
     * @param blue
     * @return true: this RGB value is on shape of gray, otherwise false
     */
    public static boolean isShapeOfGray(int red, int green, int blue) {
        int grayVal = 30;
        return Math.abs(red - green) < grayVal && Math.abs(red - blue) < grayVal && Math.abs(green - blue) < grayVal;
    }

    /**
     * create RGB value from 3 colors
     * @param red
     * @param green
     * @param blue
     * @return RGB value
     */
    public static int createRGBFromColors(int red, int green, int blue) {
        int rgb = 0;

        rgb |= red << 16;
        rgb |= green << 8;
        rgb |= blue;
        rgb |= 0xFF000000;

        return rgb;
    }

    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }
}
