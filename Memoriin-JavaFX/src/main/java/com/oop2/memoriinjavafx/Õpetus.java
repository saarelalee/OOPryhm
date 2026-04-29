package com.oop2.memoriinjavafx;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Õpetus {
    public void start() {
        BorderPane bp = new BorderPane();

        Label tekst = new Label("Memoriin.\n" +
                "Leia mängulaualt võimalikult kiiresti sümbolite paarid.\n" +
                "Mäng lõppeb, kui kõik paarid on leitud " +
                "või nupu \"sulge\" vajutamisel.\n" +
                "Pane tähele! Mängulaual laiusega m " +
                "ja pikkusega n arvestatakse " +
                "elementide koordinaate järgnevalt:\n" +
                "(0,0) (0,1) … (0,m)\n" +
                "(1,0) (1,1) … (1,m)\n" +
                "  …     …   …   …\n" +
                "(n,0) (n,1) … (n,m)");
        tekst.setWrapText(true);
        tekst.setMaxWidth(400);
        tekst.setTextAlignment(TextAlignment.CENTER);

        VBox vb = new VBox();
        vb.getChildren().add(tekst);
        vb.setAlignment(Pos.CENTER);

        bp.setCenter(vb);

        ToggleButton sulge = new ToggleButton("Sulge");
        HBox all = new HBox();
        all.setAlignment(Pos.CENTER);
        all.setPadding(new Insets(20));
        all.setSpacing(20);
        all.getChildren().add(sulge);

        bp.setBottom(all);

        Scene scene = new Scene(bp, 320,320);
        Stage stage = new Stage();
        stage.setTitle("Juhend");
        stage.setScene(scene);

        sulge.setOnMousePressed(e -> {
            System.out.println("sulgemine");
            sulge.setDisable(true);
            stage.close();
        });

        stage.show();
    }

    static void main() {
        Platform.startup(() -> {
            // Vajalik lõimel jooksutamiseks, kui ei soovi hetkel ees olevat akent asendada
            Õpetus ed = new Õpetus();
            ed.start();
        });
    }
}
