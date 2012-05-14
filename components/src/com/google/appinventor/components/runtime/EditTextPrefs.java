package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;

@DesignerComponent(version = YaVersion.EDITTEXTPREFS_COMPONENT_VERSION,
    description = "Non-visible component that adds edit-text preference item in the preferences of the phone.",
    category = ComponentCategory.PREFERENCE,
    nonVisible = true,
    iconName = "images/edittextprefs.png")
@SimpleObject
public class EditTextPrefs extends AndroidNonvisibleComponent implements Component, Deleteable {
  public EditTextPrefs(ComponentContainer container) {
    super(container.$form());
    final Context context = (Context) container.$context();
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetEditTextPrefsDialogTitle(String dialog_title) {

  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetEditTextPrefsKey(String key) {

  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetEditTextPrefsTitle(String title) {

  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetEditTextPrefsSummary(String summary) {

  }

  @Override
  public void onDelete() {

  }
}
