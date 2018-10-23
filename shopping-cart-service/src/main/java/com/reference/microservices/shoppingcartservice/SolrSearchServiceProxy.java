package com.reference.microservices.shoppingcartservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="solr-search-service", url="localhost:8300")
public interface SolrSearchServiceProxy {
	//@GetMapping("/shopping-cart-solr/productName/{productName}")
	@GetMapping("/product-detail-solr/productName/{productName}")
	public CatalogueBean retreiveProductDetailSolr(@PathVariable("productName") String productName);
}
