import java.util.Base64;
public class securityutil
{
        public static String hashPassword(String password,long salt)
        {
            String salting = String.valueOf(salt);
            String combined = salting + password;
            String hashed = Base64.getEncoder().encodeToString(combined.getBytes());
            return hashed;
        }
    }




