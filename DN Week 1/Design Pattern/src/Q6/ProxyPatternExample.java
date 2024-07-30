package Q6;

import java.util.HashMap;
import java.util.Map;

interface Image {
    void display();
}


class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer(fileName);
    }

    private void loadFromRemoteServer(String fileName) {
        System.out.println("Loading " + fileName + " from remote server...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;
    private static Map<String, RealImage> imageCache = new HashMap<>();

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = imageCache.get(fileName);
            if (realImage == null) {
                realImage = new RealImage(fileName);
                imageCache.put(fileName, realImage);
            }
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        image1.display();
        System.out.println("");

        image1.display();
        System.out.println("");

        image2.display();
        System.out.println("");

        image2.display();
    }
}

