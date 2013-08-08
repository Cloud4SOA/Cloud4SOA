/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client;

import java.util.List;

import com.extjs.gxt.samples.client.examples.model.BeanPost;
import com.extjs.gxt.samples.client.examples.model.Photo;
import com.extjs.gxt.samples.client.examples.model.Post;
import com.extjs.gxt.samples.resources.client.model.Customer;
import com.extjs.gxt.samples.resources.client.model.Stock;
import com.extjs.gxt.ui.client.data.FilterPagingLoadConfig;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExampleServiceAsync {
  public void getPosts(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Post>> callback);

  public void getBeanPosts(PagingLoadConfig config, AsyncCallback<PagingLoadResult<BeanPost>> callback);

  public void getCustomers(AsyncCallback<List<Customer>> callback);

  public void getPhotos(AsyncCallback<List<Photo>> callback);

  public void getLiveGridModels(PagingLoadConfig config, AsyncCallback<PagingLoadResult<ModelData>> callback);

  public void getStocks(FilterPagingLoadConfig config, AsyncCallback<PagingLoadResult<Stock>> callback);
}
