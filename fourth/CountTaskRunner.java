package fourth;

import first.Task;
import third.Strategy;

public class CountTaskRunner extends AbstractTaskRunner
{
    private int counter = 0;

    public CountTaskRunner(Strategy strategy)
    {
        super(strategy);
        counter = 0;
    }

    @Override
    protected void action(Task task)
    {
        counter++;
    }

    public int getCounter()
    {
        return counter;
    }
}
