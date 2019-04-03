package service;

import dao.ProductDAO;
import dto.ProductDTO;

public class ManagementService {
	public int addProduct(ProductDTO dto) {
		ProductDAO dao=new ProductDAO();
		if(dao.productSearch(dto.getProductId())==null)
			return dao.productInsert(dto);
		else {
			return -1;
		}
	}
	
	public int updateProduct(ProductDTO dto) {
		ProductDAO dao=new ProductDAO();
		int result=0;
		if(dao.productSearch(dto.getProductId())==null)
			result=-1;
		else {
			result= dao.productUpdate(dto);
		}
		return result;
	}
	
	public int deleteProduct(String id) {
		ProductDAO dao=new ProductDAO();
		return dao.productDelete(id);
		
	}
}
