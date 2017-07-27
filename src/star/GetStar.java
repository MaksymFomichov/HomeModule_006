package star;

/*
 * решение нашел тут https://stackoverflow.com/questions/16327588/how-to-make-star-shape-in-java
 */

import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

public class GetStar {
    private int yCoordinate;
    private int xCoordinate;
    private int radius;
    private double insideRadius;
    private int countAngle;

    public GetStar(int xCoordinate, int yCoordinate, int radius, int countAngle) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = Main.HEIGHT_SCREEN - yCoordinate;
        this.radius = radius;
        this.insideRadius = radius / 2.63;
        this.countAngle = countAngle;
    }

    public Line[] drawStar() {
        Line[] lineStar = new Line[countAngle * 2];
        Point2D[] point = new Point2D[countAngle * 2];
        double startAngleRad = Math.toRadians(-18);
        double deltaAngleRad = Math.PI / countAngle;
        for (int i = 0; i < countAngle * 2; i++) {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double relX = Math.cos(angleRad);
            double relY = Math.sin(angleRad);
            if (i % 2 == 0) {
                relX = relX * radius;
                relY = relY * radius;
            } else {
                relX = relX * insideRadius;
                relY = relY * insideRadius;
            }
            point[i] = new Point2D(xCoordinate + relX, yCoordinate + relY);
        }
        // записываем координаты в линии
        for (int i = 0; i < lineStar.length; i++) {
            if (i == lineStar.length - 1) {
                lineStar[i] = new Line(point[i].getX(), point[i].getY(), point[0].getX(), point[0].getY());
            } else {
                lineStar[i] = new Line(point[i].getX(), point[i].getY(), point[i + 1].getX(), point[i + 1].getY());
            }
        }
        return lineStar;
    }
}
