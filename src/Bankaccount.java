import java.util.Base64;
public class Bankaccount {
    private double bankbalance;
    private String bankname;
    public long bankaccountnumber;
    private String password;
    public double  getbankbalance() {
        return bankbalance;
    }


    Bankaccount(double bankbalance, String bankname, long bankaccountnumber, String  password ) {
        this.bankbalance = bankbalance;
        this.bankname = bankname;
        this.bankaccountnumber = bankaccountnumber;
        this.password = password;
    }

    public long getBankaccountnumber() {
        return bankaccountnumber;
    }

    public String getBankname() {
        return bankname;
    }
    public void deposit(long amount){
        this.bankbalance += amount;
    }
    public void withdraw(long amount) throws Fundsexception {
        if(this.bankbalance >= amount){
            this.bankbalance -= amount;
        }
        else{
                throw new Fundsexception("Insufficient Funds");


        }
    }
    public boolean checkpassword(String password){
        return  this.password.equals(password);

    }






}