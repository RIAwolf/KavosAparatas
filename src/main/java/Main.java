import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private int _currentMachine = -1;
    private ArrayList<CoffeMachine> _machines = null;
    private ArrayList<ProductsVO> _multipleProducts = null;
    private MachineService _service = null;
    private ProductsVO _singleProduct = null;

    public static void main(String[] args) {

        Main facade = new Main();
        facade.run();

    }

    public void run() {
        _multipleProducts = new ArrayList<ProductsVO>();
        _service = new MachineService();
        _singleProduct = new ProductsVO(1000, 1000, 1000);
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu();
            int pasirinkimas = sc.nextInt();
            switch (pasirinkimas) {
                case 0:
                    System.out.println("Sayonara");
                    return;
                case 1:
                    System.out.println("Iveskite kiek aparatu sukurti");
                    int n = sc.nextInt();
                    _machines = _service.createMachines(n);
                    break;
                case 2:
                    _service.assignMultipleProducts(_machines, _multipleProducts);

                    break;
                case 3:
                    _service.assignSingleProduct(_machines, _singleProduct);
                    break;
                case 4:
                    _service.washMashines(_machines);
                    break;
                case 5:
                    _service.dumpMachineProducts(_machines);
                    break;
                case 6:
                    System.out.println("Iveskite aparato numeri nuo 0 iki " + (_machines.size() - 1));
                    _currentMachine = sc.nextInt();
                    break;
                case 7:
                    _machines.get(_currentMachine).addProducts(new ProductsVO(10, 10, 10));
                    break;
                case 8:
                    _machines.get(_currentMachine).makeCoffe("latte");
                    break;
                case 9:
                    _machines.get(_currentMachine).makeCoffe("black");
                    break;
                case 10:
                    _machines.get(_currentMachine).makeCoffe("espresso");
                    break;
                case 11:
                    _machines.get(_currentMachine).showIsReady();
                    break;
                case 12:
                    _machines.get(_currentMachine).showStatus();
                    break;
            }

        }
    }

    public void showMenu() {
        System.out.println("Pasirinkite ka norite daryti");
        System.out.println("0 - baigti darba");
        System.out.println("1 - Sukurti N aparatu");
        System.out.println("2 - priskirti skirtingus produktus apratams");
        System.out.println("3 - priskirti bendra produkta apratams");
        System.out.println("4 - plauti visus aparatus");
        System.out.println("5 - ismesti produktus is visu aparatu");
        System.out.println("6 - pasirinkti aparata su kuriuo norite dirbti");
        System.out.println("7 - papildyti pasirinkta kavos aparata");
        System.out.println("8 - daryti Latte su pasirinktu aparatu");
        System.out.println("9 - daryti Juoda kava su pasirinktu aparatu");
        System.out.println("10 - daryti espresso su pasirinktu aparatu");
        System.out.println("11 - parodyti ar pasirinktas aparatas yra pasiruoses");
        System.out.println("12 - parodyti pasirinkto aparato busena");


    }
}
