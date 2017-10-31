package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by jacky on 31/10/2017.
 */
public class ResaultSearch {
    private HashMap<Integer, String> byProductName;
    private HashMap<Integer, String> companyName;
    private HashMap<Integer, String> tags;
    private HashMap<Integer, String> sellerId;

    public ResaultSearch() {
        byProductName = new HashMap<>();
        companyName = new HashMap<>();
        tags = new HashMap<>();
        sellerId = new HashMap<>();
    }

    public HashMap<Integer, String> getByProductName() {
        return byProductName;
    }

    public void setByProductName(LinkedHashMap<Integer, String> byProductName) {
        this.byProductName = byProductName;
    }

    public HashMap<Integer, String> getCompanyName() {
        return companyName;
    }

    public void setCompanyName(LinkedHashMap<Integer, String> companyName) {
        this.companyName = companyName;
    }

    public HashMap<Integer, String> getTags() {
        return tags;
    }

    public void setTags(LinkedHashMap<Integer, String> tags) {
        this.tags = tags;
    }

    public HashMap<Integer, String> getSellerId() {
        return sellerId;
    }

    public void setSellerId(LinkedHashMap<Integer, String> sellerId) {
        this.sellerId = sellerId;
    }

    public void addToToProductName(int nProductId, String szProductName) {
        byProductName.put(nProductId, szProductName);
    }

    public void addToCompamyName(int nProductId, String szCompanyName) {
        companyName.put(nProductId, szCompanyName);
    }

    public void addToTags(int nProductId, String szCompanyName) {
        tags.put(nProductId, szCompanyName);
    }

    public void addToSeller(int nProductId, String szCompanyName) {
        sellerId.put(nProductId,szCompanyName);
    }


    public static void printMap(HashMap mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
}
