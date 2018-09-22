/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application
{
    private int WINDOW_WIDTH;
    private int WINDOW_HEIHGT;
    
    private Scene scene;
    MainWindow controller;
    private Canvas can;
    private GraphicsContext gc;
    
    private Pixl cGrid;

    
    
    public Main()
    {
    
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        essentials(primaryStage);
    
        
        int w = 1;
        
        cGrid = new Pixl(WINDOW_HEIHGT / w, 100, w);
        cGrid.setGc(gc);
        controller.setcGrid(cGrid);
        
        
        prepareHendlers();
        
        
    }
    
    public void essentials(Stage primaryStage) throws IOException
    {
        // GET FXMLController
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("mainWindow.fxml").openStream());
        controller = fxmlLoader.getController();
        //
        
        scene = controller.makeScene();
        
        

        primaryStage.setTitle("Light Mixture!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        can = controller.getMainCanvas();
        WINDOW_HEIHGT = (int) can.getHeight();
        WINDOW_WIDTH = (int) can.getWidth();
        gc = controller.getGC();
       
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    public  void prepareHendlers()
    {
    }
    
}
