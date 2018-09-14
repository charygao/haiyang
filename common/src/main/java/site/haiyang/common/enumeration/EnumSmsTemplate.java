package site.haiyang.common.enumeration;

public enum EnumSmsTemplate {

//    valiCode("您的登陆验证码为x请在10分钟内使用!");
    valiCode("您的登录验证码为x，请在10分钟内使用。【双喜积分平台】");
    private String value;
    
    private EnumSmsTemplate(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    

}
