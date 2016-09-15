package app.component;

import app.html.ContentContainer;
import app.html.contentContainer.Form;
import app.html.contentContainer.inputField.InputFieldContent;
import app.html.contentContainer.inputField.InputType;
import app.html.contentContainer.LabelContent;
import app.html.contentContainer.inputField.SubmitButton;

/**
 *
 * @author Matthew Lickei (mjlickei93@gmail.com)
 */
public class LoginComponent implements IComponent
{
    
    @Override
    public String render()
    {
        ContentContainer loginContainer = new ContentContainer();
        loginContainer.addClassName("login-container");
    
        InputFieldContent usernameInput = new InputFieldContent(null, "username", InputType.TEXT, "username", null);
        LabelContent usernameLabel = new LabelContent(null, null, null, "Username");
        usernameLabel.addContentContainer(usernameInput);
    
        InputFieldContent passwordInput = new InputFieldContent(null, "password", InputType.PASSWORD, "password", null);
        LabelContent passwordLabel = new LabelContent(null, null, null, "Password");
        passwordLabel.addContentContainer(passwordInput);
    
        SubmitButton loginButton = new SubmitButton(null, "submit-button", "Login");
    
        Form form = new Form(null, "login", Form.POST, "/authenticate");
        form.addContentContainer(usernameLabel);
        form.addContentContainer(passwordLabel);
        form.addContentContainer(loginButton);
    
        loginContainer.addContentContainer(form);
        
        return form.render();
    }
}
