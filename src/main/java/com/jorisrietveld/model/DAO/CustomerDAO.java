package com.jorisrietveld.model.DAO;

import com.jorisrietveld.model.Entity.Customer;
import com.mysql.cj.api.xdevapi.Table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 22-03-2017 11:40
 * Licence: GPLv3 - General public licence version 3.
 * Teachers: Rob loves and  Winnie van Schilt
 * <p>
 * ======================================================================
 * ===               Java final assignment number: 10                 ===
 * ======================================================================
 * An short description about the project
 * ----------------------------------------------------------------------
 * An speedboat rental company wants to digitize there rental records.
 * The company owns 10 speedboats and they want to record what speedboat
 * get rented on what date, the amount of fuel that was used, the total
 * profit earned and the damage that the speedboat accumulated during
 * the speedboat rental.
 */
public class CustomerDAO extends DAO
{
    private static final ArrayList<String> COLUMNS = new ArrayList<String>()
    {{
        add("id");
        add("firstName");
        add("lastName");
        add("email");
        add("telephoneNumber");
        add("dateAdded");
        add("dateModified");
    }};

   /* public enum COLUMNS implements TableColumns
    {
        ID("id","String"),
        FIRST_NAME("firstName","String"),
        LAST_NAME("lastName","String"),
        EMAIL("email","String"),
        TELEPHONE_NUMBER("telephoneNumber","String"),
        DATE_ADDED("dateAdded","TimeStamp"),
        DATE_MODIFIED("dateModified","TimeStamp");

        private String columnName;
        private String dataType;

        Columns(String columnName, String dataType)
        {
            this.columnName = columnName;
        }

        public String getName()
        {
            return columnName;
        }

        public String getDataType()
        {
            return dataType;
        }
    }*/

    public CustomerDAO()
    {
        super(Name.CUSTOMER, COLUMNS);
    }

    public Customer createCustomerFromResultSet(ResultSet resultSet) throws Exception
    {
        return new Customer(
                resultSet.getInt("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("email"),
                resultSet.getString("telephoneNumber"),
                resultSet.getTimestamp("dateAdded"),
                resultSet.getTimestamp("dateModified")
        );
    }

    public ArrayList<Customer> createCustomersFromResultSet(ResultSet resultSet) throws Exception
    {
        ArrayList<Customer> customers=new ArrayList<>();

        while(resultSet.next())
        {
            customers.add(new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("email"),
                    resultSet.getString("telephoneNumber"),
                    resultSet.getTimestamp("dateAdded"),
                    resultSet.getTimestamp("dateModified")
            ));
        }
        return customers;
    }

    public Customer getById(int id)
    {
        try
        {
            String sqlQuery=String.format(
                    "SELECT %s FROM `%s`.`%s` WHERE id = ? ",
                    String.join(",", COLUMNS),
                    DATABASE_NAME,
                    Name.CUSTOMER
            );

            PreparedStatement statement=connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);

            ResultSet dbCustomer=statement.executeQuery();

            return createCustomerFromResultSet(dbCustomer);
        }
        catch(Exception e)
        {

        }
        return null;
    }
}
