/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sylabusy.model;

import java.util.List;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.odfdom.dom.element.table.TableTableElement;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.text.Paragraph;

/**
 *
 * @author Piotrek
 */
public class ReadODT {
    
    public void loadDocument() throws Exception {
        
        TextDocument odtDoc = TextDocument.loadDocument("C:/Sylabusy/PWSZ-ZI (Semestr 1, Algebra liniowa).odt");
        
        Paragraph aaa = odtDoc.getParagraphByIndex(2, true);
        
        List<Table> tables = odtDoc.getTableList();
        
        
        TableTableElement el;
        //el = (TableTableElement)tables.get(0);
        Table tab = tables.get(0);
        Cell cl = tab.getCellByPosition(0, 0);
        //TableTableElement el = (TableTableElement)tables.;
        
        //System.out.println(aaa.getTextContent() + " - " + tables.size() + tab.getRowCount() + tab.getColumnCount() + cl.getStringValue());
        System.out.println(tables.size() + " - " + tab.getRowCount() + " - " + tab.getColumnCount() + " - " + cl.getStringValue());
        
    }
    
}
