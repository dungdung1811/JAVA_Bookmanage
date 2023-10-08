package ra.model;

public class Catalog {
//    Attribute
    private int catalogId;
    private String catalogName;

//    Contructor

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
    }
//    Methothod

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                '}';
    }
}
