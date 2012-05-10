package com.google.appinventor.components.runtime;

import android.view.Menu;

/**
 * Listener for distributing the Activity onCreateOptionsMenu() method to interested components.
 */
public interface OnCreateOptionsMenuListener {
  public void onCreateOptionsMenu(Menu menu);
}
