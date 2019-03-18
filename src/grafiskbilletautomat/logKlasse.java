/*

skal logge alt

*/
package grafiskbilletautomat;

import java.util.ArrayList;


public class logKlasse
{
    //Tid, dato, beskrivelse + type id, beløb, fortløbende nummer (id)
    
    //Handling er en streng + tidspunkt
    //Transaktion er beløb + tidspunkt
    
    public static void logHandling(LogElement element) throws Exception
    {
        String file = "Historik.log";

        ArrayList<LogElement> l;

        try
        {
            l = (ArrayList<LogElement>) Serialisering.hent(file);
            System.out.println("Læst: " + l);
        } 
        catch (Exception e)
        {
            l = new ArrayList();
            System.out.println("Oprettet: " + l);
            e.printStackTrace();
        }

        //l.add("Ven" + l.size());
        l.add(element);
        Serialisering.gem(l, file);
        System.out.println("Gemt: " + l);
    }

}
    

    

