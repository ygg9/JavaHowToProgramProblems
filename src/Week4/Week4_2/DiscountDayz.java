package Week4.Week4_2;

public class DiscountDayz {
    public static boolean isDiscountDay(Date date){
        if(date.getDay()%2 == 0){
            return true;
        } else{
            return false;
        }
    }
}
