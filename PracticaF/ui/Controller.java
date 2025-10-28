package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField inputNodes;

    @FXML
    private Button generateButton;

    @FXML
    private Label outputLabel;

    @FXML
    public void initialize() {
        outputLabel.setText("Listo para generar el grafo.");
    }

    @FXML
    private void onGenerateGraph() {
        String value = inputNodes.getText();
        outputLabel.setText("Se generó un grafo con " + value + " nodos (simulado).");
    }
}
