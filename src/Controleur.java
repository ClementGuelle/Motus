package src;

import src.metier.Jeu;
import iut.algo.Clavier;

public class Controleur
{
	public static void main(String[] args) 
	{
		Jeu jeu = new Jeu();

		String mot = Clavier.lireString();

		jeu.VerifEmplacementCaratere(mot);
	}
}