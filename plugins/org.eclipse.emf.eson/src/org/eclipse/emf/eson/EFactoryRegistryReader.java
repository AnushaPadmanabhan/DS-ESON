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
package org.eclipse.emf.eson;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.emf.ecore.plugin.RegistryReader;

import com.google.common.base.Optional;

/**
 * Inspired by org.eclipse.xtext.builder.impl.RegistryBuilderParticipant.BuilderParticipantReader.
 * 
 * @author Michael Vorburger
 */
public class EFactoryRegistryReader<T> extends RegistryReader {
	
	protected final static Logger logger = Logger.getLogger(EFactoryRegistryReader.class);
	
	protected static final String ATT_CLASS = "class";
//	protected static final String ATT_ID = "id";
	
	protected final String extensionPointID;
	protected final Map<String, T> extensionClassToInstance;
	
	public EFactoryRegistryReader(IExtensionRegistry pluginRegistry, String pluginID, String extensionPointID) {
		super(pluginRegistry, pluginID, extensionPointID);
		this.extensionPointID = extensionPointID;
		this.extensionClassToInstance = new HashMap<String, T>();
		readRegistry();
	}

	public Iterable<T> get() {
		return extensionClassToInstance.values();
	}
	
	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		boolean result = false;
		if (element.getName().equals(extensionPointID)) {
//			final String id = element.getAttribute(ATT_ID);
			final String className = element.getAttribute(ATT_CLASS);
			if (className == null) {
				logMissingAttribute(element, ATT_CLASS);
//			} else if (id == null) {
//				logMissingAttribute(element, ATT_ID);
			} else if (add) {
				Optional<T> instance = get(element);
				if (!instance.isPresent()) {
					result = false;
				} else {
					extensionClassToInstance.put(className, instance.get());
					result = true;
				}
			} else {
				extensionClassToInstance.remove(className);
				result = true;
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected Optional<T> get(IConfigurationElement element) {
		try {
			return Optional.of((T) element.createExecutableExtension(ATT_CLASS));
		} catch (CoreException e) {
			logError(element, e);
		} catch (NoClassDefFoundError e) {
			logError(element, e);
		}
		return Optional.absent();
	}

	protected void logError(IConfigurationElement element, Throwable e) {
		logger.error(getErrorTag(element), e);
	}

	@Override
	protected void logError(IConfigurationElement element, String text) {
		logger.error(getErrorTag(element));
		logger.error(text);
	}
	
	protected String getErrorTag(IConfigurationElement element) {
		IExtension extension = element.getDeclaringExtension();
		return "Plugin " + extension.getContributor().getName() + ", extension " + extension.getExtensionPointUniqueIdentifier(); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
