package ir.maktabsharif.repository.product;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class productRepositoryImpl extends BaseRepositoryImpl<Product,Long> implements productRepository {

    public productRepositoryImpl() {
        super(Product.class);
    }
}
