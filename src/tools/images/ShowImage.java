package tools.images;

import java.awt.*;

public class ShowImage extends Frame {

	String filename;

	public ShowImage(String filename) {

		this.setSize(420, 350);

		this.setVisible(true);

		this.filename = filename;

	}

	public void paint(Graphics g) {

		Image image = this.getToolkit().getImage(filename);

		g.drawImage(image, 0, 0, this);

	}

	public static void main(String[] args) {

		new ShowImage("E:/zzzzzzzzzzzzzzzzzzzzzzzzzzz/111.jpg");

	}

}