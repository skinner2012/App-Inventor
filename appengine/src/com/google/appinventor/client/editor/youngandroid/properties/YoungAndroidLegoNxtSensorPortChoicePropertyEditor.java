// Copyright 2008 Google Inc. All Rights Reserved.

package com.google.appinventor.client.editor.youngandroid.properties;

import com.google.appinventor.client.widgets.properties.ChoicePropertyEditor;

/**
 * Property editor for choosing an sensor port for a sensor on a Lego Mindstorms
 * NXT robot.
 *
 * @author lizlooney@google.com (Liz Looney)
 */
public class YoungAndroidLegoNxtSensorPortChoicePropertyEditor extends ChoicePropertyEditor {

  // Lego Mindstorms NXT sensor port choices
  private static final Choice[] sensorPorts = new Choice[] {
    new Choice("1", "1"),
    new Choice("2", "2"),
    new Choice("3", "3"),
    new Choice("4", "4")
  };

  public YoungAndroidLegoNxtSensorPortChoicePropertyEditor() {
    super(sensorPorts);
  }
}
