package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

public class HelpPage extends ForumPageObject {
    private By _goToHelpPage = By.xpath("//div[@class='user_block']//a[contains(@href,'action=login')]");

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    //нЕКИЙ ЭЛЕМЕНТ который загружается последний на странице и свидетельствует о том, что страница готова
    @Override
    protected By readyLocator() {
        return By.xpath("//*[@id=\"button_help\"]/a/span");
    }


    final public LoginPage getLoginPage()
    {
        // Нажимаем ссылку "войдите", локатор определён в приватном свойстве _goToLoginPage
        this.component().session().driver().findElement(_goToHelpPage).click();
        // Возвращаем объект страницы входа
        return new LoginPage();
    }

    @Override
    public By TopLinks(){

        return null;
    }
    }

  /* final public MainPageLoggedIn login (String _help)
    {
        _help.concat(_help);

        System.out.println(_username.getValue());
        System.out.println(_password.getValue());



        _loginBtn.click();

        return new MainPageLoggedIn();
    }



}*/
