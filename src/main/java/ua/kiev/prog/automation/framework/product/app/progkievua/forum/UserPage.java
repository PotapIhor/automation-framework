package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.widgets.UserWidget;

import java.util.ArrayList;
import java.util.List;

public class UserPage extends ForumPageObject {
    @Override
    public By TopLinks() {
        return null;
    }

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("");
    }

    public UserWidget findUser (String userName){

        //Собрать все записи
        List<WebElement> list = this.driver().findElements(By.xpath("//div[@id='mlist']/table//tbody/tr"));
        List<UserWidget> usersList = new ArrayList<>();
        for (int i = 1; i <= list.size(); i ++) {
            usersList.add(new UserWidget(this.driver(), By.xpath("//div[@id='mlist']/table//tbody/tr["+i+"]")));
        }

        //найти пользователя по имени
        UserWidget resultUser = null;
        for (UserWidget user : usersList){

            if (userName.equals(user.getUserName())){
                resultUser = user;
                break;
            }
        }

        //рекурсия,если не найдено

            if (resultUser ==null){
            WebElement nextPage = this.driver().findElement(By.xpath("(//div[contains(@class, 'pagelinks')]//strong/following-sibling::a)[1]"));
            nextPage.clear();
            this.findUser(userName);
            return this.findUser(userName);
            }
   return resultUser;
    }

}
