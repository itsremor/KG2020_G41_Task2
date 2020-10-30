package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;
import ru.vsu.cs.PixelDrawer;

import java.awt.*;

public class BriesenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BriesenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }



    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double x = x1;
        double y = y1;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int ix;
        int iy;

        double dif = 0;

        if(x1 < x2) ix = 1; else ix = -1;
        if(y1 < y2) iy = 1; else iy = -1;

        if(dx > dy) {
            for (int i = 1; i < dx; i++) {
                pd.setPixel((int)x,(int)y, Color.GREEN);
                x += ix;
                dif += dy * 2;
                if(dif > dx){
                    y += iy;
                    dif -= dx * 2;
                }
            }
        }

        else{
            for (int i = 1; i < dy; i++) {
                pd.setPixel((int)x,(int)y, Color.RED);
                y += iy;
                dif += dx * 2;
                if(dif > dy){
                    x += ix;
                    dif -= dy * 2;
                }
            }
        }
    }
}