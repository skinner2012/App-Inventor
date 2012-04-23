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
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

@DesignerComponent(version = YaVersion.SIMPLEMENU_COMPONENT_VERSION,
    description = "Non-visible component that adds simple menu item in menu of the phone.",
    category = ComponentCategory.MENU,
    nonVisible = true,
    iconName = "images/menu.png")
@SimpleObject
public class SimpleMenu extends AndroidNonvisibleComponent implements Component {
  public SimpleMenu(ComponentContainer container) {
    super(container.$form());
    final Context context = (Context) container.$context();
  }
}
