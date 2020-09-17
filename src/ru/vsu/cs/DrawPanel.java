package ru.vsu.cs;

import ru.vsu.cs.Utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        LineDrawer ld = new GraphicsLineDrawer(bi_g);

        DrawUtils.drawSnowFlake(ld,400,400,50,8);

        g.drawImage(bi,0,0,null);
        bi_g.dispose();
    }
}
