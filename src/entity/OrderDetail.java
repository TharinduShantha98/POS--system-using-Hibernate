package entity;

import javax.persistence.*;

@Entity(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue
    private long orderDetailId;
    private  String orderId;
    private String itemCode;
    private int orderQty;
    private double itemDiscount;
    private double cost;
    private double itemProfit;


    @ManyToOne
    private Order order;

    @ManyToOne
    private  Item item;


    public OrderDetail() {
    }

    public OrderDetail(long orderDetailId, String orderId, String itemCode,
                       int orderQty, double itemDiscount, double cost, double itemProfit, Order order, Item item) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.orderQty = orderQty;
        this.itemDiscount = itemDiscount;
        this.cost = cost;
        this.itemProfit = itemProfit;
        this.order = order;
        this.item = item;
    }

    public OrderDetail(String orderId, String itemCode,
                       int orderQty, double itemDiscount, double cost, double itemProfit, Order order, Item item) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.orderQty = orderQty;
        this.itemDiscount = itemDiscount;
        this.cost = cost;
        this.itemProfit = itemProfit;
        this.order = order;
        this.item = item;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getItemProfit() {
        return itemProfit;
    }

    public void setItemProfit(double itemProfit) {
        this.itemProfit = itemProfit;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
