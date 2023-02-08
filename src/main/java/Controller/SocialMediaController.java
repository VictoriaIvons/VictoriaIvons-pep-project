package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.javalin.Javalin;
import io.javalin.http.Context;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */ 
 
  public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.get("example-endpoint", this::exampleHandler);

        app.post("register", this::postRegisterNewHandler);
        app.post("login",this::postLoginHandler);
        app.post("messages",this::postCreateMessageHandler);
        app.get("messages",this::getAllMessagesHandler);
        app.get("messages/{message_id}",this::getMessageByIdHandler);
        app.delete("messages/{message_id}",this::deleteMessageByIdHandler);
        app.patch("messages/{message_id}",this::patchMessageByIdHandler);
        app.get("messages/{account_id}",this::getMessageByAccountIdHandler);
        
        private void postAccountsHandler(Context ctx)throws JsonProcessingException{
            ObjectMapper mapper=new ObjectMapper();
            Account account=mapper.readValue(ctx.body(),Account.class);
            Account addedAccount=accountService.addAccount(account);
            if(addedAccount==null){
                ctx.status(400);
            }else{
                ctx.json(mapper.writeValueAsString(account));
            }
            private void getAllAccountsHandler(Context context){
            context.json("accounts");
        }
            private void postMessagesHandler(Context ctx)throws JSONProcessingexception{
                Object mapper=new ObjectMapper();
                Message message=mapper.readValue(ctx.body(),Message.class);
                Message addedMessage=messageService.addMessage(message);
                if(addedMessage==null){
                    ctx.status(400);
                }else{
                    ctx.json(mapper.WriteValueAsString(message));
                }
            } 
            private void getAllMessagesHandler(Context context){
            context.json("messages");
        }
        }
        
       
       
       
        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }


}
    
    
    


        
    


