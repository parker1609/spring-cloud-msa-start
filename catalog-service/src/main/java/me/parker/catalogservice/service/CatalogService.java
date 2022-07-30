package me.parker.catalogservice.service;

import me.parker.catalogservice.jpa.CatalogEntity;

public interface CatalogService {

    Iterable<CatalogEntity> getAllCatalogs();
}
