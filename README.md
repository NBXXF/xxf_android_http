# xxf http架构
##### 快速使用
 ```
    api 'com.github.NBXXF:xxf_android_http:2.4.0'
    
    implementation 'io.reactivex.rxjava2:rxjava:2.2.8'
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.google.code.gson:gson:2.8.2'
    
  ```
 
     
##### http请求
      ``` 1. http接口interface声明（与retrofit十分类似)
      @BaseUrl(com.tokentm.businesscard.config.BuildConfig.API_URL) //必选;baseurl 为retrofit的基础路由,比如:http://www.baidu.com/
      @Interceptor({TokenInterceptor.class})  //可选;拦截器 继承自okhttp3.Interceptor
      @GsonInterceptor(GlobalGsonConvertInterceptor.class) //可选; json或者gson转换拦截器 继承自com.xxf.arch.http.converter.gson.GsonConvertInterceptor
      public interface BackupApiService {
      
      
       @GET("config/question")
       Observable<ResponseDTO<List<SecurityQuestionDTO>>> backupUpConfigQuestionQuery();
       
       
       }
       
   ```
   
   
         ```2. api 请求方式,并绑定loading对话框
       XXF.getApiService(BackupApiService.class)
                .backupUpConfigQuestionQuery()
                .map(new ResponseDTOSimpleFunction<List<SecurityQuestionDTO>>())
                .compose(XXF.<List<SecurityQuestionDTO>>bindToProgressHud(new ProgressHUDTransformerImpl.Builder(this)))//绑定progress loadingdialog
                .subscribe(new Consumer<List<SecurityQuestionDTO>>() {
                    @Override
                    public void accept(List<SecurityQuestionDTO> securityQuestionDTOS) throws Exception {
                     
                    }
                });
   ```