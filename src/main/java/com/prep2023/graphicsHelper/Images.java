package com.prep2023.graphicsHelper;

import java.awt.*;
import javax.swing.ImageIcon;

public class Images {
    public static void draw(Canvas canvas, String imagePath, int x, int y) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();

        canvas.getGraphics2D().drawImage(image, x, y, null);
    }
}
