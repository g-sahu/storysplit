package com.gsapps.storysplit.util;

import android.content.Context;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.support.v4.content.ContextCompat.checkSelfPermission;

public class AppUtils {

    public static boolean hasPermission(Context context, String permission) {
        return checkSelfPermission(context, permission) == PERMISSION_GRANTED;
    }
}
