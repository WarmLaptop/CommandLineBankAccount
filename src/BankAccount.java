/**
 * Created by Jordan on 5/29/2017.
 */
public class BankAccount {
    private int AccNum;
    private int Balance;
    private String UserName;

//BankAccount constructor:
    BankAccount(int A, int B, String N){
        this.AccNum=A;
        this.Balance=B;
        this.UserName=N;
    }

// Depositing Method:
    int Deposit(int DepositAmount){
            if(DepositAmount<=10_000){
                Balance+=DepositAmount;
            }
            else{
                System.out.println("You cannot deposit more than $10,000");
            }

        return Balance;
    }

// Withdrawal Method:
    int Withdrawal(int WithdrawAmount){
        if(Balance>=WithdrawAmount) {
            Balance -= WithdrawAmount;
        }
        else{
            System.out.println("You cannot withdraw more than your balance. Input rejected.");
            }

        return Balance;
    }


// Return balance using setter:
    int getBalance(){

        return Balance;
    }
// Return Account number using setter:
    int getAccNum(){

        return AccNum;
    }

}

