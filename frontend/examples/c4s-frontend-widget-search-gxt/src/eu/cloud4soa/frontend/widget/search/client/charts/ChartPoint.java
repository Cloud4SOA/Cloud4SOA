package eu.cloud4soa.frontend.widget.search.client.charts;

public class ChartPoint {
	double x;
	double y;
	
	public ChartPoint (double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
}
