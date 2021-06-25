package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    private Product first = new Product(1, "first", 10);
    private Product second = new Product(2, "second", 20);
    private Product third = new Product(3, "third", 30);

    @BeforeEach
    public void setUp(){
        repo.save(first);
        repo.save(second);
        repo.save(third);
    }

    @Test
    void shouldRemoveByIdWhenExist() {
        repo.removeById(2);

        Product[] expected = { first, third };
        Product[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdWhenNotExist(){

        assertThrows(NotFoundException.class, () -> repo.removeById(5));
    }
}