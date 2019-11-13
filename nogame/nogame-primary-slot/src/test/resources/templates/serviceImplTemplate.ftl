package ${javaServiceImplPackageName};

import com.oristartech.cim.core.service.OrstServiceImpl;
import ${javaEntityPackageName}.${javaPascalName}Entity;
import ${javaMapperPackageName}.${javaPascalName}Mapper;
import ${javaServicePackageName}.${javaPascalName}Service;

import org.springframework.stereotype.Service;

/**
 * 服务实现类
 */
@Service
public class ${javaPascalName}ServiceImpl extends OrstServiceImpl<${javaPascalName}Mapper, ${javaPascalName}Entity>
	implements ${javaPascalName}Service {

}