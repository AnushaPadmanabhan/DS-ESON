/*
 * #%L
 * org.eclipse.emf.eson.tests
 * %%
 * Copyright (C) 2013 - 2014 Michael Vorburger
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */
package org.eclipse.emf.eson.xcore.tests;

import javax.inject.Inject;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eson.tests.util.ESONWithTestmodelAndXcoreInjectorProvider;
import org.eclipse.emf.eson.tests.util.ResourceProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests specifically related to Xcore integration.
 */
@RunWith(XtextRunner.class)
@InjectWith(ESONWithTestmodelAndXcoreInjectorProvider.class)
public class XcoreTest {

	@Inject ResourceProvider resourceProvider;

	@Test
	@SuppressWarnings("unused")
	public void testXcore() throws Exception {
		resourceProvider.load(URI.createURI("classpath:/model/Ecore.ecore"), true);
		resourceProvider.load(URI.createURI("classpath:/model/Ecore.genmodel"), true);
		GenModel genModel = (GenModel) resourceProvider.loadModel("model/TestModel2.xcore");
		// TODO feature = how to get the 'age' out of this?
		EObject eObject = resourceProvider.loadModel("res/xcore/XcoreTest.efactory");
		// TODO ideally should eObject.eGet(feature) - to check age is 99
	}
}
