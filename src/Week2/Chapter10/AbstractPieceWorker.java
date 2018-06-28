package Week2.Chapter10;

public class AbstractPieceWorker extends AbstractEmployee{
    public double getWage() {
        return wage;
    }

    public double getPieces() {
        return pieces;
    }

    private double wage;
    private double pieces;

    public AbstractPieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces, Date birthday){
        super(firstName, lastName, socialSecurityNumber, birthday);

        this.wage = wage;
        this.pieces = pieces;
    }

    @Override
    public double earnings(){
        return getWage() * getPieces();
    }

    @Override
    public String toString(){
        return String.format("piece worker: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "pieces", getPieces(), "wage" , getWage());
    }
}
