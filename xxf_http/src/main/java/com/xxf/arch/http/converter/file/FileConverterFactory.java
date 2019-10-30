package com.xxf.arch.http.converter.file;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author youxuan  E-mail:xuanyouwu@163.com
 * @Description 直接传递文件
 */
public class FileConverterFactory extends Converter.Factory {
    public static FileConverterFactory create() {
        return new FileConverterFactory();
    }

    private FileConverterFactory() {

    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        Class<?> rawType = getRawType(type);
        if (rawType == File.class) {
            return new FileRequestBodyConverter();
        }
        //解析不了,返回null
        return null;
    }

}