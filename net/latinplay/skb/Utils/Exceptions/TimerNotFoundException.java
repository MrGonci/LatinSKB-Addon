package net.latinplay.skb.Utils.Exceptions;

public class TimerNotFoundException extends Exception{
    public TimerNotFoundException(int id){
        super("Timer with id: " + id + " not found");
    }
}
