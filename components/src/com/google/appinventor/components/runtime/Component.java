// Copyright 2007 Google Inc. All Rights Reserved.

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentConstants;

/**
 * Interface for Simple components.
 *
 */
@SimpleObject
public interface Component {
  /**
   * Returns the dispatch delegate that is responsible for dispatching events
   * for this component.
   */
  public HandlesEventDispatching getDispatchDelegate();

  /*
   * Text alignment constants.
   */
  static final int ALIGNMENT_NORMAL = 0;
  static final int ALIGNMENT_CENTER = 1;
  static final int ALIGNMENT_OPPOSITE = 2;

  /*
   * Color constants.
   */
  static final int COLOR_NONE = 0x00FFFFFF;
  static final int COLOR_BLACK = 0xFF000000;
  static final int COLOR_BLUE = 0xFF0000FF;
  static final int COLOR_CYAN = 0xFF00FFFF;
  static final int COLOR_DKGRAY = 0xFF444444;
  static final int COLOR_GRAY = 0xFF888888;
  static final int COLOR_GREEN = 0xFF00FF00;
  static final int COLOR_LTGRAY = 0xFFCCCCCC;
  static final int COLOR_MAGENTA = 0xFFFF00FF;
  static final int COLOR_ORANGE = 0xFFFFC800;
  static final int COLOR_PINK = 0xFFFFAFAF;
  static final int COLOR_RED = 0xFFFF0000;
  static final int COLOR_WHITE = 0xFFFFFFFF;
  static final int COLOR_YELLOW = 0xFFFFFF00;
  static final int COLOR_DEFAULT = 0x00000000;

  static final String DEFAULT_VALUE_COLOR_NONE = "&H00FFFFFF";
  static final String DEFAULT_VALUE_COLOR_BLACK = "&HFF000000";
  static final String DEFAULT_VALUE_COLOR_BLUE = "&HFF0000FF";
  static final String DEFAULT_VALUE_COLOR_CYAN = "&HFF00FFFF";
  static final String DEFAULT_VALUE_COLOR_DKGRAY = "&HFF444444";
  static final String DEFAULT_VALUE_COLOR_GRAY = "&HFF888888";
  static final String DEFAULT_VALUE_COLOR_GREEN = "&HFF00FF00";
  static final String DEFAULT_VALUE_COLOR_LTGRAY = "&HFFCCCCCC";
  static final String DEFAULT_VALUE_COLOR_MAGENTA = "&HFFFF00FF";
  static final String DEFAULT_VALUE_COLOR_ORANGE = "&HFFFFC800";
  static final String DEFAULT_VALUE_COLOR_PINK = "&HFFFFAFAF";
  static final String DEFAULT_VALUE_COLOR_RED = "&HFFFF0000";
  static final String DEFAULT_VALUE_COLOR_WHITE = "&HFFFFFFFF";
  static final String DEFAULT_VALUE_COLOR_YELLOW = "&HFFFFFF00";
  static final String DEFAULT_VALUE_COLOR_DEFAULT = "&H00000000";

  /*
   * Font constants.
   */
  static final float FONT_DEFAULT_SIZE = 14;

  /*
   * Layout constants.
   */
  static final int LAYOUT_ORIENTATION_HORIZONTAL = ComponentConstants.LAYOUT_ORIENTATION_HORIZONTAL;
  static final int LAYOUT_ORIENTATION_VERTICAL = ComponentConstants.LAYOUT_ORIENTATION_VERTICAL;

  /*
   * Typeface constants.
   */
  static final int TYPEFACE_DEFAULT = 0;
  static final int TYPEFACE_SANSSERIF = 1;
  static final int TYPEFACE_SERIF = 2;
  static final int TYPEFACE_MONOSPACE = 3;

  /*
   * Length constants (for width and height).
   */
  static final int LENGTH_PREFERRED = -1;
  static final int LENGTH_FILL_PARENT = -2;
  static final int LENGTH_UNKNOWN = -3;

  /*
   * Screen direction constants.
   * Observe that opposite directions have the same magnitude but opposite signs.
   */
  static final int DIRECTION_NORTH = 1;
  static final int DIRECTION_NORTHEAST = 2;
  static final int DIRECTION_EAST = 3;
  static final int DIRECTION_SOUTHEAST = 4;
  static final int DIRECTION_SOUTH = -1;
  static final int DIRECTION_SOUTHWEST = -2;
  static final int DIRECTION_WEST = -3;
  static final int DIRECTION_NORTHWEST = -4;
  // Special values
  static final int DIRECTION_NONE = 0;
  static final int DIRECTION_MIN = -4;
  static final int DIRECTION_MAX = 4;

  // Add by Skinner
  /*
   * Menu Icon constants.
   */
  static final int MENU_ICON_ADD = 1;
  static final int MENU_ICON_AGENDA = 2;
  static final int MENU_ICON_CLOSECLEARCANCEL = 3;
  static final int MENU_ICON_EDIT = 4;
  static final int MENU_ICON_GALLERY = 5;
  static final int MENU_ICON_HELP = 6;
  static final int MENU_ICON_INFODETAILS = 7;
  static final int MENU_ICON_MANAGE = 8;
  static final int MENU_ICON_MORE = 9;
  static final int MENU_ICON_PREFERENCES = 10;
  static final int MENU_ICON_SEARCH = 11;
  static final int MENU_ICON_VIEW = 12;
}
