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
		ProductDTO temp=dao.productSearch(dto.getProductId());
		if(temp==null)
			result=-1;
		else {
			if(dto.getImageName()==null) {
				dto.setImageName(temp.getImageName());
			}
			result= dao.productUpdate(dto);
		}
		return result;
	}
	
	public int deleteProduct(String id) {
		ProductDAO dao=new ProductDAO();
		return dao.productDelete(id);
		
	}
}
