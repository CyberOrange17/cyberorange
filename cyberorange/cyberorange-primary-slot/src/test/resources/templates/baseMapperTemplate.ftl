package ${javaMapperPackageName}.base;

import org.apache.ibatis.annotations.Mapper;

import com.cyberorange.mapper.basics.BasicsMapper;
import ${javaEntityPackageName}.${javaPascalName}Entity;

/**
 * 基础CRUD接口类
 */
@Mapper
public interface Base${javaPascalName}Mapper extends BasicsMapper<${javaPascalName}Entity>{

}