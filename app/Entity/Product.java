package Entity;


import java.util.Arrays;
import java.util.List;

/**
 * Created by jacky on 29/09/2017.
 */
public class Product {
    int ProductId = -1;
    int SellerId = -1;
    String CompanyName;
    String ProductName;
    Float MinPrice;
    Float MaxPrice;
    String tags[];

    public Product() {
    }

    public Product(int productId, int sellerId, String companyName, String productName, Float minPrice, Float maxPrice, String[] tags) {
        ProductId = productId;
        SellerId = sellerId;
        CompanyName = companyName;
        ProductName = productName;
        MinPrice = minPrice;
        MaxPrice = maxPrice;
        this.tags = tags;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getSellerId() {
        return SellerId;
    }

    public void setSellerId(int sellerId) {
        SellerId = sellerId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Float getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(Float minPrice) {
        MinPrice = minPrice;
    }

    public Float getMaxPrice() {
        return MaxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        MaxPrice = maxPrice;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public static String[] setTagsToArray(String tagsBeforeConvertion) {
        String[] stringsTagBefor = tagsBeforeConvertion.split("}\\{");
        String[] tagsArrayToReturn = new String[stringsTagBefor.length];
        int nCounter = 0;
        for (String currTag : stringsTagBefor) {
            if (currTag.contains("{")) {
                tagsArrayToReturn[nCounter] = currTag.replace("{", "");
            } else if (currTag.contains("}")) {
                tagsArrayToReturn[nCounter] = currTag.replace("}", "");
            } else {
                tagsArrayToReturn[nCounter] = currTag;
            }
            System.out.println(tagsArrayToReturn[nCounter]);
            nCounter++;
        }
        return tagsArrayToReturn;
    }
}
