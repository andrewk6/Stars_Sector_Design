package custom_components;

import javax.swing.ButtonGroup;

public class Tool_Group extends ButtonGroup{
	public static final int TOOL_DRAW = 0;
	public static final int TOOL_SELECT_PLACE = 1;
	
	
	private int tool;
	
	public Tool_Group() {
		super();
	}
	
	public int getTool() {
		return tool;
	}
	
	public void setTool(int tool) {
		this.tool = tool;
	}
}