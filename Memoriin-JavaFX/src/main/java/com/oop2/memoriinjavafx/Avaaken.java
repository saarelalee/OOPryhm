package com.oop2.memoriinjavafx;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Avaaken {
    public void start() throws IOException {
        BorderPane bp = new BorderPane();

        ToggleButton raskemLüliti = new ToggleButton("RASKEM TASE: VÄLJAS");
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

        alusta.setOnMousePressed(e -> {
            String nimiSõne = nimi.getText().trim();
            String lauaLaiusSõne = lauaLaius.getText().trim();
            String lauaPikkusSõne = lauaPikkus.getText().trim();

            ArrayList<String> vead = new ArrayList<>();


            if (nimiSõne.isEmpty()) {
                String viga = "Palun sisesta oma nimi enne mängu alustamist.";
                vead.add(viga);
            }

            if (lauaLaiusSõne.isEmpty()) {
                String viga = "Palun sisesta laius enne mängu alustamist.";
                vead.add(viga);
            }

            if (lauaPikkusSõne.isEmpty()) {
                String viga = "Palun sisesta pikkus enne mängu alustamist.";
                vead.add(viga);
            }

            MängulauaKontrollija kontrollija = new MängulauaKontrollija();

            if (!sisendiKontroll(lauaPikkusSõne) || !sisendiKontroll(lauaLaiusSõne)) {
                String viga = "Palun sisesta korreksted täisarvulised mõõdud enne mängu alustamist.";
                vead.add(viga);
            } else {
                if (!kontrollija.kasSobib(Integer.parseInt(lauaPikkusSõne),Integer.parseInt(lauaLaiusSõne))) {
                    String viga = "Palun sisesta korreksted täisarvulised mõõdud enne mängu alustamist.";
                    vead.add(viga);
                }
            }

            if (vead.isEmpty()) {
                alusta.setDisable(true);
                raskemLüliti.setDisable(true);
                nimi.setEditable(false);
                lauaLaius.setEditable(false);
                lauaPikkus.setEditable(false);

                // Alustab mänguga, hetkel puudub, saab kas luua
                System.out.println("ALGUS");
            } else {
                Alert teade = new Alert(Alert.AlertType.ERROR);
                teade.setTitle("Viga");
                teade.setHeaderText("Viga sisestuses");

                StringBuilder vigadeSõne = new StringBuilder();
                for (String s : vead) {
                    vigadeSõne.append(s).append("\n");
                }
                teade.setContentText(String.valueOf(vigadeSõne));
                teade.showAndWait();
            }

        });

        bp.setTop(pealkiri);
        bp.setBottom(all);
        BorderPane.setAlignment(pealkiri,Pos.TOP_CENTER);
        BorderPane.setAlignment(alusta,Pos.BOTTOM_CENTER);
        bp.setCenter(vb);

        Scene scene = new Scene(bp, 350, 350);
        Stage stage = new Stage();
        stage.setTitle("Memoriin");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static boolean sisendiKontroll(String sisend) {
        try {
            Integer.parseInt(sisend);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    static void main() {
        Platform.startup(() -> {
            // Vajalik lõimel jooksutamiseks, kui ei soovi hetkel ees olevat akent asendada
            Avaaken ed = new Avaaken();
            try {
                ed.start();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}


