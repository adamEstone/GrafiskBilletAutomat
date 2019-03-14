/*

beskriver en enkelt billet, enten voksen, barn, eller cykel.
type, pris, dato, tid
kontruktor skal gives type og pris

 */
package grafiskbilletautomat;

public class billetKlasse {

    private int type = 0;
    private int price = 0;
    private String timeStamp = "";

    public billetKlasse(int theType, int thePrice, String theTimeStamp) {

        type = theType;
        price = thePrice;
        timeStamp = theTimeStamp;
        
    }
    
    public double getType() {
        return type;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getTimeStamp() {

        return timeStamp;
    }
    

}
