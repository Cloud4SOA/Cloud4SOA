/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.server;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.extjs.gxt.samples.client.FileService;
import com.extjs.gxt.samples.client.examples.model.FileModel;
import com.extjs.gxt.samples.client.examples.model.FolderModel;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.RemoteSortTreeLoadConfig;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class FileServiceImpl extends RemoteServiceServlet implements FileService {

  private File root;
  private FilenameFilter filter;
  private HashMap<File, String> idMap = new HashMap<File, String>();
  private int counter = 0;

  public FileServiceImpl() {
    URL rootUrl = getClass().getClassLoader().getResource("com/extjs");
    try {
      // %20 will be converted to a space
      root = new File(rootUrl.toURI());
    } catch (URISyntaxException e) {
      // fallback
      root = new File(rootUrl.getFile());
    }
    filter = new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return !name.startsWith(".");
      }
    };
  }

  public List<FileModel> getFolderChildren(FileModel folder) {
    File[] files = null;
    if (folder == null) {
      files = root.listFiles(filter);
    } else {
      File f = new File(folder.getPath());
      files = f.listFiles(filter);
    }

    List<FileModel> models = new ArrayList<FileModel>();
    for (File f : files) {
      FileModel m = null;
      if (f.isDirectory()) {
        m = new FolderModel(f.getName(), f.getAbsolutePath());
      } else {
        m = new FileModel(f.getName(), f.getAbsolutePath());
        m.set("size", f.length());
        m.set("date", new Date(f.lastModified()));
      }

      if (idMap.containsKey(f)) {
        m.set("id", idMap.get(f));
      } else {
        String id = String.valueOf(counter++);
        idMap.put(f, id);
        m.set("id", id);
      }

      models.add(m);
    }

    Collections.sort(models, new Comparator<FileModel>() {
      public int compare(FileModel o1, FileModel o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
    return models;
  }

  public List<FileModel> getFolderChildren(final RemoteSortTreeLoadConfig loadConfig) {
    List<FileModel> models = getFolderChildren((FileModel) loadConfig.getParent());
    final String prop = loadConfig.getSortField();
    final boolean desc = loadConfig.getSortDir() == SortDir.DESC;
    if (prop != null) {
      Collections.sort(models, new Comparator<FileModel>() {
        @SuppressWarnings({"unchecked", "rawtypes"})
        public int compare(FileModel o1, FileModel o2) {
          boolean m1Folder = o1 instanceof FolderModel;
          boolean m2Folder = o2 instanceof FolderModel;

          if (m1Folder && !m2Folder) {
            return -1;
          } else if (!m1Folder && m2Folder) {
            return 1;
          }

          Comparable v1 = o1.get(prop);
          Comparable v2 = o2.get(prop);
          if (v1 == null && v2 != null) {
            return -1;
          } else if (v1 != null && v2 == null) {
            return 0;
          } else if (v1 == null && v2 == null) {
            return o1.getName().compareTo(o2.getName());
          }
          return desc ? v2.compareTo(v1) : v1.compareTo(v2);
        }
      });
    }

    return models;
  }

}
