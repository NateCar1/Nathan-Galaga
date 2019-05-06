package com.cctc.amatlock.test;

import java.awt.*;

public class Pawn extends CoreObject
{
    private int ticks = 0;
    private Lazers[] lazers = new Lazers[100];
    private int lazerCounter = 0;
    int scored = 0;

    public Pawn(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public void shoot() {

        Lazers lazer = new Lazers(x, y, 3, 5, Color.RED,false);
        lazer.setVelY(5);

        lazers[lazerCounter] = lazer;
        lazerCounter++;
        if (lazerCounter >= lazers.length) {
            lazerCounter = 0;
        }
    }
    @Override
    public void tick()
    {
        if(destroyed)
        {
            return;
        }
        ticks++;
        if(ticks == 30)
        {
            shoot();
            ticks = 0;
        }



        if(x > Reference.WIDTH-width*2)
        {
            this.setVelX(-5);
            y -= -40;

        }
        if(x < 0)
        {
            this.setVelX(5);
            y -= -40;
        }

        x += velX;
        y += velY;

        for(int i=0;i <lazerCounter;i++)
        {
            lazers[i].tick();
        }
    }

    @Override
    public void render(Graphics g)
    {

        if(!destroyed)
        {
            for(int i=0;i <lazerCounter;i++)
            {
                lazers[i].render(g);
            }
            g.setColor(color);
            g.fillRect(x,y,width,height);
        }
    }
}
