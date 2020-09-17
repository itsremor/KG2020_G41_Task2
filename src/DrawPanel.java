import Utils.DrawUtils;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        DrawUtils snow = new DrawUtils();
        snow.drawSnowFlake(g,400,400,50,4269);
    }
}
