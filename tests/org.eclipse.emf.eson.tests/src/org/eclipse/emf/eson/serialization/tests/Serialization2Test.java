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
package org.eclipse.emf.eson.serialization.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.eson.resource.EFactoryResource;
import org.eclipse.emf.eson.tests.util.ESONWithTestmodelInjectorProvider;
import org.eclipse.emf.eson.tests.util.ResourceProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testmodel.TestModel;
import testmodel.TestmodelFactory;

@RunWith(XtextRunner.class)
@InjectWith(ESONWithTestmodelInjectorProvider.class)
public class Serialization2Test {

	@Inject protected ResourceProvider resourceProvider;
	@Inject protected ParseHelper<EObject> parseHelper;
	
	@Test public void testReferenceTestSimpleAlternative() throws Exception {
		TestModel testModel = resourceProvider.loadModel("res/SerializationTests/ReferenceTestSimple.efactory", TestModel.class);
		String oldSerializedText = SerializationUtils.toString(testModel.eResource());

		testModel.getReferenceTestContainer().get(0).getContainments().get(0).setName("target2");
		String newSerializedText = SerializationUtils.toString(testModel.eResource());

		assertEquals(oldSerializedText.replace("target1", "target2"), newSerializedText);
	}
	
	@Test 
	public void testChangeGoodNameToFunkyNameWithSpace() throws Exception {
        TestModel testModel = resourceProvider.loadModel("res/SerializationTests/AttributeTest.efactory", TestModel.class);
        assertEquals("testModelName", testModel.getName());
        testModel.setName("test#Model Name");
        String text = SerializationUtils.toString(testModel.eResource());
        Resource newTestModelResource = parseHelper.parse(text).eResource();
        resourceProvider.validate(newTestModelResource);
        TestModel newTestModel = EFactoryResource.getEFactoryEObject(newTestModelResource, TestModel.class);
        assertNotNull(newTestModel);
        assertEquals("test#Model Name", newTestModel.getName());
        assertFalse(text, text.contains("testModelName"));
    }
	
    @Test 
    public void testChangeNameThenSecondAttribute() throws Exception {
        TestModel testModel = resourceProvider.loadModel("res/SerializationTests/AttributeTest.efactory", TestModel.class);
        //assertEquals("testModelName", testModel.getName());
        testModel.setName("name");
        testModel.setSingleRequired(TestmodelFactory.eINSTANCE.createSingleRequired());
        String text = SerializationUtils.toString(testModel.eResource());
        
        Resource newTestModelResource = parseHelper.parse(text).eResource();
        resourceProvider.validate(newTestModelResource);
        TestModel newTestModel = EFactoryResource.getEFactoryEObject(newTestModelResource, TestModel.class);
        assertNotNull(newTestModel);
        assertEquals("name", newTestModel.getName());
    }	
    
	@Test 
	public void testAttributeWithSpecialChar() throws Exception {
		
		/*
		* Instantiate EcoreFactory
		*/
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;

		/*
		* Create EClass instance to model AttributeWithSpecialCharClassEClass class
		*/
		EClass attributeWithSpecialCharClassEClass = theCoreFactory.createEClass();
		attributeWithSpecialCharClassEClass.setName("AttributeWithSpecialCharClass1");

		/*
		* Instantiate EPackage and provide unique URI
		* to identify this package
		*/
		EPackage attributeWithSpecialCharEPackage = theCoreFactory.createEPackage();
		attributeWithSpecialCharEPackage.setName("attributeWithSpecialChar");
		attributeWithSpecialCharEPackage.setNsPrefix("attributeWithSpecialChar");
		attributeWithSpecialCharEPackage.setNsURI("attributeWithSpecialChar");
		
		/*
		* Instantiate EcorePackage
		*/
		EcorePackage theCorePackage = EcorePackage.eINSTANCE;

		/*
		* Create attributes for BookStore class as specified in the model
		*/
		EAttribute attributeNameWithSpecialChar1 = theCoreFactory.createEAttribute();
		attributeNameWithSpecialChar1.setName(".attributeNameWithSpecialChar");
		attributeNameWithSpecialChar1.setEType(theCorePackage.getEString());

		EAttribute attributeNameWithSpecialChar2 = theCoreFactory.createEAttribute();
		attributeNameWithSpecialChar2.setName("attributeNameWithSpecialChar.");
		attributeNameWithSpecialChar2.setEType(theCorePackage.getEString());

		EAttribute attributeNameWithSpecialChar3 = theCoreFactory.createEAttribute();
		attributeNameWithSpecialChar3.setName("attributeNameWith..SpecialChar");
		attributeNameWithSpecialChar3.setEType(theCorePackage.getEString());

		EAttribute atId = theCoreFactory.createEAttribute();
		atId.setName("@id");
		atId.setEType(theCorePackage.getEString());
		
		EAttribute simpleAttributeAsString = theCoreFactory.createEAttribute();
		simpleAttributeAsString.setName("simpleAttributeAsString");
		simpleAttributeAsString.setEType(theCorePackage.getEString());
		
		EAttribute extremeNameAttribute = theCoreFactory.createEAttribute();
		extremeNameAttribute.setName("extreme\"name");
		extremeNameAttribute.setEType(theCorePackage.getEString());
		
		// Link parts together
		attributeWithSpecialCharClassEClass.getEStructuralFeatures().add(attributeNameWithSpecialChar1);
		attributeWithSpecialCharClassEClass.getEStructuralFeatures().add(attributeNameWithSpecialChar2);
		attributeWithSpecialCharClassEClass.getEStructuralFeatures().add(attributeNameWithSpecialChar3);
		attributeWithSpecialCharClassEClass.getEStructuralFeatures().add(atId);
		attributeWithSpecialCharClassEClass.getEStructuralFeatures().add(simpleAttributeAsString);
		attributeWithSpecialCharClassEClass.getEStructuralFeatures().add(extremeNameAttribute);

		attributeWithSpecialCharEPackage.getEClassifiers().add(attributeWithSpecialCharClassEClass);
				
		// Register package
		EPackage.Registry.INSTANCE.put(attributeWithSpecialCharEPackage.getNsURI(), attributeWithSpecialCharEPackage);
		
		new ResourceImpl().getContents().add(attributeWithSpecialCharEPackage);

		// Load the eson
        EObject eson = resourceProvider.loadModel("res/SerializationTests/AttributeNameWithSpecialChar.eson");

        Assert.assertEquals("AttributeWithSpecialCharClass1", eson.eClass().getName());
        Assert.assertEquals(".attributeNameWithSpecialChar", eson.eClass().getEAllAttributes().get(0).getName());
        Assert.assertEquals("attributeNameWithSpecialChar.", eson.eClass().getEAllAttributes().get(1).getName());
        Assert.assertEquals("attributeNameWith..SpecialChar", eson.eClass().getEAllAttributes().get(2).getName());
        Assert.assertEquals("@id", eson.eClass().getEAllAttributes().get(3).getName());
        Assert.assertEquals("simpleAttributeAsString", eson.eClass().getEAllAttributes().get(4).getName());

        String text = SerializationUtils.toString(eson.eResource());
        
        System.out.println(text);
    }
	
}
