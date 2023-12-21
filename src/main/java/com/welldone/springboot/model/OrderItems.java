package com.welldone.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.welldone.springboot.model.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_OrderItems")
public class OrderItems implements Serializable {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer qnt;
    private Double price;

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public OrderItems() {
    }

    public OrderItems(Order order, Product product, Integer qnt, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.qnt = qnt;
        this.price = price;
    }

    public Integer getQnt() {
        return qnt;
    }

    public void setQnt(Integer qnt) {
        this.qnt = qnt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItems that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
