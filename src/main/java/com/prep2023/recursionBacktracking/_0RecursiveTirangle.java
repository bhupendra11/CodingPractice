package com.prep2023.recursionBacktracking;

import com.prep2023.graphicsHelper.DrawingUtility;

public class _0RecursiveTirangle {


    static void drawFractal(double x, double y, double w, double h ){
        DrawingUtility.drawTriangle(x,y,w,h);
        if(w<0.2 || h<0.2)return;
        double halfH = h/2;
        double halfW = w/2;
        drawFractal(x,y,halfW,halfH);
        drawFractal(x+halfW/2, y+halfH,halfW,halfH);
        drawFractal(x+halfW,y,halfW,halfH);

    }

    public static void main(String[] args) {
        drawFractal(100,100,500,500);
    }
}
