/**
 * @author GUELLE clément
 */

package src;

import src.metier.Jeu;
import src.vue.FrameJeu;

public class Controleur
{

	private Jeu      jeu;
	private FrameJeu frameJeu;

	public Controleur()
	{
		this.jeu      = new Jeu();
		this.frameJeu = new FrameJeu(this);
	}
	
	public char[] verifEmplacementCaratere(String mot) { return this.jeu.verifEmplacementCaratere(mot); }

	public int getNbLettreMot() { return this.jeu.getMotATrouver().length(); }
	public int getNbEssaie   () { return this.jeu.getNbEssaie(); }
	public int getTaille     () { return this.jeu.getMotATrouver().length() * 50 + 80;}

	public String[] getListeMotsJoueur(){ return this.jeu.getListeMotsJoueur(); }

	public static void main(String[] args) 
	{
		new Controleur();
	}
}