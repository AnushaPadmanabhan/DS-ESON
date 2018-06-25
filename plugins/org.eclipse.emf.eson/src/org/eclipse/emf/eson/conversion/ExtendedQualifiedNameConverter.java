/*
 * #%L
 * org.eclipse.emf.eson
 * %%
 * Copyright (C) 2013 - 2015 Michael Vorburger, Anton Kosyakov 
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */
package org.eclipse.emf.eson.conversion;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

public class ExtendedQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {

	@Override
	public QualifiedName toQualifiedName(String qualifiedNameAsString) {
		QualifiedName qualifiedName = super.toQualifiedName(qualifiedNameAsString);
		if (qualifiedNameAsString.endsWith(getDelimiter())) {
			List<String> segments = new ArrayList<String>(qualifiedName.getSegments());
			while(StringUtils.endsWith(qualifiedNameAsString, getDelimiter())){	
				segments.add("");		// support trailing dot (empty last segment)
				qualifiedNameAsString = StringUtils.removeEnd(qualifiedNameAsString, getDelimiter());
			}
			qualifiedName = QualifiedName.create(segments);
		}
		return qualifiedName;
	}
}
