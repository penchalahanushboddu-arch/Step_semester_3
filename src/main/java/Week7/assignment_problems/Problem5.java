class Cart {
    private Double[] prices;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new Double[maxItems];
    }

    public void addItem(double price) {

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] == null) {
                prices[i] = price;
                return;
            }
        }

        System.out.println("Cart is full");
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] != null) {
                total += prices[i];
            }
        }

        return total;
    }

    public int getItemCount() {
        int count = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] != null) {
                count++;
            }
        }

        return count;
    }
}

public class Problem5 {
    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}