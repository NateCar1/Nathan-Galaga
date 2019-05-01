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
        Pawns pawn = Screen.getInstance().pawns;
        x += velX;
        y += velY;
        if(intersects(pawn))
        {
            pawn.destroyed = true;
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
