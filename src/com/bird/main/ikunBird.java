package com.bird.main;

import com.bird.util.Gameutil;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.bird.util.Constant.*;

/**
 * ikunBird
 *
 * @ClassName ikunBird
 * @Description ikunBird
 * @Author 202132110121 202132110159
 * @DATE 2023/5/14 18:28
 * @Version 1.0
 */
public class ikunBird extends Bird {

    public String[] BIRD_IMG = IKUNBIRD_IMG;

    public ikunBird() {
        images = new BufferedImage[BIRD_IMG_COUNT];
        for (int i = 0; i < BIRD_IMG_COUNT; i++) {
            images[i] = Gameutil.loadBufferedImage(BIRD_IMG[i]);
        }
        int w = images[0].getWidth();
        int h = images[0].getHeight();
        rect = new Rectangle(w, h);
    }

    @Override
    public void flyLogic() {
        if (up) {
            acceleration--;
            y += acceleration;
            if (acceleration < -30) {
                acceleration = -30;
            }
            if (y < 20) {
                y = 20;
                acceleration = 0;
            }
        }
        if (!up) {
            acceleration++;
            y += acceleration;
            if (acceleration > 30) {
                acceleration = 30;
            }
            if (y > 475) {
                y = 475;
                acceleration = 0;
            }
        }
    }
}
