package com.teste.demo.Service;

import com.teste.demo.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {this.shippingService = shippingService;}

    public Double total (Order order){
        double basic = order.getBasic();
        double discount = order.getDiscount();
        double shipping = shippingService.shipment(order);
        double discountedValue = basic - (basic * discount / 100.0);
        return discountedValue + shipping;
    }

    public String orderSummary(Order order){
        double total = total(order);
        return "Codigo do pedido:" + order.getCode()
                + "valor total: R$ " + String.format("%.2f", total);
        // ajuste forçado para atualização no GitHub


    }
}
