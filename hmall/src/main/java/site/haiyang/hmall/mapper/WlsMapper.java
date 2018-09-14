package site.haiyang.hmall.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.haiyang.hmall.model.Wls;

@Mapper
public interface WlsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wls record);

    int insertSelective(Wls record);

    Wls selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wls record);

    int updateByPrimaryKey(Wls record);
}