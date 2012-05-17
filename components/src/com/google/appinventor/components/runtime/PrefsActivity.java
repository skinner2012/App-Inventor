package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.collect.Sets;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;

import java.util.Set;

@DesignerComponent(version = YaVersion.PREFERENCE_COMPONENT_VERSION,
    category = ComponentCategory.PREFERENCE,
    description = "Top-level preference activity containing all other preference items in the program",
    showOnPalette = false)
@SimpleObject
public final class PrefsActivity extends PreferenceActivity {

  private static final Set<OnCreatePrefsItemListener> onCreatePrefsItemListeners = Sets.newHashSet();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setPreferenceScreen(createPreferenceHierarchy());
  }

  private PreferenceScreen createPreferenceHierarchy() {
    PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(this);

    screen.removeAll();

    for (OnCreatePrefsItemListener onCreatePrefsItemListener : onCreatePrefsItemListeners) {
      onCreatePrefsItemListener.onCreatePrefsItem(screen, this);
    }
    
    return screen;
  }

  public static void registerForOnCreatePrefsItem(OnCreatePrefsItemListener component) {
    onCreatePrefsItemListeners.add(component);
  }
}

