package Controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;
import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    AccountService accountService;
    MessageService messageService;

    public SocialMediaController(){
        this.accountService=new AccountService();
        this.messageService=new MessageService();

    }
    
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.get("example-endpoint", this::exampleHandler);
        app.post("/register",this::postRegisterNewHandler);
       app.post("/login",this::postLoginHandler);
      app.post("/messages", this::postCreateMessageHandler);
        app.get("/messages", this::getAllMessageHandler);
        app.get("/messages/{message_id}",this::getMessageByIdHandler);
        app.delete("/messages/{message_id}",this::deleteMessageByIdHandler);
        app.patch("/messages/{message_id}",this::UpdateMessageByIdHandler);
        app.get("/messages/{account_id}/messages",this::getMessageByAccountIdHandler);

        return app;
    }
    private void postRegisterNewHandler(Context ctx) throws JsonProcessingException{
        ObjectMapper mapper=new ObjectMapper();
        Account account=mapper.readValue(ctx.body(),Account.class);
        Account addedAccount=accountService.CreateNewUsers(account);
        if(addedAccount!=null){
            ctx.json(mapper.writeValueAsString(addedAccount));
        }else{
            ctx.status(400);
        }
    }
    private void postLoginHandler(Context ctx)throws JsonProcessingException{
       ObjectMapper mapper=new ObjectMapper();
       Account account=mapper.readValue(ctx.body(),Account.class);
       Account postLogin=accountService.retrieveId(account.getUsername(), account.getPassword());
       if(postLogin!=null){
     
        ctx.json(mapper.writeValueAsString(postLogin));
       }else{
        ctx.status(401);
       }
   }
    private void postCreateMessageHandler(Context ctx)throws JsonProcessingException{
       ObjectMapper mapper=new ObjectMapper();
       Message message=mapper.readValue(ctx.body(),Message.class);
       Message addedMessage=messageService.addMessage(message);
       if(addedMessage!=null){
        ctx.json(mapper.writeValueAsString(addedMessage));
        //ctx.status(200);
       }else{
        ctx.status(400);
       }
   }
    private void getAllMessageHandler(Context ctx){
       List<Message>messages=messageService.getAllMessages();
       ctx.json(messages);
    }
    private void getMessageByIdHandler(Context ctx)throws JsonProcessingException{
       //ObjectMapper mapper=new ObjectMapper();
        Message retreivedMessage = messageService.getMessageById(Integer.parseInt(ctx.pathParam("message_id")));
               if(retreivedMessage==null){
            ctx.status(200);
            return;        
        }
        ctx.json(retreivedMessage);
    }

   private void UpdateMessageByIdHandler(Context ctx)throws JsonProcessingException{
        ObjectMapper mapper=new ObjectMapper();
        Message message=mapper.readValue(ctx.body(),Message.class);
        int message_id=Integer.parseInt(ctx.pathParam("message_id"));
        Message messages=messageService.updateById(message,message_id);
        if(messages==null || message.message_text.isBlank()){
            ctx.status(400);
           
        }else{
        ctx.json(messages);
        }
    }
    private void deleteMessageByIdHandler(Context ctx)throws JsonProcessingException{
       Message deleteMessage = messageService.deleteById(Integer.parseInt(ctx.pathParam("message_id")));
       
       if(deleteMessage==null){
        ctx.status(200);
    
    }else{
        
        ctx.json(deleteMessage);
    }
}
    private void getMessageByAccountIdHandler(Context ctx)throws JsonProcessingException{
    
        int account_id = Integer.parseInt(ctx.pathParam("account_id"));
       List<Message> messagelist=messageService.getMessageByAccountId(account_id);
     
        ctx.json(messagelist);
     }
       
    
    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }


}
    
    


        
    


