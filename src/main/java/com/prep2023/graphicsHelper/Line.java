package com.prep2023.graphicsHelper;

import java.awt.*;

public class Line {
    public static void draw(Canvas canvas, int x1, int y1, int x2, int y2, Color color) {
        canvas.drawLine(x1, y1, x2, y2, color);
    }
}
