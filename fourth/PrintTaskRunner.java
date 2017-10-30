package fourth;

import first.Task;
import third.Strategy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrintTaskRunner extends AbstractTaskRunner
{
    public PrintTaskRunner(Strategy strategy)
    {
        super(strategy);
    }

    @Override
    protected void action(Task task)
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
    }
}
