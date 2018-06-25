/*
 * #%L
 * org.eclipse.emf.eson.ui
 * %%
 * Copyright (C) 2016 Michael Vorburger and others
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */
package org.eclipse.emf.eson.validation;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.eson.EFactoryRegistryReader;

public class EFactoryValidatorExtensionRegistry {

	private static final String pluginID = "org.eclipse.emf.eson";
	
	protected final IExtensionRegistry extensionRegistry =  RegistryFactory.getRegistry();

	protected final EFactoryRegistryReader<AbstractESONAttributeCustomValidator> validatorRegistryReader;

	public EFactoryValidatorExtensionRegistry() {
		this.validatorRegistryReader = new EFactoryRegistryReader<AbstractESONAttributeCustomValidator>(extensionRegistry, pluginID, "attributeValidator");
	}

	public Iterable<AbstractESONAttributeCustomValidator> getValidators() {
		return validatorRegistryReader.get();
	}

}
