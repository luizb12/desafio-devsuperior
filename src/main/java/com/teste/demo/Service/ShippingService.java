package com.teste.demo.Service;

import com.teste.demo.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {



    public Double shipment (Order order) {
        double basic = order.getBasic();
        if(basic < 100){
            return 20.0;
        } else if (basic >= 100 && basic <= 200){
            return 12.0;
        } else {
            return 0.0;
        }

    }

}
