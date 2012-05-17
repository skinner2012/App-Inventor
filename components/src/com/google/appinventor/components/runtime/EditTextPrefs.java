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
import android.os.Handler;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.EditTextPreference;

@DesignerComponent(version = YaVersion.EDITTEXTPREFS_COMPONENT_VERSION,
    description = "Non-visible component that adds edit-text preference item in the preferences of the phone.",
    category = ComponentCategory.PREFERENCE,
    nonVisible = true,
    iconName = "images/edittextprefs.png")
@SimpleObject
public final class EditTextPrefs extends AndroidNonvisibleComponent  
    implements Component, OnCreatePrefsItemListener, Deleteable {

  private String editTextPrefsDialogTitle;
  private String editTextPrefsKey;
  private String editTextPrefsTitle;
  private String editTextPrefsSummary;
  private String editTextPrefsDefaultValue;

  private SharedPreferences sharedPreferences;

  public EditTextPrefs(ComponentContainer container) {
    super(container.$form());
    PrefsActivity.registerForOnCreatePrefsItem(this);

    editTextPrefsDialogTitle = "Dialog-Title of EditTextPreference";
    editTextPrefsKey = "keyofEditTextPreference";
    editTextPrefsTitle = "Title of EditTextPreference";
    editTextPrefsSummary = "Summary of EditTextPreference";
    editTextPrefsDefaultValue = "Default Value of EditTextPreference";
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Dialog-Title of EditPreference")
  @SimpleProperty
  public void SetEditTextPrefsDialogTitle(String dialog_title) {
    editTextPrefsDialogTitle = dialog_title;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "keyofEditTextPreference")
  @SimpleProperty
  public void SetEditTextPrefsKey(String key) {
    editTextPrefsKey = key;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Title of EditTextPreference")
  @SimpleProperty
  public void SetEditTextPrefsTitle(String title) {
    editTextPrefsTitle = title;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Summary of EditTextPreference")
  @SimpleProperty
  public void SetEditTextPrefsSummary(String summary) {
    editTextPrefsSummary = summary;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Default Value of EditTextPreference")
  @SimpleProperty
  public void SetEditTextPrefsDefaultValue(String defaultvalue) {
    editTextPrefsDefaultValue = defaultvalue;
  }

  @SimpleFunction
  public Object GetEditTextPrefsValue() {
    String value = sharedPreferences.getString(editTextPrefsKey, editTextPrefsDefaultValue);    
    return value;
  }

  @Override
  public void onCreatePrefsItem(PreferenceScreen screen, PrefsActivity context) {
    EditTextPreference editTextPref = new EditTextPreference(context);
    editTextPref.setDialogTitle(editTextPrefsDialogTitle);
    editTextPref.setKey(editTextPrefsKey);
    editTextPref.setTitle(editTextPrefsTitle);
    editTextPref.setSummary(editTextPrefsSummary);
    editTextPref.setDefaultValue(editTextPrefsDefaultValue);
    screen.addPreference(editTextPref);

    sharedPreferences = screen.getSharedPreferences();
  }

  @Override
  public void onDelete() {

  }
}

