package cloud.test1.domain.entity;


import org.springframework.data.annotation.Id;


public class HomeBanner {

    @Id
    private String id;

    private String name;

    private String url;

    private Integer status;

    private String desc;

    public HomeBanner() {
    }

    public HomeBanner(String name, String url, Integer status, String desc) {
        this.name = name;
        this.url = url;
        this.status = status;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HomeBanner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
