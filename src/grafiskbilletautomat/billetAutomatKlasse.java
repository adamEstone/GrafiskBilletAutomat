package grafiskbilletautomat;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;


/*
prisen bliver bestemt herfra

*/



public class billetAutomatKlasse
{
    private static ArrayList<String> transaktioner = new ArrayList<String>();
    
    public static ArrayList<billetKlasse> Kurv = new ArrayList<billetKlasse>();

    private static double pris;    // Prisen for én billet.
    private static double balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
    
    

    /**
     * Opret en billetautomat, der sælger billetter til en given billetpris.
     * @param billetpris skal være større end nul (p.t. bliver det ikke tjekket)
     */

    /**
     * Giver prisen for en billet.
     */
    public double getBilletpris()
    {
        double resultat = pris;
        return resultat;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     */
    public void indsætPenge(double beløb)
    {
        Date tid = new Date();
	transaktioner.add(tid + " der blev indsat "+beløb+" kroner");
        balance = balance + beløb;
    }

    /**
     * Giver balancen (beløbet maskinen har modtaget til den næste billet).
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Udskriv en billet.
     */
    public void udskrivBillet()
    {
        if (balance >= pris)
        {
            transaktioner.add(new Date() + " der blev udskrevet en billet");
            antalBilletterSolgt = antalBilletterSolgt + 1;
            balance = balance - pris;

            System.out.println("##########B##T##########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                      #");
            System.out.println("#        Billet        #");
            System.out.println("#        " + pris + " kr.        #");
            System.out.println("#                      #");
            System.out.println("# Du har " + balance + " kr til gode #");
            System.out.println("##########B##T##########");
            System.out.println();
        } else
        {
            System.out.println("Saldo for lav");
        }
    }
    
    	public double returpenge() {
		double returbeløb = balance;
		transaktioner.add(new Date() + " kunden fik "+returbeløb+" kr retur");
		balance = 0;
		System.out.println("Du får "+returbeløb+" kr retur");
		return returbeløb;
	}

    
    //Service metoder:

    public void setBilletpris(String montørkode, double nyPris)
    {
        if (montørkode.equals("1234"))
        {
            pris = nyPris;
        } else
        {
            System.err.println("Kunne ikke sætte pris - forkert kode");
        }
    }

    public double getSamletSalgsbeløb(String montørkode)
    {
        if (montørkode.equals("1234"));
        return pris * antalBilletterSolgt;
    }
    
    
    public static String getDate()
    {
        Date epoch = new Date(System.currentTimeMillis());

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

        return date.format(epoch);
    }

    public static String getTime()
    {
        Date epoch = new Date(System.currentTimeMillis());

        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

        return time.format(epoch);
    }
}
