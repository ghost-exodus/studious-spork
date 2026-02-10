import java.util.ArrayList;
import java.util.Scanner;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args){
        bankservice mybank= new bankservice();
        while(true){
            welcome(mybank);
        }

        }
        static void welcome(bankservice bankserviceuser1){

            Scanner sc = new Scanner(System.in);
        System.out.println("welcome to pepo bank Username  ");
        String username= sc.nextLine();
        if(bankserviceuser1.checkUser(username)){
            User user= bankserviceuser1.getUser(username);
            System.out.println("Welcome     "+user.getUsername()+"   enter bank password");
            //scanner bug removed
            sc.nextLine();
            String unsecuredpass = sc.nextLine();
            String passkey = securityutil.hashPassword( unsecuredpass,username);

            //lisitng of accounts
            if(user.checkPassword(passkey)) {
                 ArrayList<Bankaccount> Useraccountlist= user.Getbankaccountlist();
                 for(int i=0;i<Useraccountlist.size();i++){
                     System.out.println("your accounts are ");
                     Bankaccount acc= Useraccountlist.get(i);
                     System.out.println(i+1 +"  "+ acc.getbanktype()+"  "+acc.getBankaccountnumber());
                 }
                System.out.println("choose your account no (eg: 1)");
                 int accountlistedno =sc.nextInt();
                 Bankaccount selectedaccount = Useraccountlist.get(accountlistedno-1);
                System.out.println("choosen bankaccount "+selectedaccount.getbanktype());




                // action procedures
                System.out.println("enter action 1.withdrawal 2.deposit 3.checkbalance 4.talk to support bot");
                int action = sc.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("enter withdrawal amount");
                        int amount = sc.nextInt();
                        System.out.println((" done new balance   "+selectedaccount.getbankbalance()));
                        try{selectedaccount.withdraw(amount);}
                          catch(Fundsexception e){e.Getmessage();};


                        break;
                    case 2:
                        System.out.println("enter deposit amount");
                        int amount1 = sc.nextInt();
                        selectedaccount.deposit(amount1);
                        break;
                    case 3:
                        System.out.println("checkbalance amount");
                        System.out.println(selectedaccount.getbankbalance());
                        break;
                    case 4:
                        System.out.println("coming soon");
                        break;
                    default:
                        System.out.println("invalid choice");


                }
            } else{
                System.out.println("invalid password");

            }

        }// new user generation
        else{

                System.out.println("new user detected  enter new password");

                sc.nextLine();
                String enterpassword = sc.nextLine();
                String password = securityutil.hashPassword( enterpassword,username);
                User user= new User(username,password);
                System.out.println("enter bank name ");
                sc.nextLine();
                String banktype = sc.nextLine();
                System.out.println("enter bank name");
                sc.nextLine();
                String bankcompanyname = sc.next();
                System.out.println("enter bankbalance");
                double bankbalance = sc.nextDouble();


            SecureRandom secRand = new SecureRandom();
            int accountnumber = secRand.nextInt(10000,99000);

                Bankaccount newaccount= new Bankaccount(bankbalance, bankcompanyname,accountnumber,banktype);
                user.addBankaccount(newaccount);
                bankserviceuser1.addUser(user);

            }

        }




    }



