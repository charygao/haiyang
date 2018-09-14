package site.haiyang.common.enumeration;

public enum EnumHost {

    wxHost("https://open.weixin.qq.com/connect/oauth2/authorize"),
    accessTokenHost("https://api.weixin.qq.com/cgi-bin/token"),
    ticketHost("https://api.weixin.qq.com/cgi-bin/ticket/getticket"),
    
    smsHost("http://gd.ums86.com:8899/sms/Api/Send.do");
    
    private String value;
    
    EnumHost(String str) {
        this.value = str;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
