package entity;

import model.ItemDetail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "order")
public class Order {

    @Id
    private String orderId;
    private String orderDate;
    private String orderTime;
    private String cusId;
    private String employId;
    private Double totalCost;


    @OneToMany(mappedBy = "order")
    private List<OrderDetail>  itemList = new ArrayList<>();


    public Order() {
    }

    public Order(String orderId, String orderDate, String orderTime,
                 String cusId, String employId, Double totalCost, List<OrderDetail> itemList) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.cusId = cusId;
        this.employId = employId;
        this.totalCost = totalCost;
        this.itemList = itemList;
    }


    public List<OrderDetail> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderDetail> itemList) {
        this.itemList = itemList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }



    //  private ArrayList<ItemDetail> items;




}
