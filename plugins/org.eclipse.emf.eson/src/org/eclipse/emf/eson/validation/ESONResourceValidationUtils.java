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

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;

/**
 * Utility class that verifies if the validation of a resource specified by its
 * uri is disabled or not. The default implementation always accept the
 * validation.
 * 
 * <p>
 * A Specific implementation of the interface
 * {@code ESONResourceValidationTester} must be registered with the extension
 * point <tt>org.eclipse.emf.eson.validation</tt>.
 * 
 * <p>
 * Only one instance of the extension point is supported for now.
 * 
 * @author atripod
 */
public class ESONResourceValidationUtils {

	private static Logger logger = Logger.getLogger(ESONResourceValidationUtils.class);

	private static String EXTENSION_POINT = "org.eclipse.emf.eson.validation";

	private static ESONResourceValidationUtils _instance = new ESONResourceValidationUtils();

	private ESONResourceValidationTester validationTester;

	private ESONResourceValidationUtils() {
		loadValidationTester();
	}

	private void loadValidationTester() {

		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_POINT);

		if (config.length > 0) {
			IConfigurationElement element = config[0];
			try {
				validationTester = (ESONResourceValidationTester) element
						.createExecutableExtension("class");
			} catch (CoreException ex) {
				logger.error(
						"A ESONResourceValidationTester cannot be instantiated, please check extension point: {"
								+ EXTENSION_POINT + "}", ex);
			}
		}

		if (validationTester == null) {
			validationTester = ESONResourceValidationTester.defaultValidationTester;
			logger.warn("No custom ESONResourceValidationTester defined, so the default implementation will be used");
		}

	}

	/**
	 * Returns <tt>true</tt> if the validation should be disabled for the
	 * resource identified by the specified uri.
	 * 
	 * @param uri
	 *            the resource uri to be checked
	 * @return <tt>true</tt> if the validation should be disabled for the
	 *         resource identified by the specified uri
	 */
	public static boolean isValidationDisabled(URI uri) {
		return _instance.validationTester.isValidationDisabled(uri);
	}

}
