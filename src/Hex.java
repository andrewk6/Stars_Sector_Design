public class Hex{
	public static final int HEX_POINTS = 6;
	
	private int[] xCoords;
	private int[] yCoords;
	private int xSize;
	private int ySize;
	private int[] textCo = new int[2];
	
	public Hex() {
		xCoords = new int[6];
		yCoords = new int[6];
		xSize = -1;
		ySize = -1;
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
	}
	
	public Hex(int[]xs, int[] ys, int xS, int yS) {
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
}