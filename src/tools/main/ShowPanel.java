package tools.main;

import java.awt.*;

import tools.EdgeDetector;
import tools.EdgeDetectorException;
import tools.images.ShowImage;

public class ShowPanel extends Frame {

	String filename;
	
	

	public ShowPanel(String filename) {

		this.setSize(420, 350);

		this.setVisible(true);

		this.filename = filename;
	}

	public void paint(Graphics g) {

		Image image = this.getToolkit().getImage(filename);
		
		Image edgeImage =edgeDetect(image);
		
		g.drawImage(edgeImage, 0, 0, this);

	}

	public static void main(String[] args) {

		new ShowPanel("E:/zzzzzzzzzzzzzzzzzzzzzzzzzzz/111.jpg");

	}
	
	public Image edgeDetect(Image sourceImage){
		EdgeDetector edgeDetector = new EdgeDetector();
		edgeDetector.setSourceImage(sourceImage);
		//edgeDetector.setThreshold(128);
		edgeDetector.setThreshold(100);
		edgeDetector.setWidGaussianKernel(5);
		try {
			edgeDetector.process();
		} catch (EdgeDetectorException e) {
			System.out.println(e.getMessage());
		}
		Image edgeImage = edgeDetector.getEdgeImage();
		//yourPanel.show(edgeImage);
		return edgeImage;
	}

}
