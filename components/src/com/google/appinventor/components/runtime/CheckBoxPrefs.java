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
import android.preference.CheckBoxPreference;

@DesignerComponent(version = YaVersion.CHECKBOXPREFS_COMPONENT_VERSION,
    description = "Non-visible component that adds checkbox preference item in the preferences of the phone.",
    category = ComponentCategory.PREFERENCE,
    nonVisible = true,
    iconName = "images/checkboxprefs.png")
@SimpleObject
public final class CheckBoxPrefs extends AndroidNonvisibleComponent 
    implements Component, OnCreatePrefsItemListener, Deleteable {

  private String checkBoxPrefsKey;
  private String checkBoxPrefsTitle;
  private String checkBoxPrefsSummary;
  private boolean checkBoxPrefsDefaultValue;

  private SharedPreferences sharedPreferences;

  public CheckBoxPrefs(ComponentContainer container) {
    super(container.$form());
    PrefsActivity.registerForOnCreatePrefsItem(this);

    checkBoxPrefsKey = "keyofCheckBoxPreference";
    checkBoxPrefsTitle = "Title of CheckBoxPreference";
    checkBoxPrefsSummary = "Summary of CheckBoxPreference";
    checkBoxPrefsDefaultValue = false;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "keyofCheckBoxPreference")
  @SimpleProperty
  public void SetCheckBoxPrefsKey(String key) {
    checkBoxPrefsKey = key;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Title of CheckBoxPreference")
  @SimpleProperty
  public void SetCheckBoxPrefsTitle(String title) {
    checkBoxPrefsTitle = title;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Summary of CheckBoxPreference")
  @SimpleProperty
  public void SetCheckBoxPrefsSummary(String summary) {
    checkBoxPrefsSummary = summary;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_BOOLEAN,
    defaultValue = "False")
  @SimpleProperty
  public void SetCheckBoxPrefsDefaultValue(boolean defaultvalue) {
    checkBoxPrefsDefaultValue = defaultvalue;
  }

  @SimpleFunction
  public boolean GetCheckBoxPrefsValue() {
    boolean value = sharedPreferences.getBoolean(checkBoxPrefsKey, checkBoxPrefsDefaultValue);
    return value;
  }

  @Override
  public void onCreatePrefsItem(PreferenceScreen screen, PrefsActivity context) {
    CheckBoxPreference checkBoxPref = new CheckBoxPreference(context);
    checkBoxPref.setKey(checkBoxPrefsKey);
    checkBoxPref.setTitle(checkBoxPrefsTitle);
    checkBoxPref.setSummary(checkBoxPrefsSummary);
    checkBoxPref.setDefaultValue(checkBoxPrefsDefaultValue);
    screen.addPreference(checkBoxPref);

    sharedPreferences = screen.getSharedPreferences();
  }

  @Override
  public void onDelete() {

  }
}

