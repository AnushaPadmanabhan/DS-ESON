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

import org.eclipse.emf.common.util.URI;

/**
 * The <tt>ESONResourceValidationTester</tt> verify if the validation is
 * disabled for a specified resource uri.
 * 
 * <p>
 * The concrete classes must be registered with the extension point
 * "org.eclipse.emf.eson.validation".
 * 
 * @author atripod
 */
public interface ESONResourceValidationTester {

	/**
	 * Returns <tt>true</tt> if the validation should be disabled for the
	 * resource identified by the specified uri.
	 * 
	 * @param uri
	 *            the resource uri to be checked
	 * @return <tt>true</tt> if the validation should be disabled for the
	 *         resource identified by the specified uri
	 */
	boolean isValidationDisabled(URI uri);
	
	/**
	 * Default validation tester. The resource can always be validated.
	 */
	ESONResourceValidationTester defaultValidationTester = 
			new ESONResourceValidationTester() {
				@Override
				public boolean isValidationDisabled(URI uri) {
					return false;
				}
			};
	
}
