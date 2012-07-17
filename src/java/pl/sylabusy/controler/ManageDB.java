/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sylabusy.controler;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;
import pl.sylabusy.model.ReadAll;
import pl.sylabusy.model.ReadODT;

/**
 *
 * @author piotrek
 */
@ManagedBean(name = "users")
@SessionScoped
public class ManageDB implements Serializable {

    @Resource(name = "myPoolPostgres")
    private DataSource ds;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public ManageDB() throws Exception {
    }

    public List<ReadAll> getUsersList() throws SQLException, Exception {

        if (ds == null) {
            throw new SQLException("Can't get data source");
        }

        //get database connection
        Connection con = ds.getConnection();

        if (con == null) {
            throw new SQLException("Can't get database connection");
        }

        PreparedStatement ps = con.prepareStatement(
                "select * from users");

        //get customer data from database
        ResultSet result = ps.executeQuery();

        List<ReadAll> list = new ArrayList<>();

        while (result.next()) {
            ReadAll cust = new ReadAll();

            cust.setUserName(result.getString("username"));

            cust.setPassword(result.getString("password"));


            //store all data into a List
            list.add(cust);
        }

        ReadODT readodt = new ReadODT();
        readodt.loadDocument();

        return list;

    }
}
