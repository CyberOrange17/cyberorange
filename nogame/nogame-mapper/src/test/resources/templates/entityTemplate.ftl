package ${javaEntityPackageName};

import java.io.Serializable;
<#list importTypeList as typeString>
${typeString}
</#list>

import com.oristartech.cim.core.mybatis.OrstTableName;
import com.oristartech.cim.core.mybatis.OrstTableColumn;

/**
 * ${mysqlTableComment}
 */
@OrstTableName("${mysqlTableAlias}")
public class ${javaPascalName}Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	<#list columnList as column>

	/**
	 * ${column.mysqlColumnComment}
	 */
	@OrstTableColumn("${column.mysqlColumnName}")
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ${javaPascalName}Entity other = (${javaPascalName}Entity) that;
        return (
	        <#list columnList as column>
	        <#if column_index = 0>
	        (this.get${column.javaPascalName}() == null ? other.get${column.javaPascalName}() == null : this.get${column.javaPascalName}().equals(other.get${column.javaPascalName}()))
			<#else>
			&& (this.get${column.javaPascalName}() == null ? other.get${column.javaPascalName}() == null : this.get${column.javaPascalName}().equals(other.get${column.javaPascalName}()))
			</#if>
			</#list>
        	);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        <#list columnList as column>
        result = prime * result + ((get${column.javaPascalName}() == null) ? 0 : get${column.javaPascalName}().hashCode());
        </#list>
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        <#list columnList as column>
		sb.append(", ${column.javaCamelName}=").append(${column.javaCamelName});
		</#list>
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    
	<#list columnList as column>
	//${column.mysqlColumnComment}
    public static final String ${column.mysqlColumnName} = "${column.mysqlColumnName}";
    
	</#list>
}