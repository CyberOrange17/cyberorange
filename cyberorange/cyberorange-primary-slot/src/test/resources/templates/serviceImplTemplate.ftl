package ${javaServiceImplPackageName};

import com.cyberorange.service.basics.impl.BasicsServiceImpl;
import ${javaEntityPackageName}.${javaPascalName}Entity;
import ${javaMapperPackageName}.${javaPascalName}Mapper;
import ${javaServicePackageName}.${javaPascalName}Service;

import org.springframework.stereotype.Service;

/**
 * 服务实现类
 */
@Service
public class ${javaPascalName}ServiceImpl extends BasicsServiceImpl<${javaPascalName}Mapper, ${javaPascalName}Entity>
	implements ${javaPascalName}Service {

}