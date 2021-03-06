// Copyright 2008 Google Inc. All Rights Reserved.

package com.google.appinventor.shared.rpc.project;

/**
 * Describes a file (using its project and file IDs) and its content.
 *
 */
public final class FileDescriptorWithContent extends FileDescriptor {

  // For serialization
  private static final long serialVersionUID = 957689430802334457L;

  // File content
  private String content;

  /**
   * Default constructor (for serialization only).
   * Unfortunately this will prevent any fields from being marked as final!
   */
  @SuppressWarnings("unused")
  private FileDescriptorWithContent() {
  }

  /**
   * Creates a new descriptor for a file and its content.
   *
   * @param projectId  project ID
   * @param fileId  file ID
   * @param content  file content
   */
  public FileDescriptorWithContent(long projectId, String fileId, String content) {
    super(projectId, fileId);
    this.content = content;
  }

  /**
   * Returns the content of the associated file.
   *
   * @return  file content
   */
  public String getContent() {
    return content;
  }
}
