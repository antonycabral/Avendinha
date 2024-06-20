package com.avendinha.service;

import com.avendinha.model.Product;
import com.avendinha.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Obtém todos os produtos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtém um produto pelo ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Cria um novo produto
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Atualiza um produto existente
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        // Atualiza os detalhes do produto com os novos valores
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());

        return productRepository.save(product);
    }

    // Deleta um produto
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        // Deleta o produto do repositório
        productRepository.delete(product);
    }
}