package fourth;

import first.Task;
import third.Strategy;

public class DelayedPrintTaskRunner extends PrintTaskRunner
{
    private final int delay;

    public DelayedPrintTaskRunner(Strategy strategy, int delay)
    {
        super(strategy);
        this.delay = delay;
    }

    @Override
    protected void action(Task task)
    {
        super.action(task);

        try
        {
            Thread.sleep(delay);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
