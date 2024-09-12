package src;

import src.metier.Jeu;
import src.vue.FrameJeu;

public class Controleur
{

	private Jeu      jeu;
	private FrameJeu frameJeu;

	public Controleur()
	{
		this.jeu = new Jeu();
		this.frameJeu = new FrameJeu();
	}
	
	public char[] VerifEmplacementCaratere(String mot)
	{
		return this.jeu.VerifEmplacementCaratere(mot);
	}

	public static void main(String[] args) 
	{
		new Controleur();
	}
}