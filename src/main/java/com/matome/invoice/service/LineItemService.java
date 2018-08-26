package com.matome.invoice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.invoice.model.LineItem;
import com.matome.invoice.repository.LineItemRepository;

@Service
public class LineItemService {
	
	@Autowired
	private LineItemRepository lineItemRepository;
	
	public void addLineItem(LineItem lineItem) {
		lineItemRepository.save(lineItem);
		
	}
	
	public List<LineItem> viewLineItems() {
		List<LineItem> lineItems = new ArrayList<>();
		lineItemRepository.findAll()
		    .forEach(lineItems::add);
		return lineItems;
		
	}

}
