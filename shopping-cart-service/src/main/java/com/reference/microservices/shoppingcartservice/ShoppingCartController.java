package com.reference.microservices.shoppingcartservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@RestController
public class ShoppingCartController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SolrSearchServiceProxy proxy;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	String name =null;
	
	@GetMapping("/shopping-cart-solr/productName/{productName}")
	public CatalogueBean retreiveProductDetailSolr(@PathVariable String productName) {
		CatalogueBean catalogueBean= new CatalogueBean();
		logger.info(" call made to solr --> ");
		catalogueBean =  proxy.retreiveProductDetailSolr(productName);
		logger.info(" reponse is {} --> ",catalogueBean);
	
		return catalogueBean;
		
	}
	

	
	@GetMapping("/shopping-cart-solr/createCart/productName/{productName}/customerID/{customerID}")
	public CatalogueBean createCart(@PathVariable String productName, @PathVariable int customerID) {
		CatalogueBean catalogueBean= new CatalogueBean();
		logger.info(" call made to solr for creation--> ");
		catalogueBean =  proxy.retreiveProductDetailSolr(productName);
		logger.info(" reponse is {} --> ",catalogueBean);
		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setProduct_Long(catalogueBean.getProductLongDescription());
		productDetail.setProduct_Short(catalogueBean.getProductShortDescription());
		
		logger.info(" created productDetail--> ");
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCustomer_id(customerID);
		orderDetail.setOrder_value(10000L);
		orderDetail.setProductDetail(productDetail);
		orderDetail.setQuantity(20);
		
		logger.info(" created orderDetail and inovke save method--> ");
		
		orderDetailRepository.save(orderDetail);
		
		logger.info(" after inovkinvoking  save method--> ");
		
		return catalogueBean;
		
	}
	
	@GetMapping("/shopping-cart-solr/getCartDetail/all")
	public List<OrderDetail> getCartDetails() {
		logger.info(" call made getCartDetails--> ");
		List<OrderDetail> orderdetailList = orderDetailRepository.findAll();
		logger.info(" after inovkinvoking  getCartDetails--> ");
		return orderdetailList;
		
	}
	
}
