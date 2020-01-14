package com.cyberorange.console.mybatis.generater;

import java.util.ArrayList;
import java.util.List;

public class Table {

	public String hash = "#";
	public String dollar = "$";
	public static final String JAVA_PACKAGE_SEPARATOR = ".";
	public static final String DIRECTORY_FILE_SEPARATOR = "/";
	private static final String[] ignoreTableName = new String[] {};

	private String mysqlTableName;
	private String mysqlTableAlias;
	private String mysqlTableComment;

	private String javaModuleName;
	private String javaCamelName;
	private String javaPascalName;

	private String javaBasePackageName;
	private String javaBasePackageDirectory;
	private String javaEntityPackageName = "entity";
	private String javaMapperPackageName = "mapper";
	private String javaMapperBasePackageName = "mapper.base";
	private String javaServicePackageName = "service";
	private String javaServiceImplPackageName = "service.impl";

	private List<String> importTypeList = new ArrayList<>();

	private List<Column> columnList = new ArrayList<>();

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getDollar() {
		return dollar;
	}

	public void setDollar(String dollar) {
		this.dollar = dollar;
	}

	public String getMysqlTableName() {
		return mysqlTableName;
	}

	public void setMysqlTableName(String mysqlTableName) {
		this.mysqlTableName = mysqlTableName;
		this.mysqlTableAlias = setIgnoreTableName(mysqlTableName);
	}

	public String getMysqlTableAlias() {
		return mysqlTableAlias;
	}

	public void setMysqlTableAlias(String mysqlTableAlias) {
		this.mysqlTableAlias = mysqlTableAlias;
	}

	public String getMysqlTableComment() {
		return mysqlTableComment == null ? "" : mysqlTableComment;
	}

	public void setMysqlTableComment(String mysqlTableComment) {
		this.mysqlTableComment = mysqlTableComment;
	}

	public String getJavaModuleName() {
		return javaModuleName;
	}

