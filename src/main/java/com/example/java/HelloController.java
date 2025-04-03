package com.example.java;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Line> tableView;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        logger.info("Hello button clicked, welcome text updated.");
    }

    @FXML
    public void initialize() {
        List<Line> expenses = ExpenseDAO.getAllExpenses();
        tableView.getItems().setAll(expenses);
        logger.info("TableView initialized with expenses.");
    }

    @FXML
    protected void onAddLineButtonClick() {
        AddLineDialog dialog = new AddLineDialog();
        dialog.display();
        Line newLine = dialog.getNewLine();
        if (newLine != null) {
            ObservableList<Line> lines = tableView.getItems();
            lines.add(newLine);
            logger.info("New line added: {}", newLine);
        }
    }

    private void saveLinesToFile(List<Line> lines) {
        try (FileWriter writer = new FileWriter("lines.csv")) {
            for (Line line : lines) {
                writer.write(String.format("%s,%f,%f,%f,%f,%f,%f,%f,%f%n",
                        line.getPeriode(), line.getTotal(), line.getLogement(), line.getNouriture(),
                        line.getSorties(), line.getVoiture(), line.getVoyage(), line.getImpots(), line.getAutres()));
            }
            logger.info("Lines saved to file.");
        } catch (IOException e) {
            logger.error("Failed to save lines to file", e);
        }
    }
}