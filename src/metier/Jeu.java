package src.metier;

import java.io.FileInputStream;
import java.util.Scanner;

public class Jeu 
{
	/*--------------*/
	/*    Données   */
	/*--------------*/

	private String motAChercher;


	/*--------------*/
	/* Instructions */
	/*--------------*/

	/**
	 * Constructeur de la classe
	 */
	public Jeu()
	{
		this.motAChercher = this.SelectionMotAleatoire();
	}


	/*--------------*/
	/*    Getter    */
	/*--------------*/

	public String getMotATrouver() { return this.motAChercher; }

	
	/*----------------*/
	/* Autres Méthode */
	/*----------------*/

	/**
	 * Cette méthode permet de choisir un mot aléatoirement dans la liste de mot prévu.
	 * @return Le mot à trouver.
	 */
	public String SelectionMotAleatoire()
	{

		int    nbMots       = 0;
		String motAChercher = "";

		// Compte le nombre de mot dans la liste.
		try
		{
			Scanner sc = new Scanner(new FileInputStream("../src/ListeMots.txt"), "UTF8");

			while (sc.hasNextLine())
			{
				sc.nextLine();
				nbMots ++;
			}

			sc.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		int IdMotChoisi = (int) (Math.random() * nbMots);


		// Prend un mot aléatoirement dans la liste de mot.
		try
		{
			Scanner sc = new Scanner(new FileInputStream("../src/ListeMots.txt"), "UTF8");

			for (int i = 0; i < IdMotChoisi; i++) 
			{
				sc.nextLine();
			}

			motAChercher = sc.nextLine();

			System.out.println("Le mot à trouver est : " + motAChercher);

			sc.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return motAChercher;

	}


	/**
	 * Cette méthode va permettre de savoir si un caractere est présent dans le mot ou non et si il est à la bonne place ou non.
	 * @param motJoueur Le mot entrer par le joueur.
	 * @return retourne un tableau pour chaque caractere du mot où cela dit si B : bonne place, M : mauvaise place, I : inexistant dans le mot.
	 */
	public char[] VerifEmplacementCaratere(String motJoueur)
	{

		char[]  placementCaractere    = new char[this.motAChercher.length()];
		boolean caractereExiste       = false;
		int     nbFoisCaratere        = 0;
		int     nbFoisCaractereValide = 0;

		for (int i = 0; i < placementCaractere.length; i++)
		{
			// Met B à l'emplacement du caractere si les deux sont identiques
			if(this.motAChercher.charAt(i) == motJoueur.charAt(i))
				placementCaractere[i] = 'B';

			else
			{
				// Met I si le caractere est inexistant dans le mot
				for (int j = 0; j < placementCaractere.length; j++) 
				{
					if( this.motAChercher.charAt(j) == motJoueur.charAt(i) )
						caractereExiste = true;
				}
					
				if ( caractereExiste == false )
					placementCaractere[i] = 'I';


				// Met M si le caractere est à la mauvaise place dans le mot ( et avec le bon nombre de fois où il est dans le mot )
				else
				{
					for (int j = 0; j < placementCaractere.length; j++)
					{
						if ( this.motAChercher.charAt(j) == motJoueur.charAt(i) )
							nbFoisCaratere ++;
					}

					for (int j = 0; j < i; j++)
					{
						if ( motJoueur.charAt(j) == motJoueur.charAt(i) )
							nbFoisCaratere --;
					}

					if ( nbFoisCaratere > 0 )
						placementCaractere[i] = 'M';
					else
						placementCaractere[i] = 'I';

					caractereExiste = false;
					nbFoisCaratere  = 0;

				}
			}
			
		}

		// Apres avoir fini le tour de tous les caracteres dans le mot il y a des erreurs avec les M alors que toutes les lettres peuvent être bien placé
		for (int i = 0; i < placementCaractere.length; i++)
		{
			if (placementCaractere[i] == 'M')
			{

				// Permet de calculer le nombre de fois où la lettre est présente dans le mot
				for (int j = 0; j < placementCaractere.length; j++)
				{
					if ( motJoueur.charAt(j) == motJoueur.charAt(i) )
						nbFoisCaratere++;
				}

				System.out.println(" nb " + motJoueur.charAt(i) + " dans le mot : " + nbFoisCaractereValide);

				// Permet de calculer le nombre de fois où la lettre est bien placé
				for (int j = 0; j < placementCaractere.length; j++)
				{
					if ( motJoueur.charAt(j) == motJoueur.charAt(i) && placementCaractere[j] == 'B')
						nbFoisCaractereValide ++;
				}

				System.out.println(" nb caractere bon : " + nbFoisCaractereValide);

				// Soustrait le nombre de fois que le caractere est bien placé avec le nombre de fois que le caractere existe comme ca cela permet de savoir si il est M ou I
				if ( nbFoisCaratere > nbFoisCaractereValide )
					placementCaractere[i] = 'I';

				nbFoisCaratere        = 0;
				nbFoisCaractereValide = 0;
			}
		}

		for (int i = 0; i < placementCaractere.length; i++) 
		{
			System.out.println(placementCaractere[i]);
		}

		return placementCaractere;
	}
}
