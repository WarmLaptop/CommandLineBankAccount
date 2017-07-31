import java.util.Random;
import java.util.Scanner;

/**
 * Created by Jordan on 5/30/2017.
 */


public class BankInterface {
    public static void main(String[] args) {
            String KILL = "Quit";

            System.out.println("Enter your username:");
            Scanner Username = new Scanner(System.in);
            String Name = Username.nextLine();
            if (Name.equals(KILL)){System.exit(0);}

            Random AccountNum = new Random();
            int AccNum = AccountNum.nextInt(1000000);

            BankAccount myAccount = new BankAccount(AccNum, 0, Name);


            System.out.println("Account Number: " + AccNum + "\nUsername: " + Name + "\nBalance: " + myAccount.getBalance() + "\n");
            System.out.println("Please enter the following options: \nCheck Account Number\nChange Name\nCheck Balance\nWithdraw\nDeposit\nQuit");

            do {
                Scanner keyboard = new Scanner(System.in);
                String Input = keyboard.nextLine();
                if (Input.equals(KILL)) break;

                switch (Input) {
                    case "Check Balance":
                        System.out.println(myAccount.getBalance() + " is the current account balance.\n");
                        break;
                    case "Change Name":
                        do {
                            System.out.println("Please enter the updated name:");
                            Scanner NewName = new Scanner(System.in);
                            String NewNewName = NewName.nextLine();

                            if (Name.equals(NewNewName)) {
                                System.out.println("Your new name is identical. Please enter a different name:");
                                continue;
                            }

                            if (!Name.equals(NewNewName)) {
                                Name = NewNewName;
                                System.out.println(Name + " is your new username.");
                                break;
                            }
                        } while (true);
                        break;
                    case "Check Account Number":
                        System.out.println("Account number is: " + myAccount.getAccNum());
                        break;
                    case "Withdraw":
                        do{
// Any bonus marks for handling exceptions with try ant catch? :)
                            try {
                            System.out.println("Please enter the withdrawal amount: ");
                            Scanner NegMoney = new Scanner(System.in);
                            int LessMoney = Integer.parseInt(NegMoney.next());
                            System.out.println("Balance is now: " + myAccount.Withdrawal(LessMoney));
                            break;
                            }
                         catch (NumberFormatException exc) {
                            System.out.println("Input invalid, not a number.");
                            System.out.println("Please enter a number, not alphabets: ");
                            }
                        } while(true);
                        break;
                    case "Deposit":
                        do{
                        try {
                            System.out.println("Please enter the deposit amount: ");
                            Scanner PosMoney = new Scanner(System.in);
                            int MoreMoney = Integer.parseInt(PosMoney.next());
                            System.out.println("Balance is now: " + myAccount.Deposit(MoreMoney));
                            break;
                        }
                        catch (NumberFormatException exc) {
                            System.out.println("Input invalid, not a number.");
                            System.out.println("Please enter a number, not alphabets: ");
                        }
                    } while(true);
                    break;
                    default:
                        System.out.println("Invalid operation. Please try again from these options:\nCheck Account Number\nChange Name\nCheck Balance\nWithdraw\nDeposit\nQuit");
                        break;
                }
            } while (true);
    System.out.println("Thank you for using Jordan Trust Bank.");
    }
}
