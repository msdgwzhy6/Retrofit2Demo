package com.LeiHolmes.retrofit2demo.support;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * description: Converter.Factory converter which uses Fastjson for JSON.
 * author： dongyeforever@gmail.com
 * date: 2016-04-26 14:01
 */
public class FastjsonConverterFactory extends Converter.Factory {

    private Charset charset;
    private static final Charset UTF_8  = Charset.forName("UTF-8");

    public static FastjsonConverterFactory create() {
        return create(UTF_8);
    }

    public static FastjsonConverterFactory create(Charset charset) {
        return new FastjsonConverterFactory(charset);
    }

    public FastjsonConverterFactory(Charset charset) {
        this.charset = charset;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new FastjsonRequestBodyConverter<>(type, charset);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FastjsonResponseBodyConverter<>(type, charset);
    }
}
