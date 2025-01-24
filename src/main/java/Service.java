/**
 * A service carried out by one or more employees.
 *
 * @author Christopher Karow
 */
public class Service extends Product {

    private int hours;
    private int employees;

    private static int pricePerHourInEuroCent = 1242;

    public Service(String name, int hours, int employees) {
        super(name);
        this.hours = hours;
        this.employees = employees;
    }

    @Override
    public int getPrice() {
        return pricePerHourInEuroCent * this.hours * this.employees;
    }

    @Override
    public void print() {
        System.out.println(
                String.format("%s Personen für %sh %s = %01d,%02d€",
                        this.employees,
                        this.hours,
                        this.getName(),
                        this.getPrice() / 100,
                        this.getPrice() % 100));
    }
}
