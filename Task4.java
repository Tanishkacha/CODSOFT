public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mock exchange rates (Base: INR)
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("INR", 1.0);       // Base currency
        rates.put("USD", 0.012);     // Indian Rupees to US Dollar
        rates.put("EUR", 0.011);     // Euro
        rates.put("GBP", 0.0095);    // British Pound
        rates.put("JPY", 1.75);      // Japanese Yen

        // Display supported currencies
        System.out.println("💱 Currency Converter");
        System.out.println("Supported currencies: INR, USD, EUR, GBP, JPY");

        // Input base currency
        String fromCurrency;
        while (true) {
            System.out.print("Enter base currency (e.g. INR): ");
            fromCurrency = scanner.next().toUpperCase();
            if (rates.containsKey(fromCurrency)) break;
            System.out.println("❌ Invalid currency. Try again.");
        }

        // Input target currency
        String toCurrency;
        while (true) {
            System.out.print("Enter target currency (e.g. USD): ");
            toCurrency = scanner.next().toUpperCase();
            if (rates.containsKey(toCurrency)) break;
            System.out.println("❌ Invalid currency. Try again.");
        }

        // Input amount
        double amount = 0;
        while (true) {
            System.out.print("Enter amount in " + fromCurrency + ": ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) break;
            } else {
                scanner.next(); // clear invalid
            }
            System.out.println("❌ Enter a valid positive amount.");
        }

        // Conversion
        double baseRate = rates.get(fromCurrency);
        double targetRate = rates.get(toCurrency);
        double convertedAmount = (amount / baseRate) * targetRate;

        // Display result
        System.out.printf("✅ %.2f %s = %.2f %s\n",
                amount, fromCurrency, convertedAmount, toCurrency);

        scanner.close();
    }
}
