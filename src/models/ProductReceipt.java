package models;

public class ProductReceipt {
    private Long id;
    private Product product;
    private Receipt receipt;

    public ProductReceipt() {
    }

    public ProductReceipt(Long id, Product product, Receipt receipt) {
        this.id = id;
        this.product = product;
        this.receipt = receipt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "ProductReceipt{" +
                "id=" + id +
                ", product=" + product +
                ", receipt=" + receipt +
                '}';
    }
}
