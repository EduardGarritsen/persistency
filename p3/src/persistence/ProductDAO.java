package persistence;

import domain.Product;

public interface ProductDAO {
	public Product findById(long id);
}
