package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Matrix;
import android.util.Log;
import android.os.Handler;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

import java.io.IOException;

@DesignerComponent(version = YaVersion.MENUITEMS_COMPONENT_VERSION,
    description = "Non-visible component that adds simple menu item in menu of the phone.",
    category = ComponentCategory.MENU,
    nonVisible = true,
    iconName = "images/menu.png")
@SimpleObject
public final class MenuItems extends AndroidNonvisibleComponent 
    implements Component, OnCreateOptionsMenuListener, OnPrepareOptionsMenuListener, OnMenuItemClickListener, Deleteable {

  private static final String LOG_TAG = "MenuItems";

  private int menuIndex;
  private String defaultMenuTitle;
  private int defaultMenuIcon;
  private boolean useUploadedIcon;
  private String iconPath;
  private Drawable menuIconDrawable;

  public MenuItems(ComponentContainer container) {
    super(container.$form());
    form.registerForOnCreateOptionsMenu(this);
    form.registerForOnPrepareOptionsMenu(this);

    menuIndex = form.getUserMenuNumofArray() + 1;
    defaultMenuTitle = "Menu Item " + (menuIndex - 2);
    defaultMenuIcon = android.R.drawable.ic_menu_help;
    useUploadedIcon = false;
    iconPath = "";
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Menu Item")
  @SimpleProperty
  public void SetMenuItemTitle(String title) {
    defaultMenuTitle = title;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_BOOLEAN,
    defaultValue = "False")
  @SimpleProperty
  public void EnableUserIcon(boolean enabled) {
    if (enabled == true)
      useUploadedIcon = true;
    else
      useUploadedIcon = false;
  }

  public Drawable scaleIcon(Drawable origIcon) {
    int width = origIcon.getMinimumWidth();
    int height = origIcon.getMinimumHeight();

    int newWidth = 36;
    int newHeight = 36;

    float scaleWidth = ((float) newWidth) / width;
    float scaleHeight = ((float) newHeight) / height;

    Matrix matrix = new Matrix();

    matrix.postScale(scaleWidth, scaleHeight);

    Bitmap bmp = ((BitmapDrawable) origIcon).getBitmap();
    Bitmap resizedBitmap = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, true);

    BitmapDrawable newIcon = new BitmapDrawable(resizedBitmap);

    return newIcon;
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_ASSET,
    defaultValue = "")
  @SimpleProperty
  public void IconUpload(String path) {
    if (path.equals(iconPath) && menuIconDrawable != null)
      return;

    iconPath = (path == null) ? "" : path;
    menuIconDrawable = null;

    if (iconPath.length() > 0) {
      try {
        menuIconDrawable = MediaUtil.getBitmapDrawable(form, iconPath);
        menuIconDrawable = scaleIcon(menuIconDrawable);
      } catch (IOException e) {
        Log.e(LOG_TAG, "Unable to load " + iconPath);
      }
    } 
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_MENUICON,
    defaultValue = Component.MENU_ICON_HELP + "")
  @SimpleProperty(
    userVisible = false)
  public void SetMenuItemIcon(int menuicon) {
    switch (menuicon) {
      case Component.MENU_ICON_ADD:
        defaultMenuIcon = android.R.drawable.ic_menu_add;
        break;
      case Component.MENU_ICON_AGENDA:
        defaultMenuIcon = android.R.drawable.ic_menu_agenda;
        break;
      case Component.MENU_ICON_CLOSECLEARCANCEL:
        defaultMenuIcon = android.R.drawable.ic_menu_close_clear_cancel;
        break;
      case Component.MENU_ICON_EDIT:
        defaultMenuIcon = android.R.drawable.ic_menu_edit;
        break;
      case Component.MENU_ICON_GALLERY:
        defaultMenuIcon = android.R.drawable.ic_menu_gallery;
        break;
      case Component.MENU_ICON_HELP:
        defaultMenuIcon = android.R.drawable.ic_menu_help;
        break;
      case Component.MENU_ICON_INFODETAILS:
        defaultMenuIcon = android.R.drawable.ic_menu_info_details;
        break;
      case Component.MENU_ICON_MANAGE:
        defaultMenuIcon = android.R.drawable.ic_menu_manage;
        break;
      case Component.MENU_ICON_MORE:
        defaultMenuIcon = android.R.drawable.ic_menu_more;
        break;
      case Component.MENU_ICON_PREFERENCES:
        defaultMenuIcon = android.R.drawable.ic_menu_preferences;
        break;
      case Component.MENU_ICON_SEARCH:
        defaultMenuIcon = android.R.drawable.ic_menu_search;
        break;
      case Component.MENU_ICON_VIEW:
        defaultMenuIcon = android.R.drawable.ic_menu_view;
        break;
    }
  }

  @SimpleEvent(description = "When menu item is clicked")
  public boolean MenuItemClick() {
    return EventDispatcher.dispatchEvent(this, "MenuItemClick");
  }

  @Override
  public boolean onMenuItemClick(MenuItem item) {
    return MenuItemClick();
  }

  @Override
  public void onCreateOptionsMenu(Menu menu) {
    MenuItem menuItem = menu.add(Menu.NONE, menuIndex, Menu.NONE, defaultMenuTitle);
    if (useUploadedIcon == true && menuIconDrawable != null)
      menuItem.setIcon(menuIconDrawable);
    else
      menuItem.setIcon(defaultMenuIcon);
    menuItem.setOnMenuItemClickListener(this);
  }

  @Override
  public void onPrepareOptionsMenu(Menu menu) {
    MenuItem menuItem = menu.add(Menu.NONE, menuIndex, Menu.NONE, defaultMenuTitle);
    if (useUploadedIcon == true && menuIconDrawable != null)
      menuItem.setIcon(menuIconDrawable);
    else
      menuItem.setIcon(defaultMenuIcon);
    menuItem.setOnMenuItemClickListener(this);
  }

  @Override
  public void onDelete() {
  }
}

