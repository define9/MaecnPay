package cn.com.syhu.pojo;

import lombok.Data;

@Data
public class MaecnConfig {
    private int uid;

    private String notify_url;

    private String return_url;

    private String output;

    private String privateKey;
}
