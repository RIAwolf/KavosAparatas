package interfaces;

import products.ProductsVO;


import java.util.List;

public interface IMachineService {
    List<ICoffeeMachine> createMachines(int n);

    ICoffeeMachine createMachine();

    void washMashines(List<ICoffeeMachine> list);

    void washMashine(ICoffeeMachine value);

    void dumpMachineProducts(List<ICoffeeMachine> list);

    void assignSingleProduct(List<ICoffeeMachine> list, ProductsVO product);

    void assignMultipleProducts(List<ICoffeeMachine> list, List<ProductsVO> products);
}
