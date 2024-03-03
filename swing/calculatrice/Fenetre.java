import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextField;

import java.awt.Color;

public class Fenetre extends JFrame
{
	public Fenetre()
	{

	}
	public Fenetre(String titre, int width, int heigth, boolean local)
	{
		this.setVisible(true);
		this.setSize(width, heigth);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(local)
			this.setLocationRelativeTo(null);
	}

	public void designe()
	{
		JPanel panel =(JPanel) this.getContentPane();

		panel.add(barOutil(), BorderLayout.NORTH);
	//	panel.add(new JTextField("Calcul"), BorderLayout.NORTH);
		panel.add(outil(), BorderLayout.EAST);
		panel.add(table());
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

		panel.setPreferredSize(new Dimension(150, 100));
		
		return panel;	
	}
	private JPanel outil1()
	{
		JPanel panel = new JPanel(new GridLayout(2, 2));
		panel.add(new JButton("+"));
		panel.add(new JButton("-"));
		panel.add(new JButton("*"));
		panel.add(new JButton("/"));
		return panel;
	}
	private JPanel table()
	{	
		JPanel panel = new JPanel(new GridLayout(4, 3));
	
		panel.add(new JButton("7"));
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("0"));
		panel.add(new JButton("."));
		panel.add(new JButton("Supr"));
			
		return panel;
	}

}
