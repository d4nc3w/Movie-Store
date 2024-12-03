package com.example.moviestoreapplication.service;

import com.example.moviestoreapplication.model.Movie;
import com.example.moviestoreapplication.model.MovieDTO;
import com.example.moviestoreapplication.model.Order;
import com.example.moviestoreapplication.model.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderDTOMapper {
    public OrderDTO map(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setMovie(order.getMovie());
        orderDTO.setUser(order.getUser());
        orderDTO.setOrderDate(order.getOrderDate());
        return orderDTO;
    }

    public Order map(OrderDTO orderDTO){
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setMovie(orderDTO.getMovie());
        order.setUser(orderDTO.getUser());
        order.setOrderDate(orderDTO.getOrderDate());
        return order;
    }
}
