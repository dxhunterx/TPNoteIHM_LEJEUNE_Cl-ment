package formes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Forme {

	public Ellipse(double x1, double y1, double x2, double y2,Color color) {
		super(x1, y1, x2, y2,color);

	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setLineWidth(width);
		gc.setStroke(color);
		if(x2 >= x1) {
    	    if(y2 >= y1) {
    	    	gc.strokeOval(x1, y1, x2-x1, y2  - y1);
    	    }else {
    	    	gc.strokeOval(x1, y2 , x2-x1, y1 - y2 );
    	    }
    	} else if(y2  >= y1) {
	    	gc.strokeOval(x2, y1, x1-x2, y2 - y1);
	    }else {
	    	gc.strokeOval(x2, y2 , x1-x2, y1 -y2 );
	    }
		
	}
	
	
	@Override
	public Forme clone() {
		Ellipse clone = new Ellipse(x1,y1,x2,y2,color);
		clone.translate(30,30);
		return clone;
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



}
