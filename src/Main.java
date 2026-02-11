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
            String passkey = sc.nextLine();

            //lisitng of accounts
            if(user.checkPassword(passkey)) {
                 ArrayList<Bankaccount> Useraccountlist= user.Getbankaccountlist();
                System.out.println("your accounts are ");
                 for(int i=0;i<Useraccountlist.size();i++){

                     Bankaccount acc= Useraccountlist.get(i);
                     System.out.println(i+1 +"  "+ acc.getbanktype()+"  "+acc.getBankname()+"  "+acc.getBankaccountnumber());

                 }

                System.out.println("choose your account no (eg: 1)");
                System.out.println("or choose "+(Useraccountlist.size()+1)+"to create a new account  " );


                int accountlistedno =sc.nextInt();
                if(accountlistedno!=Useraccountlist.size()+1){
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
                        System.out.println((" done new balance   "+selectedaccount.getbankbalance()));
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


                }}//new account generation
                else{
                        sc.nextLine();
                        System.out.println("enter banktype  name ");
                        String banktype = sc.nextLine();

                        System.out.println("enter bank company name");
                        String bankcompanyname = sc.nextLine();
                        System.out.println("enter bankbalance");
                        double bankbalance = sc.nextDouble();


                        SecureRandom secRand = new SecureRandom();
                        int accountnumber = secRand.nextInt(10000,99000);

                        Bankaccount newaccount= new Bankaccount(bankbalance, bankcompanyname,accountnumber,banktype);
                        user.addBankaccount(newaccount);
                        bankserviceuser1.addUser(user);
                        sc.nextLine();


                    }


            }
            else{
                System.out.println("invalid password");
            }

        }// new user generation
        else{

                System.out.println("new user detected  enter new password");
                String enterpassword = sc.nextLine();
                String password = securityutil.hashPassword( enterpassword,username);
                User user= new User(username,password);
                System.out.println("enter banktype  name ");
                String banktype = sc.nextLine();
                System.out.println("enter bank company name");
                String bankcompanyname = sc.nextLine();
                System.out.println("enter bankbalance");
                double bankbalance = sc.nextDouble();


            SecureRandom secRand = new SecureRandom();
            int accountnumber = secRand.nextInt(10000,99000);

                Bankaccount newaccount= new Bankaccount(bankbalance, bankcompanyname,accountnumber,banktype);
                user.addBankaccount(newaccount);
                bankserviceuser1.addUser(user);
                sc.nextLine();

            }

        }




    }



