package com.bhupendra.prep2023.graphicsHelper;

import java.awt.*;
import javax.swing.*;

import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {
    private Graphics2D g2d;

    public Canvas(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void clear() {
        g2d.clearRect(0, 0, getWidth(), getHeight());
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        g2d.setColor(color);
        g2d.drawLine(x1, y1, x2, y2);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
    }

    public Graphics2D getGraphics2D() {
        return g2d;
    }

    // Add methods for drawing shapes, text, and images.
}
