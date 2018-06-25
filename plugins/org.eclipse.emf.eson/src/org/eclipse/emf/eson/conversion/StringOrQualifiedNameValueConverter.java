/*
 * #%L
 * org.eclipse.emf.eson
 * %%
 * Copyright (C) 2016 Michael Vorburger and others. 
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */
package org.eclipse.emf.eson.conversion;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class StringOrQualifiedNameValueConverter extends AbstractNullSafeConverter<String> {

	@Override
	protected String internalToString(String value) {
		return useStringRepresentationIfNecessary(value);
	}

	@Override
	protected String internalToValue(String string, INode node)
			throws ValueConverterException {
		if (((string.startsWith("\"") && string.endsWith("\"")) ||
				string.startsWith("'") && string.endsWith("'"))) {
			return Strings.convertFromJavaString(string.substring(1, string.length()-1), true);
		} else {
			return string;
		}
	}

	private static String useStringRepresentationIfNecessary(String id) {
		if (id == null || validId(id)) {
			return id;
		} else {
			return "\"" + Strings.convertToJavaString(id) + "\"";
		}
	}

	private static boolean validId(String id) {
		if (id.startsWith(".") || id.endsWith(".") || id.contains(".NULL") || id.contains("NULL.")) {
			return false;
		}

		for (int i = 0; i < id.length(); i++) {
			char c = id.charAt(i);
			boolean alphaNum = (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
			if (!alphaNum && !"_".equals("" + c)
					&& !",".equals("" + c) && !"-".equals("" + c)
					&& !".".equals("" + c)) {
				return false;
			}
		}
		return true;
	}

}
