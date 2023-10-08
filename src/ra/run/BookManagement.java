package ra.run;

import ra.model.Catalog;
import ra.model.Product;
import ra.service.CatalogService;
import ra.service.ProductService;

import java.util.Scanner;

public class BookManagement {
    private static CatalogService catalogService = new CatalogService();
    private static ProductService productService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choise;
        do {
            System.out.println("**************************BASIC-MENU**************************");
            System.out.println("1. Quản lý danh mục ");
            System.out.println("2. Quản lý sản phẩm ");
            System.out.println("3. Thoát ");
            System.out.println("NHẬP VÀO LỰA CHỌN");
            choise = Integer.parseInt(scanner.nextLine());

            switch (choise) {
                case 1:
                    catalogManagement();
                    break;
                case 2:
                    productManagement();

                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không có");

            }

        } while (choise != 3);


    }

    private static void catalogManagement() {
        int choise;
        do {
            System.out.println("********************CATALOG-MANAGEMENT********************");
            System.out.println("1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục ");
            System.out.println("2. Hiển thị thông tin tất cả các danh mục");
            System.out.println("3. Sửa tên danh mục theo mã danh mục");
            System.out.println("4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm) ");
            System.out.println("5. Quay lại ");
            System.out.println("Nhập vào lựa chọn của bạn");
            choise = Integer.parseInt(scanner.nextLine());
            switch (choise) {
                case 1:
                    System.out.println("Nhập số lượng danh mục cần thêm");
                    int numCatalogs = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < numCatalogs; i++) {
                        System.out.println("Nhập vào tên danh mục");
                        String catalogName = scanner.nextLine();
                        Catalog catalog = new Catalog(i+1,catalogName);
                        catalogService.save(catalog);
                    }
                    System.out.println("Đã thêm thành công");
                    break;
                case 2:
                    System.out.println("Danh sách danh mục");
                    for (Catalog catalog: catalogService.getAll()) {
                        System.out.println(catalog);
                    }
                    break;
                case 3:
                    System.out.println("Nhập vào mã danh mục cần suwa");
                    int catalogIdEdit = Integer.parseInt(scanner.nextLine());
                    Catalog catalogEdit = catalogService.findById(catalogIdEdit);
                    if (catalogEdit != null){
                        System.out.println("Nhập tên mới");
                        String newCatalogName = scanner.nextLine();
                        catalogEdit.setCatalogName(newCatalogName);
                        System.out.println("ĐỔI tên thành công");

                    }else {
                        System.out.println("Không tìm thấy mã danh mục cần sửa");
                    }
                    break;
                case 4:
                    System.out.println("Nhập vào mã danh mục cần sóa");
                    int catalogIdDelete = Integer.parseInt(scanner.nextLine());
                    Catalog catalogDelete = catalogService.findById(catalogIdDelete);
                    if (catalogDelete != null){
                        if (checkCatalogUsed(catalogIdDelete)) {
                            System.out.println("Không thể sóa danh mục này");

                        } else {
                            catalogService.delete(catalogIdDelete);
                            System.out.println("Sóa thành công");
                        }
                    } else {
                        System.out.println("không tìm thấy danh mục muốn xóa");
                    }


                    break;
                case 5:
                    System.out.println("Quay lại BASIC-MENU.");
                    break;

            }
        } while (choise != 5);

    }

    private static boolean checkCatalogUsed(int catalogId) {
        for (Product product : productService.getAll()) {
            if(product.getCatalog().getCatalogId() == catalogId){
                return true;
            }
        }
        return false;
    }

    private static void productManagement() {
        int choise;
        do {
            System.out.println("********************PRODUCT-MANAGEMENT********************");
            System.out.println("1. Nhập số sản sản phẩm và nhập thông tin sản phẩm  ");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá giảm dần");
            System.out.println("4. Xóa sản phẩm theo mã ");
            System.out.println("5. Tìm kiếm sách theo tên sách ");
            System.out.println("6. Thay đổi thông tin của sách theo mã sách");
            System.out.println("7. Quay lại ");
            System.out.println("Nhập vào lựa chọn của bạn");
            choise = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
            switch (choise) {

                case 1:
                    System.out.println("Nhập số lượng sản phẩm cần thêm mới");
                    int numProducts = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < numProducts; i++) {
                        System.out.println("Nhập mã sản phẩm");
                        String productId = scanner.nextLine();
                        System.out.println("Nhập tên sản phẩm");
                        String productName = scanner.nextLine();
                        System.out.println("Nhập giá sản phẩm");
                        double productPrice = Double.parseDouble(scanner.nextLine());
                        System.out.println("Nhập miêu tả sản phẩm");
                        String description = scanner.nextLine();
                        System.out.println("Nhập số lượng sản phẩm còn trong kho");
                        int stock = scanner.nextInt();
                        System.out.println("Danh sách danh mục");
                        for (Catalog catalog:catalogService.getAll()) {
                            System.out.println("Mã danh mục: "+ catalog.getCatalogId() + "\nTên danh muc: " + catalog.getCatalogName() );
                        }
                        System.out.println("Nhập mã danh mục sản phẩm");
                        int catalogId = scanner.nextInt();
                        Catalog catalog = catalogService.findById(catalogId);
                        Product product = new Product(productId,productName,productPrice,description,stock,catalog);
                        productService.save(product);
                    }
                    System.out.println("Sản phẩm đã thêm thành công");
                    break;
                case 2:
                    System.out.println("Danh sách sản phẩm");
                    for (Product product: productService.getAll()) {
                        System.out.println(product);
                    }
                    break;
                case 3:
                    System.out.println("Sắp xếp sản phẩm theo giá giảm dần.");
                    productService.getAll().sort((p1, p2) -> Double.compare(p2.getProductPrice(), p1.getProductPrice()));
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    int productToDeleteId = Integer.parseInt(scanner.nextLine());
                    Product productTodelete = productService.findById(String.valueOf(productToDeleteId));
                    if (productTodelete != null){
                        productService.delete(String.valueOf(productToDeleteId));
                        System.out.println("Đã xóa thành công sản phẩm");
                    }else {
                        System.out.println("Không tìm thấy mã sản phẩm");
                    }
                    break;
                case 5:
                    System.out.println("nhập tên sản phẩm cần tìm");
                    String productNameToSeach = scanner.nextLine();
                    System.out.println("Danh sách sản phẩm có tên chứa \"" + productNameToSeach + "\":");
                    for (Product product: productService.getAll()) {
                       if (product.getProductName().contains(productNameToSeach)){
                           System.out.println(product);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Nhập mã sản phẩm cần sửa");
                    String productIdToEdit = scanner.nextLine();
                    Product productToEdit = productService.findById(productIdToEdit);
                    if (productToEdit != null){
                        System.out.println("nhập tên mới");
                        String productNewName = scanner.nextLine();
                        System.out.println("Nhập giá mới");
                        double productNewPrice = Double.parseDouble(scanner.nextLine());
                        System.out.println("Nhập vào mô tả mới");
                        String newDescription = scanner.nextLine();
                        productToEdit.setProductName(productNewName);
                        productToEdit.setProductPrice(productNewPrice);
                        productToEdit.setDescription(newDescription);
                        System.out.println("Đã sửa thành công sản phẩm");

                    }else {
                        System.out.println("Không tìm thấy mã sản phẩm");
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ,vui lòng chọn lại");

            }
        } while (choise != 7);
    }

}
