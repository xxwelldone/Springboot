package com.welldone.springboot.model;

public enum OrderStatus {
    WAITING_PAYMENT (1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
    private Integer x;
    private OrderStatus(int code) {
        this.x=code;
    }

    public Integer getCode() {
        return x;
    }

    public static OrderStatus valueOf(Integer code){
        for(OrderStatus i: OrderStatus.values()){
            if(i.getCode()==code){
                return i;
            }
        }
        throw new IllegalArgumentException("There's no such code");
    }
}
