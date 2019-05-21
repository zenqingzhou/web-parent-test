package com.bidewu.web.common.busilog;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BusiLogEntity implements Serializable {
    public String creatorId;

    public Date createTime;

    public String updaterId;

    public Date updateTime;

    public String busiType;

    public String busiCode;
}
