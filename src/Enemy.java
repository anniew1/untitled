import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    private final double MOVE_AMT = 0.2;
    private BufferedImage image;
    private double xCoord;
    private double yCoord;

    public Enemy() {
        xCoord = 50; // starting position is (50, 435), right on top of ground
        yCoord = 435;
        try {
            image = ImageIO.read(new File("src/goomba.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord() {
        return (int) xCoord;
    }

    public int getyCoord() {
        return (int) yCoord;
    }

    public void move() {
        if (xCoord + MOVE_AMT <= 920) {
            xCoord += MOVE_AMT;
        } else {
            xCoord = 0;
        }
    }

    public BufferedImage getEnemyImage() {
        return image;
    }

    // we use a "bounding Rectangle" for detecting collision
    public Rectangle getRect() {
        int imageHeight = getEnemyImage().getHeight();
        int imageWidth = getEnemyImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }

}
