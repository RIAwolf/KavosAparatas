public class CoffeeLatte extends CoffeeCup {
    public CoffeeLatte() {
        super.setName("Latte");
        super.setIsReady(false);
        super.setMaxVolume(250);
        super.setProducts(new ProductsVO(
                        20,
                        240,
                        20
                )
        );
        super.setPreparationDuration(4000);
    }
}
