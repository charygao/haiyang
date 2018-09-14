package site.haiyang.hmall.service;

import site.haiyang.hmall.model.Wls;

public interface WlsService {
    int deleteByPrimaryKey(Integer id);

    int insert(Wls record);

    int insertSelective(Wls record);

    Wls selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wls record);

    int updateByPrimaryKey(Wls record);
}