package com.xxf.arch.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.xxf.annotation.Router;
import com.xxf.arch.test.R;
import com.xxf.arch.activity.XXFActivity;
import com.xxf.arch.annotation.BindVM;
import com.xxf.arch.annotation.BindView;
import com.xxf.arch.test.databinding.ActivityTestBinding;
import com.xxf.arch.viewmodel.XXFViewModel;

import java.util.Arrays;

/**
 * @author youxuan  E-mail:youxuan@icourt.cc
 * @version 2.3.1
 * @Description
 * @Company Beijing icourt
 * @date createTime：2018/9/9
 */
@Router(path = "/user/test")
@BindView(R.layout.activity_test)
@BindVM(XXFViewModel.class)
public class TestActivity extends XXFActivity {
    BaseFragmentAdapter baseFragmentAdapter;
    ActivityTestBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("==========>act1:", "" + this);
        super.onCreate(savedInstanceState);
        Log.d("==========>act2:", "" + this);
        binding = getBinding();
        baseFragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager());
        binding.pager.setAdapter(baseFragmentAdapter);
        baseFragmentAdapter.bindData(true, Arrays.asList(new TestFragment(), new TestFragment(), new TestFragment()));


        findViewById(R.id.bt_setResult)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();
                        intent.putExtra("data", "hello 2019");
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }
                });
//        Observable.interval(1, TimeUnit.MILLISECONDS)
//                .compose(XXF.<Long>bindUntilEvent(this, Lifecycle.Event.ON_PAUSE))
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.d("========>data:", "" + aLong);
//                    }
//                });

    }

    @Override
    protected void onStop() {
        Log.d("=========>", "onStop1");
        super.onStop();
        Log.d("=========>", "onStop2");
    }

    @Override
    protected void onPause() {
        Log.d("=========>", "onPause1");
        super.onPause();
        Log.d("=========>", "onPause2");
    }

    @Override
    protected void onDestroy() {
        Log.d("=========>", "onDestroy1");
        super.onDestroy();
        Log.d("=========>", "onDestroy2");
    }
}