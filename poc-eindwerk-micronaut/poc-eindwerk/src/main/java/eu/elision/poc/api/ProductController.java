package eu.elision.poc.api;

import eu.elision.poc.dto.ProductDTO;
import eu.elision.poc.service.ProductService;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;

@Controller("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get
    public List<ProductDTO> listProducts() {
        return productService.findAll();
    }

    @Get("/{id}")
    public ProductDTO getProduct(@PathVariable("id") ObjectId id) {
        return productService.findById(id);
    }

    @Post
    public ProductDTO createProduct(@Body ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @Delete("/{id}")
    public void deleteProduct(@PathVariable("id") ObjectId id) {
        productService.delete(id);
    }
}