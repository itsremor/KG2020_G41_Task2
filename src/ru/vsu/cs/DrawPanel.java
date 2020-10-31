package ru.vsu.cs;

import ru.vsu.cs.Utils.DrawUtils;
import ru.vsu.cs.line_drawers.BriesenhamLineDrawer;
import ru.vsu.cs.line_drawers.DDALineDrawer;
import ru.vsu.cs.line_drawers.WooLineDrawer;
import ru.vsu.cs.pixel_drawers.GraphicsPixelDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {

    private Point position = new Point(700,100);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();

        LineDrawer ldWoo = new WooLineDrawer(new GraphicsPixelDrawer(bi_g));
        LineDrawer ldBr = new BriesenhamLineDrawer(new GraphicsPixelDrawer(bi_g));
        LineDrawer ldDDA = new DDALineDrawer(new GraphicsPixelDrawer(bi_g));

        bi_g.fillRect(0,0,getWidth(),getHeight());
        bi_g.setColor(Color.BLACK);
        bi_g.drawString("Green is DDA, Blue is Woo, Red is Briesenham", 5, 10);


        drawAll(ldWoo, ldBr, ldDDA);


        g.drawImage(bi,0,0,null);
        bi_g.dispose();


    }

    public void drawAll(LineDrawer ld1, LineDrawer ld2, LineDrawer ld3){
        //DrawUtils.drawSnowFlake(ld1,400,400,50,32);
        ld1.drawLine(getWidth()/3, getHeight()/3, position.x, position.y);
        ld2.drawLine(getWidth()/2, getHeight()/2, position.x, position.y);
        ld3.drawLine(getWidth()/5, getHeight()/2, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent e) { //с нажатой кнопкой
//        position = new Point(e.getX(), e.getY());
//        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) { //Без нажатой
        position = new Point(e.getX(), e.getY());
        repaint();
    }

}
