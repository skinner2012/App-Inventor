package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.util.Log;

import java.io.IOException;

@DesignerComponent(version = YaVersion.SIMPLEMENU_COMPONENT_VERSION,
    description = "Non-visible component that adds simple menu item in menu of the phone.",
    category = ComponentCategory.MENU,
    nonVisible = true,
    iconName = "images/menu.png")
@SimpleObject
public class SimpleMenu extends AndroidNonvisibleComponent implements Component {

  private String iconPath;
  private Drawable iconDrawable;
  private static final String LOG_TAG = "SimpleMenu";

  public SimpleMenu(ComponentContainer container) {
    super(container.$form());
    final Context context = (Context) container.$context();
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Menu Item")
  @SimpleProperty
  public void MenuItemTitle(String title) {

  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_MENUICON,
    defaultValue = Component.MENU_ICON_HELP + "")
  @SimpleProperty(
    userVisible = false)
  public void MenuItemIcon(int menuicon) {

  }
}

