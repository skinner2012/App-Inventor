package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;

public final class PrefsActivity extends PreferenceActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setPreferenceScreen(createPreferenceHierarchy());
  }

  private PreferenceScreen createPreferenceHierarchy() {
    PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);
    return screen;
  }
}

