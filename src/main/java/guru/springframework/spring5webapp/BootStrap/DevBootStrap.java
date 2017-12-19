package guru.springframework.spring5webapp.BootStrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Author vishakha = new Author("Vishakha", "Tiwari");
        Publisher publisher1 = new Publisher("abc","xyz");
        Book android = new Book("Android","11232",publisher1);
        vishakha.getBooks().add(android);
        android.getAuthors().add(vishakha);

        authorRepository.save(vishakha);
        publisherRepository.save(publisher1);
        bookRepository.save(android);


        Author nishant = new Author("nishant","sharma");
        Publisher publisher2 = new Publisher("lmn", "pql");
        Book java = new Book("java","12345", publisher2);
        nishant.getBooks().add(java);

        authorRepository.save(nishant);
        publisherRepository.save(publisher2);
        bookRepository.save(java);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
