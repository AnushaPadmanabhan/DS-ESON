/*
 * generated by Xtext
 */
package org.eclipse.emf.eson.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.eson.eFactory.BooleanAttribute;
import org.eclipse.emf.eson.eFactory.Containment;
import org.eclipse.emf.eson.eFactory.CustomNameMapping;
import org.eclipse.emf.eson.eFactory.DateAttribute;
import org.eclipse.emf.eson.eFactory.DoubleAttribute;
import org.eclipse.emf.eson.eFactory.EFactoryPackage;
import org.eclipse.emf.eson.eFactory.EnumAttribute;
import org.eclipse.emf.eson.eFactory.Factory;
import org.eclipse.emf.eson.eFactory.Feature;
import org.eclipse.emf.eson.eFactory.IntegerAttribute;
import org.eclipse.emf.eson.eFactory.MultiValue;
import org.eclipse.emf.eson.eFactory.NamespaceImport;
import org.eclipse.emf.eson.eFactory.NewObject;
import org.eclipse.emf.eson.eFactory.NullAttribute;
import org.eclipse.emf.eson.eFactory.PackageImport;
import org.eclipse.emf.eson.eFactory.Reference;
import org.eclipse.emf.eson.eFactory.StringAttribute;
import org.eclipse.emf.eson.services.EFactoryGrammarAccess;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class EFactorySemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private EFactoryGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == EFactoryPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case EFactoryPackage.BOOLEAN_ATTRIBUTE:
				sequence_BooleanAttribute(context, (BooleanAttribute) semanticObject); 
				return; 
			case EFactoryPackage.CONTAINMENT:
				sequence_Value(context, (Containment) semanticObject); 
				return; 
			case EFactoryPackage.CUSTOM_NAME_MAPPING:
				sequence_CustomNameMapping(context, (CustomNameMapping) semanticObject); 
				return; 
			case EFactoryPackage.DATE_ATTRIBUTE:
				sequence_DateAttribute(context, (DateAttribute) semanticObject); 
				return; 
			case EFactoryPackage.DOUBLE_ATTRIBUTE:
				sequence_DoubleAttribute(context, (DoubleAttribute) semanticObject); 
				return; 
			case EFactoryPackage.ENUM_ATTRIBUTE:
				sequence_EnumAttribute(context, (EnumAttribute) semanticObject); 
				return; 
			case EFactoryPackage.FACTORY:
				sequence_Factory(context, (Factory) semanticObject); 
				return; 
			case EFactoryPackage.FEATURE:
				sequence_Feature(context, (Feature) semanticObject); 
				return; 
			case EFactoryPackage.INTEGER_ATTRIBUTE:
				sequence_IntegerAttribute(context, (IntegerAttribute) semanticObject); 
				return; 
			case EFactoryPackage.MULTI_VALUE:
				sequence_MultiValue(context, (MultiValue) semanticObject); 
				return; 
			case EFactoryPackage.NAMESPACE_IMPORT:
				sequence_NamespaceImport(context, (NamespaceImport) semanticObject); 
				return; 
			case EFactoryPackage.NEW_OBJECT:
				if (rule == grammarAccess.getNewObjectRule()) {
					sequence_NewObject(context, (NewObject) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getValueAccess().getContainmentValueAction_2_3()) {
					sequence_Value_Containment_2_3(context, (NewObject) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.NULL_ATTRIBUTE:
				sequence_NullAttribute(context, (NullAttribute) semanticObject); 
				return; 
			case EFactoryPackage.PACKAGE_IMPORT:
				sequence_PackageImport(context, (PackageImport) semanticObject); 
				return; 
			case EFactoryPackage.REFERENCE:
				sequence_Reference(context, (Reference) semanticObject); 
				return; 
			case EFactoryPackage.STRING_ATTRIBUTE:
				sequence_StringAttribute(context, (StringAttribute) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Value returns BooleanAttribute
	 *     Attribute returns BooleanAttribute
	 *     BooleanAttribute returns BooleanAttribute
	 *
	 * Constraint:
	 *     value=Boolean
	 */
	protected void sequence_BooleanAttribute(ISerializationContext context, BooleanAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.BOOLEAN_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.BOOLEAN_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBooleanAttributeAccess().getValueBooleanParserRuleCall_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Annotation returns CustomNameMapping
	 *     CustomNameMapping returns CustomNameMapping
	 *
	 * Constraint:
	 *     (eClass=[EClass|QualifiedName] nameFeature=[EAttribute|QualifiedName])
	 */
	protected void sequence_CustomNameMapping(ISerializationContext context, CustomNameMapping semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__ECLASS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__ECLASS));
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__NAME_FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__NAME_FEATURE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCustomNameMappingAccess().getEClassEClassQualifiedNameParserRuleCall_2_0_1(), semanticObject.getEClass());
		feeder.accept(grammarAccess.getCustomNameMappingAccess().getNameFeatureEAttributeQualifiedNameParserRuleCall_4_0_1(), semanticObject.getNameFeature());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns DateAttribute
	 *     Attribute returns DateAttribute
	 *     DateAttribute returns DateAttribute
	 *
	 * Constraint:
	 *     value=Date
	 */
	protected void sequence_DateAttribute(ISerializationContext context, DateAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.DATE_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.DATE_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDateAttributeAccess().getValueDateParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns DoubleAttribute
	 *     Attribute returns DoubleAttribute
	 *     DoubleAttribute returns DoubleAttribute
	 *
	 * Constraint:
	 *     value=Double
	 */
	protected void sequence_DoubleAttribute(ISerializationContext context, DoubleAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.DOUBLE_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.DOUBLE_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDoubleAttributeAccess().getValueDoubleParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns EnumAttribute
	 *     Attribute returns EnumAttribute
	 *     EnumAttribute returns EnumAttribute
	 *
	 * Constraint:
	 *     value=[EEnumLiteral|QualifiedName]
	 */
	protected void sequence_EnumAttribute(ISerializationContext context, EnumAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.ENUM_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.ENUM_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEnumAttributeAccess().getValueEEnumLiteralQualifiedNameParserRuleCall_1_0_1(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Factory returns Factory
	 *
	 * Constraint:
	 *     (imports+=NamespaceImport* epackages+=PackageImport* annotations+=Annotation* root=NewObject)
	 */
	protected void sequence_Factory(ISerializationContext context, Factory semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Feature returns Feature
	 *
	 * Constraint:
	 *     (eFeature=[EStructuralFeature|QualifiedName] value=Value?)
	 */
	protected void sequence_Feature(ISerializationContext context, Feature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Value returns IntegerAttribute
	 *     Attribute returns IntegerAttribute
	 *     IntegerAttribute returns IntegerAttribute
	 *
	 * Constraint:
	 *     value=Long
	 */
	protected void sequence_IntegerAttribute(ISerializationContext context, IntegerAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.INTEGER_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.INTEGER_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntegerAttributeAccess().getValueLongParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns MultiValue
	 *     MultiValue returns MultiValue
	 *
	 * Constraint:
	 *     values+=Value*
	 */
	protected void sequence_MultiValue(ISerializationContext context, MultiValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     NamespaceImport returns NamespaceImport
	 *
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_NamespaceImport(ISerializationContext context, NamespaceImport semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.NAMESPACE_IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.NAMESPACE_IMPORT__IMPORTED_NAMESPACE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNamespaceImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     NewObject returns NewObject
	 *
	 * Constraint:
	 *     (eClass=[EClass|QualifiedName] name=ValidID? features+=Feature*)
	 */
	protected void sequence_NewObject(ISerializationContext context, NewObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Value returns NullAttribute
	 *     Attribute returns NullAttribute
	 *     NullAttribute returns NullAttribute
	 *
	 * Constraint:
	 *     value='NULL'
	 */
	protected void sequence_NullAttribute(ISerializationContext context, NullAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.NULL_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.NULL_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNullAttributeAccess().getValueNULLKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PackageImport returns PackageImport
	 *
	 * Constraint:
	 *     ePackage=[EPackage|QualifiedName]
	 */
	protected void sequence_PackageImport(ISerializationContext context, PackageImport semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.PACKAGE_IMPORT__EPACKAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.PACKAGE_IMPORT__EPACKAGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPackageImportAccess().getEPackageEPackageQualifiedNameParserRuleCall_1_0_1(), semanticObject.getEPackage());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns Reference
	 *     Reference returns Reference
	 *
	 * Constraint:
	 *     value=[EObject|QualifiedName]
	 */
	protected void sequence_Reference(ISerializationContext context, Reference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.REFERENCE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.REFERENCE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getReferenceAccess().getValueEObjectQualifiedNameParserRuleCall_0_1(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns StringAttribute
	 *     Attribute returns StringAttribute
	 *     StringAttribute returns StringAttribute
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_StringAttribute(ISerializationContext context, StringAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.STRING_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.STRING_ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringAttributeAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value returns Containment
	 *
	 * Constraint:
	 *     value=Value_Containment_2_3
	 */
	protected void sequence_Value(ISerializationContext context, Containment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.CONTAINMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.CONTAINMENT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getValueAccess().getContainmentValueAction_2_3(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Value.Containment_2_3 returns NewObject
	 *
	 * Constraint:
	 *     (eClass=[EClass|QualifiedName]? name=ValidID? features+=Feature*)
	 */
	protected void sequence_Value_Containment_2_3(ISerializationContext context, NewObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
