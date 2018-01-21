package com.springframework5.example.spring5webapp.repositories;

import com.springframework5.example.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
