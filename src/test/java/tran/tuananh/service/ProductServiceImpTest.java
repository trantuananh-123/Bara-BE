package tran.tuananh.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tran.tuananh.model.Product;
import tran.tuananh.repository.BrandRepository;
import tran.tuananh.repository.CatalogRepository;
import tran.tuananh.repository.ProductRepository;

import java.util.*;

public class ProductServiceImpTest {

    @InjectMocks
    ProductServiceImp productServiceImp;

    @Mock
    ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CatalogRepository catalogRepository;

    @Mock
    private BrandRepository brandRepository;

    @BeforeEach
    void setUp() {
        productServiceImp = new ProductServiceImp(productRepository, catalogRepository, brandRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProduct() {
        List<Product> productList = new ArrayList<>();
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        MatcherAssert.assertThat(productServiceImp.getAllProduct(), Matchers.isA(List.class));
    }

    @Test
    void addProduct() {
        Product product = new Product();
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        MatcherAssert.assertThat(productServiceImp.addProduct(product), Matchers.isA(Product.class));
    }

    @Test
    void getProductById() {
        Product product = new Product();
        product.setProductId(1);
        Optional<Product> optionalProduct = Optional.of(product);
        Mockito.when(productRepository.findById(1)).thenReturn(optionalProduct);
        MatcherAssert.assertThat(productServiceImp.getProductById(1), Matchers.isA(Product.class));
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        Product product1 = new Product();
        product.setProductId(1);
        Optional<Product> optionalProduct = Optional.of(product);
        Mockito.when(productRepository.findById(1)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(optionalProduct.get())).thenReturn(product1);
        MatcherAssert.assertThat(productServiceImp.updateProduct(1, product1), Matchers.isA(Product.class))
        ;
    }

    @Test
    void deleteProduct() {
        Product product = new Product();
        product.setProductId(1);
        Optional<Product> optionalProduct = Optional.of(product);
        Mockito.when(productRepository.findById(1)).thenReturn(optionalProduct);
        productServiceImp.deleteProduct(product.getProductId());
        Mockito.verify(productRepository, Mockito.times(1)).delete(product);

    }

    @Test
    void deleteAllProduct() {
        productServiceImp.deleteAllProduct();
        Mockito.verify(productRepository, Mockito.times(1)).deleteAll();
    }

    @Test
    void checkProductName() {
        Product product = new Product();
        product.setProductName("Hi");
        MatcherAssert.assertThat(productServiceImp.checkProductName(product.getProductName()),
                Matchers.isA(Boolean.class));
    }

    @Test
    void checkProductLength() {
        Product product = new Product();
        product.setProductName("Hi");
        MatcherAssert.assertThat(productServiceImp.checkProductLength(product.getProductName()),
                Matchers.isA(Boolean.class));
    }
}
