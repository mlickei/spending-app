package app.component;

import app.html.ContentContainer;
import app.html.contentContainer.Form;
import app.html.contentContainer.inputField.InputFieldContent;
import app.html.contentContainer.inputField.InputType;
import app.html.contentContainer.LabelContent;
import app.html.contentContainer.inputField.SubmitButton;

/**
 * @author Matthew Lickei (mjlickei93@gmail.com)
 */
public class CreateAccountComponent implements IComponent
{
    
    @Override
    public String render()
    {
        ContentContainer accountContainer = new ContentContainer();
        accountContainer.addClassName("account-container");
    
        InputFieldContent usernameInput = new InputFieldContent(null, "username", InputType.TEXT, "username", null);
        LabelContent usernameLabel = new LabelContent(null, null, null, "Username");
        usernameLabel.addContentContainer(usernameInput);
    
        InputFieldContent passwordInput = new InputFieldContent(null, "password", InputType.PASSWORD, "password", null);
        LabelContent passwordLabel = new LabelContent(null, null, null, "Password");
        passwordLabel.addContentContainer(passwordInput);
    
        InputFieldContent emailInput = new InputFieldContent(null, "email", InputType.EMAIL, "email", null);
        LabelContent emailLabel = new LabelContent(null, null, null, "Email");
        emailLabel.addContentContainer(emailInput);
    
        SubmitButton submitButton = new SubmitButton(null, "submit-button", "Submit");
    
        Form form = new Form(null, "create-account", Form.POST, "/user/authenticate-new");
        form.addContentContainer(usernameLabel);
        form.addContentContainer(passwordLabel);
        form.addContentContainer(emailLabel);
        form.addContentContainer(submitButton);
    
        accountContainer.addContentContainer(form);
        return accountContainer.render();
    }
}
