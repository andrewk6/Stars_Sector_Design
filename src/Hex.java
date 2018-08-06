import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Hex{
	public static final int HEX_POINTS = 6;
	
	private int[] xCoords;
	private int[] yCoords;
	private int xSize;
	private int ySize;
	private int[] textCo = new int[2];
	
	private Color col;
	private Shape s;
	
	private Polygon p;
	
	public Hex() {
		super();
		xCoords = new int[6];
		yCoords = new int[6];
		xSize = -1;
		ySize = -1;
		col = Color.blue;
//		this.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("Here is where I am");
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
	}
	
	public Hex(int[] xs, int[] ys) {
		if(xs.length == 6)
			xCoords = xs;
		else {
			xCoords = new int[6];
			throw new IllegalArgumentException("Invalid X-Coordinates Array Size");
		}
		
		if(ys.length == 6)
			yCoords = ys;
		else {
			yCoords = new int[6];
			throw new IllegalArgumentException("Invalid Y-Coordinates Array Size");
		}
		col = Color.blue;
	}
	
	public Hex(int[]xs, int[] ys, int xS, int yS, Polygon p) {		
		if(xs.length == 6)
			xCoords = xs;
		else {
			xCoords = new int[6];
			throw new IllegalArgumentException("Invalid X-Coordinates Array Size");
		}
		
		if(ys.length == 6)
			yCoords = ys;
		else {
			yCoords = new int[6];
			throw new IllegalArgumentException("Invalid Y-Coordinates Array Size");
		}
		xSize = xS;
		ySize = yS;
		
		textCo[0] = xCoords[0];
		textCo[1] = yCoords[2];
		
		col = Color.blue;
		this.p = p;
	}
	
	public void paintComponent(Graphics g) {
		//System.out.println("Painting 2");
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(col);
//		System.out.println(col);
		g2.fill(p);
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.black);
		g2.draw(p);
	}
		
	public int[] getXCos() {
		return xCoords;
	}
	
	public int[] getYCos() {
		return yCoords;
	}
	
	public int getTextX() {
		return textCo[0];
	}
	
	public int getTextY() {
		return textCo[1];
	}
	
	public void setColor(Color c) {
		col = c;
	}
	
	public Color getColor() {
		return col;
	}
	
	public Polygon getPolygon() {
		return p;
	}
}