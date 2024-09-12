package src.vue;

import javax.swing.*;
import java.awt.*;

public class FrameJeu extends JFrame
{

	private PanelJeu panelJeu;

	public FrameJeu()
	{

		this.setTitle("MOTUS");
		this.setSize(700, 500);
		this.setLocation(150, 150); 

		this.panelJeu = new PanelJeu(this);

		this.add(this.panelJeu);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void afficherTexteClique(String txt)
	{

		this.setTitle(txt);

	}

}
