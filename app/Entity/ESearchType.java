package Entity;

/**
 * Created by jacky on 31/10/2017.
 */
public enum ESearchType {
    PRODUCT_NAME(0), COMPANY_NAME(1), TAG_NAME(2), SELLER_ID(3);
    private int value;

    private ESearchType(int value) {
        this.value = value;
    }

    ESearchType(String stringValue) {
        if (stringValue.equals("PRODUCT_NAME")) {
            this.value = 0;
        }
        if (stringValue.equals("COMPANY_NAME")) {
            this.value = 1;
        }
        if (stringValue.equals("TAG_NAME")) {
            this.value = 2;
        }
        if (stringValue.equals("SELLER_ID")) {
            this.value = 3;
        }
    }

    public int getValue() {
        return value;
    }
}


