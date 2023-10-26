package com.prep2023.graphicsHelper;

import java.awt.*;

public class Text {
    public static void draw(Canvas canvas, String text, int x, int y, Color color, Font font) {
        canvas.getGraphics2D().setColor(color);
        canvas.getGraphics2D().setFont(font);
        canvas.getGraphics2D().drawString(text, x, y);
    }
}
