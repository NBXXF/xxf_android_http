
package com.xxf.arch.utils;

import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import java.util.Objects;

/**
 * fragment工具类
 *
 * @author wuyouxuan
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class FragmentUtils {

    /**
     * 添加fragment
     *
     * @param fragmentManager
     * @param fragment
     * @param containerViewId
     */
    public static Fragment addFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, @IdRes int containerViewId) {
        Objects.requireNonNull(fragment, "fragment is null");
        Objects.requireNonNull(fragmentManager, "fragmentManager is null");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(containerViewId, fragment);
        transaction.commitAllowingStateLoss();
        return fragment;
    }

    /**
     * 添加fragment
     *
     * @param fragmentManager
     * @param fragment
     * @param tag
     */
    public static Fragment addFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, String tag) {
        Objects.requireNonNull(fragment, "fragment is null");
        Objects.requireNonNull(fragmentManager, "fragmentManager is null");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment, tag);
        transaction.commitAllowingStateLoss();
        return fragment;
    }


    /**
     * 显示隐藏碎片
     *
     * @param fragmentManager
     * @param containerViewId
     * @param from
     * @param to
     */
    public static Fragment switchFragment(FragmentManager fragmentManager, @IdRes int containerViewId, @Nullable Fragment from, @NonNull Fragment to) {
        Objects.requireNonNull(fragmentManager, "fragmentManager is null");
        Objects.requireNonNull(to, "to fragment is null");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先判断是否被add过
        if (!to.isAdded()) {
            if (from == null) {
                transaction
                        .add(containerViewId, to)
                        .commitAllowingStateLoss();
            } else {
                transaction
                        .hide(from)
                        .add(containerViewId, to)
                        .commitAllowingStateLoss();
            }
        } else {
            transaction
                    .hide(from)
                    .show(to)
                    .commitAllowingStateLoss();
        }
        return to;
    }

}
