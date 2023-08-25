package com.atmsys;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

class bankaccount{
    static void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("ENTER YOUR NAME :");
        ATM.name=sc.nextLine();
        System.out.println("ENTER YOUR USERNAME :");
        String user=sc.nextLine();
        System.out.println("ENTER YOUR PASSWORD  :");
        String password=sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFUL...!!!");
        System.out.println("*************************************");
        ATM.menu();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,password);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else {
                    System.out.println("ENTER AGAIN !");
                }
            }
        }

    }
    static void display(String name){}
    static void login(String user,String password){}
}
class transaction{
    static void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("ENTER AMOUNT TO WITHDRAW");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("WITHDRAW");
            System.out.println(wcash+"RS. WITHDRAW SUCCESSFULLY");
            System.out.println("********************************************");
        }
        else {
            System.out.println("INSUFFICIENT BALANCE");
            System.out.println("**********************************************");
        }
        ATM.menu();
    }
    static void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************");
        System.out.println("ENTER AMOUNT TO DEPOSIT");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("DEPOSIT");
        System.out.println(dcash+" RS. AMOUNT DEPOSITED SUCCESSFULLY");
        System.out.println("*******************************************************");
        ATM.menu();
    }
    static void  transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NAME OF RECEIVER");
        String s =sc.nextLine();
        System.out.println("ENTER ACCOUNT NUMBER OF RECEIVER");
        int num=sc.nextInt();
        System.out.println("ENTER AMOUNT ");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("TRANSFERD");
            System.out.println(tcash+"RS. AMOUNT TRANSFERRED SUCCESSFULLY");
            System.out.println("******************************************************");
        }
        else {
            System.out.println("INSUFFICIENT BALANCE...!!!");
            System.out.println("*********************************************************");
        }
        ATM.menu();
    }
}
class check{
    static void checkbalance(){
        System.out.println("****************************************************************");
        System.out.println("THE AVAILABLE BALANCE :");
        ATM.showbal();
        System.out.println("****************************************************************");
        ATM.menu();

    }


}
class transachis{
    static void transachistory(){
        System.out.println("***********************************************************");
        System.out.println("TRANSACTION HISTORY :");
        int j=0;
        if(ATM.balance>=0){
            for (int i=0;i<(ATM.history.size()/2);i++){
                for (int f=0;f<2;f++){
                    System.out.println(ATM.history.get(j)+" ");
                    j++;
                }
                System.out.println("***************************************************");
            }
        }
        else {
            System.out.println("O.OO00 BALANCE");
        }
        ATM.menu();
    }

}

public class ATM {
    public static String name;
    public static int balance=0;
    public static ArrayList<String>history=new ArrayList<String>();
    static void updatebalance(int cash){
        balance=balance+cash;
    }
    static void showbal(){
        System.out.println(balance);
    }
    public static void HOME(){
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO ATM SERVICE");
        System.out.println("****************************************");
        System.out.println("SELECT OPTION");
        System.out.println("1. REGISTER");
        System.out.println("2. EXIT 0");
        System.out.println("ENTER CHIOICE");
        int choose=sc.nextInt();
        if(choose==1){
            bankaccount.register();
        }
        else {
            if(choose==2){
                System.exit(0);
            }
            else {
                System.out.println("SELECT CORRECTLY");
                HOME();
            }
        }


    }
    static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME"+ATM.name+"TO ATM SYSTEM");
        System.out.println("******************************************");
        System.out.println("SELECT OPTION :");
        System.out.println("1. WITHDRAW");
        System.out.println("2. DEPOSIT");
        System.out.println("3. TRANSFER");
        System.out.println("4. CHECK BALANCE");
        System.out.println("5. TRANSACTION HISTORY");
        System.out.println("6. EXIT");
        System.out.println("ENTER THE NUMBER");
        int choice=sc.nextInt();
        switch (choice){
            case 1:
                transaction.withdraw();
                break;
            case 2:
                transaction.deposit();
                break;
            case 3:
                transaction.transfer();
                break;
            case 4:
                check.checkbalance();
                break;
            case 5:
                transachis.transachistory();
                break;
            case 6:{
                System.out.println("THANKS VISIT AGAIN");
                System.exit(0);
            }


        }
    }

    public static void main(String[] args) {
        HOME();
    }


}
