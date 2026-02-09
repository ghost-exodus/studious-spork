import java.util.ArrayList;

public class User {
    public String username;
    private String SecurityHash;
    private ArrayList<Bankaccount> Useraccountlist;

    User(String username, String securityHash) {
        this.username = username;
        this.SecurityHash = securityHash;
        this.Useraccountlist = new ArrayList<>();

    }


    public void addBankaccount(Bankaccount User1) {
        Useraccountlist.add(User1);
    }

    public ArrayList<Bankaccount> Getbankaccount() {
        return this.Useraccountlist;
    }

    Boolean checkPassword(String password) {
         return this.SecurityHash.equals(securityutil.hashPassword(password, username));
    }



}
