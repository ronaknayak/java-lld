package com.lld.design.pattern.behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 * The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically.
 * <p>
 * Example:
 * In online shopping, notify desired customers about the product once it is available.
 * Subscribers (observers) get notified whenever the channel (subject) uploads a new video.
 *
 * Use Case	- Example
 * Event-driven systems -	Spring Application Events
 * Messaging systems -  	Kafka consumers, RabbitMQ subscribers
 * Domain events in DDD	-   Notify other aggregates/entities
 */
public class ObserverPattern {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber subscriber = new Subscriber("Ronak Nayak");
        channel.subscribe(subscriber);
        subscriber = new Subscriber("Chintan Ramani");
        channel.subscribe(subscriber);

        channel.uploadVideo("Observer Pattern Tutorial");

        channel.unsubscribe(subscriber);
        channel.uploadVideo("Strategy Pattern Deep Dive");
    }
}

interface Subject {
    void subscribe(Observer o);

    void unsubscribe(Observer o);

    void notifyObservers(String message);
}

class YouTubeChannel implements Subject {

    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : subscribers) {
            o.update(message);
        }
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("New video uploaded: " + videoTitle);
        notifyObservers("New Video: " + videoTitle);
    }
}

interface Observer {
    void update(String message);
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}
