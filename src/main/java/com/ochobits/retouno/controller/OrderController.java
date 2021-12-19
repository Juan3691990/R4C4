
package com.ochobits.retouno.controller;

import com.ochobits.retouno.model.Order;
import com.ochobits.retouno.service.OrderService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpere
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
 
    @GetMapping("/all")
    public List <Order> listar(){
        return orderService.listar();
    }
 
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create (@RequestBody Order order){
    return orderService.create(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update (@RequestBody Order order){
        return orderService.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")int id){
        return orderService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Order getOrderById (@PathVariable("id")int id){
        Optional<Order> order = orderService.getOrder(id);
        
        if(order.isPresent())
            return order.get();
        
        return null;
    }
    
    @GetMapping("/zona/{zona}")
    public List<Order> getOrdersByZona (@PathVariable("zona")String zona){
        return orderService.getOrderByZona(zona);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> getOrdersBySalesman (@PathVariable("id")int id){
        return orderService.getOrderBySalesman(id);
    }
    
    @GetMapping("/date/{date}/{id}")
    public List<Order> getOrdersByDate (@PathVariable("date")String date, 
                                        @PathVariable("id")int id ){
        try{
            Date queryDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return orderService.getOrdersByDate(queryDate, id);
        }catch(Exception e){
            return null;
        } 
    }
    
    @GetMapping("/state/{state}/{id}")
    public List<Order> getOrdersByState (@PathVariable("state")String state, 
                                         @PathVariable("id")int id ){
            return orderService.getOrdersByState(state, id);        
    }
}
