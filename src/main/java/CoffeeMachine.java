import cups.CoffeeBlack;
import cups.CoffeeCup;
import cups.CoffeeEspresso;
import cups.CoffeeLatte;
import interfaces.ICoffeeMachine;
import interfaces.IMenu;
import interfaces.IProductsContainer;
import products.ProductsVO;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine implements IProductsContainer, ICoffeeMachine, IMenu {

    public static final int MAX_USES = 5;
    private ProductsVO _products;
    private int _uses;

    private Map<String,CoffeeCup> _menu;


    public CoffeeMachine() {
        _menu = new HashMap<>();
        addCup(new CoffeeLatte());
        addCup(new CoffeeBlack());
        addCup(new CoffeeEspresso());
    }


    public CoffeeMachine(ProductsVO value) {
        this._products = value;
    }

    @Override
    public void addProducts(ProductsVO value) {
        this._products.setBeans(this._products.getBeans() + value.getBeans());
        this._products.setWater(this._products.getWater() + value.getWater());
        this._products.setSugar(this._products.getSugar() + value.getSugar());
    }

    @Override
    public void makeCoffee(String type) {
       makeCoffeeIfExists(type);
    }

    @Override
    public void cleanMachine() {
        _uses = 0;
    }

    @Override
    public void showIsReady() {
        if (_uses >= MAX_USES) {
            System.out.println("Neišvalyta");
        } else {
            System.out.println("Išvalyta");
        }
        System.out.println("Produktų būsenos:");
        if (_products.getBeans() > 0) {
            System.out.println("+ Pupelės");
        } else {
            System.out.println("- Pupelės");
        }

        if (_products.getSugar() > 0) {
            System.out.println("+ Cukrus");
        } else {
            System.out.println("- Cukrus");
        }

        if (_products.getWater() > 0) {
            System.out.println("+ Vanduo");
        } else {
            System.out.println("- Vanduo");
        }
    }

    @Override
    public void showProducts() {
        System.out.println("Pupelės: " + _products.getBeans());
        System.out.println("Cukrus: " + _products.getSugar());
        System.out.println("Vanduo: " + _products.getWater());
        System.out.println("Pienas: " + _products.getMilk());
        System.out.println("Šokoladas: " + _products.getChocolate());
    }

    @Override
    public void showStatus() {
        showProducts();
        System.out.println("Iki plovimo liko: " + (MAX_USES - _uses));
    }


    /**
     */
    private void makeCup(CoffeeCup cup) {

        if (!checkProducts(cup.getProducts().getSugar(), cup.getProducts().getWater(), cup.getProducts().getBeans()) && checkWashing()) {
            _products.setWater(_products.getWater() - cup.getProducts().getWater());
            _products.setSugar(_products.getSugar() - cup.getProducts().getSugar());
            _products.setBeans(_products.getBeans() - cup.getProducts().getBeans());
            _uses++;
            cup.setIsReady(true);
            try {
                Thread.sleep(cup.getPreparationDuration());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(cup);
        }

    }


    private boolean checkProducts(float sugar, float water, float beans) {
        boolean result = false;
        if (beans > _products.getBeans()) {
            result = true;
            System.out.println("Trūksta pupelių");
        }
        if (water > _products.getWater()) {
            result = true;
            System.out.println("Trūksta vandens");
        }
        if (sugar > _products.getSugar()) {
            result = true;
            System.out.println("Trūksta cukraus");
        }
        return result;
    }

    private boolean checkWashing() {
        boolean result = true;
        if (_uses >= MAX_USES) {
            result = false;
            System.out.println("Reikia plauti aparatą!!!");
        }
        return result;
    }

    @Override
    public ProductsVO getProducts() {
        return _products;
    }

    @Override
    public void setProducts(ProductsVO _products) {
        this._products = _products;
    }

    @Override
    public void addCup(CoffeeCup cup) {
        _menu.put(cup.getName().toLowerCase(),cup);
    }

    @Override
    public void removeCup(String key) {
        _menu.remove(key.toLowerCase());
    }

    @Override
    public void addMap(Map<String, CoffeeCup> map) {
        _menu=map;
    }

    @Override
    public void makeCoffeeIfExists(String name) {
        if(_menu.containsKey(name.toLowerCase())){
            makeCup(_menu.get(name.toLowerCase()));
        }
    }
}
