package top.fomeiherz.mapper;

import org.apache.ibatis.annotations.Param;
import top.fomeiherz.entity.InterfaceLimit;
import top.fomeiherz.entity.InterfaceLimitExample;

import java.util.List;

public interface InterfaceLimitMapper {
    int countByExample(InterfaceLimitExample example);

    int deleteByExample(InterfaceLimitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceLimit record);

    int insertSelective(InterfaceLimit record);

    List<InterfaceLimit> selectByExample(InterfaceLimitExample example);

    InterfaceLimit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterfaceLimit record, @Param("example") InterfaceLimitExample example);

    int updateByExample(@Param("record") InterfaceLimit record, @Param("example") InterfaceLimitExample example);

    int updateByPrimaryKeySelective(InterfaceLimit record);

    int updateByPrimaryKey(InterfaceLimit record);
}
