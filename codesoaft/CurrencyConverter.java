import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Hardcoded exchange rates (you should fetch real rates from an API)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("JPY", 110.0);

        System.out.println("Welcome to the Currency Converter!");

        // Step 3: User Interface and Input
        System.out.print("Enter the base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency)) {
            System.out.println("Invalid base currency.");
            scanner.close();
            return;
        }

        System.out.print("Enter the target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid target currency.");
            scanner.close();
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        // Step 4: Currency Conversion
        double baseToTargetExchangeRate = exchangeRates.get(targetCurrency) / exchangeRates.get(baseCurrency);
        double convertedAmount = amountToConvert * baseToTargetExchangeRate;

        // Step 5: Display Result
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }
}
/*output
 Welcome to the Currency Converter!
Enter the base currency (e.g., USD): USD
Enter the target currency (e.g., EUR): EUR
Enter the amount to convert: 100
Converted amount: 85.0 EUR
 */