/*

beskriver en enkelt billet, enten voksen, barn, eller cykel.
type, pris, dato, tid
kontruktor skal gives type og pris

 */
package grafiskbilletautomat;

public class billetKlasse {

    public enum ticketType
    {
        VOKSEN,
        BARN,
        CYKEL,
        TOTAL;
    }
    
    private ticketType type;
    private int price = 0;
    private String timeStamp = "";
    
    public billetKlasse(ticketType theType, int thePrice, String theTimeStamp) {

        type = theType;
        price = thePrice;
        timeStamp = theTimeStamp;
        
    }
    
    public ticketType getType() {
        return type;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getTimeStamp() {

        return timeStamp;
    }
    

}
