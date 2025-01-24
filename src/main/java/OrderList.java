import java.util.Scanner;

/**
 * Keeps track of all ordered Products.
 *
 * @author Christopher Karow
 */
public class OrderList {

    private Scanner scanner = new Scanner(System.in);

    private Product[] products = new Product[5];
    private int index = 0;

    public static void main(String[] args) {
        new OrderList().menuLoop();
    }

    public void menuLoop() {
        int selection;

        do {
            printDialog();
            selection = scanner.nextInt();
            switch (selection) {
                case 0:
                    break;
                case 1:
                    orderMaterial(this.index++);
                    break;
                case 2:
                    orderService(this.index++);
                    break;
                default:
                    System.out.println("ungültig");
                    break;
            }
        } while (selection != 0 && this.index < products.length);

        sortOrderList();
        printOrderList();
    }

    private void printDialog() {
        System.out.println("(0) Bestellung beenden\n" +
                "(1) Material bestellen\n" +
                "(2) Dienstleistung bestellen");
    }

    private void printOrderList() {
        int sum = 0;
        for (int i = 0; i < this.index; i++) {
            this.products[i].print();
            sum += this.products[i].getPrice();
        }

        System.out.println(String.format("Gesamtsumme: %01d,%02d€", sum / 100, sum % 100));
    }

    private void sortOrderList() {
        for (int i = 0; i < this.products.length - 1; i++) {
            for (int j = 0; j < this.products.length - 1; j++) {

                if (this.products[j + 1] != null &&
                        this.products[j + 1].getPrice() < this.products[j].getPrice()) {
                    Product temp = this.products[j + 1];
                    this.products[j + 1] = this.products[j];
                    this.products[j] = temp;
                }
            }
        }
    }

    private void orderService(int index) {
        System.out.println("Leistungsart?");
        this.scanner.nextLine(); // Needed to prevent the scanner from skipping the line
        String name = this.scanner.nextLine();

        System.out.println("Personenzahl?");
        int employees = this.scanner.nextInt();

        System.out.println("Stunden?");
        int hours = this.scanner.nextInt();

        this.products[index] = new Service(name, hours, employees);
    }

    private void orderMaterial(int index) {
        System.out.println("Materialname?");
        this.scanner.nextLine(); // Needed to prevent the scanner from skipping the line
        String name = this.scanner.nextLine();

        System.out.println("Stückpreis in Cent?");
        int pricePerUnit = this.scanner.nextInt();

        System.out.println("Stückzahl?");
        int amount = this.scanner.nextInt();

        this.products[index] = new Material(name, pricePerUnit, amount);
    }

}
