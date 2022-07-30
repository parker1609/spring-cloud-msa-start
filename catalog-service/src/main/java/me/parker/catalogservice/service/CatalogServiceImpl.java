package me.parker.catalogservice.service;

import lombok.extern.slf4j.Slf4j;
import me.parker.catalogservice.jpa.CatalogEntity;
import me.parker.catalogservice.jpa.CatalogRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
