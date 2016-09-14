package app.controller;

import app.html.contentContainer.Form;
import app.html.contentContainer.InputFieldContent;
import app.resource.css.CSSProvider;
import app.service.ApplicationService;
import app.html.ContentContainer;
import app.html.contentContainer.InputType;
import app.html.contentContainer.LabelContent;
import app.html.contentContainer.inputField.SubmitButton;
import org.springframework.web.servlet.ModelAndView;

/**
 * The login page controller. Used to render the login page along with it's specific resource files.
 */
public class Login extends Controller
{

    public Login(ApplicationService applicationService, ModelAndView modelAndView)
    {
        super(applicationService, modelAndView);
    }

    /**
     * Init is used to generate all the necessary html and resources for the current application service
     * @return The updated application service with the html and resources included.
     */
    @Override
    public ApplicationService init()
    {
        ApplicationService applicationService = getApplicationService();

        //Generate header information and add resources
        getResourceManager().addResource(CSSProvider.BASE_STYLES);
        getResourceManager().addResource(CSSProvider.LOGIN_PAGE);

        //Create body content
        ContentContainer bodyContainer = new ContentContainer();
        bodyContainer.setId("main-content");

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
        bodyContainer.addContentContainer(loginContainer);

        applicationService.setBodyContent(bodyContainer.render());
        return applicationService;
    }

}
