public class CoffeeCup extends Cup {
    private ProductsVO _products;
    private String _name;
    private boolean _isReady;
    private int _preparationDuration;

    public boolean getIsReady() {
        return _isReady;
    }

    public void setIsReady(boolean value) {
        this._isReady = value;
    }

    public String getName() {
        return _name;
    }

    public void setName(String value) {
        this._name = value;
    }

    public ProductsVO getProducts() {
        return _products;
    }

    public void setProducts(ProductsVO value) {
        this._products = value;
    }

    @Override
    public String toString() {
        return "Name: "+getName() + ", is ready: "+ getIsReady()+ ", beans: "+_products.getBeans()+", sugar: "+_products.getSugar()+", water: "+ _products.getWater();
    }

    public int getPreparationDuration() {
        return _preparationDuration;
    }

    public void setPreparationDuration(int value) {
        this._preparationDuration = value;
    }
}
