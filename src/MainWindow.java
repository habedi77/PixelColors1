


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainWindow implements Initializable
{
    @FXML public ChoiceBox modeChoiceBox;
    @FXML public Slider numberSlider;
    @FXML public StackPane mainStackPane;
    @FXML public Canvas mainCanvas;
    @FXML public Button generateButton;
    @FXML public AnchorPane root;
    @FXML public Slider ampSlider;
    @FXML public Slider freqSlider;
    
    private Pixl cGrid;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        modeChoiceBox.setItems(FXCollections.observableArrayList(CalculationMode.values()));
        
        modeChoiceBox.setValue("OneOnEuclidean");
    }
    
    public void GenerateButtonAction(ActionEvent actionEvent)
    {
        System.out.println(modeChoiceBox.getValue());
        cGrid.create((int) numberSlider.getValue(), 10,ampSlider.getValue(),
                     freqSlider.getValue(),CalculationMode.valueOf( modeChoiceBox.getValue().toString() ));
        cGrid.applyColor();
    }
    
    public Scene makeScene()
    {
        return  new Scene(root, root.getPrefWidth(), root.getPrefHeight());
    }
    public GraphicsContext getGC()
    {
        return mainCanvas.getGraphicsContext2D();
    }
    
    public ChoiceBox getModeChoiceBox()
    {
        return modeChoiceBox;
    }
    
    public Slider getNumberSlider()
    {
        return numberSlider;
    }
    
    public Canvas getMainCanvas()
    {
        return mainCanvas;
    }
    
    public Button getGenerateButton()
    {
        return generateButton;
    }
    
    public void setcGrid(Pixl cGrid)
    {
        this.cGrid = cGrid;
    }
}
