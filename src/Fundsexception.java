public class Fundsexception extends Exception
{
    Fundsexception(String message){
        super(message);
    }
    void Getmessage()
    {
        System.out.println("insufficient funds");
    }
}
