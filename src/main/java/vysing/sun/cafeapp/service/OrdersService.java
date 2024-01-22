package vysing.sun.cafeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vysing.sun.cafeapp.exception.DrinkNotFoundException;
import vysing.sun.cafeapp.model.Orders;
import vysing.sun.cafeapp.repo.OrdersRepo;

@Service
public class OrdersService {
    private final OrdersRepo ordersRepo;

    @Autowired
    public OrdersService(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public Orders addOrders(Orders orders){
        return ordersRepo.save(orders);
    }

    public List<Orders> findAllOrders(){
        return ordersRepo.findAll();  
    }
    
    public Orders updateOrders(Orders orders){
        return ordersRepo.save(orders);
    }

    public Orders finOrdersById(Long id){
        return ordersRepo.findOrdersById(id).orElseThrow(() -> new DrinkNotFoundException("Drink by id " + id + " was not found."));
    }

    public void deleteOrdersById(Long id){
        ordersRepo.deleteOrdersById(id);
    }

    public void deleteAllOrder(){
        ordersRepo.deleteAll();
    }
}
