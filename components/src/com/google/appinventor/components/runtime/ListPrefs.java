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

import java.util.ArrayList;

@DesignerComponent(version = YaVersion.LISTPREFS_COMPONENT_VERSION,
    description = "Non-visible component that adds list preference item in the preferences of the phone.",
    category = ComponentCategory.PREFERENCE,
    nonVisible = true,
    iconName = "images/listprefs.png")
@SimpleObject
public class ListPrefs extends AndroidNonvisibleComponent implements Component, Deleteable {
  public ListPrefs(ComponentContainer container) {
    super(container.$form());
    final Context context = (Context) container.$context();
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetListPrefsDialogTitle(String dialog_title) {

  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetListPrefsKey(String key) {

  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetListPrefsTitle(String title) {

  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "")
  @SimpleProperty
  public void SetListPrefsSummary(String summary) {

  }

  @Override
  public void onDelete() {

  }
}