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
package org.eclipse.emf.eson.ui.editor.model;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.eson.validation.ESONResourceValidationUtils;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;

/**
 * DS-11537 - Check if the validation must be enabled when the resource is
 * opened in the editor.
 * 
 * @author atripod
 */
public class ESONJavaClassPathResourceForIEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory {

    @Override
    protected boolean isValidationDisabled(URI uri, IStorage storage) {
        boolean disabled = super.isValidationDisabled(uri, storage);
        if (!disabled) {
            disabled = ESONResourceValidationUtils.isValidationDisabled(uri);
        }
        return disabled;
    } 
}
