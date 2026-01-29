import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        bankservice mybank= new bankservice();
        while(true){
            welcome(mybank);
        }

        }
        static void welcome(bankservice user1){

            Scanner sc = new Scanner(System.in);
        System.out.println("welcome to pepo bank enter bankaccount number ");
        long accountnumber= sc.nextLong();
        if(user1.checkbankaccount(accountnumber)){
            Bankaccount user= user1.getBankaccount(accountnumber);
            System.out.println("Welcome "+user.getBankaccountnumber()+"   enter bank password");
            sc.nextLine();
            String unsecuredpass = sc.nextLine();
            String passkey = securityutil.hashPassword( unsecuredpass,accountnumber);

            
            if(user.checkpassword(passkey)) {

                System.out.println("enter action 1.withdrawal 2.deposit 3.checkbalance 4.talk to support bot");
                int action = sc.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("enter withdrawal amount");
                        int amount = sc.nextInt();
                        System.out.println((" done new balance   "+user.getbankbalance()));
                        try{user.withdraw(amount);}
                          catch(Fundsexception e){e.Getmessage();};


                        break;
                    case 2:
                        System.out.println("enter deposit amount");
                        int amount1 = sc.nextInt();
                        user.deposit(amount1);
                        break;
                    case 3:
                        System.out.println("checkbalance amount");
                        System.out.println(user.getbankbalance());
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

        }
        else{
                System.out.println("new user detected ");
                System.out.println("enter bank name");
                String bankname = sc.next();
                System.out.println("enter bankbalance");
                double bankbalance = sc.nextDouble();
            System.out.println("enter bank password");
            sc.nextLine();
            String unsecuredpass = sc.nextLine();
            String password = securityutil.hashPassword( unsecuredpass,accountnumber);

                Bankaccount user= new Bankaccount(bankbalance,bankname,accountnumber,password);
                user1.addbankaccount(user);

            }

        }




    }



