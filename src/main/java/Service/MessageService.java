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
    String message_text=message.getMessage_text();
    if(!message_text.isBlank()&& message_text.length()<255){
        return messageDAO.insertMessage(message);
    }else{
        return null;
    }
    
}


public Message updateById(Message message, int message_id) {

    if(message.message_text.length()>255 || message.message_text =="")
     {
        return null;
        
     }
     messageDAO.updateMessageById(message, message_id);
     return this.messageDAO.getMessageById(message_id);
     
}
public Message deleteById(int message_id) {
    Message message=messageDAO.getMessageById(message_id);
    messageDAO.deleteMessageById(message_id);
    if(message==null){
        return null;
    }return message;
    }


public List<Message> getMessageByAccountId(int posted_by) {
    return messageDAO.getMessageByAccountId(posted_by);
}

public Message getMessageById(int message_id) {
    return messageDAO.getMessageById(message_id);
}


}

