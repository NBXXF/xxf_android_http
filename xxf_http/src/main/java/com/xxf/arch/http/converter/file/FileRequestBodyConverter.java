package com.xxf.arch.http.converter.file;

import com.xxf.arch.http.RequestUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.MultipartBody;
import retrofit2.Converter;

/**
 * @author youxuan  E-mail:xuanyouwu@163.com
 * @Description 文件file 支持 直接传递form
 */
public class FileRequestBodyConverter<T extends File> implements Converter<T, MultipartBody.Part> {


    @Override
    public MultipartBody.Part convert(T file) throws IOException {
        return MultipartBody.Part.create(RequestUtils.createFileBody(file));
    }
}