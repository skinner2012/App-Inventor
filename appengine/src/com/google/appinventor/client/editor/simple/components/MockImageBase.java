// Copyright 2009 Google Inc. All Rights Reserved.
// TODO(user): reconsider visibilities of the abstract base classes in this package

package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.appinventor.client.output.OdeLog;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Abstract superclass for MockImage and MockImageSprite.
 *
 * @author lizlooney@google.com (Liz Looney)
 */
abstract class MockImageBase extends MockVisibleComponent {
  // Property names
  private static final String PROPERTY_NAME_PICTURE = "Picture";

  // Widget for showing the image.
  private final Image image;
  private String picturePropValue;

  MockImageBase(SimpleEditor editor, String type, ImageResource icon) {
    super(editor, type, icon);

    // Initialize mock image UI
    image = new Image();
    image.addErrorHandler(new ErrorHandler() {
      @Override
      public void onError(ErrorEvent event) {
        if (picturePropValue != null && !picturePropValue.isEmpty()) {
          OdeLog.elog("Error occurred while loading image " + picturePropValue);
        }
        refreshForm();
      }
    });
    image.addLoadHandler(new LoadHandler() {
      @Override
      public void onLoad(LoadEvent event) {
        refreshForm();
      }
    });
    SimplePanel simplePanel = new SimplePanel();
    simplePanel.setStylePrimaryName("ode-SimpleMockComponent");
    simplePanel.setWidget(image);
    initComponent(simplePanel);
  }

  /*
   * Sets the image's url to a new value.
   */
  private void setPictureProperty(String text) {
    picturePropValue = text;
    String url = convertImagePropertyValueToUrl(text);
    if (url == null) {
      // text was not recognized as an asset. Just display the icon for this type of component.
      Image iconImage = getIconImage();
      image.setUrlAndVisibleRect(iconImage.getUrl(),
          iconImage.getOriginLeft(), iconImage.getOriginTop(),
          iconImage.getWidth(), iconImage.getHeight());
    } else {
      image.setUrl(url);
    }
  }

  @Override
  public int getPreferredWidth() {
    // The superclass uses getOffsetWidth, which won't work for us.
    return image.getWidth();
  }

  @Override
  public int getPreferredHeight() {
    // The superclass uses getOffsetHeight, which won't work for us.
    return image.getHeight();
  }

  // PropertyChangeListener implementation

  @Override
  public void onPropertyChange(String propertyName, String newValue) {
    super.onPropertyChange(propertyName, newValue);

    // Apply changed properties to the mock component
    if (propertyName.equals(PROPERTY_NAME_PICTURE)) {
      setPictureProperty(newValue);
      refreshForm();
    }
  }
}
