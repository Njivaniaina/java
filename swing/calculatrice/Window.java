import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame
{
  	public JTextField zoneText = new JTextField();

	public Window(String title, int width, int heigth)
	{
		this.setTitle(title);
		this.setSize(width, heigth);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(Window.this, "Voulez-vous vraiment quitter?", "Sortir", JOptionPane.YES_NO_OPTION))
				{
					Window.this.dispose();
				}
			}
		}
		);
	}

	public void designe()
	{
		JPanel panel =(JPanel) this.getContentPane();

		panel.add(barOutil(), BorderLayout.NORTH);
		panel.add(principal());
	}

	private JPanel principal()
	{
		JPanel panel = new JPanel();
		JPanel p = principal1();
		
    	zoneText.setPreferredSize(new Dimension(375, 50));	
		panel.add(zoneText);
		panel.add(p);

		return panel;
	}

	private JPanel principal1()
	{
		JPanel panel = new JPanel();
		JPanel tab = table();
		JPanel o = outil();

		tab.setPreferredSize(new Dimension(240, 260));
		o.setPreferredSize(new Dimension(130, 260));

		panel.add(tab, BorderLayout.WEST);
		panel.add(o, BorderLayout.EAST);
		return panel;
	}

	private JToolBar barOutil()
	{
		JToolBar  toolBar = new JToolBar();
		
		JButton bouton1 = new JButton("A propos");
		toolBar.add(bouton1);

		JButton bouton2 = new JButton("?");
		toolBar.add(bouton2);

		return toolBar;
	}
	
	private JPanel outil()
	{
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JButton bouton  = new JButton("=");

		panel.add(outil1());
		panel.add(bouton);
		panel.setPreferredSize(new Dimension(200, 100));

        bouton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                Eval eval = new Eval();
				zoneText.setText(eval.calcule(zoneText.getText()));
			}
		}
		);
		
		return panel;	
	}

	private JPanel outil1()
	{
        JButton bp = new JButton("+");
        JButton bm = new JButton("-");
        JButton bf = new JButton("*");
        JButton bd = new JButton("/");
		JPanel panel = new JPanel(new GridLayout(2, 2));

		panel.add(bp);
		panel.add(bm);
		panel.add(bf);
		panel.add(bd);

        addEventButton(bp, "+");
        addEventButton(bm, "-");
        addEventButton(bf, "*");
        addEventButton(bd, "/");

		return panel;
	}
  
	private void addEventButton(JButton b, String s)
	{
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				zoneText.setText(zoneText.getText()+s);
			}
		}
		);
	}

	private JPanel table()
	{	
		JPanel panel = new JPanel(new GridLayout(4, 3));
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton bDel = new JButton("Del");
		JButton bPoint = new JButton("."); 

		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b0);
		panel.add(bPoint);
 
		addEventButton(b1, "1");
		addEventButton(b2, "2");
		addEventButton(b3, "3");
		addEventButton(b4, "4");
		addEventButton(b5, "5");
		addEventButton(b6, "6");
		addEventButton(b7, "7");
		addEventButton(b8, "8");
		addEventButton(b9, "9");
		addEventButton(b0, "0");
		addEventButton(bPoint, ".");

		panel.add(bDel);
		bDel.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				String s = zoneText.getText();
				if( s.length() > 0 )
				{
					zoneText.setText(s.substring(0, s.length()-1));
				}
				}
			}
		);


		return panel;
	}

}
