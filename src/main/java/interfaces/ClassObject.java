package interfaces;

import utilities.ReadJson;
import pageobjects.*;


public interface ClassObject {

    SignInWeb signIn = new SignInWeb();
    SignUpWeb signUp = new SignUpWeb();
    ArticleWeb article = new ArticleWeb();
    ReadJson readJson = new ReadJson();

}
