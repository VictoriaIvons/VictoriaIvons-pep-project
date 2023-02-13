package Service;

import java.util.List;

import DAO.MessageDAO.MessageDAO;
import Model.Message;

public class MessageService {
    public MessageDAO messageDAO;

public MessageService(){
    messageDAO=new MessageDAO();
}
public MessageService(MessageDAO messageDAO){
    this.messageDAO=messageDAO;
}
public List<Message>getAllMessages(){
    return messageDAO.getAllMessages();
}
public Message addMessage(Message message){
    if(messageDAO.getMessageById(message.getMessage_id())==null){
        return messageDAO.insertMessage(message);
    }
    return null;
}


public Message updateById(Message message, int message_id) {
     if(messageDAO.getMessageById(message_id)!=null){
        return messageDAO.updateMessageById(message,message_id);
    
     }return null;
   
}
public Message deleteById(int message_id) {
    Message message=messageDAO.getMessageById(message_id);
    messageDAO.deleteMessageById(message_id);
    if(message==null){
        return null;
    }return message;
    }


public List<Message> getMessageByAccountId(int message_id,int account_id) {
    return messageDAO.getMessageByAccountId(message_id,account_id);
}
public Message getMessageById(int message_id) {
    return messageDAO.getMessageById(message_id);
}


}

