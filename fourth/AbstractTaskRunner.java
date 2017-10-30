package fourth;

import first.Task;
import second.Container;
import third.ContainerFactory;
import third.Strategy;

public abstract class AbstractTaskRunner
{
    private Container task_container;

    public AbstractTaskRunner(Strategy strategy)
    {
        ContainerFactory containerFactory = new ContainerFactory();
        task_container = containerFactory.createContainer(strategy);
    }

    public void addTask(Task task)
    {
        task_container.push(task);
    }

    public void executeAll()
    {
        while (!task_container.isEmpty())
        {
            Task current_task = task_container.pop();
            current_task.execute();
            action(current_task);
        }
    }

    protected abstract void action(Task task);
}
