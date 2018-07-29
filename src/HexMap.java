
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package polycreation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jimmy
 */
public class HexMap extends JPanel {

	private int ySize = 18;
	private int yOff = 50;
	private int rows = 15;

	private int xSize = 24;
	private int xOff = 50;
	private int cols = 11;
	
	private int st = 3;

	private ArrayList<ArrayList<Hex>> hexes;
	Polygon test = new Polygon();
	//ArrayList
	double m;

	public HexMap() {
		//hexs = new Hex[rows][cols];
		m = -1;
		hexes = new ArrayList<ArrayList<Hex>>();
		buildHexes();
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				for(ArrayList<Hex> hexes : hexes) {
					for(Hex hex : hexes) {
						if(hex.getPolygon().contains(e.getPoint())) {
							hex.setColor(Color.GREEN);
							repaint();
						}
					}
				}	
			}
		});
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Floodfill");
				if(e.isShiftDown()) {
					System.out.println("Shifted");
					int x = 0, y = 0;
					for(int c1 = x; c1 < hexes.size(); c1 ++)
						for(int c2 = y; c2 < hexes.get(c1).size(); c2 ++) {
							if(hexes.get(c1).get(c2).getPolygon().contains(e.getPoint())) {
								x = c1;
								y = c2;
							}
						}
					floodFill(Color.GREEN, x, y);
					repaint();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(!e.isShiftDown())
					for(ArrayList<Hex> hexes : hexes) {
						for(Hex hex : hexes) {
							if(hex.getPolygon().contains(e.getPoint())) {
								hex.setColor(Color.GREEN);
								repaint();
							}
						}
					}
			}
			
			private void floodFill(Color nCol,int x, int y){
				System.out.println("X/Size: " + x + "/" + hexes.size());
				if(x >= hexes.size() || x < 0) {
					System.out.println("Outof X Bounds");
					return;
				}
				else if(y >= hexes.get(x).size() || y < 0) {
					System.out.println("Outof Y Bounds");
					return;
				}
				else if(hexes.get(x).get(y).getColor().equals(nCol)) {
					System.out.println("Outof Same Color Bounds");
					return;
				}
				else {
					hexes.get(x).get(y).setColor(nCol);
					floodFill(nCol, x + 1, y);
					floodFill(nCol, x - 1, y);
					floodFill(nCol, x, y + 1);
					floodFill(nCol, x, y - 1);
				}
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
	
	public void buildHexes() {
		System.out.println("Painting");
//		int row = 0, col = 0;
		int yIter = 0;
		int counter = 1;
		for (int yValue = yOff; yValue < rows * ySize + yOff; yValue += ySize) {
			hexes.add(new ArrayList<Hex>());
//			System.out.println("Iter: " + col);
			int strtXVal = xOff;
			if (counter % 2 == 0) // if even start x halfway over
			{
				strtXVal = xSize / 2 + xOff;
			}

			for (int xValue = strtXVal; xValue < cols * xSize; xValue += xSize) {
				int xValues[] = { xValue, (xValue + xSize / 2), (xValue + xSize), (xValue + xSize),
						(xValue + xSize / 2), (xValue + 0) };
				
				int yValues[] = { (yValue + ySize / 3), yValue, (yValue + ySize / 3), (yValue + ySize),
						(yValue + ((ySize / 3) + ySize)), (yValue + ySize) };
				
				Polygon p = new Polygon();
				p.addPoint(xValue, (yValue + ySize / 3));
				p.addPoint((xValue + xSize / 2), yValue);
				p.addPoint((xValue + xSize), (yValue + ySize / 3));
				p.addPoint((xValue + xSize), (yValue + ySize));
				p.addPoint((xValue + xSize / 2), (yValue + ((ySize / 3) + ySize)));
				p.addPoint((xValue + 0) , (yValue + ySize));
				
				Hex hex = new Hex(xValues, yValues, xSize, ySize, p);
				hexes.get(yIter).add(hex);
				m = (m == -1) ? (((double)hex.getYCos()[1] - hex.getYCos()[0])
						/((double)hex.getXCos()[1] - hex.getXCos()[0])) : m;
			}
			yIter++;
			counter++;
		}
	}

	public void paintComponent(Graphics g) {
		for(ArrayList<Hex> hexes : hexes) {
			for(Hex hex : hexes) {
				hex.paintComponent(g);
			}
		}
	}
	
	public Hex getHex(int x, int y) {
		int col = (x - xOff) / xSize;
		int row = (y - yOff) / ySize; 
		
		if(col > xSize * cols + xOff || row > ySize * rows + yOff) {
			System.out.println("Invalid point");
		}else {
			
		}
		System.out.println("X/Y: " + col + "/" + row);
//		hexs[row][col].setColor(Color.GREEN);
//		repaint();
//		return hexs[row][col];
		return new Hex();
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
