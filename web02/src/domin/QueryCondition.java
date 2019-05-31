package domin;

public class QueryCondition {
    private String  keyWord;   // 关键字 , 模糊查询
    private String  min_price;  // 最低价格
    private String  max_price;  // 最高价格
    private String  is_hot;     // 是否热卖

    public QueryCondition() {
    }

    public QueryCondition(String keyWord, String min_price, String max_price, String is_hot) {
        this.keyWord = keyWord;
        this.min_price = min_price;
        this.max_price = max_price;
        this.is_hot = is_hot;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    @Override
    public String toString() {
        return "QueryCondition{" +
                "keyWord='" + keyWord + '\'' +
                ", min_price='" + min_price + '\'' +
                ", max_price='" + max_price + '\'' +
                ", is_hot='" + is_hot + '\'' +
                '}';
    }
}
