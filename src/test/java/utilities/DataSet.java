package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidUserCredentials")
    public static Object invalidCredentials (){
        Object[][] data = {
                {"fameloh253@chysir.com", "Pass&Pass", "Your email or password is incorrect!", ""},
                {"fameloh253@chys.com", "Pass&Pass", "Your email or password is incorrect!", ""},
                {"fameloh253@chys.com", "Pass&Pass!", "Your email or password is incorrect!", ""},
                {"", "", "", "Please fill out this field."},
                {"fameloh253@chysir.com", "", "", "Please fill out this field."}
        };
        return data;
    }
}