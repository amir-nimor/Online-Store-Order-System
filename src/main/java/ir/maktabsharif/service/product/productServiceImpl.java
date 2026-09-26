package ir.maktabsharif.service.product;

import ir.maktabsharif.exception.ValidationException;
import ir.maktabsharif.model.Product;
import ir.maktabsharif.service.Base.BaseServiceImpl;

import ir.maktabsharif.repository.product.productRepository;

import java.math.BigDecimal;

public class productServiceImpl extends BaseServiceImpl<Product, Long, productRepository> implements productService {

    public productServiceImpl(productRepository repository) {
        super(repository);
    }

    @Override
    protected void validation(Product product) throws ValidationException {
        if (product.getQuantity() < 0) throw new ValidationException("your quantity is negative");
        if (product.getPrice().compareTo(BigDecimal.ZERO) > 0) throw new ValidationException("your price is negative");
        if (product.getName().isBlank()) throw new ValidationException("your name is empty");
    }
}
