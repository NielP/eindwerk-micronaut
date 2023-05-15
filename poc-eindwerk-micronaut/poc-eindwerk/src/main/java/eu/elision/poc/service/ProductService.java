package eu.elision.poc.service;

import eu.elision.poc.domain.Product;
import eu.elision.poc.dto.ProductDTO;
import eu.elision.poc.repository.ProductRepository;
import jakarta.inject.Singleton;
import org.bson.types.ObjectId;

import java.util.List;

@Singleton
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findAll() {
        List<Product> temp = (List<Product>) productRepository.findAll();
        return temp.stream().map(eu.elision.poc.domain.Product::toProductDTO).toList();
    }


    public ProductDTO findById(ObjectId id) {
        return productRepository.findById(id)
                .map(eu.elision.poc.domain.Product::toProductDTO)
                .orElseThrow();
    }

    public ProductDTO create(ProductDTO productDTO) {
        return productRepository.save(eu.elision.poc.domain.Product.fromProductDTO(productDTO))
                .toProductDTO();
    }

    public void delete(ObjectId id) {
        productRepository.deleteById(id);
    }
}
