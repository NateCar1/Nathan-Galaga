package com.cctc.amatlock.test;

import com.cctc.amatlock.test.utilities.Sounds;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyInput implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)

    {

        Player spaceship = Screen.getInstance().spaceship;
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            spaceship.setVelX(-5);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D)
        {
            spaceship.setVelX(+5);
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            Sounds.pew.open();
            spaceship.shoot();
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        Player spaceship = Screen.getInstance().spaceship;
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            spaceship.setVelX(0);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D)
        {
            spaceship.setVelX(0);
        }
    }
}
