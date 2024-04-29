package tech.ada.basket.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.basket.ecommerce.dto.BasketItemRequest;
import tech.ada.basket.ecommerce.formatter.BasketFormatter;
import tech.ada.basket.ecommerce.model.Basket;
import tech.ada.basket.ecommerce.model.BasketItem;
import tech.ada.basket.ecommerce.model.BasketStatus;
import tech.ada.basket.ecommerce.repository.BasketRepository;
import org.modelmapper.ModelMapper;

import java.util.Optional;


@Service
public class BasketServiceImpl implements BasketService {


    private final BasketRepository basketRepository;
    private final ModelMapper modelMapper;
    private final BasketFormatter<String> basketFormatter;

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository, ModelMapper modelMapper, BasketFormatter<String> basketFormatter) {
        this.basketRepository = basketRepository;
        this.modelMapper = modelMapper;
        this.basketFormatter = basketFormatter;
    }


    public Basket createBasket(Basket basket) {
        basket.setStatus(BasketStatus.STARTED);
        return basketRepository.save(basket);
    }
    @Override
    public void addItemToBasket(BasketItemRequest basketItemRequest) {
        BasketItem basketItem = modelMapper.map(basketItemRequest, BasketItem.class);
        Basket basket = basketRepository.findById(basketItemRequest.getBasketId())
                .orElseThrow(() -> new IllegalArgumentException("Basket not found"));
        basket.addItem(basketItem);
        basketRepository.save(basket);
    }

    @Override
    public Optional<Basket> getBasketById(Long basketId) {
        return basketRepository.findById(basketId);
    }

    @Override
    public void closeBasket(Long basketId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new IllegalArgumentException("Basket not found"));
        basket.setStatus(BasketStatus.COMPLETED);
        basketRepository.save(basket);
    }


    public String formatBasket(Long basketId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new IllegalArgumentException("Basket not found"));
        return basketFormatter.formatBasket(basket);
    }
}
