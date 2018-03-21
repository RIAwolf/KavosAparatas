public class CoffeeBlack extends CoffeeCup {
    public CoffeeBlack() {
        super.setName("Black");
        super.setIsReady(false);
        super.setMaxVolume(175);
        super.setProducts(new ProductsVO(
                        15,
                        165,
                        25
                )
        );
        super.setPreparationDuration(3000);
    }
}
