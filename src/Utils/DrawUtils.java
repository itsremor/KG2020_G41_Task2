package Utils;

import java.awt.*;

public class DrawUtils {
    public static void drawSnowFlake(Graphics g, int x, int y, int r, int raysCount){
        double deg = 2*Math.PI / raysCount;
        for (int i = 0; i < raysCount; i++) {
            double dx = r * Math.cos(deg * i);
            double dy = r * Math.sin(deg * i);
            g.drawLine(x,y,x + (int)dx,y + (int)dy);
        }
    }
}
