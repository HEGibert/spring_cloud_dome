package cloud.test1.dao;

import cloud.test1.model.WxRole;

public interface WxRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxRole record);

    int insertSelective(WxRole record);

    WxRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxRole record);

    int updateByPrimaryKey(WxRole record);
}