package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

public class SearchPage extends ForumPageObject {
    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }
    //нЕКИЙ ЭЛЕМЕНТ который загружается последний на странице и свидетельствует о том, что страница готова
    @Override
    protected By readyLocator() {
        return null;
    }

    @Override
    public By TopLinks() {
        return null;
    }
}
