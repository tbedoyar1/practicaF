package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
public void start(Stage stage) throws Exception {
    // Intenta cargar el archivo FXML desde el paquete /ui
    FXMLLoader loader = new FXMLLoader(App.class.getResource("/ui/layout.fxml"));
    
    // Verificación por consola
    System.out.println("Cargando layout desde: " + App.class.getResource("/ui/layout.fxml"));
    
    Scene scene = new Scene(loader.load());
    stage.setTitle("Práctica III - Algoritmos de Caminos Múltiples");
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
}


    public static void main(String[] args) {
        launch();
    }
}
