package site.haiyang.hmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.haiyang.hmall.mapper.WlsMapper;
import site.haiyang.hmall.model.Wls;
import site.haiyang.hmall.service.WlsService;

import javax.annotation.Resource;

@Service("wlsService")
public class WlsServiceImpl implements WlsService {

    @Resource
    private WlsMapper wlsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Wls record) {
        return 0;
    }

    @Override
    public int insertSelective(Wls record) {
        return 0;
    }

    @Override
    public Wls selectByPrimaryKey(Integer id) {

        Wls wls = wlsMapper.selectByPrimaryKey(id);
        return wls;
    }

    @Override
    public int updateByPrimaryKeySelective(Wls record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Wls record) {
        return 0;
    }
}
