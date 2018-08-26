package com.matome.invoice.helpers.matchers;

import java.util.Objects;

import org.hamcrest.Description;

import com.matome.invoice.model.Invoice;

public class InvoiceMatcher extends AbstractTypeSafeMatcher<Invoice> {

	public InvoiceMatcher(Invoice expected) {
		super(expected);
	}

	@Override
	public void appendDescription(Description description, Invoice invoice) {
		description.appendText("An invoice with the following state:")
		        .appendText("\nId: ").appendValue(invoice.getId())
		        .appendText("\nClient: ").appendValue(invoice.getClient())
				.appendText("\nInvoice Date: ").appendValue(invoice.getInvoiceDate())
				.appendText("\nLine Items: ").appendValue(invoice.getLineItems())
	            .appendText("\nSub Total: ").appendValue(invoice.getSubtotal())
	            .appendText("\nVat Rate: ").appendValue(invoice.getVatRate())
	            .appendText("\nVat: ").appendValue(invoice.getVat())
	            .appendText("\nTotal: ").appendValue(invoice.getTotal());

	}

	@Override
	protected boolean matchesSafely(Invoice actual) {
		return Objects.equals(actual.getId(), expected.getId()) &&
			    Objects.equals(actual.getClient(), expected.getClient()) &&
			    Objects.equals(actual.getInvoiceDate(), expected.getInvoiceDate()) &&
			    Objects.equals(actual.getLineItems(), expected.getLineItems()) &&
			    Objects.equals(actual.getSubtotal(), expected.getSubtotal()) &&
			    Objects.equals(actual.getVatRate(), expected.getVatRate()) &&
			    Objects.equals(actual.getVat(), expected.getVat()) &&
			    Objects.equals(actual.getTotal(), expected.getTotal());
	}
	
	public static InvoiceMatcher hasSameStateAsInvoice(Invoice expected) {
	    return new InvoiceMatcher(expected);
	  }

}
