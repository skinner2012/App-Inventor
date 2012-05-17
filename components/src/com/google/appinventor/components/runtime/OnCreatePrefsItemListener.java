package com.google.appinventor.components.runtime;

import android.preference.PreferenceScreen;

/**
 * Listener for distributing the PreferenceActivity onCreatePrefsItem() method to interested components.
 */
public interface OnCreatePrefsItemListener {
  public void onCreatePrefsItem(PreferenceScreen screen, PrefsActivity context);
}

