package cs544.exercise17_1.bank.logging;

import org.springframework.stereotype.Component;

@Component
public interface ILogger {
    public void log(String logstring);
}
