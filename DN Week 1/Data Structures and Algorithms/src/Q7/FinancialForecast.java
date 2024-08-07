package Q7;

public class FinancialForecast {

    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {

        if (periods == 0) {
            return presentValue;
        }

        return calculateFutureValueRecursive(presentValue * (1 + growthRate), growthRate, periods - 1);
    }


    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05;
        int periods = 10;

        double futureValueRecursive = calculateFutureValueRecursive(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods (Recursive): $" + futureValueRecursive);

        double futureValueIterative = calculateFutureValueIterative(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods (Iterative): $" + futureValueIterative);
    }
}

