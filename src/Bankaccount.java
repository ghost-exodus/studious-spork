import java.util.Base64;
public class Bankaccount {
    private double bankbalance;
    private String banktype;
    private String bankname;
    public long bankaccountnumber;

    public double  getbankbalance() {
        return bankbalance;
    }


    Bankaccount(double bankbalance, String bankname, long bankaccountnumber , String banktype) {
        this.bankbalance = bankbalance;
        this.bankname = bankname;
        this.bankaccountnumber = bankaccountnumber;
        this.banktype = banktype;

    }
    public String getbanktype(){return this.banktype;}

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

    }






