package id.kawahedukasi.cruditemspring.controller;

import id.kawahedukasi.cruditemspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody Map<String, Object> request) {
        Map<String, Object> result = new HashMap<>();
        try {
            Map<String, Object> data = itemService.create(request);
            result = new HashMap<>();
            result.put("data", data);
//            return new ResponseEntity<>(request, HttpStatus.OK);
            return ResponseEntity.ok(request);
        } catch (Exception e) {
            result = new HashMap<>();
            result.put("message", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
