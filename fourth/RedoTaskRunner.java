package fourth;

import first.Task;
import third.Strategy;

import java.util.LinkedList;
import java.util.List;

public class RedoTaskRunner extends AbstractTaskRunner
{
    private List<Task> task_list;

    public RedoTaskRunner(Strategy strategy)
    {
        super(strategy);
        task_list = new LinkedList<>();
    }

    @Override
    protected void action(Task task)
    {
        task_list.add(0, task);
    }

    public void reExecuteALl()
    {
        for (Task task : task_list)
        {
            task.execute();
        }
    }
}
