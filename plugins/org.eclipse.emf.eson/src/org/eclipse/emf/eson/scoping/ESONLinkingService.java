/*
 * #%L
 * org.eclipse.emf.eson
 * %%
 * Copyright (C) 2016 Michael Vorburger and others
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */package org.eclipse.emf.eson.scoping;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eson.eFactory.EFactoryPackage;
import org.eclipse.emf.eson.eFactory.PackageImport;
import org.eclipse.emf.eson.util.EPackageRegistry;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.base.Optional;
import com.google.inject.Inject;

/**
  * ILinkingService which deals with EPackage references in a particular manner.
  * 
  * @see org.eclipse.xtext.xtext.XtextLinkingService which was the inspiration for this class
  * 
  * @author Michael Vorburger
  */
@SuppressWarnings("restriction")
public class ESONLinkingService extends DefaultLinkingService {

	private static final Logger log = Logger.getLogger(ESONLinkingService.class);
	private @Inject EPackageRegistry ePackageRegistry;
	
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		if (ref == EFactoryPackage.eINSTANCE.getPackageImport_EPackage() && context instanceof PackageImport)
			return getPackage((PackageImport)context, getLinkingHelper().getCrossRefNodeAsString(node, true));
		return super.getLinkedObjects(context, ref, node);
	}

	// Code below was based on XtextLinkingService, which was not too nice and lead
	// to https://bugs.eclipse.org/bugs/show_bug.cgi?id=489748.
	// Old implementation was causing StackOverflow issues
	private List<EObject> getPackage(PackageImport context, String nsUri) {
		if (nsUri == null)
			return Collections.emptyList();
		EPackage pack = loadEPackage(nsUri, context.eResource().getResourceSet());
		if (pack != null)
			return Collections.<EObject>singletonList(pack);
		return Collections.emptyList();
	}

	private EPackage loadEPackage(String resourceOrNsURI, ResourceSet resourceSet) {
		Optional<EPackage> optionalResult = ePackageRegistry.getEPackage(resourceSet, resourceOrNsURI);
		if (optionalResult.isPresent())
			return optionalResult.get();

		URI uri = URI.createURI(resourceOrNsURI);
		try {
			if ("http".equalsIgnoreCase(uri.scheme()))
				return null;
			if (uri.fragment() == null) {
				Resource resource = resourceSet.getResource(uri, true);
				if (resource.getContents().isEmpty())
					return null;
				EPackage result = (EPackage) resource.getContents().get(0);
				return result;
			}
			EPackage result = (EPackage) resourceSet.getEObject(uri, true);
			return result;
		} catch(RuntimeException ex) {
			if (uri.isPlatformResource()) {
				String platformString = uri.toPlatformString(true);
				URI platformPluginURI = URI.createPlatformPluginURI(platformString, true);
				return loadEPackage(platformPluginURI.toString(), resourceSet);
			}
			log.trace("Cannot load package with URI '" + resourceOrNsURI + "'", ex);
			return null;
		}
	}

}
