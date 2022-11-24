package DataHelper;

import models.User;

public class UserPool {

    public static User validUser() {
        return new User("Asddasdaasd@Dasd.com", "1234qwe");
        //Builder pattern
    }

    public static User failUser() {
        return new User("Asddasdaasd@Dasd.com", "1234qwedas");
    }

    public static User failUserWithoutPassword() {
        return new User("Asddasdaasd@Dasd.com", "");
    }
}
