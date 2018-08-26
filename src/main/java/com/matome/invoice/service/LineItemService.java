package com.matome.invoice.service;

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

}
