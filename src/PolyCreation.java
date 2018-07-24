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
public class PolyCreation extends JPanel{

	private int ySize = 18;
	private int yOff = 5;
	private int yRows = 15;
	
	private int xSize = 24;
	private int xOff = 5;
	private int xCol = 11;
    /**
     * @param args the command line arguments
     */
    	public void paint(Graphics g){
            
            int counter = 1;
            for (int yValue = yOff; yValue < yRows * ySize + yOff; yValue += ySize){
                int strtXVal = xOff;
                if (counter % 2 == 0) //if even start x halfway over
                {
                    strtXVal = xSize / 2 + xOff;
                }
                
                for (int xValue = strtXVal; xValue < xCol * xSize; xValue += xSize)
                {
                    int xValues[] = {xValue, (xValue + xSize / 2), (xValue + xSize), 
                             (xValue + xSize), (xValue + xSize / 2), (xValue + 0)};
                    int yValues[] = {(yValue + ySize / 3), yValue, (yValue + ySize / 3),
                        (yValue + ySize), (yValue + ((ySize / 3) + ySize)), (yValue + ySize)};
                    int points = 6;	    
                    g.drawPolygon(xValues, yValues, points);
                }
                counter++;
            }
            
	}
	
	public static void main(String[] args){
		JFrame frame= new JFrame("JavaTutorial.net");	
		frame.getContentPane().add(new PolyCreation());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
}
