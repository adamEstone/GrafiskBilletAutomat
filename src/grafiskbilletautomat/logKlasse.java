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
    
    
    logKlasse()
    {
         
    }
    
    public static void logHandling(String theString)throws Exception{
        String file = "Historik.log";
        
    		ArrayList<String> l;
		
		try {
			l = (ArrayList<String>) Serialisering.hent(file);
			System.out.println("Læst: "+l);
		} catch (Exception e) {
			l = new ArrayList();
			System.out.println("Oprettet: "+l);
		}

		l.add("Ven"+l.size());
		Serialisering.gem(l,file);
		System.out.println("Gemt: "+l);
	}
    
    }
    

    

