package imac;

import processing.core.*;

public class MainApp extends PApplet {

    float theta = 0;

    public void setup() {
        size(640, 480, P3D);
    }

    public void draw() {
        background(220);

        theta += 0.01;

        pushMatrix();
        translate(width * 0.5f, height * 0.5f, 0);
        rotateY(theta);
        rotateX(theta);
        box(100);
        popMatrix();
    }
}
