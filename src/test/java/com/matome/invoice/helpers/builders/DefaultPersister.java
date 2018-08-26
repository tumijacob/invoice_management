package com.matome.invoice.helpers.builders;

import javax.persistence.EntityManager;

public class DefaultPersister<T> extends AbstractEntityPersister<T> {

	  @Override
	  public T deepPersist(T entity, EntityManager entityManager) {
	    return persist(entity, entityManager);
	  }

	}