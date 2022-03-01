
public class taxCalculatorMain {
    static double firstTaxBracket = 0.105; // the first $14000 is taxed at 10.5% gap of 14000
    static double secondTaxBracket = 0.175; // the second tax bracket is from $14000 - $48000 is taxed at 17.5% gap of
                                            // 34000
    static double thirdTaxBracket = 0.3; // the third tax bracket is from $48000 - $70000 is taxed at 30% gap of 22000
    static double fourthTaxBracket = 0.33; // the fourth tax bracket is from $70000 - $180000 is taxed at 33% gap of
                                           // 110000
    static double fifthTaxBracket = 0.39; // the fifth tax bracket is from $180000 and upwards is taxed at 39%

    public static void main(String args[]) {
        float input = 70000;// these 2 will be updated from same input in stream;
        float totalIncome = input;// to save the original income amount
        float totalTaxAmount = 0;

        // System.out.println("Hello world");
        // get input from stream or gui

        if (input < 1) {
            if (input < 0) {
                System.out.println("error, Enter positive numbers only");
                return;
            }
            System.out.println("You owe $0 in taxes");

        } else if (input > 180000) {
            totalTaxAmount += 14000 * firstTaxBracket;
            input -= 14000;
            totalTaxAmount += 34000 * secondTaxBracket;
            input -= 34000;
            totalTaxAmount += 22000 * thirdTaxBracket;
            input -= 22000;
            totalTaxAmount += 110000 * fourthTaxBracket;
            input -= 110000;
            totalTaxAmount += input * fifthTaxBracket;
            /**
             * System.out.println("You owe $" + Double.toString(totalTaxAmount) + " in taxes
             * on your income of $"
             * + Double.toString(totalIncome));
             */
            System.out.printf("You owe $%.2f  in taxes on your income of $%.2f \n", totalTaxAmount, totalIncome);
            // call all tax brackets

        } else if (70000 < input && input <= 180000) {
            totalTaxAmount += 14000 * firstTaxBracket;
            input -= 14000;
            totalTaxAmount += 34000 * secondTaxBracket;
            input -= 34000;
            totalTaxAmount += 22000 * thirdTaxBracket;
            input -= 22000;
            totalTaxAmount += input * fourthTaxBracket;
            System.out.printf("You owe $%.2f  in taxes on your income of $%.2f \n", totalTaxAmount, totalIncome);
            // call all but top tax bracket

        } else if (48000 < input && input <= 70000) {
            totalTaxAmount += 14000 * firstTaxBracket;
            input -= 14000;
            totalTaxAmount += 34000 * secondTaxBracket;
            input -= 34000;
            totalTaxAmount += input * thirdTaxBracket;
            System.out.printf("You owe $%.2f  in taxes on your income of $%.2f \n", totalTaxAmount, totalIncome);
            // call first 3

        } else if (14000 < input && input <= 48000) {
            totalTaxAmount += 14000 * firstTaxBracket;
            input -= 14000;
            totalTaxAmount += input * secondTaxBracket;
            System.out.printf("You owe $%.2f  in taxes on your income of $%.2f \n", totalTaxAmount, totalIncome);
            // call first 2

        } else {
            totalTaxAmount += input * firstTaxBracket;
            System.out.printf("You owe $%.2f  in taxes on your income of $%.2f \n", totalTaxAmount, totalIncome);
            // call first one only

        }
        System.out.printf("Your remaning budget after tax is $%.2f", (totalIncome - totalTaxAmount));

        /**
         * may need to add extra options like loan repayment % and student loan
         * deductions
         * also need to figure out the gui
         * 
         */
    }

}