import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;

public class LaunchFrame extends JFrame {
	private int size = 500;
	private int rows, cols;
	private HexFrame hFrame;
	
	private final int baseRows = 15, baseCols = 11;

	public LaunchFrame() {
		this.setResizable(false);
		this.setPreferredSize(new Dimension(size, size));
		this.setTitle("Stars Sector Designer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildContent();
		this.getContentPane().setLayout(null);
		buildButtons();
	}

	public void buildButtons() {
		TransButton b1 = new TransButton("New Sector");
		b1.setPreferredSize(new Dimension(100, 100));
		b1.setBounds(155, 180, 180, 70);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame sizeSelect = new JFrame();
				sizeSelect.setSize(new Dimension(300, 100));
				sizeSelect.getContentPane().setLayout(new FlowLayout());
				
				NumberFormat format = NumberFormat.getInstance();
			    NumberFormatter formatter = new NumberFormatter(format);
			    formatter.setValueClass(Integer.class);
			    formatter.setMinimum(-1);
			    formatter.setMaximum(200);
			    formatter.setAllowsInvalid(false);
			    // If you want the value to be committed on each keystroke instead of focus lost
			    formatter.setCommitsOnValidEdit(true);
			    
			    JFormattedTextField row = new JFormattedTextField(formatter);
			    row.setColumns(3);
			    JFormattedTextField col = new JFormattedTextField(formatter);
			    col.setColumns(3);
			    
				JButton btn = new JButton("Confirm");
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						rows = Integer.parseInt(row.getText());
						}catch(NumberFormatException err){
							JOptionPane.showMessageDialog(null, "Invalid number of rows using default", 
									"Error Message", JOptionPane.ERROR_MESSAGE);
							rows = baseRows;
						}
						try {
							cols = Integer.parseInt(col.getText());
						}catch(NumberFormatException err){
							JOptionPane.showMessageDialog(null, "Invalid number of cols using default", 
									"Error Message", JOptionPane.ERROR_MESSAGE);
							cols = baseCols;
						}
						sizeSelect.dispose();
						dispose();
						hFrame = new HexFrame(rows, cols);
						hFrame.pack();
						hFrame.setVisible(true);
					}
				});
				sizeSelect.getContentPane().add(new JLabel("Row"));
				sizeSelect.getContentPane().add(row);
				sizeSelect.getContentPane().add(new JLabel("Column"));
				sizeSelect.getContentPane().add(col);
				sizeSelect.getContentPane().add(btn);
				
//				sizeSelect.setVisible(true);
				hFrame = new HexFrame(20, 20);
				hFrame.pack();
				hFrame.setVisible(true);
			}
		});
		this.add(b1);

		TransButton b2 = new TransButton("Load Sector");
		b2.setPreferredSize(new Dimension(100, 100));
		b2.setBounds(155, 280, 180, 70);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hello 2");
			}
		});
		this.add(b2);

		TransButton b3 = new TransButton("Exit");
		b3.setPreferredSize(new Dimension(100, 100));
		b3.setBounds(155, 380, 180, 70);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(b3);
	}

	public void buildContent() {
		JPanel pane = new JPanel() {
			public void paintComponent(Graphics g) {
				System.out.println("In Paint");
				try {
					BufferedImage bck = ImageIO.read(this.getClass().getResource("Start Menu Image Smaller.png"));
					g.drawImage(bck.getScaledInstance(size, size, BufferedImage.SCALE_SMOOTH), 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				g.setColor(new Color(10, 10, 10, 200));
				g.fillRect(50, 50, 390, 90);

				g.setColor(Color.WHITE);
				g.setFont(new Font("Monospaced", Font.BOLD, 35));
				g.drawString("Sectors Designer", 90, 80);
				g.drawString("Stars", 210, 127);
			}
		};

		this.setContentPane(pane);
	}

	public static void main(String[] args) {
		LaunchFrame frame = new LaunchFrame();
		frame.pack();
		frame.setVisible(true);
	}

	class TransButton extends JButton {
		int opacity = 100;

		public TransButton(String string) {
			super();
			this.setLayout(new BorderLayout());
			JLabel l = new JLabel(string);
			l.setForeground(Color.BLACK);
			l.setFont(new Font("Monospaced", Font.BOLD, 18));
			l.setHorizontalAlignment(JLabel.CENTER);
			add(l, BorderLayout.CENTER);
			this.setOpaque(false);
			setForeground(Color.BLACK);
			setBackground(new Color(getBackground().getRed(), getBackground().getBlue(), getBackground().getGreen(),
					opacity));
		}

		public TransButton() {
			super();
			this.setOpaque(false);
			setForeground(Color.BLACK);
			setBackground(new Color(getBackground().getRed(), getBackground().getBlue(), getBackground().getGreen(),
					opacity));
			setBorderPainted(false);
		}

		protected void paintComponent(Graphics g) {
			if (!isOpaque() && getBackground().getAlpha() < 255) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
			}
			super.paintComponent(g);
		}
	}
}