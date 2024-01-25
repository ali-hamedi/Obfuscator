package ir.ac.kntu.Models;
import ir.ac.kntu.MyCipher;


public class Product {
    String typeOfProduct ;
    String productName ;
    String price ;
    String quantity ;
    String productionDate ;
    String expirationDate ;

    public Product(String typeOfProduct, String productName, int price, int quantity, String productionDate, String expirationDate) {
        this.typeOfProduct = MyCipher.getInstance().encode(typeOfProduct);
        this.productName = MyCipher.getInstance().encode(productName);
        this.price = MyCipher.getInstance().encode(price);
        this.quantity = MyCipher.getInstance().encode(quantity);
        this.productionDate = MyCipher.getInstance().encode(correctDateFormat(productionDate));
        this.expirationDate = MyCipher.getInstance().encode(correctDateFormat(expirationDate));
    }

    public String getTypeOfProduct() {
        return MyCipher.getInstance().decode(typeOfProduct);
    }

    public void setTypeOfProduct(String  typeOfProduct) {
        this.typeOfProduct = MyCipher.getInstance().encode(typeOfProduct);
    }

    public String getProductName() {
        return MyCipher.getInstance().decode(productName);
    }

    public void setProductName(String productName) {
        this.productName = MyCipher.getInstance().encode(productName);
    }

    public int getPrice() {
        return Integer.parseInt(MyCipher.getInstance().decode(price));
    }

    public void setPrice(int price) {
        this.price = MyCipher.getInstance().encode(price);
    }

    public int getQuantity() {
        return Integer.parseInt(MyCipher.getInstance().decode(quantity));
    }

    public void setQuantity(int quantity) {
        this.quantity = MyCipher.getInstance().encode(quantity);
    }

    public String getProductionDate() {
        return MyCipher.getInstance().decode(productionDate);
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = MyCipher.getInstance().encode(productionDate);
    }

    public String getExpirationDate() {
        return MyCipher.getInstance().decode(expirationDate);
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = MyCipher.getInstance().encode(expirationDate);
    }

    public void printOut() {
        Product product = this ;
        System.out.printf(MyCipher.getInstance().decode("952fc993cf768123781a1274f5aefe125875b65846898e8ef20ddaaaec1d665956ce06fc01b8570a8a842ef941280463ae64d5b8d2155fa7e32f8a6e0fc2732309067eb4b718ab13c2a5357408aa66843fc1a7182d")
                , product.getProductName() , product.getPrice() , product.getQuantity()
                , product.getProductionDate() , product.getExpirationDate()) ;
    }

    public String  correctDateFormat (String date){
        String dates[] = MyCipher.getInstance().encode(date.split(MyCipher.getInstance().decode("9d"))) ;
        if (MyCipher.getInstance().decode(dates)[Integer.parseInt(MyCipher.getInstance().decode("81"))].length()==Integer.parseInt(MyCipher.getInstance().decode("81"))) dates[1] = '0' + dates[1];
        if (MyCipher.getInstance().decode(dates)[Integer.parseInt(MyCipher.getInstance().decode("82"))].length()==Integer.parseInt(MyCipher.getInstance().decode("81"))) dates[2] = '0' + dates[2];
        return (MyCipher.getInstance().decode(dates)[Integer.parseInt(MyCipher.getInstance().decode("80"))] + MyCipher.getInstance().decode("9d") + MyCipher.getInstance().decode(dates)[Integer.parseInt(MyCipher.getInstance().decode("81"))] + MyCipher.getInstance().decode("9d") + MyCipher.getInstance().decode(dates)[Integer.parseInt(MyCipher.getInstance().decode("82"))]) ;
    }
}
