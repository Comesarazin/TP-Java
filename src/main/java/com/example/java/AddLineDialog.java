package com.example.java;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddLineDialog {
    private Line newLine;

    public Line getNewLine() {
        return newLine;
    }

    public void display() {
        Stage dialog = new Stage();
        dialog.setTitle("Ajouter une nouvelle ligne");
        dialog.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label periodeLabel = new Label("Période:");
        GridPane.setConstraints(periodeLabel, 0, 0);
        TextField periodeInput = new TextField();
        GridPane.setConstraints(periodeInput, 1, 0);

        Label totalLabel = new Label("Total:");
        GridPane.setConstraints(totalLabel, 0, 1);
        TextField totalInput = new TextField();
        GridPane.setConstraints(totalInput, 1, 1);

        Label logementLabel = new Label("Logement:");
        GridPane.setConstraints(logementLabel, 0, 2);
        TextField logementInput = new TextField();
        GridPane.setConstraints(logementInput, 1, 2);

        Label nouritureLabel = new Label("Nouriture:");
        GridPane.setConstraints(nouritureLabel, 0, 3);
        TextField nouritureInput = new TextField();
        GridPane.setConstraints(nouritureInput, 1, 3);

        Label sortiesLabel = new Label("Sorties:");
        GridPane.setConstraints(sortiesLabel, 0, 4);
        TextField sortiesInput = new TextField();
        GridPane.setConstraints(sortiesInput, 1, 4);

        Label voitureLabel = new Label("Voiture:");
        GridPane.setConstraints(voitureLabel, 0, 5);
        TextField voitureInput = new TextField();
        GridPane.setConstraints(voitureInput, 1, 5);

        Label voyageLabel = new Label("Voyage:");
        GridPane.setConstraints(voyageLabel, 0, 6);
        TextField voyageInput = new TextField();
        GridPane.setConstraints(voyageInput, 1, 6);

        Label impotsLabel = new Label("Impôts:");
        GridPane.setConstraints(impotsLabel, 0, 7);
        TextField impotsInput = new TextField();
        GridPane.setConstraints(impotsInput, 1, 7);

        Label autresLabel = new Label("Autres:");
        GridPane.setConstraints(autresLabel, 0, 8);
        TextField autresInput = new TextField();
        GridPane.setConstraints(autresInput, 1, 8);

        Button addButton = new Button("Ajouter");
        GridPane.setConstraints(addButton, 1, 9);
        addButton.setOnAction(e -> {
            newLine = new Line();
            newLine.setPeriode(periodeInput.getText());
            newLine.setTotal(Float.parseFloat(totalInput.getText()));
            newLine.setLogement(Float.parseFloat(logementInput.getText()));
            newLine.setNouriture(Float.parseFloat(nouritureInput.getText()));
            newLine.setSorties(Float.parseFloat(sortiesInput.getText()));
            newLine.setVoiture(Float.parseFloat(voitureInput.getText()));
            newLine.setVoyage(Float.parseFloat(voyageInput.getText()));
            newLine.setImpots(Float.parseFloat(impotsInput.getText()));
            newLine.setAutres(Float.parseFloat(autresInput.getText()));
            ExpenseDAO.insertExpense(newLine);
            dialog.close();
        });

        grid.getChildren().addAll(
                periodeLabel, periodeInput, totalLabel, totalInput, logementLabel, logementInput,
                nouritureLabel, nouritureInput, sortiesLabel, sortiesInput, voitureLabel, voitureInput,
                voyageLabel, voyageInput, impotsLabel, impotsInput, autresLabel, autresInput, addButton
        );

        Scene scene = new Scene(grid, 400, 400);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
}