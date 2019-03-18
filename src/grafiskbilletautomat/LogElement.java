package grafiskbilletautomat;
import java.io.Serializable;

//tidspunkt, handling og beløb.

//Tid, dato, beskrivelse + type id, beløb, fortløbende nummer (id)
    
    //Handling er en streng + tidspunkt
    //Transaktion er beløb + tidspunkt

public class LogElement {
    public enum TypeID
    {
        GUI,
        TRANSAKTION,
        BELØB,
        HANDLING,
        MØNT;
    }
    
    public static void log(TypeID handling, String s)
    {
        LogElement element = new LogElement(handling, s);
        try
        {
            logKlasse.logHandling(element);
        } 
        catch (Exception ex)
        {
            System.out.println("Må ikke printes. 1");
        }
    }
    
    public LogElement(TypeID handling, String s)
    {
        //tid + dato altid med
        String tid = billetAutomatKlasse.getTime();
        String dato = billetAutomatKlasse.getDate();
        
        String str = tid + " " + dato + " " + handling + " " + s + "\n";
        System.out.println("LOG:\n" + str);
    }
}
