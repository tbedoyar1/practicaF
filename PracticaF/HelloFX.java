import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("¡JavaFX funciona correctamente! 😄");
        Scene scene = new Scene(label, 400, 150);
        stage.setScene(scene);
        stage.setTitle("Prueba JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
