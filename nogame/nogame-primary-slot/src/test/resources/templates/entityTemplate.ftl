package ${javaEntityPackageName};

import java.io.Serializable;
<#list importTypeList as typeString>
${typeString}
</#list>

/**
 * ${mysqlTableComment}
 */
public class ${javaPascalName}Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	<#list columnList as column>

	/**
	 * ${column.mysqlColumnComment}
	 */
    private ${column.javaType} ${column.javaCamelName};
	</#list>
	<#list columnList as column>

    public ${column.javaType} get${column.javaPascalName}() {
        return ${column.javaCamelName};
    }

    public void set${column.javaPascalName}(${column.javaType} ${column.javaCamelName}) {
        this.${column.javaCamelName} = ${column.javaCamelName};
    }
	</#list>
}