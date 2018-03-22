package interfaces;

import cups.CoffeeCup;

import java.util.Map;

public interface IMenu {
    void addCup(CoffeeCup cup);
    void removeCup(String key);
    void addMap(Map<String,CoffeeCup> map);
    void makeCoffeeIfExists(String name);
}
