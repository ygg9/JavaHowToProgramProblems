package Week1;

public class Invoice {
    String partNumber = null;
    String partDescription = null;
    int quantity = 0;
    double price = 0.0;

    Invoice(String partNumber, String partDescription, int quantity, double price){
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.price = price;
    }

    public double getInvoiceAmount(){
        if(quantity < 0){
            quantity = 0;
        }
        if(price < 0){
            price = 0.0;
        }
        return quantity * price;
    }

    //Getters
    public String getPartNumber(){
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    //Setters
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
