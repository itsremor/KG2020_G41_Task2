package ru.vsu.cs.line_drawers;

import ru.vsu.cs.LineDrawer;
import ru.vsu.cs.PixelDrawer;

import java.awt.*;

public class WooLineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public WooLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        if (dx > dy) {
            if (x2 < x1) {
                int temp = x1;
                x1 = x2;
                x2 = temp;

                temp = y1;
                y1 = y2;
                y2 = temp;
            }

            double gradient = (double) dy / dx;
            if (y2 < y1) gradient *= -1;
            double iy = y1 + gradient;

            Color color = new Color(0, 0, 1, 1f);
            pd.setPixel(x1, y1, color);
            pd.setPixel(x2, y2, color);

            for (int x = x1 + 1; x < x2; x++) {
                color = new Color(0, 0, 1, (float) (1 - (iy - (int) iy)));
                pd.setPixel(x, (int) iy, color);

                color = new Color(0, 0, 1, (float) (iy - (int) iy));
                pd.setPixel(x, (int) iy + 1, color);

                iy += gradient;
            }
        } else {
            if (y2 < y1) {
                int temp = x1;
                x1 = x2;
                x2 = temp;

                temp = y1;
                y1 = y2;
                y2 = temp;
            }

            double gradient = (double) dx / dy;
            if (x2 < x1) gradient *= -1;
            double ix = x1 + gradient;

            Color color = new Color(1, 0, 0, 1f);

            pd.setPixel(x1, y1, color);
            pd.setPixel(x2, y2, color);
            for (int y = y1 + 1; y < y2; y++) {
                color = new Color(0, 0, 1, (float) (1 - (ix - (int) ix)));
                pd.setPixel((int) ix, y, color);

                color = new Color(0, 0, 1, (float) (ix - (int) ix));
                pd.setPixel((int) ix + 1, y, color);

                ix += gradient;
            }
        }
    }
}
