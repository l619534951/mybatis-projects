package cn.zzs.mybatis.mapper;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class DepartmentDynamicSqlSupport {
    public static final Department department = new Department();

    /**
     * <p>部门id</p>
     */
    public static final SqlColumn<String> id = department.id;

    /**
     * <p>部门编码</p>
     */
    public static final SqlColumn<String> no = department.no;

    /**
     * <p>上级部门id</p>
     */
    public static final SqlColumn<String> parentId = department.parentId;

    /**
     * <p>部门名称</p>
     */
    public static final SqlColumn<String> name = department.name;

    /**
     * <p>部门类型 department部门，group小组</p>
     */
    public static final SqlColumn<String> type = department.type;

    /**
     * <p>记录是否删除</p>
     */
    public static final SqlColumn<Boolean> deleted = department.deleted;

    /**
     * <p>记录创建时间</p>
     */
    public static final SqlColumn<Date> gmtCreate = department.gmtCreate;

    /**
     * <p>记录更新时间</p>
     */
    public static final SqlColumn<Date> gmtModified = department.gmtModified;

    public static final class Department extends SqlTable {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> no = column("no", JDBCType.VARCHAR);

        public final SqlColumn<String> parentId = column("parent_id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("type", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> deleted = column("deleted", JDBCType.BIT);

        public final SqlColumn<Date> gmtCreate = column("gmt_create", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> gmtModified = column("gmt_modified", JDBCType.TIMESTAMP);

        public Department() {
            super("demo_department");
        }
    }
}