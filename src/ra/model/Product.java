package ra.model;

public class Product {
//    Attribute;
    private String productId;
    private String productName;
    private double productPrice;
    private String description;


    private int stock;
    private Catalog catalog;
    private boolean status;
//    Contructor;

    public Product() {
    }

    public Product(String productId, String productName, double productPrice, String description, int stock, Catalog catalog) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }
    //   Method:

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        String statusStr = status ? "Bán" : "Không bán";
        return "Product ID: " + productId + ", Product Name: " + productName + ", Product Price: " + productPrice
                + ", Description: " + description + ", Stock: " + stock + ", Catalog: " + catalog.getCatalogName()
                + ", Status: " + statusStr;
    }
}
