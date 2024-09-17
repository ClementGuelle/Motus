package src.vue;

import javax.swing.*;
import java.awt.*;

import src.Controleur;

public class FrameJeu extends JFrame
{
	private Controleur ctrl;
	
	private PanelJeu panelJeu;

	public FrameJeu(Controleur ctrl)
	{

		this.ctrl = ctrl;

		this.setTitle("MOTUS");
		this.setSize(this.ctrl.getTaille(), 450);
		this.setLocation(150, 150); 

		this.panelJeu = new PanelJeu(this.ctrl);

		this.add(this.panelJeu);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void afficherTexteClique(String txt)
	{

		this.setTitle(txt);

	}

}
