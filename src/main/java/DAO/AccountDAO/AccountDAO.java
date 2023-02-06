package DAO.AccountDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Account;
import Util.ConnectionUtil;



public class AccountDAO{
    public List<Account>getAccountAuthorization(){
        Connection connection=ConnectionUtil.getConnection();
        List<Account>accounts=new ArrayList<>();
    try{
        String sql="get*from account";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet rs=preparedStatement.executeQuery();
        while(rs.next()){
            Account account=new Account(rs.getInt("account_id"),
            rs.getString("username"),
            rs.getString("password"));
            accounts.add(account);
    }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return accounts;
}
}