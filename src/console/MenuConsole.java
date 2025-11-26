package console;

import dao.repositories.AccountRamRepository;
import services.AccountService;

import java.util.Scanner;

public class MenuConsole {
    private AccountService service;
    private Scanner sc = new Scanner(System.in);

    public MenuConsole(AccountService service) {
        this.service = service;
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.print("""
                    1 - Create account
                    2 - Deposit
                    3 - Withdraw
                    4 - Run special action
                    5 - Show account info
                    
                    0 - Exit
                    
                    """);

            var option = sc.nextInt();
            switch (option) {
                case 0: {
                    exit = true;
                    break;
                }
                case 1: {
                    System.out.print("""
                            1 - Deposit
                            2 - Loan
                            3 - Mortgage
                            
                            0 - Exit
                            
                            """);
                    var option2 = sc.nextInt();

                    System.out.print("Enter account number: ");
                    String number = sc.next();
                    System.out.print("Enter owner name: ");
                    String ownerName = sc.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = sc.nextDouble();
                    var result = service.createAccount(number, ownerName, initialBalance, option2);
                    System.out.println(result.message);
                    break;
                }
                case 2: {
                    System.out.print("Enter account number: ");
                    String number = sc.next();
                    System.out.print("Enter amount to deposit: ");
                    double amount = sc.nextDouble();
                    var result = service.deposit(number, amount);
                    System.out.println(result.message);
                    break;
                }
                case 3: {
                    System.out.print("Enter account number: ");
                    String number = sc.next();
                    System.out.print("Enter amount to withdraw: ");
                    double amount = sc.nextDouble();
                    var result = service.withdraw(number, amount);
                    System.out.println(result.message);
                    break;
                }
                case 4: {
                    System.out.print("Enter account number: ");
                    String number = sc.next();
                    var result = service.runSpecialAction(number);
                    System.out.println(result.message);
                    break;
                }
                case 5: {
                    System.out.print("Enter account number: ");
                    String number = sc.next();
                    var result = service.getAccountInfo(number);
                    System.out.println(result.message);
                    break;
                }
            }
        }
    }

    // Doesn't work
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
