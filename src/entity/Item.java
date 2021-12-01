package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "item")
public class Item {
    @Id
    private String  itemCode;
    private String Description;
    private String PackSize;
    private double buyingPrice;
    private double unitPrice;
    private String ItemDiscount;
    private int qtyOnHand;


    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderList = new ArrayList<>();



    public Item() {
    }

    public Item(String itemCode, String description,
                String packSize, double buyingPrice, double unitPrice, String itemDiscount, int qtyOnHand) {
        this.itemCode = itemCode;
        Description = description;
        PackSize = packSize;
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
        ItemDiscount = itemDiscount;
        this.qtyOnHand = qtyOnHand;
    }

    public Item(String itemCode, String description, String packSize, double buyingPrice,
                double unitPrice, String itemDiscount, int qtyOnHand, List<OrderDetail> orderList) {
        this.itemCode = itemCode;
        Description = description;
        PackSize = packSize;
        this.buyingPrice = buyingPrice;
        this.unitPrice = unitPrice;
        ItemDiscount = itemDiscount;
        this.qtyOnHand = qtyOnHand;
        this.orderList = orderList;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPackSize() {
        return PackSize;
    }

    public void setPackSize(String packSize) {
        PackSize = packSize;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getItemDiscount() {
        return ItemDiscount;
    }

    public void setItemDiscount(String itemDiscount) {
        ItemDiscount = itemDiscount;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public List<OrderDetail> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDetail> orderList) {
        this.orderList = orderList;
    }
}
