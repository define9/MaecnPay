import cn.com.syhu.MaecnClient;
import cn.com.syhu.pojo.MaecnConfig;
import cn.com.syhu.pojo.PayInfo;
import org.junit.Test;

public class MaecnClientTest {

    @Test
    public void pageExecute() {
        MaecnConfig config = new MaecnConfig();
        config.setNotify_url("dwadaw");
        config.setOutput("html");
        config.setPrivateKey("dwada");
        config.setUid(213);
        config.setReturn_url("dwafawf");
        MaecnClient maecnClient = new MaecnClient(config);

        PayInfo payInfo = new PayInfo();
        payInfo.setName("ddd");
        payInfo.setOut_trade_no("dasdda");
        payInfo.setMoney(23412.23f);

        System.out.println(maecnClient.pageExecute(payInfo));
    }


    @Test
    public void verify() {
        MaecnConfig config = new MaecnConfig();
        config.setNotify_url("dwadaw");
        config.setOutput("html");
        config.setPrivateKey("dwada");
        config.setUid(213);
        config.setReturn_url("dwafawf");
        MaecnClient maecnClient = new MaecnClient(config);

        PayInfo payInfo = new PayInfo();
        payInfo.setName("丝袜一条");
        payInfo.setOut_trade_no("2021122623590001");
        payInfo.setMoney(9.99f);
    }
}