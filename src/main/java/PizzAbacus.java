import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class PizzAbacus extends Application {

    private DecimalFormat df2 = new DecimalFormat("#.##");

    Image image = new Image ("/pizza2.png", 500, 500, true, false);
    private BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    private BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    private Background background = new Background(backgroundImage);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5.0);
        gridPane.setVgap(5.0);
        gridPane.setBackground(background);

        Button ok = new Button ("Calculate");
        Label label = new Label();
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font(35));
        Label diameterText = new Label("Enter pizza diameter");
        diameterText.setFont(Font.font(32));
        Label priceText = new Label("Enter pizza price");
        priceText.setFont(Font.font(32));
        TextField diameter = new TextField();
        TextField price = new TextField();
        gridPane.add(diameterText, 10, 20);
        gridPane.add(priceText, 30, 20);
        gridPane.add(ok, 50, 50);
        gridPane.add(diameter, 10,25);
        gridPane.add(price, 30,25);
        gridPane.add(label, 10, 50);
        Scene scene = new Scene(gridPane, 900, 600, Color.BLUEVIOLET);

        ok.setOnAction(event -> {
            double diam = Double.parseDouble(diameter.getText());
            double prc = Double.parseDouble(price.getText());
            diam /= 2;
            double finPrice = (prc / (3.14 * (diam * diam))) * 10000;
            System.out.println(finPrice);
            System.out.println(diam);
            label.setText(df2.format(finPrice) + " zl \n" +
                            "per square meter \nof pizza");

        });
        primaryStage.setTitle("PizzAbacus");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
