
package sortingalgo;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class SortingAlgo extends Application {
    
  private void starting(Stage stage) {
        
        Pane grid = new Pane();
        Text txt = new Text(200, 50+40, "Welcome To");
        txt.setFont(Font.font("VERDANA", FontWeight.LIGHT, FontPosture.ITALIC, 20));

        //txt.set
        Text txt2 = new Text(140, 80+40, "Sorting Algorithm Simulation ");
        txt2.setFont(Font.font("VERDANA", FontWeight.BOLD, 18));

        Text txt3 = new Text(10, 150+20, "Input:(Only Integers)");
        txt3.setFont(Font.font("VERDANA", FontWeight.MEDIUM, 14));
        
        ImageView image=new ImageView(new Image(getClass().getResourceAsStream("background_image1.jpg"), 600, 400, true, true));
        
        image.setFitHeight(400);
        image.setFitWidth(600);
                grid.getChildren().add(image);
        grid.getChildren().addAll(txt, txt2, txt3);


        TextField tf1 = new TextField();
        tf1.setMaxSize(30, 10);
        TextField tf2 = new TextField();
        tf2.setMaxSize(30, 10);
        TextField tf3 = new TextField();
        tf3.setMaxSize(30, 10);
        TextField tf4 = new TextField();
        tf4.setMaxSize(30, 10);
        TextField tf5 = new TextField();
        tf5.setMaxSize(30, 10);
        TextField tf6 = new TextField();
        tf6.setMaxSize(30, 10);
        TextField tf7 = new TextField();
        tf7.setMaxSize(30, 10);
        TextField tf8 = new TextField();
        tf8.setMaxSize(30, 10);
        TextField tf9 = new TextField();
        tf9.setMaxSize(30, 10);
        TextField tf10 = new TextField();
        tf10.setMaxSize(30, 10);

        HBox hb = new HBox();
        hb.setLayoutX(50);
        hb.setLayoutY(170+20);
        hb.setSpacing(10);
        hb.getChildren().addAll(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10);

        Button randbut = new Button("Random Input");
        randbut.setLayoutX(100);
        randbut.setLayoutY(220+30);
        randbut.setMinSize(80, 20);
        DropShadow shadow1 = new DropShadow();
        randbut.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            randbut.setEffect(shadow1);
        });
        randbut.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            randbut.setEffect(null);
        });
        List<TextField> txf = Arrays.asList(tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10);
        randbut.setOnAction((ActionEvent event) -> {
            Iterator<TextField> iterator = txf.iterator();
            while (iterator.hasNext()) {
                iterator.next().setText(Integer.toString((int) (Math.random() * 100)));
            }
        });
        
        Button start = new Button("Start");
        start.setFont(Font.font("VERDANA", FontWeight.BOLD, 18));
        start.setLayoutX(400);
        start.setLayoutY(250);
        start.setMinSize(80, 50);
        DropShadow shadow = new DropShadow();
        start.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            start.setEffect(shadow);
        });
        start.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            start.setEffect(null);
        });

        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int[] a = new int[10];
                a[0] = Integer.parseInt(tf1.getText());
                a[1] = Integer.parseInt(tf2.getText());
                a[2] = Integer.parseInt(tf3.getText());
                a[3] = Integer.parseInt(tf4.getText());
                a[4] = Integer.parseInt(tf5.getText());
                a[5] = Integer.parseInt(tf6.getText());
                a[6] = Integer.parseInt(tf7.getText());
                a[7] = Integer.parseInt(tf8.getText());
                a[8] = Integer.parseInt(tf9.getText());
                a[9] = Integer.parseInt(tf10.getText());

                //System.out.println("Hello World!");
                sort sortwindow = new sort(a);
                sortwindow.start(stage);
            }
        });

        grid.getChildren().addAll(hb, start, randbut);
        //grid.getChildren().addAll(tf[0]);
       // grid.setStyle("-fx-background-color: bisque;");

        stage.setScene(new Scene(grid, 600, 400/*,Color.*/));
        stage.setTitle("Input Window");
    }

    @Override
    public void start(Stage stage) throws Exception {

        starting(stage);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
