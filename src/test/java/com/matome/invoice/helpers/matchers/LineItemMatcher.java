package com.matome.invoice.helpers.matchers;

import java.util.Objects;

import org.hamcrest.Description;

import com.matome.invoice.model.LineItem;

public class LineItemMatcher extends AbstractTypeSafeMatcher<LineItem> {

	public LineItemMatcher(LineItem expected) {
		super(expected);
	}

	@Override
	public void appendDescription(Description description, LineItem lineItem) {
		description.appendText("An invoice with the following state:")
		        .appendText("\nId: ").appendValue(lineItem.getId())
		        .appendText("\nDescription: ").appendValue(lineItem.getDescription())
				.appendText("\nQuantity: ").appendValue(lineItem.getQuantity())
				.appendText("\nUnit Price: ").appendValue(lineItem.getUnitPrice())
	            .appendText("\nItem Total: ").appendValue(lineItem.getItemTotal());
	            
	}

	@Override
	protected boolean matchesSafely(LineItem actual) {
		return Objects.equals(actual.getId(), expected.getId()) &&
			    Objects.equals(actual.getDescription(), expected.getDescription()) &&
			    Objects.equals(actual.getQuantity(), expected.getQuantity()) &&
			    Objects.equals(actual.getUnitPrice(), expected.getUnitPrice()) &&
			    Objects.equals(actual.getItemTotal(), expected.getItemTotal());
	}
	
	public static LineItemMatcher hasSameStateAsLineItem(LineItem expected) {
	    return new LineItemMatcher(expected);
	  }

}

