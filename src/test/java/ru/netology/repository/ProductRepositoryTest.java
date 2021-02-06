package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Exception.NoFoundException;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.menedger.ProductMenedger;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Smartphone first = new Smartphone(1,"Smartphone1", 5000, "Manf1");
    Smartphone second = new Smartphone(2, "Smartphone2", 1000, "Manf2");
    Smartphone third = new Smartphone(3, "Smartphone3", 500, "Manf3");
    Book forth = new Book(4, "Ono", 100, "Auth1");
    Book fifth = new Book(5, "Love", 100, "Auth2");
    Book sixth = new Book(6, "Family", 50, "Auth3");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    void shouldRemoveByIdIfExists() {
        int idToRemove = 4;
        repository.removeById (idToRemove);
        Product[] expected = new Product[]{first, second, third, fifth, sixth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldWhenTryToRemoveMissingElement() {
        int idToRemove = 17;
        Exception e = assertThrows(NoFoundException.class, () -> repository.removeById(idToRemove));
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}