package tools.main;

import java.awt.*;
import java.awt.image.*;

import tools.EdgeDetector;
import tools.EdgeDetectorException;

public class Flow {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Image sourceImage=new Image("tis");
		
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
		//yourPanel.show(edgeImage);
	}
	
	
	

}
