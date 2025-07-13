package com.lld.design.pattern.behavioural;

/**
 * What are Behavioral Design Patterns in Java?
 * Behavioral Design Patterns offer solution on how objects communicate and interact with each other
 * and how to provide lose coupling and flexibility to extend easily.
 *
 * We use Strategy Pattern when we have multiple algorithms for a specific task and client
 * decides the actual implementation to be used at runtime.
 * <p>
 * we can easily add new Strategy without modifying classes which uses strategies e.g. Context.
 * However, this becomes possible because Strategy pattern is based upon the Open Closed Design Principle,
 * which says that new behavior is added by writing new code not by modifying tried and tested old code.
 */
public class StrategyPattern {
    public static void main(String[] args) {
        int[] numbs= {6, 9, 7, 4, 8};

        //We can provide any strategy to do the sorting
        SortingService ctx = new SortingService(new BubbleSort());
        ctx.arrange(numbs);

        //We can change the strategy without changing Context class
        ctx = new SortingService(new MergeSort());
        ctx.arrange(numbs);
    }
}

interface SortingStrategy {
    void sort(int [] numbers);
}

// Context Class
class SortingService {
    private final SortingStrategy sortingStrategy;

    public SortingService(SortingStrategy sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public void arrange(int [] input){
        sortingStrategy.sort(input);
    }
}

class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting array using bubble sort strategy");
    }
}

class MergeSort implements SortingStrategy {
    @Override
    public void sort(int[] numbers) {
        System.out.println("sorting array using merge sort strategy");
    }
}


