
/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class ImageScaleConverter {
    
    ImageResource makeGray(ImageResource colorImage) {
        ImageResource grayImage = new ImageResource(colorImage.getWidth(), colorImage.getHeight());
        for(Pixel p : grayImage.pixels()) {
            Pixel inPixel = colorImage.getPixel(p.getX(), p.getY());
            int avg = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            p.setRed(avg);
            p.setGreen(avg);
            p.setBlue(avg);
        }
        return grayImage;
    }
    
    ImageResource makeInverted(ImageResource colorImage) {
        ImageResource invertedImage = new ImageResource(colorImage.getWidth(), colorImage.getHeight());
        for(Pixel p : invertedImage.pixels()) {
            Pixel inPixel = colorImage.getPixel(p.getX(), p.getY());
            p.setRed(255 - inPixel.getRed());
            p.setGreen(255 - inPixel.getGreen());
            p.setBlue(255 - inPixel.getBlue());
        }
        return invertedImage;
    }
    void showGrayImage() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String originalImageName = image.getFileName();
            ImageResource grayImage = makeGray(image);
            String grayImageName = "gray-" + originalImageName;
            grayImage.setFileName(grayImageName);
            grayImage.draw();
            grayImage.save();
        }
           
    }
    
    void showInvertedImage() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String originalImageName = image.getFileName();
            ImageResource invertedImage = makeInverted(image);
            String invertedImageName = "inverted-" + originalImageName;
            invertedImage.setFileName(invertedImageName);
            invertedImage.draw();
            invertedImage.save();
        }
    }
    
    
}
