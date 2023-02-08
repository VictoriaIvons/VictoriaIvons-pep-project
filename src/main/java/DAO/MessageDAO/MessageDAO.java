package DAO.MessageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Message;
import Util.ConnectionUtil;

public class MessageDAO {
    public List<Message>getAllMessages(){
        Connection connection=ConnectionUtil.getConnection();
        List<Message> messages=new ArrayList<>();
        try{
            String sql="select*from messages";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Message message=new Message(rs.getInt("message_id"),
                rs.getInt("posted_by"),
                rs.getString("message_text"),
                rs.getLong("time_posted_epoch"));
                messages.add(message);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return messages;
    }
    public Message insertMessage(Message message){
        Connection connection=ConnectionUtil.getConnection();
        try{
            String sql="insert into (message_id,posted_by,message_text,time_posted_epoch) values(?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,message.getMessage_id());
            preparedStatement.setInt(2,message.getPosted_by());
            preparedStatement.setString(3,message.getMessage_text());
            preparedStatement.setLong(4,message.getTime_posted_epoch());
            preparedStatement.executeUpdate();
            return message;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
