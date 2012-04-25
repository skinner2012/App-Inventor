// Copyright 2008 Google Inc. All Rights Reserved.

package com.google.appinventor.client.editor.youngandroid.properties;

import static com.google.appinventor.client.Ode.MESSAGES;
import com.google.appinventor.client.widgets.properties.ChoicePropertyEditor;

/**
 * Property editor for menu icon.
 *
 */
public class YoungAndroidMenuIconChoicePropertyEditor extends ChoicePropertyEditor {

  // Text alignment choices
  private static final Choice[] menuIcons = new Choice[] {
    new Choice(MESSAGES.addMenuIcon(), "1"),
    new Choice(MESSAGES.agendaMenuIcon(), "2"),
    new Choice(MESSAGES.closeclearcancelMenuIcon(), "3"),
    new Choice(MESSAGES.editMenuIcon(), "4"),
    new Choice(MESSAGES.galleryMenuIcon(), "5"),
    new Choice(MESSAGES.helpMenuIcon(), "6"),
    new Choice(MESSAGES.infodetailsMenuIcon(), "7"),
    new Choice(MESSAGES.manageMenuIcon(), "8"),
    new Choice(MESSAGES.moreMenuIcon(), "9"),
    new Choice(MESSAGES.preferencesMenuIcon(), "10"),
    new Choice(MESSAGES.searchMenuIcon(), "11"),
    new Choice(MESSAGES.viewMenuIcon(), "12"),
  };

  public YoungAndroidMenuIconChoicePropertyEditor() {
    super(menuIcons);
  }
}
