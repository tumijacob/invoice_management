package com.matome.invoice.helpers.builders;

import javax.persistence.EntityManager;


public abstract class AbstractEntityBuilder<T> extends AbstractBuilder<T> {

	  public AbstractEntityPersister<T> getPersister() {
	    return new DefaultPersister<>();
	  }

	  public T buildAndPersist(EntityManager entityManager) {
	    T entity = build();
	    return getPersister().deepPersist(entity, entityManager);
	  }

	}
