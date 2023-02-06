package Controller;

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
        private void handleMessage(Context context){
            context.json("Handler");
        }
       app.post("localhost8080/register", this::handleMessage(Register));
        app.post("localhost8080/login", this::handleMessage(Login));
        app.post("localhost8080/messages",this::handleMessage(Message));
        app.get("localhost8080/messages",this::handleMessage(Message));
        app.get("localhost8080/messages",this::handleMessage(Message_Id));
        app.delete("localhost8080/messages", this::handleMessage(Message_Id));
        app.patch("localhost8080/messages",this::handleMessage(Message_Id));


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