package cloud.test1.model.view;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Null;

public class UserDTO {

    private Long id;

    @NotBlank
    private String name;

    //@Null  次对象必须为null
    private Integer sex;

    private Integer age;

    @NotBlank
    private String desc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
