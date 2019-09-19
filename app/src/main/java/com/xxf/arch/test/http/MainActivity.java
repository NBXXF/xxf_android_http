package com.xxf.arch.test.http;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonObject;
import com.xxf.arch.http.XXFHttp;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

public class MainActivity extends Activity {

    private void deleteDir(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                deleteDir(file);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("==========>act1:", "" + this);
        super.onCreate(savedInstanceState);
        Log.d("==========>act2:", "" + this);
        setContentView(R.layout.activity_main);


        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d("========>error:", Log.getStackTraceString(throwable));
            }
        });
        findViewById(R.id.bt_clear)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        File file = new File(BaseApplication.getInstance().getCacheDir(), "okHttpCache");
                        deleteDir(file);
                    }
                });
        findViewById(R.id.bt_test)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XXFHttp.getApiService(LoginApiService.class)
                                .getCity()
                                // .take(1)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<JsonObject>() {
                                    @Override
                                    public void accept(JsonObject jsonObject) throws Exception {
                                        Log.d("======>", "" + jsonObject);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.d("======>", "err:" + throwable);
                                    }
                                });
                    }
                });
        findViewById(R.id.bt_test_first_cache)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XXFHttp.getApiService(LoginApiService.class)
                                .getCityFirstCache()
                                // .take(1)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<JsonObject>() {
                                    @Override
                                    public void accept(JsonObject jsonObject) throws Exception {
                                        Log.d("======>", "" + jsonObject);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.d("======>", "err:" + throwable);
                                    }
                                });
                    }
                });
        findViewById(R.id.bt_test_first_remote)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XXFHttp.getApiService(LoginApiService.class)
                                .getCityFirstRemote()
                                // .take(1)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<JsonObject>() {
                                    @Override
                                    public void accept(JsonObject jsonObject) throws Exception {
                                        Log.d("======>", "" + jsonObject);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.d("======>", "err:" + throwable);
                                    }
                                });
                    }
                });
        findViewById(R.id.bt_test_only_cache)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XXFHttp.getApiService(LoginApiService.class)
                                .getCityOnlyCache()
                                // .take(1)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<JsonObject>() {
                                    @Override
                                    public void accept(JsonObject jsonObject) throws Exception {
                                        Log.d("======>", "" + jsonObject);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.d("======>", "err:" + throwable);
                                    }
                                });
                    }
                });
        findViewById(R.id.bt_test_if_cache)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        XXFHttp.getApiService(LoginApiService.class)
                                .getCityIfCache()
                                // .take(1)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<JsonObject>() {
                                    @Override
                                    public void accept(JsonObject jsonObject) throws Exception {
                                        Log.d("======>", "" + jsonObject);
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        Log.d("======>", "err:" + throwable);
                                    }
                                });
                    }
                });
    }

}
