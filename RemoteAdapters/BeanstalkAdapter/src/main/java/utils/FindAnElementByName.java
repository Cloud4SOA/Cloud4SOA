/*
 * Copyright [2013] [Cloud4SOA, www.cloud4soa.eu]
 *
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;


//import com.sun.xml.internal.ws.util.xml.XmlUtil;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class FindAnElementByName {


   // public static void findFromfile( String xml_string,String elemname )  throws Exception{
    public static void findFromString( String xml_string,String elemname )  throws Exception{
    // create an input source for target document and parse it


        //na katargi8ei auto
        InputSource is = new InputSource( xml_string );
        //InputSource is = new InputSource( "resources\\personal.xml" );

    
    //Document d = XmlUtil.getDocument( is );
    Document d = (Document) XmlUtil.getDocument( is );
     //   Text d = new Text() {}
        // get all tags in the document with the name email
    NodeList emails = d.getElementsByTagName( elemname );
    for( int i = 0; i < emails.getLength(); i++ ) {
    // for every email tag
    Element person = (Element) emails.item( i );
    
    // print out the text value.  note that we have to get the value of
    // first child of the email element which is a text node
    System.out.println( person.getFirstChild().getNodeValue() );
    }
    }

}
