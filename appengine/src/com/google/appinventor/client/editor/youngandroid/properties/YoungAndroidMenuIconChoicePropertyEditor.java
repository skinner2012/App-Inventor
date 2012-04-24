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
    new Choice(MESSAGES.accountlistMenuIcon(), "0"),
    new Choice(MESSAGES.addMenuIcon(), "1"),
    new Choice(MESSAGES.agendaMenuIcon(), "2"),
    new Choice(MESSAGES.archiveMenuIcon(), "3"),
    new Choice(MESSAGES.attachmentMenuIcon(), "4"),
    new Choice(MESSAGES.closeclearcancelMenuIcon(), "5"),
    new Choice(MESSAGES.composeMenuIcon(), "6"),
    new Choice(MESSAGES.editMenuIcon(), "7"),
    new Choice(MESSAGES.galleryMenuIcon(), "8"),
    new Choice(MESSAGES.helpMenuIcon(), "9"),
    new Choice(MESSAGES.infodetailsMenuIcon(), "10"),
    new Choice(MESSAGES.manageMenuIcon(), "11"),
    new Choice(MESSAGES.moreMenuIcon(), "12"),
    new Choice(MESSAGES.notificationsMenuIcon(), "13"),
    new Choice(MESSAGES.preferencesMenuIcon(), "14"),
    new Choice(MESSAGES.searchMenuIcon(), "15"),
    new Choice(MESSAGES.starMenuIcon(), "16"),
    new Choice(MESSAGES.viewMenuIcon(), "17"),
  };

  public YoungAndroidMenuIconChoicePropertyEditor() {
    super(menuIcons);
  }
}
