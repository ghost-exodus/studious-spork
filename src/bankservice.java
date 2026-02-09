import java.util.HashMap;
public class bankservice {
    public HashMap<String, User> Users= new HashMap<>();
    public void addUser(User user1){
        Users.put(user1.username,user1);

        }




    public User getUser(String username){
        return Users.get(username);

    }
    public boolean checkUser(String username){
        return Users.containsKey(username);
    }

    };







