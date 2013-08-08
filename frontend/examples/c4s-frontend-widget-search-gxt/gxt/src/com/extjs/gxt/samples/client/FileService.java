/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client;

import java.util.List;

import com.extjs.gxt.samples.client.examples.model.FileModel;
import com.extjs.gxt.ui.client.data.RemoteSortTreeLoadConfig;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Example <code>RemoteService</code>.
 */
@RemoteServiceRelativePath("fileservice")
public interface FileService extends RemoteService {

  /**
   * Returns the children of the given parent.
   * 
   * @param folder the parent folder
   * @return the children
   */
  public List<FileModel> getFolderChildren(FileModel folder);

  /**
   * Returns the children of the given parent.
   * 
   * @param loadConfig the load config
   * @return the children
   */
  public List<FileModel> getFolderChildren(RemoteSortTreeLoadConfig loadConfig);

}
