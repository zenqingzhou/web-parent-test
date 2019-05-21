package com.bidewu.web.common.utils.upload;

import lombok.Data;

/**
 * @author WuShoulei on 2018/3/15
 */
@Data
public class ImageUpload {

    /**
     * 图片url（可查看路径）
     */
    private String imgUrl;

    /**
     * 文件名
     */
    private String fileName;

//    /**
//     * 图片Base64编码
//     */
//    private String base64Img;
}
