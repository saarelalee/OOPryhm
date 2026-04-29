package com.oop2.memoriinjavafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Edetabel {
    public void start() throws IOException {
        double kõrgus = 350;
        double laius = 350;
        int arv = 0;

        Rectangle2D piirid = Screen.getPrimary().getVisualBounds();

        double ekraaniLaius = piirid.getWidth()-100;
        double ekraaniKõrgus = piirid.getHeight()-200;

        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);

        ArrayList<String[]> kõikAndmed = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("edetabel.txt"))) {
            String rida;
            while ((rida = br.readLine()) != null) {
                kõikAndmed.add(rida.split(";"));
            }
        }

        kõikAndmed.sort((a,b) -> {
            int p1 = Integer.parseInt(a[1]);
            int p2 = Integer.parseInt(a[1]);
            if(p1 != p2) return p2-p1;

            long t1 = Long.parseLong(a[2]);
            long t2 = Long.parseLong(b[2]);
            return Long.compare(t1, t2);
        });


        gp.add(new Label("NIMI"),0,0);
        gp.add(new Label("ÕIGEID PAARE"),1,0);
        gp.add(new Label("KULUNUD AEG"),2,0);

        int reaNumber = 1;
        for (String[] ridaOsadena : kõikAndmed) {
            gp.add(new Label(ridaOsadena[0]), 0, reaNumber);
            gp.add(new Label(ridaOsadena[1]), 1, reaNumber);

            long kokkuAeg = Long.parseLong(ridaOsadena[2]);
            long minutid = kokkuAeg / 60;
            long sekundid = kokkuAeg % 60;
            System.out.println(180 % 60);

            String ajaTekst;
            if (sekundid == 0) {
                ajaTekst = minutid + " min ";
            }
            else if (minutid > 0) {
                ajaTekst = minutid + " min " + sekundid + " s";
            } else {
                ajaTekst = sekundid + " s";
            }

            gp.add(new Label(ajaTekst), 2, reaNumber);
            reaNumber++;
            arv++;
        }


        if (arv > 7) {
            double vahe = arv - 7;
            kõrgus += 50 * vahe;
        }


        VBox vb = new VBox();

        Label pealkiri = new Label("EDETABEL");
        pealkiri.setFont(new Font(20));
        pealkiri.setPadding(new Insets(20));

        VBox üleval = new VBox();
        üleval.getChildren().add(pealkiri);

        ToggleButton valmis = new ToggleButton("Valmis");
        VBox all = new VBox();
        all.setAlignment(Pos.CENTER);
        all.setPadding(new Insets(20));
        all.getChildren().add(valmis);

        vb.getChildren().add(gp);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        bp.setTop(pealkiri);
        BorderPane.setAlignment(pealkiri,Pos.TOP_CENTER);

        ScrollPane kest = new ScrollPane();
        kest.setFitToWidth(true);
        kest.setContent(vb);
        bp.setCenter(kest);



        bp.setBottom(all);
        BorderPane.setAlignment(valmis,Pos.BOTTOM_CENTER);

        Scene scene = new Scene(bp, laius, kõrgus);
        Stage stage = new Stage();
        stage.setTitle("Edetabel");
        stage.setScene(scene);
        stage.setMaxHeight(ekraaniKõrgus);
        stage.setMaxWidth(ekraaniLaius);

        valmis.setOnMousePressed(e -> {
            System.out.println("valmis");
            valmis.setDisable(true);
            stage.close();
        });

        stage.show();
    }

    static void main() {
        Platform.startup(() -> {
            // Vajalik lõimel jooksutamiseks
            Edetabel ed = new Edetabel();
            try {
                ed.start();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
