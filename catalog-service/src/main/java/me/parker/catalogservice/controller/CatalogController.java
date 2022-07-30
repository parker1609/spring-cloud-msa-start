package me.parker.catalogservice.controller;

import me.parker.catalogservice.jpa.CatalogEntity;
import me.parker.catalogservice.service.CatalogService;
import me.parker.catalogservice.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
public class CatalogController {

    private final Environment env;
    private final CatalogService catalogService;

    public CatalogController(Environment env, CatalogService catalogService) {
        this.env = env;
        this.catalogService = catalogService;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Catalog Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getUsers() {
        Iterable<CatalogEntity> catalogList = catalogService.getAllCatalogs();

        List<ResponseCatalog> results = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        catalogList.forEach(v -> results.add(modelMapper.map(v, ResponseCatalog.class)));

        return ResponseEntity.ok(results);
    }
}
