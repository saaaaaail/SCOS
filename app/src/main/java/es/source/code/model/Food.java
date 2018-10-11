package es.source.code.model;

/**
 * Created by sail on 2018/10/8.
 */

public class Food {
    // 菜名
    private String foodName;

    // 价格
    private int price;

    // 库存;
    private int store;

    //备注
    private String remark;

    //类别
    private int category;

    // 是否点单
    private boolean order;

    // 图片资源ID;
    private int imgId;


    public Food(String foodName, int price, int store, String remark, int category, boolean order, int imgId) {
        this.foodName = foodName;
        this.price = price;
        this.store = store;
        this.remark = remark;
        this.category = category;

        this.order = order;
        this.imgId = imgId;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
