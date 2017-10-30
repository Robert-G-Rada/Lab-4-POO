package com;

import first.Counter;
import first.GenerateRandom;
import first.PrintMessage;
import fourth.CountTaskRunner;
import fourth.DelayedPrintTaskRunner;
import fourth.PrintTaskRunner;
import fourth.RedoTaskRunner;
import second.Container;
import third.ContainerFactory;
import third.Strategy;

public class Main
{

    public static void main(String[] args)
    {
        task1();
        task2();
        task3();
    }

    private static void printTask(int k)
    {
        System.out.println("---- TASK " + k + "----");
    }

    private static void task1()
    {
        printTask(1);

        PrintMessage pm = new PrintMessage("Hello world!");
        GenerateRandom gr = new GenerateRandom();
        Counter cnt = new Counter();

        pm.execute();

        gr.execute();

        cnt.execute();
        cnt.execute();
        cnt.execute();
        cnt.execute();

        System.out.println("");
    }

    private static void task2()
    {
        printTask(2);

        ContainerFactory containerFactory = new ContainerFactory();

        Container queue = containerFactory.createContainer(Strategy.FIFO);
        Container stack = containerFactory.createContainer(Strategy.LIFO);

        queue.push(new PrintMessage("Hello"));
        queue.push(new GenerateRandom());
        queue.push(new Counter());

        stack.push(new PrintMessage("Hello"));
        stack.push(new GenerateRandom());
        stack.push(new Counter());

        System.out.println("Queue pop: " + queue.pop());
        System.out.println("Stack pop: " + stack.pop());

        stack.transferFrom(queue);
        System.out.println("Transfer to queue");

        while (!stack.isEmpty())
        {
            System.out.println("Stack pop " + stack.pop());
        }

        System.out.println("");
    }

    public static void task3()
    {
        printTask(3);

        System.out.println("CountTaskRunner LIFO");
        CountTaskRunner ctr = new CountTaskRunner(Strategy.LIFO);

        ctr.addTask(new PrintMessage("task 1"));
        ctr.addTask(new PrintMessage("task 2"));
        ctr.addTask(new PrintMessage("task 3"));
        ctr.addTask(new PrintMessage("task 4"));

        ctr.executeAll();
        System.out.println(ctr.getCounter() + " tasks executed");
        System.out.println("---------------");

        System.out.println("RedoTaskRunner FIFO");
        RedoTaskRunner rtr = new RedoTaskRunner(Strategy.FIFO);

        rtr.addTask(new PrintMessage("task 1"));
        rtr.addTask(new PrintMessage("task 2"));

        rtr.executeAll();
        rtr.reExecuteALl();
        System.out.println("---------------");

        System.out.println("DelayedPrintTaskRunner FIFO");
        PrintTaskRunner ptr = new DelayedPrintTaskRunner(Strategy.FIFO, 1000);

        ptr.addTask(new PrintMessage("task 1"));
        ptr.addTask(new PrintMessage("task 2"));
        ptr.addTask(new PrintMessage("task 3"));

        ptr.executeAll();
    }
}