	public void setJavaModuleName(String javaModuleName) {
		this.javaModuleName = javaModuleName;
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

	public String getJavaBasePackageName() {
		return javaBasePackageName;
	}

	public void setJavaBasePackageName(String javaBasePackageName) {
		this.javaBasePackageName = javaBasePackageName;
	}

	public String getJavaBasePackageDirectory() {
		return javaBasePackageDirectory;
	}

	public void setJavaBasePackageDirectory(String javaBasePackageDirectory) {
		this.javaBasePackageDirectory = javaBasePackageDirectory;
	}

	public String getJavaEntityPackageName() {
		return javaEntityPackageName;
	}

	public void setJavaEntityPackageName(String javaEntityPackageName) {
		this.javaEntityPackageName = javaEntityPackageName;
	}

	private String getJavaPackageName(String basePackage, String moduleName, String suffixName) {
		StringBuilder sb = new StringBuilder();
		sb.append(basePackage).append(JAVA_PACKAGE_SEPARATOR);
		if (null != moduleName && !"".equals(moduleName)) {
			sb.append(moduleName).append(JAVA_PACKAGE_SEPARATOR);
		}
		sb.append(suffixName);
		return sb.toString();
	}

	public String getJavaMapperPackageName() {
		return javaMapperPackageName;
	}

	public void setJavaMapperPackageName(String javaMapperPackageName) {
		this.javaMapperPackageName = javaMapperPackageName;
	}

	public String getJavaMapperBasePackageName() {
		return javaMapperBasePackageName;
	}

	public void setJavaMapperBasePackageName(String javaMapperBasePackageName) {
		this.javaMapperBasePackageName = javaMapperBasePackageName;
	}

	public String getJavaServicePackageName() {
		return javaServicePackageName;
	}

	public void setJavaServicePackageName(String javaServicePackageName) {
		this.javaServicePackageName = javaServicePackageName;
	}

	public String getJavaServiceImplPackageName() {
		return javaServiceImplPackageName;
	}

	public void setJavaServiceImplPackageName(String javaServiceImplPackageName) {
		this.javaServiceImplPackageName = javaServiceImplPackageName;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

	public void addColumn(Column column) {
		if (null == this.columnList) {
			this.columnList = new ArrayList<>();
		}
		this.columnList.add(column);
	}

	public List<String> getImportTypeList() {
		return importTypeList;
	}

	public void setImportTypeList(List<String> importTypeList) {
		this.importTypeList = importTypeList;
	}

	public void addImportType(String importType) {
		if (importType == null || "".equals(importType)) {
			return;
		}
		if (this.importTypeList == null) {
			this.importTypeList = new ArrayList<>();
		}
		if (!this.importTypeList.contains(importType)) {
			this.importTypeList.add(importType);
		}
	}

	private void buildJavaModuleName(String mysqlTableName) {
		if (mysqlTableName == null || "".equals(mysqlTableName)) {
			return;
		}
		this.javaModuleName = mysqlTableName.toLowerCase().split("_")[0];
	}

	private void buildJavaPascalName(String mysqlTableName, String moduleName) {
		String newName = setIgnoreTableName(mysqlTableName);
		newName = setIgnoreModuleName(newName, moduleName);
		this.javaPascalName = setFirstLetterUpperCase(setUnderlineToCamel(newName));
	}

	private void buildJavaCamelName(String mysqlTableName, String moduleName) {
		String newName = setIgnoreTableName(mysqlTableName);
		newName = setIgnoreModuleName(newName, moduleName);
		this.javaCamelName = setUnderlineToCamel(newName);
	}

	public static String setIgnoreModuleName(String mysqlTableName, String moduleName) {
		if (mysqlTableName == null || "".equals(mysqlTableName.trim())) {
			return mysqlTableName;
		}
		if (moduleName == null || "".equals(moduleName.trim())) {
			return mysqlTableName;
		}
		String tableName = mysqlTableName;
		String prefixName = moduleName + "_";
		if (tableName.toLowerCase().startsWith(prefixName.toLowerCase())) {
			tableName = tableName.substring(prefixName.length());
		}
		return tableName;
	}

	public static String setIgnoreTableName(String mysqlTableName) {
		if (mysqlTableName == null || "".equals(mysqlTableName.trim())) {
			return mysqlTableName;
		}
		String newName = mysqlTableName.trim();
		for (String ignoreName : ignoreTableName) {
			newName = newName.replaceAll(ignoreName, "");
		}
		return newName;
	}

	public static String setFirstLetterUpperCase(String value) {
		if (value == null || "".equals(value.trim())) {
			return value;
		}
		char[] chars = value.toCharArray();
		if (chars[0] >= 'a' && chars[0] <= 'z') {
			chars[0] = (char) (chars[0] - 32);
		}
		return String.valueOf(chars);
	}

	/**
	 * 转换下划线之后的第一个字母为大写，并把下划线去掉
	 * 
	 * @param param
	 * @return
	 */
	public static String setUnderlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		String lowerCaseName = param.trim().toLowerCase();
		int len = lowerCaseName.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = lowerCaseName.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(lowerCaseName.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public String getJavaModuleDirectory(String rootDirectory) {
		String md = rootDirectory + "src/main/java/";
		md += this.javaBasePackageName.replaceAll("\\.", DIRECTORY_FILE_SEPARATOR);
		md += Table.DIRECTORY_FILE_SEPARATOR;
		if (null != this.javaModuleName && !"".equals(this.javaModuleName)) {
			md += this.javaModuleName;
			md += Table.DIRECTORY_FILE_SEPARATOR;
		}
		return md;
	}

	public String getJavaMapperXmlDirectory(String rootDirectory) {
		String mxd = rootDirectory + "src/main/resources/mapper/";
		return mxd;
	}

	private void buildJavaPackageName() {
		this.javaBasePackageDirectory = this.javaBasePackageName.replaceAll("\\.", DIRECTORY_FILE_SEPARATOR);
		this.javaEntityPackageName = getJavaPackageName(this.javaBasePackageName, this.javaModuleName,
				this.javaEntityPackageName);
		this.javaMapperPackageName = getJavaPackageName(this.javaBasePackageName, this.javaModuleName,
				this.javaMapperPackageName);
		this.javaMapperBasePackageName = getJavaPackageName(this.javaBasePackageName, this.javaModuleName,
				this.javaMapperBasePackageName);
		this.javaServicePackageName = getJavaPackageName(this.javaBasePackageName, this.javaModuleName,
				this.javaServicePackageName);
		this.javaServiceImplPackageName = getJavaPackageName(this.javaBasePackageName, this.javaModuleName,
				this.javaServiceImplPackageName);
	}

	public void buildAll() {
		buildJavaModuleName(this.mysqlTableAlias);
		buildJavaPascalName(this.mysqlTableAlias, this.javaModuleName);
		buildJavaCamelName(this.mysqlTableAlias, this.javaModuleName);
		buildJavaPackageName();
		buildJavaDateType();
	}

	public void buildJavaDateType() {
		if (null == this.columnList) {
			return;
		}
		for (Column column : this.columnList) {
			addImportType(column.getJavaTypeImportPackage());
		}
	}

	public static void main(String[] args) {
		Table t = new Table();
		t.setMysqlTableName("primary_login_user");
		t.setJavaBasePackageName("org.aabbc.generater");
		t.buildAll();
		System.out.println(t.getJavaMapperPackageName());
	}
}
