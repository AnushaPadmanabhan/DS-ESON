/*
 * #%L
 * org.eclipse.emf.eson.ui
 * %%
 * Copyright (C) 2009 - 2014 Sebastian Benz, Michael Vorburger and others
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */
package org.eclipse.emf.eson.ui.contentassist;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.eson.EFactoryRegistryReader;

/**
 *
 * @author phanikumark
 *
 */
public class EFactoryProposalProviderExtensionRegistry {

    private static final String pluginID = "org.eclipse.emf.eson.ui";
    
    protected final IExtensionRegistry extensionRegistry =  RegistryFactory.getRegistry();

    protected final EFactoryRegistryReader<ICustomProposalProvider> registryReader;

    public EFactoryProposalProviderExtensionRegistry() {
        this.registryReader = new EFactoryRegistryReader<ICustomProposalProvider>(extensionRegistry, pluginID, "proposalprovider");
    }

    public Iterable<ICustomProposalProvider> getProposalProviders() {
        return registryReader.get();
    }

}
