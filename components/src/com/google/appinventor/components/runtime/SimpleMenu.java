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
public class SimpleMenu extends AndroidNonvisibleComponent implements Component, OnMenuItemClickListener, Deleteable {

  private MenuItem menuItem;

  public SimpleMenu(ComponentContainer container) {
    super(container.$form());
    final Context context = (Context) container.$context();

    menuItem = form.onFormCreateMenu();
    menuItem.setOnMenuItemClickListener(this);
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_STRING,
    defaultValue = "Menu Item")
  @SimpleProperty
  public void MenuItemTitle(String title) {
    menuItem.setTitle(title); 
  }

  @DesignerProperty(editorType = DesignerProperty.PROPERTY_TYPE_MENUICON,
    defaultValue = Component.MENU_ICON_HELP + "")
  @SimpleProperty(
    userVisible = false)
  public void MenuItemIcon(int menuicon) {
    switch (menuicon) {
      case Component.MENU_ICON_ADD:
        menuItem.setIcon(android.R.drawable.ic_menu_add);
        break;
      case Component.MENU_ICON_AGENDA:
        menuItem.setIcon(android.R.drawable.ic_menu_agenda);
        break;
      case Component.MENU_ICON_CLOSECLEARCANCEL:
        menuItem.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        break;
      case Component.MENU_ICON_EDIT:
        menuItem.setIcon(android.R.drawable.ic_menu_edit);
        break;
      case Component.MENU_ICON_GALLERY:
        menuItem.setIcon(android.R.drawable.ic_menu_gallery);
        break;
      case Component.MENU_ICON_HELP:
        menuItem.setIcon(android.R.drawable.ic_menu_help);
        break;
      case Component.MENU_ICON_INFODETAILS:
        menuItem.setIcon(android.R.drawable.ic_menu_info_details);
        break;
      case Component.MENU_ICON_MANAGE:
        menuItem.setIcon(android.R.drawable.ic_menu_manage);
        break;
      case Component.MENU_ICON_MORE:
        menuItem.setIcon(android.R.drawable.ic_menu_more);
        break;
      case Component.MENU_ICON_PREFERENCES:
        menuItem.setIcon(android.R.drawable.ic_menu_preferences);
        break;
      case Component.MENU_ICON_SEARCH:
        menuItem.setIcon(android.R.drawable.ic_menu_search);
        break;
      case Component.MENU_ICON_VIEW:
        menuItem.setIcon(android.R.drawable.ic_menu_view);
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
  public void onDelete() {
    form.onFormRemoveMenu(menuItem.getItemId());
  }
}

