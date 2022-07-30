package me.parker.orderservice.service;

import me.parker.orderservice.dto.OrderDto;
import me.parker.orderservice.jpa.OrderEntity;
import me.parker.orderservice.jpa.OrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = mapper.map(orderDto, OrderEntity.class);

        orderRepository.save(orderEntity);

        return mapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        ModelMapper mapper = new ModelMapper();
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);

        return mapper.map(orderEntity, OrderDto.class);
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }
}
