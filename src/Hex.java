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
		//System.out.println(col);
		g2.fill(p);
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.black);
		g2.draw(p);
	}
	
//	int n=6;
//	int x[]= new int[n];
//	int y[]= new int[n];
//	double angle = 2*Math.PI/n;
//	protected void paintComponent(Graphics g) {
//	    if (getModel().isArmed()) {
//	        g.setColor(Color.lightGray);
//	    } else {
//	        g.setColor(getBackground());
//	    }
//	    int x0 = getSize().width/2;
//	    int y0 = getSize().height/2;
//	    for(int i=0; i<n; i++) {
//	        double v = i*angle;
//	        x[i] = x0 + (int)Math.round((getWidth()/2)*Math.cos(v));
//	        y[i] = y0 + (int)Math.round((getHeight()/2)*Math.sin(v));
//	    }
//	    g.fillPolygon(x, y, n);
//	    super.paintComponent(g);
//	}
//	 
//	protected void paintBorder(Graphics g) {
//	    g.setColor(getForeground());
//	    int x0 = getSize().width/2;
//	    int y0 = getSize().height/2;
//	    for(int i=0; i<n; i++) {
//	        double v = i*angle;
//	        x[i] = x0 + (int)Math.round((getWidth()/2)*Math.cos(v));
//	        y[i] = y0 + (int)Math.round((getHeight()/2)*Math.sin(v));
//	    }
//	    g.drawPolygon(x, y, n);
//	}
//	 
//	Polygon polygon;
//	public boolean contains(int x1, int y1) {
//	    if (polygon == null ||
//	            !polygon.getBounds().equals(getBounds())) {
//	        int x0 = getSize().width/2;
//	        int y0 = getSize().height/2;
//	        for(int i=0; i<n; i++) {
//	            double v = i*angle;
//	            x[i] = x0 + (int)Math.round((getWidth()/2)*Math.cos(v));
//	            y[i] = y0 + (int)Math.round((getHeight()/2)*Math.sin(v));
//	        }
//	        polygon = new Polygon(x,y,n);
//	    }
//	    return polygon.contains(x1, y1);
//	}
	
	
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