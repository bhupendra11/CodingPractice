package com.bhupendra.prep2023.graphicsHelper;

import java.awt.*;
import javax.swing.*;

public class DrawingUtility {
    private static JFrame frame;
    private static Canvas canvas;

    static {
        frame = new JFrame("Drawing Utility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new Canvas(800, 600); // Default dimensions
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public static void drawTriangle(double x, double y, double w, double h) {
        canvas.setTriangleDimensions(x, y, w, h);
        canvas.repaint();
    }

    public static void close() {
        frame.dispose();
    }

    public static void main(String[] args) {
        drawTriangle(100.0, 100.0, 200.0, 200.0);
        close();
    }

    private static class Canvas extends JPanel {
        private int x, y, w, h;

        public Canvas(int width, int height) {
            setPreferredSize(new Dimension(width, height));
        }

        public void setTriangleDimensions(double x, double y, double w, double h) {
            this.x = (int) x;
            this.y = (int) y;
            this.w = (int) w;
            this.h = (int) h;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int[] xPoints = {x, x + w, x + (w / 2)};
            int[] yPoints = {y + h, y + h, y};
            int nPoints = 3;

            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(xPoints, yPoints, nPoints);
        }
    }
}
