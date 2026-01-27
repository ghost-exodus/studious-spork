import java.util.Base64;
public class securityutil
{
    private String plaintext;
    public String storedhash;
    public void encoder(String plaintext){
          storedhash=Base64.getEncoder().encodeToString(plaintext.getBytes()).toString();
    }



}
