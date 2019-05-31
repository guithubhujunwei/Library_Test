package domin;

import java.util.List;

public class PageBean {
    private  String  everyNum = "12";  // 规定 是 每页 12个 .
    private  String currentPage ;  // 当前页
    private  int totalCount;       // 商品的总数量 .   47条
    private  int totalPage ;       // 总页数   通过 totalCount /  everyNum -->向上取整 计算.  47/12 --> 4
    private List<Product> productList;

    public PageBean() {
    }

    public PageBean(String everyNum, String currentPage, int totalCount, int totalPage, List<Product> productList) {
        this.everyNum = everyNum;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.productList = productList;
    }

    public String getEveryNum() {
        return everyNum;
    }

    public void setEveryNum(String everyNum) {
        this.everyNum = everyNum;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "everyNum='" + everyNum + '\'' +
                ", currentPage='" + currentPage + '\'' +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", productList=" + productList +
                '}';
    }
}
