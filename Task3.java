import java.util.Scanner;

public class Task3 {

    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("✅ Deposited: ₹" + amount);
            } else {
                System.out.println("❌ Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("❌ Insufficient balance. Available: ₹" + balance);
            } else if (amount <= 0) {
                System.out.println("❌ Withdrawal amount must be positive.");
            } else {
                balance -= amount;
                System.out.println("✅ Withdrawn: ₹" + amount);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00); // Starting balance

        System.out.println("🏧 Welcome to the ATM!");
        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. 💰 Deposit");
            System.out.println("2. 💸 Withdraw");
            System.out.println("3. 📄 Check Balance");
            System.out.println("4. ❌ Exit");
            System.out.print("Your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next(); // clear invalid input
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("📄 Your current balance is: ₹" + account.getBalance());
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
