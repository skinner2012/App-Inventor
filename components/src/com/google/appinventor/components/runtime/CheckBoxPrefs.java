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

@DesignerComponent(version = YaVersion.CHECKBOXPREFS_COMPONENT_VERSION,
    description = "Non-visible component that adds checkbox preference item in the preferences of the phone.",
    category = ComponentCategory.PREFERENCE,
    nonVisible = true,
    iconName = "images/checkboxprefs.png")
@SimpleObject
public class CheckBoxPrefs extends AndroidNonvisibleComponent implements Component {
  public CheckBoxPrefs(ComponentContainer container) {
    super(container.$form());
    final Context context = (Context) container.$context();
  }
}
