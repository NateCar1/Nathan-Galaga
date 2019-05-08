package com.cctc.amatlock.test;

import com.cctc.amatlock.test.utilities.Images;

import java.awt.*;

public class Player extends CoreObject
{
    private Lazers[] lazers = new Lazers[100];
    private int lazerCounter = 0;
    int scored = 0;



    public Player(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }


    @Override
    public void tick()
    {
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
        g.setColor(color);
//        g.fillRect(x,y,width,height);
        g.drawImage(Images.barry,x,y,30,30,null);

        for(int i=0;i <lazerCounter;i++)
        {
            lazers[i].render(g);
        }
    }
    public void shoot()
    {

        Lazers lazer = new Lazers(x,y,3,5, Color.BLUE,true);
        lazer.setVelY(-5);

        lazers[lazerCounter] = lazer;
        lazerCounter ++;
        if(lazerCounter >= lazers.length)
        {
            lazerCounter = 0;
        }
    }

}
