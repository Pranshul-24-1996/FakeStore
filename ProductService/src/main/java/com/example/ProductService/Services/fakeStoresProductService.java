package com.example.ProductService.Services;

import com.example.ProductService.Models.Product;
import com.example.ProductService.dtos.FakeStoreProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStore")
public class fakeStoresProductService implements ProductService{

    @Override
    public Product getProductById(long productId) {
        /*
        Take product Id from the user and call the below endpoint
         https://fakestoreapi.com/products/ + id
         */
        String url =  "https://fakestoreapi.com/products/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(url, FakeStoreProductDto.class);

        assert fakeStoreProductDto != null;
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String name, String description, String category, Double price) {
        return null;
    }

    @Override
    public String updateProductById(Long productId, Product updatedProductDetails) {
        return "";
    }

    @Override
    public String deleteProductById(long productId) {
        return "";
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setProductId(dto.getId());
        product.setName(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setImage(dto.getImage());
        return product;
    }
}
