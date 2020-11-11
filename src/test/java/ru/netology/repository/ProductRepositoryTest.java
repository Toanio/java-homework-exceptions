package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book(1,"Книга",100,"Автор",1000,2020);

  @Test
  void shouldDeleteIfExist() {
    repository.save(coreJava);
    int idToRemove = 1;
    repository.removeById(idToRemove);
    Product[] expected = new Product[]{};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }
  @Test
  void shouldThrowException() {
    repository.save(coreJava);
    int idToRemove = 4;
    assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
  }
}
