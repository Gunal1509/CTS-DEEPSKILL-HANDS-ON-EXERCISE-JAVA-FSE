public class FinancialForecasting {
    static double futureValue(double amount, double growthRate, int years) {
        if (years == 0) {
            return amount;
        }
        return futureValue(amount * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double presentValue = 10000;   
        double growthRate = 0.10;     
        int years = 5;

        double result = futureValue(presentValue, growthRate, years);

        System.out.println("Present Value : Rs." + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.println("Future Value  : Rs." + result);
    }
}