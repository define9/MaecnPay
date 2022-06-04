package cn.com.syhu.config;

import cn.com.syhu.MaecnClient;
import cn.com.syhu.pojo.MaecnConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayConfig {
    @Value("${payInfo.uid}")
    private int uid;

    @Value("${payInfo.notify_url}")
    private String notify_url;

    @Value("${payInfo.return_url}")
    private String return_url;

    @Value("${payInfo.output}")
    private String output;

    @Value("${payInfo.privateKey}")
    private String privateKey;

    @Bean
    public MaecnClient maecnClient(){
        MaecnConfig maecnConfig = new MaecnConfig();
        maecnConfig.setUid(uid);
        maecnConfig.setNotify_url(notify_url);
        maecnConfig.setReturn_url(return_url);
        maecnConfig.setOutput(output);
        maecnConfig.setPrivateKey(privateKey);

        return new MaecnClient(maecnConfig);
    }
}
