package dev.andreia.vendas.entities.enums;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private Integer code;

    private OrderStatus(int code){
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus orderStatus : OrderStatus.values()){
            if(orderStatus.getCode() == code){
                return orderStatus;
            }
        }

        throw new IllegalArgumentException("INVALID CODE!");
    }

}
