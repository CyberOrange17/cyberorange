package ${javaFacadeImplPackageName};

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.oristartech.cim.core.facade.OrstFacadeImpl;
import ${javaEntityPackageName}.${javaPascalName}Entity;
import ${javaServicePackageName}.${javaPascalName}Service;
import ${javaFacadePackageName}.${javaPascalName}Facade;

/**
 * 服务实现类
 */
@Component
@Service(interfaceClass=${javaPascalName}Facade.class,version="1.0.0")
public class ${javaPascalName}FacadeImpl extends OrstFacadeImpl<${javaPascalName}Service, ${javaPascalName}Entity>
	implements ${javaPascalName}Facade {

}