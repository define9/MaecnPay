package cn.com.syhu;

import cn.com.syhu.pojo.MaecnConfig;
import cn.com.syhu.pojo.PayInfo;
import cn.com.syhu.utils.HttpUtil;
import cn.com.syhu.utils.MD5Util;

import java.util.Objects;

public class MaecnClient {

    private final static String domain = "https://pay.maecn.com/pay/api";

    private final MaecnConfig maecnConfig;

    private final StringBuilder genSign = new StringBuilder();

    public MaecnClient(MaecnConfig config) {
        this.maecnConfig = config;

        genSign.append("notify_url=").append(config.getNotify_url());
        genSign.append("&return_url=").append(config.getReturn_url());
        genSign.append("&uid=").append(config.getUid());
        if (!config.getOutput().isEmpty())genSign.append("&output=").append(config.getOutput());
    }

    public String pageExecute(PayInfo payInfo) {
        StringBuilder urlParams = new StringBuilder();
        urlParams.append(genSign)
                .append("&money=").append(payInfo.getMoney())
                .append("&name=").append(payInfo.getName())
                .append("&type=").append(payInfo.getType())
                .append("&out_trade_no=").append(payInfo.getOut_trade_no());

        String sign = MD5Util.md5Lower(urlParams + maecnConfig.getPrivateKey());
        urlParams.append("&sign=").append(sign);

        return HttpUtil.get(domain + "?" + urlParams);
    }

    public boolean verify(PayInfo payInfo, String sign, String trade_no, String time, String status) {
        String params = "out_trade_no=" + payInfo.getOut_trade_no() +
                "&trade_no=" + trade_no +
                "&uid=" + maecnConfig.getUid() +
                "&type=" + payInfo.getType() +
                "&name=" + payInfo.getName() +
                "&money=" + String.format("%.2f", payInfo.getMoney());
        if (time != null && !time.isEmpty()) params += "&time=" + time;
        if (status != null && !status.isEmpty()) params += "&status=" + status;
        params += maecnConfig.getPrivateKey();
        return Objects.requireNonNull(MD5Util.md5Lower(params)).equals(sign.toLowerCase());
    }
}
