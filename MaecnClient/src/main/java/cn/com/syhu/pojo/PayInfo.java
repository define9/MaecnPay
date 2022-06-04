package cn.com.syhu.pojo;

import lombok.Data;

@Data
public class PayInfo {
    private String out_trade_no;

    private String type;

    private String name;

    private float money;
}
