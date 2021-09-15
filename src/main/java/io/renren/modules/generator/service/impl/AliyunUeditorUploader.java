/**
 * projectName: renren-fast
 * fileName: AliyunUeditorUploader.java
 * packageName: io.renren.modules.generator.service
 * date: 2021-04-23 11:44
 * copyright(c) 2017-2020 xxx公司
 */
package io.renren.modules.generator.service.impl;

import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.IStorageManager;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class AliyunUeditorUploader implements IStorageManager {
    @Override
    public State saveBinaryFile(byte[] bytes, String s, String s1) {
        return null;
    }

    @Override
    public State saveFileByInputStream(InputStream inputStream, String s, String s1) {
        return null;
    }

    @Override
    public State saveFileByInputStream(InputStream inputStream, String s, String s1, long l) {
        return null;
    }
}
