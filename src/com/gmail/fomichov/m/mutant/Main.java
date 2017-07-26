package com.gmail.fomichov.m.mutant;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH_SCREEN = 800;
    public static final int HEIGHT_SCREEN = 800;
    private GetBodyMutant getBodyMutant;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);

        Text textCount = new Text();
        textCount.setTranslateX(10);
        textCount.setTranslateY(15);
        textCount.setText("количество элементов мутанта");
        TextField countCircle = new TextField();
        countCircle.setTranslateX(10);
        countCircle.setTranslateY(20);
        countCircle.setText("5");

        Text textMinRadius = new Text();
        textMinRadius.setTranslateX(10);
        textMinRadius.setTranslateY(65);
        textMinRadius.setText("минимальный радиус");
        TextField minRadius = new TextField();
        minRadius.setTranslateX(10);
        minRadius.setTranslateY(70);
        minRadius.setText("10");

        Text textMaxRadius = new Text();
        textMaxRadius.setTranslateX(10);
        textMaxRadius.setTranslateY(115);
        textMaxRadius.setText("максимальный радиус");
        TextField maxRadius = new TextField();
        maxRadius.setTranslateX(10);
        maxRadius.setTranslateY(120);
        maxRadius.setText("100");

        Button button = new Button();
        button.setTranslateX(10);
        button.setTranslateY(160);
        button.setText("Нарисовать мутанта");

        Button buttonRed = new Button();
        buttonRed.setTranslateX(10);
        buttonRed.setTranslateY(190);
        buttonRed.setText("Закрасить мутанта в красный");

        Pane root = new Pane();
        root.getChildren().addAll(textCount, textMinRadius, textMaxRadius,
                countCircle, minRadius, maxRadius, button, buttonRed);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("МутантиК");
        primaryStage.show();


        // обрабатываем нажатие на кнопку "нарисовать мутанта"
        button.setOnMouseClicked(event -> {
            // получаем данные с полей
            int count = Integer.parseInt(countCircle.getText());
            int minRad = Integer.parseInt(minRadius.getText());
            int maxRad = Integer.parseInt(maxRadius.getText());
            getBodyMutant = new GetBodyMutant(count, minRad, maxRad);
            // чистим экран (нужно для следующих нажатий на кропку "нарисовать")
            root.getChildren().clear();
            // передаем данные для отрисовки
            root.getChildren().addAll(getBodyMutant.drawMutant());
            root.getChildren().addAll(getBodyMutant.drawPartsHead());
            // сохраняем текущие данные для повторного вывода на экран и выводим их
            countCircle.setText(String.valueOf(count));
            minRadius.setText(String.valueOf(minRad));
            maxRadius.setText(String.valueOf(maxRad));
            root.getChildren().addAll(textCount, textMinRadius, textMaxRadius,
                    countCircle, minRadius, maxRadius, button, buttonRed);
        });

        // обрабатываем нажате на кнопку "закрасить красным"
        buttonRed.setOnMouseClicked(event -> {
            getBodyMutant.changeColorToRed();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
