/*
 * #%L
 * org.eclipse.emf.eson
 * %%
 * Copyright (C) 2017 Michael Vorburger and others.
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */
package org.eclipse.emf.eson.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator;

/**
 * Check the resource need to be validated or not depending on its location in the workspace,
 * 
 * @author atripod
 */
@SuppressWarnings("restriction")
public class ESONDerivedStateAwareResourceValidator extends DerivedStateAwareResourceValidator {

	@Override
	public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator monitor) throws OperationCanceledError {

		if (monitor.isCanceled())
			return Collections.emptyList();
		
		if (ESONResourceValidationUtils.isValidationDisabled(resource.getURI())) {
			return Collections.emptyList();
		}
		
		return super.validate(resource, mode, monitor);
	}
	
	@Override
	protected void validate(Resource resource, CheckMode mode, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		if (monitor.isCanceled())
			return;

		if (ESONResourceValidationUtils.isValidationDisabled(resource.getURI()))
			return;
		
		super.validate(resource, mode, monitor, acceptor);
	}
}
