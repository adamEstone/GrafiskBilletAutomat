package grafiskbilletautomat;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdk.jshell.spi.ExecutionControl;


/*
prisen bliver bestemt herfra

*/

public class billetAutomatKlasse
{
    private static ArrayList<String> transaktioner = new ArrayList<String>();
    
    public static ArrayList<billetKlasse> VoksenBilletter = new ArrayList<billetKlasse>();
    public static ArrayList<billetKlasse> BørneBilletter = new ArrayList<billetKlasse>();
    public static ArrayList<billetKlasse> CykelBilletter = new ArrayList<billetKlasse>();

    private static double totalPris;    // Prisen for én billet.
    
    private static double voksenPris = 20;    // Prisen for én billet.
    private static double børnePris = 15;    // Prisen for én billet.
    private static double cykelPris = 12.5;    // Prisen for én billet.
    
    private static double balance; // Hvor mange penge kunden p.t. har puttet i automaten

    private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
    
   
    /**
     * Opret en billetautomat, der sælger billetter til en given billetpris.
     * @param billetpris skal være større end nul (p.t. bliver det ikke tjekket)
     */

    //TODO: VIRKER IKKE! FÅR IKKE AKTUEL PRIS
    private static double getTotalBalance()
    {
        double adult = getAdultPrice();
        double child = getChildPrice();
        double bike = getBikePrice();
        
        return adult + child + bike;
    }

    private static double getAdultPrice()
    {
        return voksenPris;
    }
    
    private static void setAdultPrice(double pris)
    {
        voksenPris = pris;
    }

    private static double getChildPrice()
    {
        return børnePris;
    }
    
    private static void setChildPrice(double pris)
    {
        børnePris = pris;
    }

    private static double getBikePrice()
    {
        return cykelPris;
    }
    
    private static void setBikePrice(double pris)
    {
        cykelPris = pris;
    }
    
    /**
     * Giver prisen for en billet.
     */
    public static double getBilletpris(billetKlasse.ticketType type)
    {
        double pris = 0.0;
        switch(type)
        {
            case VOKSEN:
                pris = getAdultPrice();
                break;
            case BARN:
                pris = getChildPrice();
                break;
            case CYKEL:
                pris = getBikePrice();
                break;
            default:
                break;
                
        }
        return pris;
    }
    
    
    public static void setBilletpris(billetKlasse.ticketType type, double pris)
    {
        if (pris < 0)
        {
            JFrame fra = new JFrame();
            JOptionPane.showMessageDialog(fra, "Prisen skal være positiv.");
            return;
        }
        
        switch(type)
        {
            case VOKSEN:
                setAdultPrice(pris);
                break;
            case BARN:
                setChildPrice(pris);
                break;
            case CYKEL:
                setBikePrice(pris);
                break;
            default:
                break;
                
        }
    }
    
    
    public static double getAdultTotal()
    {
        return VoksenBilletter.size() * getAdultPrice();
    }
    
    public static double getChildTotal()
    {
        return BørneBilletter.size() * getChildPrice();
    }
    
    public static double getBikeTotal()
    {
        return CykelBilletter.size() * getBikePrice();
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
    public static double getBalance()
    {
        return balance;
    }
    
    public static void setBalance(double bal)
    {
        if (bal < 0)
        {
            JFrame fra = new JFrame();
            JOptionPane.showMessageDialog(fra, "Prisen skal være positiv.");
            return;
        }
        
        balance = bal;
    }
    
    public static void setTotalPrice(double price)
    {
        totalPris = price;
    }
    
    public static double getTotalPrice()
    {
        return totalPris;
    }

    /**
     * Udskriv en billet.
     */
    public void udskrivBillet()
    {
        if (balance >= totalPris)
        {
            transaktioner.add(new Date() + " der blev udskrevet en billet");
            antalBilletterSolgt = antalBilletterSolgt + 1;
            balance = balance - totalPris;

            System.out.println("##########B##T##########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                      #");
            System.out.println("#        Billet        #");
            System.out.println("#        " + totalPris + " kr.        #");
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
            totalPris = nyPris;
        } else
        {
            System.err.println("Kunne ikke sætte pris - forkert kode");
        }
    }

    public double getSamletSalgsbeløb(String montørkode)
    {
        if (montørkode.equals("1234"));
        return totalPris * antalBilletterSolgt;
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
