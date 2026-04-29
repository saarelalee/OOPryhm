package com.oop2.memoriinjavafx;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Avaaken {
    public void start() throws IOException {
        double kõrgus = 350;
        double laius = 350;
        int arv = 0;

        Rectangle2D piirid = Screen.getPrimary().getVisualBounds();

        double ekraaniLaius = piirid.getWidth()-100;
        double ekraaniKõrgus = piirid.getHeight()-200;

        BorderPane bp = new BorderPane();

        ToggleButton raskemLüliti = new ToggleButton("Raskem tase");
        TextField nimi = new TextField();
        nimi.setAlignment(Pos.CENTER);
        nimi.setMaxWidth(150);
        nimi.setPromptText("Sisesta oma nimi");

        TextField lauaPikkus = new TextField();
        lauaPikkus.setAlignment(Pos.CENTER);
        lauaPikkus.setPromptText("Sisesta mängulaua pikkus täisarvuna");

        TextField lauaLaius = new TextField();
        lauaLaius.setAlignment(Pos.CENTER);
        lauaLaius.setPromptText("Sisesta mängulaua laius täisarvuna");


        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setMaxWidth(250);
        vb.setSpacing(20);
        vb.getChildren().addAll(raskemLüliti,nimi, lauaPikkus, lauaLaius);

        raskemLüliti.setOnAction(e -> {
            if (raskemLüliti.isSelected()) {
                raskemLüliti.setText("RASKEM TASE: SEES");
            } else {
                raskemLüliti.setText("RASKEM TASE: VÄLJAS");
            }

            if (nimi.getText().trim().isEmpty()) {
                Alert teade = new Alert(Alert.AlertType.ERROR);
                teade.setTitle("Viga sisestuses");
                teade.setHeaderText("Nimi puudub!");
                teade.setContentText("Palun sisesta oma nimi enne mängu alustamist.");
                teade.showAndWait();
            }
        });

        Label pealkiri = new Label("MEMORIIN");
        pealkiri.setFont(new Font(20));
        pealkiri.setPadding(new Insets(20));

        VBox üleval = new VBox();
        üleval.getChildren().add(pealkiri);

        ToggleButton alusta = new ToggleButton("Alusta");
        VBox all = new VBox();
        all.setAlignment(Pos.CENTER);
        all.setPadding(new Insets(20));
        all.getChildren().add(alusta);

        alusta.setOnAction(e -> {
            String nimiSõne = nimi.getText().trim();
            String lauaLaiusSõne = lauaLaius.getText().trim();
            String lauaPikkusSõne = lauaPikkus.getText().trim();


            if (nimiSõne.isEmpty()) {
                Alert teade = new Alert(Alert.AlertType.ERROR);
                teade.setTitle("Viga sisestuses");
                teade.setHeaderText("Nimi puudub!");
                teade.setContentText("Palun sisesta oma nimi enne mängu alustamist.");
                teade.showAndWait();
            }

            if (lauaLaiusSõne.isEmpty()) {
                Alert teade = new Alert(Alert.AlertType.ERROR);
                teade.setTitle("Viga sisestuses");
                teade.setHeaderText("Mängulaua laius puudub!");
                teade.setContentText("Palun sisesta laius enne mängu alustamist.");
                teade.showAndWait();
            }

            if (lauaPikkusSõne.isEmpty()) {
                Alert teade = new Alert(Alert.AlertType.ERROR);
                teade.setTitle("Viga sisestuses");
                teade.setHeaderText("Mängulaua pikkus puudub!");
                teade.setContentText("Palun sisesta pikkus enne mängu alustamist.");
                teade.showAndWait();
            }

            if (!sisendiKontroll(lauaPikkusSõne) || !sisendiKontroll(lauaLaiusSõne)) {
                Alert teade = new Alert(Alert.AlertType.ERROR);
                teade.setTitle("Viga sisestuses");
                teade.setHeaderText("Mõõtudes puuduvad täisarvud");
                teade.setContentText("Palun sisesta korreksted täisarvulised mõõdud enne mängu alustamist.");
                teade.showAndWait();
            }
        });

        bp.setTop(pealkiri);
        bp.setBottom(all);
        BorderPane.setAlignment(pealkiri,Pos.TOP_CENTER);
        BorderPane.setAlignment(alusta,Pos.BOTTOM_CENTER);
        bp.setCenter(vb);





        Scene scene = new Scene(bp, laius, kõrgus);
        Stage stage = new Stage();
        stage.setTitle("Memoriin");
        stage.setScene(scene);
        stage.setMaxHeight(ekraaniKõrgus);
        stage.setMaxWidth(ekraaniLaius);
        stage.show();
    }

    static void main() {
        Platform.startup(() -> {
            // Vajalik lõimel jooksutamiseks
            Avaaken ed = new Avaaken();
            try {
                ed.start();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    static boolean sisendiKontroll(String sisend) {
        try {
            Integer.parseInt(sisend);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
