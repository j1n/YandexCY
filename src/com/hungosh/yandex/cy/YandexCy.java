/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hungosh.yandex.cy;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author jin
 */
public class YandexCy {
    public YandexCy(){
        
    }
    
    public Integer getCy(String domain) throws ParserConfigurationException, IOException, SAXException{
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document rDoc = db.parse("http://bar-navig.yandex.ru/u?ver=2&show=32&url=http://"+domain);
         rDoc.getDocumentElement().normalize();
           NodeList nList = rDoc.getElementsByTagName("tcy");
           for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               Element eElement = (Element) nNode;
                   return Integer.parseInt(eElement.getAttribute("value"));
           }
        return 0;
    }
}
