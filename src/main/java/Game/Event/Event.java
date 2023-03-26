package Game.Event;

import entities.Hero;

import java.util.Scanner;

public abstract class Event {
    public abstract void trigger(Hero hero, Scanner sc);
}
