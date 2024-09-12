package src.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelJeu extends JPanel implements ActionListener, ItemListener 
{

	private FrameJeu frameJeu;

	private JPanel panelTitre;
	private JPanel panelMotTest;
	private JPanel panelMotJoueur;

	public PanelJeu(FrameJeu frame)
	{

		this.frameJeu = frame;

		this.setLayout(new BorderLayout());

		/* ---------------------------------- */
		/* CRÉATION DES COMPOSANTS            */
		/* ---------------------------------- */

		this.panelTitre     = new JPanel(new BorderLayout(10, 10));
		this.panelMotTest   = new JPanel(new BorderLayout(10, 10));
		this.panelMotJoueur = new JPanel(new BorderLayout(10, 10));

		/* ---------------------------------- */
		/* POSITIONNEMENT DES COMPOSANTS      */
		/* ---------------------------------- */

		this.panelTitre    .add(new JLabel("MOTUS"), BorderLayout.CENTER);
		this.panelMotTest  .add(new JLabel("MOTUS"), BorderLayout.CENTER);
		this.panelMotJoueur.add(new JLabel("MOTUS"), BorderLayout.CENTER);


		this.add(this.panelTitre    , BorderLayout.NORTH);
		this.add(this.panelMotTest  , BorderLayout.CENTER);
		this.add(this.panelMotJoueur, BorderLayout.SOUTH);

		/* ---------------------------------- */
		/* ACTIVATION DES COMPOSANTS          */
		/* ---------------------------------- */

	}

	public void actionPerformed(ActionEvent e)
	{

	}

	public void itemStateChanged(ItemEvent e)
	{

	}
}
