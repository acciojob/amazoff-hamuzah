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

    public int getOrdersLeftAfterGivenTimeByPartnerId(String deliveryTime, String partnerId) {
        String time[] = deliveryTime.split(":");
        int newTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(newTime,partnerId);
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        int time = orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
        String HH = String.valueOf(time/60);
        String MM = String.valueOf(time%60);

        if(HH.length()<2){
            HH="0"+HH;
        }
        if(MM.length()<2){
            MM ="0"+MM;
        }

        return HH+":"+MM;
    }

    public void deletePartnerById(String partnerId) {
        orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderRepository.deleteOrderById(orderId);
    }
}
