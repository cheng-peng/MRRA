package debug;

import com.cxp.lib_common.base.BaseApplication;

/**
 * 文 件 名: MainApplication
 * 创 建 人: CXP
 * 创建日期: 2018-05-25 17:05
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MainApplication extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }

    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {

    }
}
