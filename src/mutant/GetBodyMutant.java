package com.gmail.fomichov.m.mutant;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

public class GetBodyMutant {
    private int countParts;
    private int minRadius;
    private int maxRadius;

    private Circle[] circles;
    private Circle[] circleHead;

    public GetBodyMutant(int countParts, int minRadius, int maxRadius) {
        this.countParts = countParts;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    // получаем элементы тела мутанта
    public Circle[] drawMutant() {
        circles = new Circle[countParts];
        for (int i = 0; i < circles.length; i++) {
            double radius = randomRadius(minRadius, maxRadius);
            circles[i] = new Circle(
                    Main.WIDTH_SCREEN / 2, // х
                    Main.HEIGHT_SCREEN - getCircleY(radius, i) - 40, // y
                    radius, // radius
                    Paint.valueOf(randomColor()));
        }
        return circles;
    }

    // получаем данные для элементов головы
    public Circle[] drawPartsHead() {
        int count = countParts - 1;
        circleHead = new Circle[3];
        circleHead[0] = new Circle(Main.WIDTH_SCREEN / 2 - circles[count].getRadius() / 2, circles[count].getCenterY() - circles[count].getRadius() / 4,
                randomRadius(circles[count].getRadius() / 10, circles[count].getRadius() / 5), Paint.valueOf(randomColor())); // левый глаз
        circleHead[1] = new Circle(Main.WIDTH_SCREEN / 2 + circles[count].getRadius() / 2, circles[count].getCenterY() - circles[count].getRadius() / 4,
                randomRadius(circles[count].getRadius() / 10, circles[count].getRadius() / 5), Paint.valueOf(randomColor())); // правый глаз
        circleHead[2] = new Circle(Main.WIDTH_SCREEN / 2, circles[count].getCenterY() + circles[count].getRadius() / 4,
                randomRadius(circles[count].getRadius() / 10, circles[count].getRadius() / 5), Paint.valueOf(randomColor())); // нос
        return circleHead;
    }

    // меняем цвет на красный
    public void changeColorToRed() {
        for (int i = 0; i < circles.length; i++) {
            circles[i].setFill(Color.RED);
        }
        for (int i = 0; i < circleHead.length; i++) {
            circleHead[i].setFill(Color.RED);
        }
    }

    // получаем координату по Y для элемента мутанта, прибавляем диаметры всех предыддущих колец к текущему радиусу
    private double getCircleY(double radius, int countArray) {
        if (countArray == 0) {
            return radius;
        } else {
            double diameter = 0;
            for (int i = 0; i < countArray; i++) {
                double tempDiameter = circles[i].getRadius() * 2;
                diameter = tempDiameter + diameter;
            }
            return radius + diameter;
        }
    }

    // получаем рандомный радиус в зависимости от првоначальных значений
    private double randomRadius(double minRadius, double maxRadius) {
        return minRadius + (Math.random() * maxRadius);
    }

    // получаем рандомный цвет
    private String randomColor() {
        Random random = new Random();
        Color color = Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 0.5f);
        return color.toString();
    }

    // меняем цвет кругов на градиент серого
    public void changeColorToGradient() {
        int countStep = 255 / circles.length;
        int valueColor = 0;
        for (int i = 0; i < circles.length; i++) {
            Color color = Color.rgb(valueColor, valueColor, valueColor);
            System.out.println(valueColor);
            valueColor = valueColor + countStep;
            circles[i].setFill(color);
        }
    }
}
