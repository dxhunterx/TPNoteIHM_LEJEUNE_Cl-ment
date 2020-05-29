package formes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * 
 * @author LEJEUNE Clement
 *
 */
public class Ligne extends Forme{

	public Ligne(double x1, double y1, double x2, double y2,Color colorBordure, Color colorFill) {
		super(x1, y1, x2, y2,colorBordure,colorFill);

	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setLineWidth(width);
		gc.setStroke(colorBordure);
		gc.strokeLine(x1, y1,x2,y2);
		gc.setFill(colorFill);

		
	}

	@Override
	public boolean touche(double x, double y) {
		if(x2 >= x1) {
    	    if(y2 >= y1) {
    	    	if(x>=x1 &&x<=x2 && y>=y1 &&y<=y2) {
    	    		return true;
    	    	}
    	    }else {
    	    	if(x>=x1 &&x<=x2 && y<=y1 &&y>=y2) {
    	    		return true;
    	    	}
    	    }
    	} else if(y2 >= y1) {
	    	if(x<=x1 &&x>=x2 && y>=y1 &&y<=y2) {
	    		return true;
	    	}
	    }else {
	    	if(x<=x1 &&x>=x2 && y<=y1 &&y>=y2) {
	    		return true;
	    	}
	    }
		return false;
	}

	@Override
	public Forme clone() {
		Ligne clone = new Ligne(x1,y1,x2,y2,colorBordure,colorFill);
		clone.translate(30,30);
		return clone;
	}



}
