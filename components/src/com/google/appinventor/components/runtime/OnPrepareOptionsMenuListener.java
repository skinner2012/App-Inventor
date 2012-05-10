package com.google.appinventor.components.runtime;

import android.view.Menu;

/**
 * Listener for distributing the Activity onPrepareOptionsMenu() method to interested components.
 */
public interface OnPrepareOptionsMenuListener {
  public void onPrepareOptionsMenu(Menu menu);
}
