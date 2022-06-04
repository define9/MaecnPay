package cn.com.syhu.controller;

import cn.com.syhu.MaecnClient;
import cn.com.syhu.pojo.PayInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    MaecnClient client;

    @GetMapping(value = "/demo")
    public String demo(float sale, String out_trade_no){
        if (client == null)
            return "client为null";
        PayInfo payInfo = new PayInfo();
        payInfo.setMoney(sale);
        payInfo.setName("dd");
        payInfo.setOut_trade_no(out_trade_no);
        payInfo.setType("ali");
        return client.pageExecute(payInfo);
    }

    @GetMapping(value = "/back")
    public String callbak(PayInfo payInfo, String sign, String trade_no, String time, String status) {
        boolean v = client.verify(payInfo, sign, trade_no, time, status);
        return "SUCCESS";
    }

    @GetMapping(value = "/")
    public String root(){
        return "你好";
    }
}
