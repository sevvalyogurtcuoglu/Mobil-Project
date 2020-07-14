import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder( this)
        .applicationId("KuhhfNwP8irFebb644h9AAIpitN6YtpeRN9mbMDp")
        .clientKey("L2kEJi92EdZM9nKxoh8OXWie9hqeQ4A2LAgS5Lwz")
        .server("https://parseapi.back4app.com/")
        .build());

    }
}
