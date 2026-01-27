import java.util.HashMap;
public class bankservice {
    public HashMap<Long, Bankaccount> bankaccounts= new HashMap<>();
    public void addbankaccount(Bankaccount user1){
        bankaccounts.put(user1.getBankaccountnumber() ,user1);
    }
    public Bankaccount getBankaccount(long accountnumber){
        return bankaccounts.get(accountnumber);

    }
    public boolean checkbankaccount(long user1){
        return bankaccounts.containsKey(user1);
    }

    }







