package com.example.java;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Line> tableView;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize() {
        List<Line> expenses = ExpenseDAO.getAllExpenses();
        tableView.getItems().setAll(expenses);
    }

    @FXML
    protected void onAddLineButtonClick() {
        AddLineDialog dialog = new AddLineDialog();
        dialog.display();
        Line newLine = dialog.getNewLine();
        if (newLine != null) {
            ObservableList<Line> lines = tableView.getItems();
            lines.add(newLine);
        }
    }

    private void saveLinesToFile(List<Line> lines) {
        try (FileWriter writer = new FileWriter("lines.csv")) {
            for (Line line : lines) {
                writer.write(String.format("%s,%f,%f,%f,%f,%f,%f,%f,%f%n",
                        line.getPeriode(), line.getTotal(), line.getLogement(), line.getNouriture(),
                        line.getSorties(), line.getVoiture(), line.getVoyage(), line.getImpots(), line.getAutres()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}