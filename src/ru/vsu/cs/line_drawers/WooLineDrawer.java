package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;
import ru.vsu.cs.PixelDrawer;

import java.awt.*;
import java.text.CollationKey;

public class WooLineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public WooLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        int ix;
        int iy;

        if (x1 < x2) ix = 1;
        else ix = -1;
        if (y1 < y2) iy = 1;
        else iy = -1;

        Color color = new Color(0, 0, 0, 255);

        pd.setPixel(x1, y1, color);
        pd.setPixel(x2, y2, color);


        if (dx > dy) {
            double gradient = dy / dx;
            double y = y1 + gradient;
            for (int i = x1 + 1; i < x2; i++) {
                color = new Color(0, 0, 0, (float) (1 - (y - (int) y)));
                pd.setPixel(i, (int) y, color);

                color = new Color(0, 0, 0, (float) (y - (int) y));
                pd.setPixel(i, (int) y + 1, color);
                y += gradient;
            }
        } else {
            double gradient = dx / dy;
            double x = x1 + gradient;
            for (int i = y1 + 1; i < y2; i++) {
                color = new Color(0, 0, 0, (float) (1 - (x - (int) x)));
                pd.setPixel((int) x, i, color);

                color = new Color(0, 0, 0, (float) (x - (int) x));
                pd.setPixel((int) x + 1, i, color);
                x += gradient;
            }

        }

    }
}
