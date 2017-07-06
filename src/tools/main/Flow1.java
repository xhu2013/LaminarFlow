package tools.main;

import java.awt.Image;

import tools.EdgeDetector;
import tools.EdgeDetectorException;

public class Flow1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ShowPanel("E:/zzzzzzzzzzzzzzzzzzzzzzzzzzz/111.jpg");
	}

	
	public void fun(){
		EdgeDetector edgeDetector = new EdgeDetector();
		edgeDetector.setSourceImage(sourceImage);
		edgeDetector.setThreshold(128);
		edgeDetector.setWidGaussianKernel(5);
		try {
			edgeDetector.process();
		} catch (EdgeDetectorException e) {
			System.out.println(e.getMessage());
		}
		Image edgeImage = edgeDetector.getEdgeImage();
		yourPanel.show(edgeImage);
	}
}
