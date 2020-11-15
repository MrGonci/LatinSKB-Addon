package net.latinplay.skb.Utils.Timer;

import net.latinplay.skb.Utils.Exceptions.TimerNotFoundException;
import net.latinplay.skb.Utils.Interfaces.SKAddon;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;


public class Timer implements SKAddon {

    private int back;
    private final int original;
    private final boolean repeat;
    private boolean cancelled;
    public final HashMap<Integer, Runnable> TaskActions =new HashMap<>();
    public final HashMap<Integer, Runnable> TaskActionsSpecified =new HashMap<>();
    public static final HashMap<Integer, Timer> timers =new HashMap<>();

    private static int timerId = 0;

    public Timer(int time, boolean repeat){
        this.repeat = repeat;
        this.original = time;
        this.back = time;
        timerId++;
        timers.put(timerId, this);
    }


    /**
     * Timer Methods
     */
    public final void start() {
        int id = timerId;

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!cancelled) {
                    if (back == 0) {
                        back--;
                        if (!repeat) {
                            cancel();
                            timers.remove(id);
                        } else {
                            resetTimer();
                        }
                    } else {
                        back--;
                    }
                    executeTaskAt(back);
                }else{
                    cancel();
                    timers.remove(id);
                }
            }
        }.runTaskTimer(plugin, 0, 20);
    }

    public final void addExecutable(Runnable run){
        int i = 0;
        while (i < original){
            if(!TaskActions.containsKey(i)){
                TaskActions.put(i, run);
            }
            i++;
        }
    }
    public final void addExecutable(int onPerform, Runnable run){
        TaskActionsSpecified.put(onPerform, run);
    }

    public final void resetTimer(){
        back = original;
    }

    public final int getTime(){
        return back;
    }

    public void setCancelled() {
        this.cancelled = true;
    }

    /**
     * Cancel the timer
     * @return boolean
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Obtains timer
     * @param id the timer id
     * @return a timer instance
     * @throws TimerNotFoundException
     */
    public static Timer getTimer(int id) throws TimerNotFoundException {
        if(timers.containsKey(id)) {
            if(timers.get(id) != null){
                return timers.get(id);
            }
        }
        throw new TimerNotFoundException(id);
    }

    private void executeTaskAt(int task){
        if(TaskActions.containsKey(task)){
            Runnable run = TaskActions.get(task);
            run.run();
        }
        if(TaskActionsSpecified.containsKey(task)){
            Runnable run = TaskActionsSpecified.get(task);
            run.run();
        }
    }


}

