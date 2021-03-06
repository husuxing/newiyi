/**
 * SharePreferenceUtil.java
 *
 * @version 1.0.0
 * Create at 2013-1-5 下午02:38:43
 * Copyright (c) 2012 by e_trans.
 */
package jdhe.iyibank.com.iyimeal.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;
import java.util.Map;


/**
 * 存储配置信息的工具类 <br>
 * 注：可读取的数据类型有-<code>boolean、int、float、long、String.</code>
 */
public class SharePreferenceUtil {

    private final static String FILE_NAME = "com.pigbear.comehelpme";
    private final int MODE = Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE;
    private final SharedPreferences sharedpreferences;

    public SharePreferenceUtil(Context context, String fileName) {
        sharedpreferences = context.getSharedPreferences(fileName, MODE);
    }

    public SharePreferenceUtil(Context context) {
        if (context instanceof Activity) {
            sharedpreferences = ((Activity) context).getPreferences(MODE);
        } else {
            sharedpreferences = context.getSharedPreferences(FILE_NAME, MODE);
        }
    }


    public boolean saveSharedPreferences(String key, String value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        try {
            editor.putString(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return editor.commit();
    }

    public String loadStringSharedPreference(String key, String defaultStr) {
        String str = null;
        try {
            str = sharedpreferences.getString(key, defaultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public boolean saveSharedPreferences(String key, int value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public int loadIntSharedPreference(String key) {
        return sharedpreferences.getInt(key, 0);
    }

    public boolean saveSharedPreferences(String key, float value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    public float loadFloatSharedPreference(String key) {
        return sharedpreferences.getFloat(key, 0f);
    }

    public boolean saveSharedPreferences(String key, Long value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public long loadLongSharedPreference(String key) throws Exception {
        return sharedpreferences.getLong(key, 0l);
    }

    public boolean saveSharedPreferences(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public boolean loadBooleanSharedPreference(String key) {
        return sharedpreferences.getBoolean(key, false);
    }

    public boolean saveAllSharePreference(String keyName, List<?> list) {
        int size = list.size();
        if (size < 1) {
            return false;
        }
        SharedPreferences.Editor editor = sharedpreferences.edit();
        if (list.get(0) instanceof String) {
            for (int i = 0; i < size; i++) {
                editor.putString(keyName + i, (String) list.get(i));
            }
        } else if (list.get(0) instanceof Long) {
            for (int i = 0; i < size; i++) {
                editor.putLong(keyName + i, (Long) list.get(i));
            }
        } else if (list.get(0) instanceof Float) {
            for (int i = 0; i < size; i++) {
                editor.putFloat(keyName + i, (Float) list.get(i));
            }
        } else if (list.get(0) instanceof Integer) {
            for (int i = 0; i < size; i++) {
                editor.putLong(keyName + i, (Integer) list.get(i));
            }
        } else if (list.get(0) instanceof Boolean) {
            for (int i = 0; i < size; i++) {
                editor.putBoolean(keyName + i, (Boolean) list.get(i));
            }
        }
        return editor.commit();
    }

    public Map<String, ?> loadAllSharePreference(String key) {
        return sharedpreferences.getAll();
    }

    public boolean removeKey(String key) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove(key);
        return editor.commit();
    }

    public boolean removeAllKey() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        return editor.commit();
    }

    public void setSessionId(String id) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("sessionid", id);
        editor.commit();
    }

    public String getSessionId() {
        return sharedpreferences.getString("sessionid", null);
    }

    //tokingid
    public void setTokingId(String id) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("tokingid", id);
        editor.commit();
    }

    public String getTokingId() {
        return sharedpreferences.getString("tokingid", "");
    }
}

