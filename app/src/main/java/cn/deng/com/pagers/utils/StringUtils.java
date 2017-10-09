package cn.deng.com.pagers.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/**
 * Created by lenovo on 2017/9/30.
 */

public class StringUtils {
    /**
     * 替换字符串
     *
     * @param context 上下文
     * @param resId   资源ID
     * @param obj     任意对象
     * @return 替换后的字符串
     */
    public static String formatString(Context context, int resId, Object obj) {
        String str = context.getResources().getString(resId);
        return String.format(str, obj);
    }


    /**
     * 字符串截取变色
     *
     * @param color   颜色字符
     * @param string3 你要变色的字符，可为null
     * @param string2 你要变色的字符
     * @param string  整个字符串
     */
    public static SpannableStringBuilder stringInterceptionChangeRed(
            String string, String string2, String string3, String color) {
        int fstart = string.indexOf(string2);
        int fend = fstart + string2.length();
        SpannableStringBuilder style = new SpannableStringBuilder(string);
        if (!"".equals(string3) && string3 != null) {
            int bstart = string.indexOf(string3);
            int bend = bstart + string3.length();
            style.setSpan(new ForegroundColorSpan(Color.parseColor(color)), bstart, bend,
                    Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }

        style.setSpan(new ForegroundColorSpan(Color.parseColor(color)), fstart, fend,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return style;

    }
}