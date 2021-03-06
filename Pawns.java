package com.cctc.amatlock.test;

import java.awt.*;

public class Pawns extends CoreObject
{
    public Pawns(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void tick()
    {
        if(destroyed)
        {
            return;
        }
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g)
    {

        if(!destroyed)
        {
            g.setColor(color);
            g.fillRect(x,y,width,height);
        }
    }
}
