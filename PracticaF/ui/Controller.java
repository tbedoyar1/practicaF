package ui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class Controller {

    @FXML
    private TextField inputNodes;

    @FXML
    private TextField inputEdges;

    @FXML
    private Canvas canvas;

    @FXML
    private Label resultLabel;

    @FXML
    private AnchorPane graphPane;

    private GraphicsContext gc;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        resultLabel.setText("Ingrese valores y genere un grafo.");
    }

    @FXML
    private void onGenerateGraph() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        resultLabel.setText("");

        // Leer entradas
        int nodes, edges;
        try {
            nodes = Integer.parseInt(inputNodes.getText());
            edges = Integer.parseInt(inputEdges.getText());
        } catch (NumberFormatException e) {
            resultLabel.setText("⚠️ Ingrese números válidos.");
            return;
        }

        if (nodes < 1) {
            resultLabel.setText("⚠️ Debe haber al menos 1 nodo.");
            return;
        }

        // Dibujar nodos aleatoriamente
        Random rand = new Random();
        double[] x = new double[nodes];
        double[] y = new double[nodes];

        for (int i = 0; i < nodes; i++) {
            x[i] = 50 + rand.nextDouble() * (canvas.getWidth() - 100);
            y[i] = 50 + rand.nextDouble() * (canvas.getHeight() - 100);

            gc.setFill(Color.SKYBLUE);
            gc.fillOval(x[i] - 15, y[i] - 15, 30, 30);

            gc.setFill(Color.BLACK);
            gc.fillText("N" + (i + 1), x[i] - 10, y[i] + 5);
        }

        // Dibujar aristas aleatorias
        for (int i = 0; i < edges; i++) {
            int n1 = rand.nextInt(nodes);
            int n2 = rand.nextInt(nodes);
            if (n1 == n2) continue; // Evita bucles

            gc.setStroke(Color.GRAY);
            gc.setLineWidth(2);
            gc.strokeLine(x[n1], y[n1], x[n2], y[n2]);
        }

        resultLabel.setText("Grafo generado con " + nodes + " nodos y " + edges + " aristas.");
    }

    @FXML
    private void onClearGraph() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        resultLabel.setText("Lienzo limpio. Puede generar un nuevo grafo.");
    }
}
