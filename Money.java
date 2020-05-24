public class Money {
    public static int calculateYears(double principal, double interest,  double tax, double desired) {
        int years = 0;
        double without_tax;
        while(principal < desired){
            without_tax = principal*interest;
            principal += without_tax - without_tax*tax;
            years++;
        }
        return years;
    }
}
