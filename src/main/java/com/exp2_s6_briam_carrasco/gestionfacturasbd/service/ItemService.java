package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Item;

public interface ItemService {
    
    List<Item> getAllItems();
    Optional<Item> getItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    
}
