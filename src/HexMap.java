
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package polycreation;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jimmy
 */
public class HexMap extends JPanel {

	private int ySize = 18;
	private int yOff = 5;
	private int yRows = 15;

	private int xSize = 24;
	private int xOff = 5;
	private int xCols = 11;

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
				Hex hex = new Hex(xValues, yValues);
				g.drawPolygon(hex.getXCos(), hex.getYCos(), Hex.HEX_POINTS);
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
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
