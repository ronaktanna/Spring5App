package com.springframework5.example.spring5webapp.bootstrap;

import com.springframework5.example.spring5webapp.model.Author;
import com.springframework5.example.spring5webapp.model.Book;
import com.springframework5.example.spring5webapp.model.Publisher;
import com.springframework5.example.spring5webapp.repositories.AuthorRepository;
import com.springframework5.example.spring5webapp.repositories.BookRepository;
import com.springframework5.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "XYZ Street");
        Book domainDrivenDesign = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(domainDrivenDesign);
        publisherRepository.save(harperCollins);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "ZYX Street");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(worx);


    }
}
