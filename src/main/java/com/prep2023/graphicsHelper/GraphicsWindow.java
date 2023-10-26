package com.prep2023.graphicsHelper;

import javax.swing.*;

public class GraphicsWindow {
    private JFrame frame;
    
    public GraphicsWindow(int width, int height) {
        frame = new JFrame("Graphics Window");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void close() {
        frame.dispose();
    }
}
