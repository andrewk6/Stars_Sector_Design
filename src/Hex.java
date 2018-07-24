public class Hex{
	public static final int HEX_POINTS = 6;
	
	private int[] xCoords;
	private int[] yCoords;
	
	public Hex() {
		xCoords = new int[6];
		yCoords = new int[6];
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
	
	public int[] getXCos() {
		return xCoords;
	}
	
	public int[] getYCos() {
		return yCoords;
	}
}