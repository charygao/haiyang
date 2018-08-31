package site.haiyang.hmall.model;

public class GGKLog {
    private Integer id;

    private String barcode;

    private Integer userId;

    private String ip;

    private Integer createTime;

    private Byte isGet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Byte getIsGet() {
        return isGet;
    }

    public void setIsGet(Byte isGet) {
        this.isGet = isGet;
    }
}