package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addPartner(String partnerId) {
        orderRepository.addPartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId,partnerId);
    }

    public Order getOrderById(String orderId) {
       Order order = orderRepository.getOrderById(orderId);
       return order;
    }

    public DeliveryPartner getPartnerById(String partnerId) {
       DeliveryPartner partner= orderRepository.getPartnerById(partnerId);
        return partner;
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
       int ordercount = orderRepository.getOrderCountByPartnerId(partnerId);
        return ordercount;
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
       List<String>list = orderRepository.getOrdersByPartnerId(partnerId);
        return list;
    }

    public List<String> getAllOrders() {
      List<String>list = orderRepository.getAllOrders();
        return list;
    }

    public Integer getCountOfUnassignedOrders() {
        int count = (int) orderRepository.getCountOfUnassignedOrders();
        return count;
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        String[]arr = time.split(":");
        int hh = Integer.parseInt(arr[0]);
        int mm = Integer.parseInt(arr[1]);

        int timint = (hh*60) + mm;

        Integer timeint = (hh*60) + mm;
        int count = orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(timeint,partnerId);
        return count;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        int timeInt = orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
        int hh = timeInt/60;
        int mm = timeInt%60;
        String HH = String.valueOf(hh);
        if(HH.length()==1){
            HH = '0' + HH;
        }
        String MM = String.valueOf(mm);
        if(MM.length()==1){
            MM = '0'+MM;
        }

        String time = HH + ":" + MM;
        return time;
    }

    public void deletePartnerById(String partnerId) {
        orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderRepository.deleteOrderById(orderId);
    }
}
