import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
     //variables 
    public int balance = 1000;
    public String pin = new String("9320");
    public ArrayList<String> history = new ArrayList<String>();
    public Scanner sc = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    public Functions(){
        System.out.print("Enter pin: ");
        String data  = new String(input.next());

        if(data.equals(pin)){
            menu();
        }
        else{
            System.out.println("**Incorrect pin!");
        }
    }

    //functions
    public void menu(){
        Scanner choice = new Scanner(System.in);
        System.out.println("1.Account balance inquiry\n2.Cash withdrawal\n3.Cash deposit\n4.PIN change\n5.Transaction history\n6.Exit");
        int ch = choice.nextInt();

        switch (ch) {
            case 1:
                accBalance(); 
                break;
            case 2:
                withdrawal();
                break;
            case 3:
                    deposit();
                    break;
            case 4:
                    pinChange();
                    break;
            case 5:
                traHistory();
                 break; 
            case 6:
                System.exit(0);
                break;
            default:
                break;

        }

    }

    public void accBalance(){
        System.out.println("**Your Account Balance: "+balance);
        menu();
    }

    public void withdrawal(){
        System.out.print("Enter the Amount: ");
        int withdraw = sc.nextInt();

        if(withdraw <= balance){
            balance-= withdraw;
            System.out.println("**Withdrawal done!");
            history.add("*Cash withdraw: "+withdraw+"\tAccount Balance: "+balance);
            menu();
        }
        else{
            System.out.println("**Insufficient Balance!");
            menu();
        }
    }

    public void deposit(){
        System.out.print("Enter the Amount: ");
        int amount = sc.nextInt();
        balance+=amount;
        System.out.println("**Cash Deposit Done!");
        history.add("*Cash Desposit: "+amount+"\tAccount Balance: "+balance);
        menu();
    }

    public void pinChange(){
        System.out.print("Enter the pin: ");
        String newPin = new String(sc.next());

        if(newPin.length() <= 6 && newPin.length() >= 4){
            pin = newPin;
            System.out.println("**Pin Changed**");
            System.out.println("Enter Pin: ");
            String data = input.next();

            if(data.equals(newPin)){
                menu();
            }
            else{
                System.out.println("Please try again.!");
            }
        }
        else{
            System.out.println("**Length of pin should be less than 6 digits and more than 4 digits!");
            
        }
        menu();
    }
    public void traHistory(){
        for(String tr : history){
            System.out.println(tr);
        }
        menu();
    }
}
