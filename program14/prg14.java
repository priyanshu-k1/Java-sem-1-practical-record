//14.Write a program to load and display image and perform grey scale. 
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URL;
import javax.imageio.ImageIO;

public class prg14 {
    public static void main(String[] args) throws Exception {
        // 1. Load the image from a URL
        URL url = new URI("https://picsum.photos/200").toURL();
        BufferedImage img = ImageIO.read(url);

        // 2. Loop through every pixel
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                
                // Get the color of the current pixel
                int p = img.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // Calculate average (this is the "grey" value)
                int avg = (r + g + b) / 3;

                // Replace RGB with the average value
                p = (avg << 16) | (avg << 8) | avg;
                img.setRGB(x, y, p);
            }
        }

        // 3. Save the result
        File output = new File("grayscale.png");
        ImageIO.write(img, "png", output);
        
        System.out.println("Success! Image saved as grayscale.png");
    }
}