
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package polycreation;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jimmy
 */
public class HexMap extends JPanel {

	private int ySize = 18;
	private int yOff = 50;
	private int yRows = 15;

	private int xSize = 24;
	private int xOff = 50;
	private int xCols = 11;
	
	private int st = 3;

	private Hex[][] hexs;

	public HexMap() {
		hexs = new Hex[xCols][yRows];
	}

	public void paint(Graphics g) {

		int counter = 1;
		for (int yValue = yOff; yValue < yRows * ySize + yOff; yValue += ySize) {
			int strtXVal = xOff;
			if (counter % 2 == 0) // if even start x halfway over
			{
				strtXVal = xSize / 2 + xOff;
			}

			for (int xValue = strtXVal; xValue < xCols * xSize; xValue += xSize) {
				
				int xValues[] = { xValue, (xValue + xSize / 2), (xValue + xSize), (xValue + xSize),
						(xValue + xSize / 2), (xValue + 0) };
				
				int yValues[] = { (yValue + ySize / 3), yValue, (yValue + ySize / 3), (yValue + ySize),
						(yValue + ((ySize / 3) + ySize)), (yValue + ySize) };
				
				Hex hex = new Hex(xValues, yValues, xSize, ySize);
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke(st));
				g2.drawPolygon(hex.getXCos(), hex.getYCos(), Hex.HEX_POINTS);
				g.setColor(Color.blue);
				g.fillPolygon(hex.getXCos(), hex.getYCos(), Hex.HEX_POINTS);
				//g.drawChars(new char[] {'A'}, 0, 1, hex.getTextX() + xOff, hex.getTextY() + yOff);
			}
			counter++;
		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("JavaTutorial.net");
		frame.getContentPane().add(new HexMap());
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
