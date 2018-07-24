
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package polycreation;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	double m;

	public HexMap() {
		hexs = new Hex[xCols][yRows];
		m = -1;
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Click");
				//getSelectedHexagon(e.getX(), e.getY());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
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
				m = (m == -1) ? (((double)hex.getYCos()[1] - hex.getYCos()[0])
						/((double)hex.getXCos()[1] - hex.getXCos()[0])) : m;
//				System.out.println("Y: " + (hex.getYCos()[1] - hex.getYCos()[0]));
//				System.out.println("X: " + (hex.getXCos()[1] - hex.getXCos()[0]));
//				System.out.println("Slope/Const Upper Left: " + m + "/" + (-(m*hex.getXCos()[0]) + hex.getYCos()[0]));
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.black);
				g2.setStroke(new BasicStroke(st));
				g2.drawPolygon(hex.getXCos(), hex.getYCos(), Hex.HEX_POINTS);
				g.setColor(hex.getColor());
				g.fillPolygon(hex.getXCos(), hex.getYCos(), Hex.HEX_POINTS);
				//g.drawChars(new char[] {'A'}, 0, 1, hex.getTextX() + xOff, hex.getTextY() + yOff);
			}
			counter++;
		}
	}
	
	public Hex getHex(int x, int y) {
		int xG = x / xSize;
		int yG = y / ySize;
		
		if(xG > xSize * xCols || yG > ySize * yRows) {
			System.out.println("Invalid point");
		}else {
			
		}
		return hexs[x][y];
	}

	/*	
	private final Hex getSelectedHexagon(int x, int y)
	{
		System.out.println("Mouse Click: " + x + "/" + y);
	    // Find the row and column of the box that the point falls in.
		int gridHeight = yRows * ySize;
		int gridWidth = xCols * xSize;
	    int row = (int) (y / gridHeight);
	    int column;

	    boolean rowIsOdd = row % 2 == 1;

	    // Is the row an odd number?
	    if (rowIsOdd)// Yes: Offset x to match the indent of the row
	        column = (int) ((x - gridWidth / 2) / gridWidth);
	    else// No: Calculate normally
	        column = (int) (x / gridWidth);
	    // Work out the position of the point relative to the box it is in
	    double relY = y - (row * gridHeight);
	    double relX;

	    if (rowIsOdd)
	        relX = (x - (column * gridWidth)) - gridWidth / 2;
	    else
	        relX = x - (column * gridWidth);
	    // Work out if the point is above either of the hexagon's top edges
	    if (relY < (-m * relX) + 0) // LEFT edge
	        {
	            row--;
	            if (!rowIsOdd)
	                column--;
	        }
	    else if (relY < (m * relX) - 0) // RIGHT edge
	        {
	            row--;
	            if (rowIsOdd)
	                column++;
	        }
	    System.out.println("Row/Col: " + row + "/" + column);
	    hexs[row][column].setColor(Color.green);
	    repaint();
	    return hexs[row][column];
	}
*/
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
