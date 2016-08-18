package com.example.scxh.myapp;

import java.io.InputStream;
import java.util.List;

/**
 * Created by scxh on 2016/7/27.
 */
public interface BookParse{
    public List<book> parse(InputStream is) throws Exception;
    public String serialize(List<book> books) throws Exception;
}
