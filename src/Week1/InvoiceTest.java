package Week1;

public class InvoiceTest {
    public static void main(String[] args) {
        Invoice customer1 = new Invoice("2", "Nuts and Bolts", 5, 3.00);
        System.out.println("Invoice amount: " + customer1.getInvoiceAmount());
        //set and get part description
        customer1.setPartDescription("This is a different description");
        System.out.println(customer1.getPartDescription());
        //set and get part number
        customer1.setPartNumber("4");
        System.out.println("Part Number: " + customer1.getPartNumber());
        //set and get quantity
        customer1.setQuantity(10);
        System.out.println("Quantity: " + customer1.getQuantity());
        //set and get price
        customer1.setPrice(13.00);
        System.out.println("Price: " + customer1.getPrice());
    }
}
