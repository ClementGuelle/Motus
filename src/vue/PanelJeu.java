package src.vue;

import javax.swing.*;

import src.Controleur;

import java.awt.*;
import java.awt.event.*;

public class PanelJeu extends JPanel implements ActionListener, ItemListener, KeyListener 
{

	private Controleur ctrl;
	
	private JPanel   panelMotFait;
	private JPanel   panelMotJoueur;
	private JPanel[] motJoueur;

	private JLabel[][] lettreMot;

	private JTextField[] lettre;

	// Apparaît dans keyReleased
	private boolean plusieursTouches;

	public PanelJeu(Controleur ctrl)
	{

		this.ctrl = ctrl;
		this.setLayout(new BorderLayout());

		/* ---------------------------------- */
		/* CRÉATION DES COMPOSANTS            */
		/* ---------------------------------- */

		this.panelMotFait   = new JPanel(new GridLayout(this.ctrl.getNbEssaie(), this.ctrl.getNbLettreMot(),10,10 ));
		this.panelMotJoueur = new JPanel(new GridLayout(1, this.ctrl.getNbLettreMot(), 10, 10));
		this.motJoueur      = new JPanel[this.ctrl.getNbLettreMot()];
		
		this.lettreMot      = new JLabel[this.ctrl.getNbEssaie()][this.ctrl.getNbLettreMot()];

		this.lettre         = new JTextField[this.ctrl.getNbLettreMot()];

		this.plusieursTouches = false;

		
		// Fait les espaces entre les cases
		this.panelMotFait  .setBorder(BorderFactory.createEmptyBorder(10, 40, 15, 40)); 
		this.panelMotJoueur.setBorder(BorderFactory.createEmptyBorder(15, 40, 10, 40));
		

		for (int i = 0; i < this.ctrl.getNbEssaie(); i++)
		{
			for (int j = 0; j < this.ctrl.getNbLettreMot(); j++) 
			{
				this.lettreMot[i][j] = new JLabel();
				this.lettreMot[i][j].setPreferredSize(new Dimension(50, 50));
				this.lettreMot[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				this.lettreMot[i][j].setOpaque(false);
			}
		}

		for (int i = 0; i < this.ctrl.getNbLettreMot(); i++)
		{
			this.motJoueur[i] = new JPanel(new BorderLayout());
			this.motJoueur[i].setPreferredSize(new Dimension(50, 50));
			this.motJoueur[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			this.motJoueur[i].setOpaque(false);
		}

		for (int i = 0; i < this.motJoueur.length; i++)
		{
			this.lettre[i] = new JTextField();
			this.lettre[i].setFont(new Font("sansSherif", Font.PLAIN, 30));

			if ( i != 0)
				this.lettre[i].setEditable(false);
		}
		
		/* ---------------------------------- */
		/* POSITIONNEMENT DES COMPOSANTS      */
		/* ---------------------------------- */

		for (int i = 0; i < this.lettre.length; i++) 
		{
			this.motJoueur[i].add(this.lettre[i], BorderLayout.CENTER);
		}

		for (int i = 0; i < this.ctrl.getNbEssaie(); i++)
		{
			for (int j = 0; j < this.ctrl.getNbLettreMot(); j++)
			{
				this.panelMotFait.add(this.lettreMot[i][j]);
			}
		}

		for (int i = 0; i < this.ctrl.getNbLettreMot(); i++)
		{
			this.panelMotJoueur.add(this.motJoueur[i]);
		}


		this.add(this.panelMotFait   , BorderLayout.CENTER);
		this.add(this.panelMotJoueur , BorderLayout.SOUTH);

		/* ---------------------------------- */
		/* ACTIVATION DES COMPOSANTS          */
		/* ---------------------------------- */

		for (int i = 0; i < this.lettre.length; i++) 
		{
			this.lettre[i].addKeyListener(this);
		}


	}


	public void actionPerformed(ActionEvent e)
	{
	}

	public void itemStateChanged(ItemEvent e)
	{

	}

	public void keyTyped(KeyEvent e)
	{
		
	}


	@Override
	public void keyPressed(KeyEvent e)
	{
		for (int i = 0; i <= (this.lettre.length - 1); i++)
		{
			if (this.lettre[i].isEditable() && this.lettre[i].getText().length() >= 1 && e
					.getKeyChar() != KeyEvent.VK_BACK_SPACE)
			{
				this.plusieursTouches = true;
				JOptionPane.showMessageDialog(null, "Vous ne pouvez pas mettre plusieurs caractère sur une seule case",
						"Trop de caractère", JOptionPane.WARNING_MESSAGE);
			}
			if (this.lettre[i].isEditable() && this.lettre[i].getText().length() >= 1 )
				this.plusieursTouches = false;

		}


	}


	@Override
	public void keyReleased(KeyEvent e)
	{

		int indice = -1;

		String mot = "";
	

		if ( this.plusieursTouches )
			return;


		for (int i = 0; i <= (this.lettre.length - 1); i++)
		{
			if (this.lettre[i].isEditable())
				indice = i;
		}

		if ( e.getKeyChar() == KeyEvent.VK_BACK_SPACE && this.lettre[indice].getText().length() == 0 )
		{
			if (indice == 0)
			{
				return;
			}
			else
			{
				this.lettre[indice].setEditable(false);
				this.lettre[indice - 1].setEditable(true);
				this.lettre[indice - 1].requestFocusInWindow();
				this.lettre[indice - 1].setText("");
			}
		}
		else
		{
			if (indice == (this.lettre.length - 1))
			{
				this.lettre[indice].setEditable(false);

				for (int i = 0; i < (this.lettre.length - 1); i++)
				{
					mot += this.lettre[i].getText();
				}

				ctrl.verifEmplacementCaratere(mot);
			}
			else
			{
				this.lettre[indice]    .setEditable(false);
				this.lettre[indice + 1].setEditable(true);
				this.lettre[indice + 1].requestFocusInWindow();
			}
		}

		this.plusieursTouches = false;
	}
	
}
