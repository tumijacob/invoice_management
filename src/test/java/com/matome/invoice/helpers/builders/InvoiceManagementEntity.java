package com.matome.invoice.helpers.builders;

import java.io.Serializable;
import java.util.Objects;

/**
 * Abstract generic base class for all entities. Entities are model objects that are persisted to
 * the data store. This class allows implementations to specify the type of the identifier e.g. Long
 * or UUID
 */
@SuppressWarnings("serial")
public abstract class InvoiceManagementEntity<T> implements Serializable {

  public abstract T getId();

  public abstract void setId(T id);

  @Override
  public String toString() {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (!(obj.getClass().equals(getClass()))) {
      // This entity has a different type
      return false;
    }

    if (getId() == null) {
      // This entity has not been persisted
      return super.equals(obj);
    }

    // note the check for different class type above, therefore the warning of class casting can be
    // ignored.
    @SuppressWarnings("unchecked")
    InvoiceManagementEntity<T> other = (InvoiceManagementEntity<T>) obj;

    return getId().equals(other.getId());
  }

  @Override
  public int hashCode() {
    if (getId() == null) {
      // This entity has not been persisted
      return super.hashCode();
    }
    return Objects.hashCode(getId());
  }
}
