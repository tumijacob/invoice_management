package com.matome.invoice.helpers.builders;

import com.matome.invoice.model.LineItem;

public class LineItemBuilder extends AbstractEntityBuilder<LineItem> {

	private Long id;
	private long quantity;
	private String description;
	private double unitPrice;

	public LineItemBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public LineItemBuilder withQuantity(long quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public LineItemBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public LineItemBuilder withUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}

	@Override
	public LineItem build() {
		LineItem lineItem = new LineItem();
		lineItem.setId(id);
		lineItem.setDescription(description);
		lineItem.setQuantity(quantity);
		lineItem.setUnitPrice(unitPrice);
		
		return lineItem;
	}
	
	public static LineItemBuilder aLineItem() {
		return new LineItemBuilder();
		
	}

}
