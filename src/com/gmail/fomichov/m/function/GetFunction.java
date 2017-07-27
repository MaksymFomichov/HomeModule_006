package com.gmail.fomichov.m.function;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class GetFunction {


    public Line[] getAxis() {
        Line[] lineAxis = new Line[2];
        lineAxis[0] = new Line(Main.WIDTH_SCREEN / 2, 0, Main.WIDTH_SCREEN / 2, Main.HEIGHT_SCREEN);
        lineAxis[1] = new Line(0, Main.HEIGHT_SCREEN / 2, Main.WIDTH_SCREEN, Main.HEIGHT_SCREEN / 2);
        return lineAxis;
    }

    public Circle[] getX2() {
        int value = -400;
        Circle[] circles = new Circle[value * -2 + 1];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(getRealX(value), getRealY(Math.pow(value, 2)), 2);
            //circles[i] = new Circle(getRealX(value), getRealY(Math.pow(value, 3)), 2);
            // circles[i] = new Circle(getRealX(value), getRealY(Math.cos(value)), 2);
            value++;
        }
        return circles;
    }

    private double getRealX(double x) {
        return Main.WIDTH_SCREEN / 2 + x;
    }

    private double getRealY(double y) {
        return Main.HEIGHT_SCREEN / 2 - y;
    }
}
