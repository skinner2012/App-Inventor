package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.util.YailList;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;

import android.app.Activity;
import android.os.Handler;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.ListPreference;
import android.util.Log;

import java.util.ArrayList;

@DesignerComponent(version = YaVersion.LISTPREFS_COMPONENT_VERSION,
    description = "Non-visible component that adds list preference item in the preferences of the phone.",
    category = ComponentCategory.PREFERENCE,
    nonVisible = true,
    iconName = "images/listprefs.png")
@SimpleObject
public final class ListPrefs extends AndroidNonvisibleComponent 
    implements Component, OnCreatePrefsItemListener, Deleteable {

  private String listPrefsDialogTitle;
  private String listPrefsKey;
  private String listPrefsTitle;
  private String listPrefsSummary;
  private CharSequence[] listPrefsEntries;
  private CharSequence[] listPrefsEntryValues;

  private SharedPreferences sharedPreferences;

  public ListPrefs(ComponentContainer container) {
    super(container.$form());
    PrefsActivity.registerForOnCreatePrefsItem(this);

    listPrefsDialogTitle = "Dialog-Title of ListPreference";
    listPrefsKey = "keyofListPreference";
    listPrefsTitle = "Title of ListPreference";
    listPrefsSummary = "Summary of ListPreference";
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Dialog-Title of ListPreference")
  @SimpleProperty
  public void SetListPrefsDialogTitle(String dialog_title) {
    listPrefsDialogTitle = dialog_title;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "keyofListPreference")
  @SimpleProperty
  public void SetListPrefsKey(String key) {
    listPrefsKey = key;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Title of ListPreference")
  @SimpleProperty
  public void SetListPrefsTitle(String title) {
    listPrefsTitle = title;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Summary of ListPreference")
  @SimpleProperty
  public void SetListPrefsSummary(String summary) {
    listPrefsSummary = summary;
  }

  @SimpleProperty
  public void SetListPrefsEntries(YailList entries) {
    Object[] objects = entries.toStringArray(); 
    listPrefsEntries = new CharSequence[entries.size()];
    for (int i=0; i<objects.length; i++) {
      listPrefsEntries[i] = (CharSequence) objects[i];
      Log.d("ListPrefs", "entry " + i + ": " + listPrefsEntries[i]);
    }
  }

  @SimpleProperty
  public void SetListPrefsEntryValues(YailList entryvalues) {
    Object[] objects = entryvalues.toStringArray();
    listPrefsEntryValues = new CharSequence[entryvalues.size()];
    for (int i=0; i<objects.length; i++) {
      listPrefsEntryValues[i] = (CharSequence) objects[i];
      Log.d("ListPrefs", "entryvalue " + i + ": " + listPrefsEntryValues[i]);
    }
  }

  @SimpleFunction
  public Object GetListPrefsValue() {
    String value = sharedPreferences.getString(listPrefsKey, "");
    return value;
  }

  @Override
  public void onCreatePrefsItem(PreferenceScreen screen, PrefsActivity context) {
    ListPreference listPref = new ListPreference(context);
    listPref.setDialogTitle(listPrefsDialogTitle);
    listPref.setKey(listPrefsKey);
    listPref.setTitle(listPrefsTitle);
    listPref.setSummary(listPrefsSummary);
    listPref.setEntries(listPrefsEntries);
    listPref.setEntryValues(listPrefsEntryValues);
    screen.addPreference(listPref);

    sharedPreferences = screen.getSharedPreferences();
  }

  @Override
  public void onDelete() {

  }
}

