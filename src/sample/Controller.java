package sample;


import java.util.ArrayList;

import formes.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Controller {


	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private VBox vBoxA;
	
	@FXML
	private Label optionLabel;
	
	@FXML
	private VBox vBoxB;
	
	@FXML
	private RadioButton selectRadio;
	
	@FXML
	private ToggleGroup radios;
	
	@FXML
	private RadioButton ellipseRadio;
	
	@FXML
	private RadioButton rectangleRadio;
	
	@FXML
	private RadioButton lineRadio;
	
	@FXML
	private ColorPicker colorPicker;
	
	@FXML
	private ColorPicker colorPickerBis;
	
	@FXML
	private Canvas canvas;
	
    @FXML
    private Button deleteButton;

    @FXML
    private Button cloneButton;
    
    
    
    
    
    final double widthUnselect = 3;
    final double widthSelect = 6;
    Forme formeS;
    Forme formePreVisualisation;
    Color colorBordure = Color.BLACK;
    Color colorFill = Color.CORNSILK;
    double x1;
	double y1;
	double x2;
	double y2;
	ArrayList<Forme> listeF= new ArrayList<Forme>();

	public void drawAll(GraphicsContext gc) {
		gc.clearRect(0, 0, 800, 575);
		listeF.forEach(f -> f.draw(gc));
	}
	
	public void unselect(GraphicsContext gc) {
		if(formeS!=null) {
			formeS.setWidth(widthUnselect);
		formeS=null;
		drawAll(gc);
		}
	}
	
	



    
    @FXML
    public void initialize(){
    	
    	colorPicker.setValue(Color.BLACK);
    	colorPickerBis.setValue(Color.CORNSILK);
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	gc.setLineWidth(4);
    	deleteButton.setDisable(true);
    	cloneButton.setDisable(true);
    	
    	System.out.println(colorBordure);
    	
    	colorPicker.setOnAction(event ->  {
    		colorBordure = colorPicker.getValue();

            if(formeS!=null) {
            	formeS.setColorBordure(colorBordure);
            	drawAll(gc);
            }
        });
    	colorPickerBis.setOnAction(event ->  {
    		colorFill = colorPickerBis.getValue();

            if(formeS!=null) {
            	formeS.setColorFill(colorFill);
            	drawAll(gc);
            }
        });
    	
    	
    	
    	selectRadio.setOnAction(event -> {
    		deleteButton.setDisable(false);
    		deleteButton.setOnAction(eventbis-> {
    			listeF.remove(formeS);
    			drawAll(gc);
    		});
    		cloneButton.setDisable(false);
    		cloneButton.setOnAction(eventbis-> {
    			if(formeS!=null) {
    				listeF.add(formeS.clone());
    				drawAll(gc);
    			}
    			
    		});
    		
    		
    		canvas.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                	x1=event.getX();
                	y1=event.getY();
                	unselect(gc);
                	for(Forme f:listeF) {
                		if(f.touche(event.getX(), event.getY())) {
                			System.out.println("trouve");
                			formeS=f;
                			formeS.setWidth(widthSelect);
                			drawAll(gc);
                			break;
                		}
                	}
                }
            });
    		canvas.setOnMouseDragged((new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                	x2=event.getX();
                	y2=event.getY();
                	if(formeS!=null) {
                		formeS.translate(x2-x1, y2-y1);
                		drawAll(gc);
                	}
                	x1=event.getX();
                	y1=event.getY();
                }
            }));
    		canvas.setOnMouseReleased(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                	x2=event.getX();
                	y2=event.getY();
                	if(formeS!=null) {
                		formeS.translate(x2-x1, y2-y1);
                		drawAll(gc);
                	}
                	
       	
                }
            });
    		
	
    		
    	});
    	
    	
    	lineRadio.setOnAction(event -> {
    		deleteButton.setDisable(true);
    		cloneButton.setDisable(true);
    		unselect(gc);
    		canvas.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    x1=event.getX();
                    y1=event.getY();
                    
                }
            });

    		canvas.setOnMouseDragged((new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    formePreVisualisation=new Ligne(x1,y1,event.getX(),event.getY(),colorBordure,colorFill);
                    drawAll(gc);
                    formePreVisualisation.draw(gc);
                }
            }));
    		
    		canvas.setOnMouseReleased(
                    new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                	Ligne line = new Ligne(x1,y1,event.getX(),event.getY(),colorBordure,colorFill);
                	listeF.add(line);
                	drawAll(gc);
                }
            });
    		

    		
    		
    		
    		
    		
    		
        });
    	//ellipse
    	ellipseRadio.setOnAction(event -> {
    		deleteButton.setDisable(true);
    		cloneButton.setDisable(true);
    		unselect(gc);
    		canvas.setOnMousePressed(
                    new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                    x1=event.getX();
                    y1=event.getY();
                }
            });

    		canvas.setOnMouseDragged((new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    formePreVisualisation=new Ellipse(x1,y1,event.getX(),event.getY(),colorBordure,colorFill);
                    drawAll(gc);
                    formePreVisualisation.draw(gc);
                }
            }));
    		
    		canvas.setOnMouseReleased(
                    new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                	Ellipse ell = new Ellipse(x1,y1,event.getX(),event.getY(),colorBordure,colorFill);
                	listeF.add(ell);
                	drawAll(gc);
                }
            });
        });
    	//rectangle
    	rectangleRadio.setOnAction(event -> {
    		deleteButton.setDisable(true);
    		cloneButton.setDisable(true);
    		unselect(gc);
    	    
    		canvas.setOnMousePressed(
                    new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                    x1=event.getX();
                    y1=event.getY();
                }
            });

    		canvas.setOnMouseDragged((new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    formePreVisualisation=new Rectangle(x1,y1,event.getX(),event.getY(),colorBordure,colorFill);
                    drawAll(gc);
                    formePreVisualisation.draw(gc);
                }
            }));
    		
    		canvas.setOnMouseReleased(
                    new EventHandler<MouseEvent>(){

                @Override
                public void handle(MouseEvent event) {
                	Rectangle rect = new Rectangle(x1,y1,event.getX(),event.getY(),colorBordure,colorFill);
                	System.out.println(rect);
                	listeF.add(rect);
                	drawAll(gc);
                }
            });
    		
        });
    	
    }
   
}






