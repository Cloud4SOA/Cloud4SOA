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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.extjs.gxt.samples.client.ExampleService;
import com.extjs.gxt.samples.client.examples.model.BeanPost;
import com.extjs.gxt.samples.client.examples.model.Photo;
import com.extjs.gxt.samples.client.examples.model.Post;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Customer;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.FilterConfig;
import com.extjs.gxt.ui.client.data.FilterPagingLoadConfig;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService {

  private List<Post> posts;
  private List<BeanPost> beanPosts;
  private List<Photo> photos;
  private List<ModelData> liveGridModels;
  private List<Stock> stocks;

  public List<Photo> getPhotos() {
    if (photos == null) {
      loadPhotos();
    }
    return photos;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public PagingLoadResult<BeanPost> getBeanPosts(PagingLoadConfig config) {
    if (beanPosts == null) {
      loadPosts();
    }
    if (config.getSortInfo().getSortField() != null) {
      final String sortField = config.getSortInfo().getSortField();
      if (sortField != null) {
        Collections.sort(beanPosts, config.getSortInfo().getSortDir().comparator(new Comparator() {
          public int compare(Object o1, Object o2) {
            BeanPost p1 = (BeanPost) o1;
            BeanPost p2 = (BeanPost) o2;
            if (sortField.equals("forum")) {
              return p1.getForum().compareTo(p2.getForum());
            } else if (sortField.equals("username")) {
              return p1.getUsername().compareTo(p2.getUsername());
            } else if (sortField.equals("subject")) {
              return p1.getSubject().compareTo(p2.getSubject());
            } else if (sortField.equals("date")) {
              return p1.getDate().compareTo(p2.getDate());
            }
            return 0;
          }
        }));
      }
    }

    ArrayList<BeanPost> sublist = new ArrayList<BeanPost>();
    int start = config.getOffset();
    int limit = beanPosts.size();
    if (config.getLimit() > 0) {
      limit = Math.min(start + config.getLimit(), limit);
    }
    for (int i = config.getOffset(); i < limit; i++) {
      sublist.add(beanPosts.get(i));
    }
    return new BasePagingLoadResult<BeanPost>(sublist, config.getOffset(), beanPosts.size());
  }

  public List<Customer> getCustomers() {
    List<Customer> customers = new ArrayList<Customer>();
    customers.add(new Customer("Darrell", "darrell@foo.com", 1));
    customers.add(new Customer("Maro", "maro@foo.com", 2));
    customers.add(new Customer("Alec", "alec@foo.com", 3));
    customers.add(new Customer("Lia", "lia@foo.com", 4));
    return customers;
  }

  public PagingLoadResult<ModelData> getLiveGridModels(final PagingLoadConfig config) {
    try {
      if (liveGridModels == null) {
        liveGridModels = new ArrayList<ModelData>(500000);
        for (int i = 0; i < 500000; i++) {
          ModelData m = new BaseModel();
          m.set("a", "a " + i);
          m.set("b", "b " + i);
          m.set("c", "c " + i);
          liveGridModels.add(m);
        }

      }
      ArrayList<ModelData> sublist = new ArrayList<ModelData>();
      int start = config.getOffset();
      int limit = liveGridModels.size();
      if (config.getLimit() > 0) {
        limit = Math.min(start + config.getLimit(), limit);
      }
      List<ModelData> copy = new ArrayList<ModelData>(liveGridModels);
      if (config.getSortField() != null) {
        Collections.sort(copy, new Comparator<ModelData>() {
          @SuppressWarnings({"unchecked", "rawtypes"})
          public int compare(ModelData m1, ModelData m2) {
            Object o1 = m1.get(config.getSortField());
            Object o2 = m2.get(config.getSortField());
            if (o1 == null || o2 == null) {
              if (o1 == null && o2 == null) {
                return 0;
              } else {
                return (o1 == null) ? -1 : 1;
              }
            }
            if (o1 instanceof Comparable) {
              return ((Comparable) o1).compareTo(o2);
            }
            return ((String) o1).toLowerCase().compareTo(((String) o2).toLowerCase());
          }
        });
        if (config.getSortDir().equals(SortDir.DESC)) {
          Collections.reverse(copy);
        }
      }
      for (int i = config.getOffset(); i < limit; i++) {
        sublist.add(copy.get(i));
      }

      return new BasePagingLoadResult<ModelData>(sublist, start, copy.size());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public PagingLoadResult<Post> getPosts(final PagingLoadConfig config) {
    if (posts == null) {
      loadPosts();
    }

    if (config.getSortInfo().getSortField() != null) {
      final String sortField = config.getSortInfo().getSortField();
      if (sortField != null) {
        Collections.sort(posts, config.getSortInfo().getSortDir().comparator(new Comparator<Post>() {
          public int compare(Post p1, Post p2) {
            if (sortField.equals("forum")) {
              return p1.getForum().compareTo(p2.getForum());
            } else if (sortField.equals("username")) {
              return p1.getUsername().compareTo(p2.getUsername());
            } else if (sortField.equals("subject")) {
              return p1.getSubject().compareTo(p2.getSubject());
            } else if (sortField.equals("date")) {
              return p1.getDate().compareTo(p2.getDate());
            }
            return 0;
          }
        }));
      }
    }

    ArrayList<Post> sublist = new ArrayList<Post>();
    int start = config.getOffset();
    int limit = posts.size();
    if (config.getLimit() > 0) {
      limit = Math.min(start + config.getLimit(), limit);
    }
    for (int i = config.getOffset(); i < limit; i++) {
      sublist.add(posts.get(i));
    }
    return new BasePagingLoadResult<Post>(sublist, config.getOffset(), posts.size());
  }

  private String getValue(NodeList fields, int index) {
    NodeList list = fields.item(index).getChildNodes();
    if (list.getLength() > 0) {
      return list.item(0).getNodeValue();
    } else {
      return "";
    }
  }

  private void loadPhotos() {
    photos = new ArrayList<Photo>();

    String url = getThreadLocalRequest().getSession().getServletContext().getRealPath("/samples/images/photos");
    // %20 will be converted to a space
    File folder = new File(url);

    File[] pics = folder.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return !name.startsWith(".");
      }
    });
    Arrays.sort(pics, new Comparator<File>() {
      public int compare(File o1, File o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });

    for (File pic : pics) {
      Photo photo = new Photo();
      photo.setName(pic.getName());
      photo.setDate(new Date(pic.lastModified()));
      photo.setSize(pic.length());
      photo.setPath("samples/images/photos/" + pic.getName());
      photos.add(photo);
    }
  }

  private void loadPosts() {
    posts = new ArrayList<Post>();
    beanPosts = new ArrayList<BeanPost>();

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(getClass().getResourceAsStream("posts.xml"));
      doc.getDocumentElement().normalize();

      NodeList nodeList = doc.getElementsByTagName("row");

      for (int s = 0; s < nodeList.getLength(); s++) {
        Node fstNode = nodeList.item(s);
        if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
          Element fstElmnt = (Element) fstNode;
          NodeList fields = fstElmnt.getElementsByTagName("field");
          Post p = new Post();
          p.setForum(getValue(fields, 0));
          p.setDate(sf.parse(getValue(fields, 1)));
          p.setSubject(getValue(fields, 2));
          p.setUsername(getValue(fields, 4));
          posts.add(p);

          BeanPost beanPost = new BeanPost();
          beanPost.setForum(getValue(fields, 0));
          beanPost.setDate(sf.parse(getValue(fields, 1)));
          beanPost.setSubject(getValue(fields, 2));
          beanPost.setUsername(getValue(fields, 4));
          beanPosts.add(beanPost);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public PagingLoadResult<Stock> getStocks(FilterPagingLoadConfig config) {
    if (stocks == null) {
      stocks = TestData.getStocks();
    }

    if (config.getSortInfo().getSortField() != null) {
      final String sortField = config.getSortInfo().getSortField();
      if (sortField != null) {
        Collections.sort(stocks, config.getSortInfo().getSortDir().comparator(new Comparator() {
          public int compare(Object o1, Object o2) {
            Stock s1 = (Stock) o1;
            Stock s2 = (Stock) o2;

            if (sortField.equals("name")) {
              return s1.getName().compareTo(s2.getName());
            } else if (sortField.equals("symbol")) {
              return s1.getSymbol().compareTo(s2.getSymbol());
            }
            return 0;
          }
        }));
      }
    }
    ArrayList<Stock> temp = new ArrayList<Stock>();
    ArrayList<Stock> remove = new ArrayList<Stock>();
    for (Stock s : stocks) {
      temp.add(s);
    }

    List<FilterConfig> filters = config.getFilterConfigs();
    for (FilterConfig f : filters) {
      Object ov = f.getValue();
      String c = f.getComparison();
      for (Stock s : stocks) {
        Object value = s.get(f.getField());
        if (f.isFiltered(s, ov, c, value)) {
          remove.add(s);
        }
      }
    }

    for (Stock s : remove) {
      temp.remove(s);
    }

    ArrayList<Stock> sublist = new ArrayList<Stock>();
    int start = config.getOffset();
    int limit = temp.size();
    if (config.getLimit() > 0) {
      limit = Math.min(start + config.getLimit(), limit);
    }
    for (int i = config.getOffset(); i < limit; i++) {
      sublist.add(temp.get(i));
    }
    return new BasePagingLoadResult<Stock>(sublist, config.getOffset(), temp.size());
  }

}
