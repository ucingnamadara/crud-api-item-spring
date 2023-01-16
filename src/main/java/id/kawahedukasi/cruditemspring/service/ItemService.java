package id.kawahedukasi.cruditemspring.service;

import id.kawahedukasi.cruditemspring.model.Item;
import id.kawahedukasi.cruditemspring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
public class ItemService {
    @Autowired//inject
    ItemRepository itemRepository;

    public Map<String, Object> create(Map<String, Object> request) throws Exception {
        String name = request.get("name").toString();
        Double price = Double.valueOf(request.get("price").toString());
        String type = request.get("type").toString();
        Long count = Long.valueOf(request.get("count").toString());
        String description = request.get("description").toString();

        if(name == null || price == null || type == null || count == null){
            throw new Exception("BAD_REQUEST");
        }
        Item item = persistItem(name, price, type, count, description);
        return Map.of("id", item.getId());
    }

    @Transactional
    public Item persistItem(String name, Double price, String type, Long count, String description){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setType(type);
        item.setCount(count);
        item.setDescription(description);

        itemRepository.save(item);
        return item;
    }
}
