package top.fomeiherz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fomeiherz.entity.InterfaceLimit;
import top.fomeiherz.mapper.InterfaceLimitMapper;
import top.fomeiherz.service.InterfaceLimitService;

@Service
public class InterfaceLimitServiceImpl implements InterfaceLimitService {

    @Autowired
    private InterfaceLimitMapper interfaceLimitMapper;

    @Override
    public InterfaceLimit getEntityByPri(Integer id) {
        return interfaceLimitMapper.selectByPrimaryKey(id);
    }

}
