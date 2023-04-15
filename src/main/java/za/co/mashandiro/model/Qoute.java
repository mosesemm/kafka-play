package za.co.mashandiro.model;

public class Qoute {
    public String id;
    public int price;

    public Qoute() {}

    public Qoute(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        
        return "Quote{"+
        "id='"+id+"', price="+price+"}";
    }


}
