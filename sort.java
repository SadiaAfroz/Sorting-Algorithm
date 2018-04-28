
package sortingalgo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;



class sort  {

    final Pane root = new Pane();
    ComboBox<String> cb;
    final PathTransition[] pathtransition = new PathTransition[2];
    int[] data;
    final Lock lock = new ReentrantLock();
    final Condition[] swapComplete = {lock.newCondition(), lock.newCondition()};

    sort(int[] a) {
        data = a;
    }
    //  @Override

    public void start(Stage stage) {
        
        Label[] labels = createLabels(data);
         ImageView image1=new ImageView(new Image(getClass().getResourceAsStream("violet.PNG"), 800, 500, true, true));
        
        image1.setFitHeight(500);
        image1.setFitWidth(800);
        root.getChildren().addAll(image1);

        root.getChildren().addAll(labels);
       
        ObservableList<String> sorttype = FXCollections.observableArrayList("Selection Sort", " Bubble Sort", "Merge Sort");
        cb = new ComboBox<>(sorttype);
        cb.setLayoutX(580);
        cb.setLayoutY(330);
        cb.setValue(" Select type");
//        Label lmincol=new Label();
//        lmincol.setMinSize(20, 20);
//        lmincol.setMaxSize(20, 20);
//        lmincol.setStyle("-fx-background-color: khaki; "+ "-fx-font-family: Verdana; "
//                              + "-fx-font-size: 12pt; ");
//        Label lmin=new Label("Minimum value");
//        lmin.setMinSize(100, 20);
//        lmin.setMaxSize(100, 20);
//        HBox hb=new HBox(5, lmin,lmincol);
//        hb.setLayoutX(100);
//        hb.setLayoutY(330);
//         root.getChildren().addAll(hb);
        Button back = new Button("Back");
        back.setFont(Font.font("VERDANA", FontWeight.BOLD, 18));
        back.setLayoutX(0);
        back.setLayoutY(450);
        back.setMinSize(80, 50);
        DropShadow shadow = new DropShadow();
        back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            back.setEffect(shadow);
        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            back.setEffect(null);
        });
        back.setOnAction((ActionEvent event) -> {
            SortingAlgo sc=new SortingAlgo();
            try {
                sc.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
                root.getChildren().addAll(cb,back);
        cb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cb.getValue().equals("Selection Sort")) {
                    sort(data, labels);
                }
                if (cb.getValue().equals(" Bubble Sort")) {
                    bubble(data, labels);
                }
                if (cb.getValue().equals("Merge Sort")) {
                    mergesort2( labels,data);
                }
            }
        });
        
   root.setStyle("-fx-background-color: bisque;");

        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Animation");
        // stage.show();

    }
    
 private void mergesort2(Label[] rect, int[] a) {

        Thread thread = new Thread(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < 2; i++) {
                        rect[i].setStyle("-fx-background-radius: 10; "
                                + "-fx-background-color: blanchedalmond; "
                                + "-fx-font-family: Verdana; "
                                + "-fx-font-size: 12pt; "
                                + "-fx-font-weight: bold;");
                    }
                    for (int i = 2; i < 4; i++) {
                        rect[i].setStyle("-fx-background-radius: 10; "
                                + "-fx-background-color: cornflowerblue; "
                                + "-fx-font-family: Verdana; "
                                + "-fx-font-size: 12pt; "
                                + "-fx-font-weight: bold;");
                    }
                    
 for (int i = 4; i < 6; i++) {
                        rect[i].setStyle("-fx-background-radius: 10; "
                                + "-fx-background-color: coral; "
                                + "-fx-font-family: Verdana; "
                                + "-fx-font-size: 12pt; "
                                + "-fx-font-weight: bold;");
                    }
                    for (int i = 6; i < 8; i++) {
                        rect[i].setStyle("-fx-background-radius: 10; "
                                + "-fx-background-color: crimson; "
                                + "-fx-font-family: Verdana; "
                                + "-fx-font-size: 12pt; "
                                + "-fx-font-weight: bold;");
                    }
                    for(int i=8;i<10;i++){
                    rect[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: darkorange; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                    }
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                    }//Color.
                    rect[1].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: darkcyan ; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                    rect[3].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: blueviolet; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                    rect[5].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: cyan; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                    rect[7].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: gold; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");//Color.HOTPINK
                    rect[9].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: burlywood; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                            
                    int j = 0, m = 1;
                    int num=10;
                            int rght, wid, rend;
    int ik,jk,mk,tk;
    int[] b =new int[10];
    Label[] bs=new Label[10];
                        for (int k=1; k < num; k *= 2 ) {       
        for (int left=0; left+k < num; left += k*2 ) {
            rght = left + k;        
            rend = rght + k;
            if (rend > num) rend = num; 
            mk = left; ik = left; jk = rght; 
            while (ik < rght && jk < rend) { 
                if (a[ik] <= a[jk]) {         
                    b[mk] = a[ik];
                    rect[ik].setLayoutX(70*mk+20);
                     rect[ik].setLayoutY(150+70);
                     bs[mk]=rect[ik];
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println("index :"+ i +" "+ m);
                    ik++;
                   
                } else {
                    b[mk] = a[jk]; 
                     rect[jk].setLayoutX(70*mk+20);
                     rect[jk].setLayoutY(150+70);
                     bs[mk]=rect[jk];
                    try {
                        Thread.sleep(1000);
                        //System.out.println("index :"+ j +" "+ m);
                        jk++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                mk++;
            }
            while (ik < rght) { 
                b[mk]=a[ik];
                 rect[ik].setLayoutX(70*mk+20);
                     rect[ik].setLayoutY(150+70);
                     bs[mk]=rect[ik];
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("index :"+ i +" "+ m);
                ik++; mk++;
            }
            while (jk < rend) { 
                b[mk]=a[jk]; 
                 rect[jk].setLayoutX(70*mk+20);
                     rect[jk].setLayoutY(150+70);
                     bs[mk]=rect[jk];
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("index :"+ j +" "+ m);
                jk++; mk++;
            }
            for (mk=left; mk < rend; mk++) { 
                a[mk] = b[mk]; 
                bs[mk].setLayoutX(70*mk+20);
                     bs[mk].setLayoutY(150);
                     
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(left==0 && mk==2){
                for(int i=0;i<2;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: darkcyan; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
                
            }
            else if(left==2 && mk==4){
                for(int i=2;i<4;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: blueviolet; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
            }
            else if(left==4 && mk==6){
                for(int i=4;i<6;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: cyan; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
            }
            else if(left==6 && mk==8){
                for(int i=6;i<8;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: gold; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
            }
            else if(left==8 && mk==10){
                for(int i=8;i<10;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: burlywood; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
            }
            else if(left==0 && mk==4){
                for(int i=0;i<4;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: blueviolet; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
            }
            else if(left==4 && mk==8){
                for(int i=4;i<8;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: cyan; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
            }
            else if(left==0 && mk==8){
                for(int i=0;i<8;i++){
                    bs[i].setStyle("-fx-background-radius: 10; "
                            + "-fx-background-color: yellow; "
                            + "-fx-font-family: Verdana; "
                            + "-fx-font-size: 12pt; "
                            + "-fx-font-weight: bold;");
                }
            }
                
            
             for(int w=left;w<rend;w++){
                            //System.out.println(rect[y].getLayoutX()+" "+rect[y].getLayoutY()+" "+rect[y].getText());
                            rect[w]=bs[w];
                            }
            
        }
        
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
              
                             
                }
                        for(int gf=0;gf<10;gf++){
                                 rect[gf].setStyle("-fx-background-radius: 10; "
                                + "-fx-background-color: greenyellow; "
                                + "-fx-font-family: Verdana; "
                                + "-fx-font-size: 12pt; "
                                + "-fx-font-weight: bold;");
                            }
                         }
        );
        thread.setDaemon(true);
        thread.start();
    }
 
 
 private void bubble(int[] a, Label[] rect){
    Thread thread = new Thread(
                () -> {
                       int n = a.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
              rect[i].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: yellow; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                        try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sort .class.getName()).log(Level.SEVERE, null, ex);
                    }      
                 for(int j=1; j < (n-i); j++){  
                          if(a[j-1] > a[j]){  
                              rect[i].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: orange; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                                 //swap elements  
                                 temp = a[j-1];  
                                 a[j-1] = a[j];  
                                 a[j] = temp;
                                  rect[j-1].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: aqua; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                                   rect[j].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: aqua; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                            final int finalMin =j ;
                            final int finalI = j-1;
                            FutureTask<Void> future = new FutureTask<>(
                                    () -> {
                                        swap(
                                                0,
                                                rect[finalI],
                                                60,
                                                rect[finalMin].getLayoutX() - rect[finalI].getLayoutX(),
                                                Duration.seconds(3)
                                        );
                                        swap(
                                                1,
                                                rect[finalMin],
                                                -60,
                                                rect[finalI].getLayoutX() - rect[finalMin].getLayoutX(),
                                                Duration.seconds(4)
                                        );

                                        return null;
                                    }
                            );

                            lock.lock();
                            try {
                                Platform.runLater(future);
                               // future.get();
                                for (Condition condition : swapComplete) {
                                    condition.await();
                                }
                            } catch (InterruptedException e) {
                                Thread.interrupted();
                                break;
                            } 
//                            catch (ExecutionException e) {
//                                e.printStackTrace();
//                                break;
//                            }
                            finally {
                                lock.unlock();
                            }
                              
                            Label temporary = rect[j-1];
                            rect[j-1] = rect[j];
                            rect[j] = temporary;
                            rect[j-1].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: orange; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                                   rect[j].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: orange; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                        }
                          
                         
                        //System.out.println(a[i]);
                    
                          
                      //  System.out.println(a[j]);
                    }
//                
//                    rect[10-i-1].setStyle("-fx-background-radius: 10; " +
//                "-fx-background-color: chartreuse; " + 
//                "-fx-font-family: Verdana; " +
//                "-fx-font-size: 12pt; " +
//                "-fx-font-weight: bold;");
             
               
                }
           for(int k=0;k<10;k++){
                    rect[k].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: chartreuse; " + 
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                }
                }
        );
        thread.setDaemon(true);
        thread.start();
}
 

 private void sort(int[] a, Label[] rect) {
        // Selection Sort
        Thread thread = new Thread(
                () -> {
                    int min;
                    for (int i = 0; i < a.length; i++) {
                            rect[i].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: yellow; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                        try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(sort .class.getName()).log(Level.SEVERE, null, ex);
                    }      
                        min = i;
                        for (int j = i + 1; j < a.length; j++) {
                            if (a[j] < a[min]) {
                                min = j;

                            }
                        }
                        if (min != i) {
                            int temp = a[i];
                            a[i] = a[min];
                            a[min] = temp;
                            final int finalMin = min;
                            final int finalI = i;
                             rect[min].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: khaki; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");//Color.KHAKI
                            FutureTask<Void> future = new FutureTask<>(
                                    () -> {
                                        swap(
                                                0,
                                                rect[finalI],
                                                60,
                                                rect[finalMin].getLayoutX() - rect[finalI].getLayoutX(),
                                                Duration.seconds(3)
                                        );
                                        swap(
                                                1,
                                                rect[finalMin],
                                                -60,
                                                rect[finalI].getLayoutX() - rect[finalMin].getLayoutX(),
                                                Duration.seconds(4)
                                        );

                                        return null;
                                    }
                            );

                            lock.lock();
                            try {
                                Platform.runLater(future);
                                future.get();
                                for (Condition condition : swapComplete) {
                                    condition.await();
                                }
                            } catch (InterruptedException e) {
                                Thread.interrupted();
                                break;
                            }   catch (ExecutionException ex) { 
                                    Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
                                } 
//                            catch (ExecutionException e) {
//                                e.printStackTrace();
//                                break;
//                            } 
                            finally {
                                lock.unlock();
                            }
                             rect[i].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: orange; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                             rect[min].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: orange; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                            Label temporary = rect[i];
                            rect[i] = rect[min];
                            rect[min] = temporary;
                        }
                        else
                        rect[i].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: orange; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                        System.out.println(a[i]);
                     for(int j=0;j<=i;j++){
                          rect[j].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: chartreuse; " +
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                     }   
                    }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(sort.class.getName()).log(Level.SEVERE, null, ex);
            }
                    for(int k=0;k<10;k++){
                    rect[k].setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: chartreuse; " + 
                "-fx-font-family: Verdana; " +
                "-fx-font-size: 12pt; " +
                "-fx-font-weight: bold;");
                }
                }
        );
        thread.setDaemon(true);
        thread.start();
    }
 
 private Label[] createLabels(int[] a) {
        Label[] rect = new Label[a.length];

        for (int i = 0; i < a.length; i++) {
            createLabel(i, a, rect);
        }

        return rect;
    }

    private void createLabel(int i, int[] a, Label[] rect) {
        rect[i] = new Label(Integer.toString(a[i]));
        rect[i].setMinSize(50, 50);
        rect[i].setMaxSize(50, 50);
        rect[i].setAlignment(Pos.CENTER);
        rect[i].setStyle(
                "-fx-background-radius: 10; "
                + "-fx-background-color: orange ; "// Color.LAVENDER
                + "-fx-font-family: Verdana; "
                + "-fx-font-size: 12pt; "
                + "-fx-font-weight: bold;"
        );
        rect[i].relocate(70 * i + 20, 150);
    }

    void swap(int transitionIdx, Region node, double dy, double dx, Duration duration) {
        double cx = node.getWidth() / 2;
        double cy = node.getHeight() / 2;

        Path path1 = new Path(
                new MoveTo(cx, cy),
                new LineTo(cx, cy + dy),
                new LineTo(dx + cx, cy + dy),
                new LineTo(dx + cx, cy)
        );

        pathtransition[transitionIdx] = new PathTransition(duration, path1, node);

        pathtransition[transitionIdx].setOnFinished(event -> {
            node.setLayoutX(node.getLayoutX() + node.getTranslateX());
            node.setLayoutY(node.getLayoutY() + node.getTranslateY());
            node.setTranslateX(0);
            node.setTranslateY(0);

            lock.lock();
            try {
                swapComplete[transitionIdx].signal();
            } finally {
                lock.unlock();
            }
        });

        pathtransition[transitionIdx].play();
    }

}

  
    