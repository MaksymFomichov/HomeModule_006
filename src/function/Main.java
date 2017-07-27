package function;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH_SCREEN = 800;
    public static final int HEIGHT_SCREEN = 800;
    private GetFunction getFunction;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);
        getFunction = new GetFunction();

        Button button = new Button();
        button.setTranslateX(10);
        button.setTranslateY(10);
        button.setText("Получить график");

        Pane root = new Pane();
        root.getChildren().addAll(button);
        root.getChildren().addAll(getFunction.getAxis());

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("График функции");
        primaryStage.show();

        button.setOnMouseClicked(event -> {
            // чистим экран (нужно для следующих нажатий на кропку "нарисовать")
            root.getChildren().clear();
            // передаем данные для отрисовки
            root.getChildren().addAll(getFunction.getX2());
            // сохраняем текущие данные для повторного вывода на экран и выводим их
            root.getChildren().addAll(button);
            root.getChildren().addAll(getFunction.getAxis());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

