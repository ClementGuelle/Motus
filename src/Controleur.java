package src;

import src.metier.Jeu;

public class Controleur
{

	private Jeu jeu;

	public Controleur()
	{
		this.jeu = new Jeu(this);
	}
	
	public char[] VerifEmplacementCaratere(String mot)
	{
		return this.jeu.VerifEmplacementCaratere(mot);
	}

	public void FinPartieVictoire()
	{
		System.out.println("Fin de partie victoire");
	}

	public void FinPartieDefaite()
	{
		System.out.println("Fin de partie défaite");
	}


	public static void main(String[] args) 
	{
		new Controleur();
	}
}