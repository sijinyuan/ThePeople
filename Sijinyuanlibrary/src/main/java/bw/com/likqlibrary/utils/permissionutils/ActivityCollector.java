package bw.com.likqlibrary.utils.permissionutils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class ActivityCollector {

    private static final List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static List<Activity> getActivitylist() {
        if (activityList != null && activityList.size() > 0) {
            return activityList;
        }else {
            return null;
        }
    }

    public static void removeActivity(Activity activity) {

        activityList.remove(activity);
    }

    public static Activity getTopActivity() {
        if (activityList.isEmpty()) {
            return null;
        } else {
            return activityList.get(activityList.size() - 1);
        }
    }


}
