package ${javaEntityPackageName};

import java.io.Serializable;
import lombok.Data;
<#list importTypeList as typeString>
${typeString}
</#list>

/**
 * ${mysqlTableComment}
 */
@Data
public class ${javaPascalName}Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	<#list columnList as column>

	/**
	 * ${column.mysqlColumnComment}
	 */
    private ${column.javaType} ${column.javaCamelName};
	</#list>
}