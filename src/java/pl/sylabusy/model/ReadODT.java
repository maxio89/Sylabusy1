/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sylabusy.model;

import org.odftoolkit.simple.TextDocument;

/**
 *
 * @author Piotrek
 */
public class ReadODT {
    
    public void loadDocument() throws Exception {
        
        TextDocument odtDoc = TextDocument.loadDocument("C:/in.odt");
        
    }
    
}
