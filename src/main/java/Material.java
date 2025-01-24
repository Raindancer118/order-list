/**
 * A material which may be ordered.
 *
 * @author Christopher Karow
 */
public class Material extends Product {

    private int pricePerUnit;
    private int amount;

    public Material(String name, int pricePerUnit, int amount) {
        super(name);
        this.pricePerUnit = pricePerUnit;
        this.amount = amount;
    }

    @Override
    public int getPrice() {
        return this.amount * this.pricePerUnit;
    }

    @Override
    public void print() {
        System.out.println(
                String.format("%s * %s = %01d,%02d€",
                        this.amount,
                        this.getName(),
                        this.getPrice() / 100,
                        this.getPrice() % 100));
    }
}
