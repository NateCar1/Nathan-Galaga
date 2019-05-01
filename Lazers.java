package com.cctc.amatlock.test;

import java.awt.*;

public class Lazers extends CoreObject
{


    public Lazers(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }





    @Override
    public void tick()
    {
        if(destroyed)
        {
            return;
        }
        CoreObject[] objects = Screen.getCoreObjects();
        for(int i = 0; i < Screen.getObjectCounter();i++)
        {
            CoreObject pawn = Screen.getCoreObjects()[i];
            if(intersects(pawn) && !pawn.destroyed)
            {
                pawn.destroyed = true;
                destroyed = true;
            }
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
