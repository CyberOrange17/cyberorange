package ${javaMapperPackageName}.base;

import org.apache.ibatis.annotations.Mapper;

import com.oristartech.cim.core.mapper.OrstMapper;
import ${javaEntityPackageName}.${javaPascalName}Entity;

/**
 * 数据库生成基础CRUD接口类
 */
@Mapper
public interface Base${javaPascalName}Mapper extends OrstMapper<${javaPascalName}Entity>{

}