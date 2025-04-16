package com.exp2_s6_briam_carrasco.gestionfacturasbd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp2_s6_briam_carrasco.gestionfacturasbd.model.Item;
import com.exp2_s6_briam_carrasco.gestionfacturasbd.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        if (itemRepository.existsById(id)) {
            item.setIdItem(id);
            return itemRepository.save(item);
        } else {
            return null; 
        }
    }
    
}
