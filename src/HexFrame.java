import javax.swing.*;

import custom_components.Tool_Group;

import java.awt.*;

public class HexFrame extends JFrame{
	int baseRows, baseCols;
	HexMap hMap;
	JPanel cPane, sPane, iPane, toolsPane, colSel, infoSel;
	Tool_Group toolPick;
	String tool;
	final String COLS = "Colors", INFO = "Info";
	
	public HexFrame(int baseRows, int baseCols) {
		super();
		hMap = new HexMap(baseRows, baseCols);
		cPane = new JPanel();
		sPane = new JPanel();
		iPane = new JPanel();
		toolsPane = new JPanel();
		colSel = new JPanel();
		infoSel = new JPanel();
		
		sPane.setLayout(new CardLayout());
		sPane.add(colSel, COLS);
		infoSel.setBackground(Color.GREEN);
		colSel.setBackground(Color.PINK);
		sPane.add(infoSel, INFO);
		CardLayout cl = (CardLayout)sPane.getLayout();
		cl.show(sPane, INFO);
		
		toolPick = new Tool_Group();
		JRadioButton toolPaint = new JRadioButton("Drawing");
		JRadioButton toolPlace = new JRadioButton("Placing/Selecting");
		toolPick.add(toolPlace);
		toolPick.add(toolPaint);
		toolPlace.setSelected(true);
		toolsPane.add(toolPlace);
		toolsPane.add(toolPaint);
		
		JButton save = new JButton("Save");
		JButton load = new JButton("Load");
		toolsPane.add(save);
		toolsPane.add(load);
		
		this.baseRows = baseRows;
		this.baseCols = baseCols;
		this.setPreferredSize(new Dimension(1200,800));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setContentPane(cPane);
		
		toolsPane.setPreferredSize(new Dimension(1200, 60));
		sPane.setPreferredSize(new Dimension(150, 540));
		colSel.setPreferredSize(sPane.getPreferredSize());
		infoSel.setPreferredSize(sPane.getPreferredSize());
		iPane.setPreferredSize(new Dimension(300, 540));
		
		cPane.setLayout(new BorderLayout());
		cPane.add(sPane, BorderLayout.WEST);
		sPane.add(new JTextField("Test"));
		cPane.add(hMap, BorderLayout.CENTER);
		cPane.add(iPane, BorderLayout.EAST);
		cPane.add(toolsPane, BorderLayout.SOUTH);
		
		toolsPane.setBackground(Color.black);
		sPane.setBackground(Color.BLUE);
		iPane.setBackground(Color.GRAY);
	}
}