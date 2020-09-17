package ru.vsu.cs;

import ru.vsu.cs.Utils.DrawUtils;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        LineDrawer ld = new GraphicsLineDrawer(g);
        DrawUtils snow = new DrawUtils();
        snow.drawSnowFlake(ld,400,400,50,4269);
    }
}
