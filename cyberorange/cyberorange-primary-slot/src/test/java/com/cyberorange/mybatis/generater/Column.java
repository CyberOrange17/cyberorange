package com.cyberorange.mybatis.generater;

public class Column {

	private String mysqlColumnName;
	private String mysqlDataType;
	private String mysqlColumnComment;

	private String javaCamelName;
	private String javaPascalName;
	private String javaType;
	private String JavaTypeImportPackage;

	public String getMysqlColumnName() {
		return mysqlColumnName;
	}

	public void setMysqlColumnName(String mysqlColumnName) {
		this.mysqlColumnName = mysqlColumnName;
		this.javaCamelName = Table.setUnderlineToCamel(mysqlColumnName);
		this.javaPascalName = Table.setFirstLetterUpperCase(this.javaCamelName);
	}

	public String getMysqlDataType() {
		return mysqlDataType;
	}

	public void setMysqlDataType(String mysqlDataType) {
		buildJavaType(mysqlDataType);
	}

	public String getMysqlColumnComment() {
		return mysqlColumnComment;
	}

	public void setMysqlColumnComment(String mysqlColumnComment) {
		this.mysqlColumnComment = mysqlColumnComment;
	}

	public String getJavaCamelName() {
		return javaCamelName;
	}

	public void setJavaCamelName(String javaCamelName) {
		this.javaCamelName = javaCamelName;
	}

	public String getJavaPascalName() {
		return javaPascalName;
	}

	public void setJavaPascalName(String javaPascalName) {
		this.javaPascalName = javaPascalName;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaTypeImportPackage() {
		return JavaTypeImportPackage;
	}

	public void setJavaTypeImportPackage(String javaTypeImportPackage) {
		JavaTypeImportPackage = javaTypeImportPackage;
	}

	private void buildJavaType(String columnType) {
		this.mysqlDataType = columnType;
		switch (columnType) {
		case "BIGINT":
			this.javaType = "Long";
			break;
		case "TEXT":
		case "LONGTEXT":
			this.mysqlDataType = "LONGVARCHAR";
		case "CHAR":
		case "VARCHAR":
		case "LONGVARCHAR":
			this.javaType = "String";
			break;
		case "DATE":
		case "DATETIME":
		case "TIMESTAMP":
			this.mysqlDataType = "TIMESTAMP";
			this.javaType = "Date";
			this.JavaTypeImportPackage = "import java.util.Date;";
			break;
		case "INTEGER":
		case "TINYINT":
		case "SMALLINT":
			this.javaType = "Integer";
			break;
		case "INT":
			this.mysqlDataType = "INTEGER";
			this.javaType = "Integer";
			break;
		case "FLOAT":
		case "DOUBLE":
		case "NUMERIC":
		case "DECIMAL":
			this.javaType = "BigDecimal";
			this.JavaTypeImportPackage = "import java.math.BigDecimal;";
			break;
		default:
			this.javaType = "String";
		}
	}
}
