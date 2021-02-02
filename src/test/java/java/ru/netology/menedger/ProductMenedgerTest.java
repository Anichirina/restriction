package java.ru.netology.menedger;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.menedger.ProductMenedger;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductMenedgerTest {
    private Product[] products;
    private ProductRepository repository = new ProductRepository();
    private ProductMenedger productManager = new ProductMenedger(repository);

    @Test
    public void shouldFindByNameSmartphone() {
        products = new Product[4];
        products[0] = new Book(1, "bookName1", 50, "author1");
        products[1] = new Smartphone(2, "smartName1", 500, "man1");
        products[2] = new Smartphone(3, "smartName2", 1000, "man2");
        products[3] = new Book(4, "bookName2", 100, "author2");

        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("smartName1");
        Product[] expected = {products[1]};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindBookByAuthor() {
        products = new Product[4];
        products[0] = new Book(1, "bookName1", 50, "author1");
        products[1] = new Smartphone(2, "smartName1", 500, "man1");
        products[2] = new Smartphone(3, "smartName2", 1000, "man2");
        products[3] = new Book(4, "bookName2", 100, "author2");


        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("author1");
        Product[] expected = {products[0]};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindBookByName() {
        products = new Product[4];
        products[0] = new Book(1, "bookName1", 50, "author1");
        products[1] = new Smartphone(2, "smartName1", 500, "man1");
        products[2] = new Smartphone(3, "smartName2", 1000, "man2");
        products[3] = new Book(4, "bookName2", 100, "author2");
        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("bookName2");
        Product[] expected = {products[3]};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindSmartphoneByManucfature() {
        products = new Product[4];
        products[0] = new Book(1, "bookName1", 50, "author1");
        products[1] = new Smartphone(2, "smartName1", 500, "man1");
        products[2] = new Smartphone(3, "smartName2", 1000, "man2");
        products[3] = new Book(4, "bookName2", 100, "author2");
        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("man2");
        Product[] expected = {products[2]};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchNotExists() {
        products = new Product[2];
        products[0] = new Book(1, "bookName1", 50, "author1");
        products[1] = new Smartphone(2, "smartName1", 500, "man1");
        for (int i = 0; i < 2; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("booloName1");
        Product[] expected = new Product[0];

        assertArrayEquals(actual, expected);
    }

}