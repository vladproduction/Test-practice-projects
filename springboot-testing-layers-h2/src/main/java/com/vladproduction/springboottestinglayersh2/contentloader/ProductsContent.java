package com.vladproduction.springboottestinglayersh2.contentloader;

import com.vladproduction.springboottestinglayersh2.entity.Product;
import com.vladproduction.springboottestinglayersh2.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ProductsContent  implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger logger = LogManager.getLogger(ProductsContent.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("prod-1");
        product1.setDescription("descr-1");
        product1.setPrice(100.0);
        productRepository.save(product1);
        logger.info("prod-1 saved with id: " + product1.getId());

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("prod-2");
        product2.setDescription("descr-2");
        product2.setPrice(200.0);
        productRepository.save(product2);
        logger.info("prod-2 saved with id: " + product2.getId());

        Product product3 = new Product();
        product3.setId(3L);
        product3.setName("prod-3");
        product3.setDescription("descr-3");
        product3.setPrice(300.0);
        productRepository.save(product3);
        logger.info("prod-3 saved with id: " + product3.getId());

        Product product4 = new Product();
        product4.setId(4L);
        product4.setName("prod-4");
        product4.setDescription("descr-4");
        product4.setPrice(400.0);
        productRepository.save(product4);
        logger.info("prod-4 saved with id: " + product4.getId());

        Product product5 = new Product();
        product5.setId(5L);
        product5.setName("prod-5");
        product5.setDescription("descr-5");
        product5.setPrice(500.0);
        productRepository.save(product5);
        logger.info("prod-5 saved with id: " + product5.getId());

    }
}
