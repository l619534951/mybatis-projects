package cn.zzs.mybatis.mapper;

import static cn.zzs.mybatis.mapper.MenuDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.zzs.mybatis.entity.Menu;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface MenuMapper {
    BasicColumn[] selectList = BasicColumn.columnList(id, parentId, name, order, url, isParent, deleted, gmtCreate, gmtModified);

    /**
     * @param selectStatement
     * @return long
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    /**
     * @param deleteStatement
     * @return int
     */
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
     * @param insertStatement
     * @return int
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Menu> insertStatement);

    /**
     * @param multipleInsertStatement
     * @return int
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Menu> multipleInsertStatement);

    /**
     * @param selectStatement
     * @return Optional<Menu>
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MenuResult")
    Optional<Menu> selectOne(SelectStatementProvider selectStatement);

    /**
     * @param selectStatement
     * @return List<Menu>
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MenuResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="order", property="order", jdbcType=JdbcType.TINYINT),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_parent", property="isParent", jdbcType=JdbcType.BIT),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Menu> selectMany(SelectStatementProvider selectStatement);

    /**
     * @param updateStatement
     * @return int
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
     * @param completer
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, menu, completer);
    }

    /**
     * @param completer
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, menu, completer);
    }

    /**
     */
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     */
    default int insert(Menu record) {
        return MyBatis3Utils.insert(this::insert, record, menu, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(name).toProperty("name")
            .map(order).toProperty("order")
            .map(url).toProperty("url")
            .map(isParent).toProperty("isParent")
            .map(deleted).toProperty("deleted")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModified).toProperty("gmtModified")
        );
    }

    /**
     */
    default int insertMultiple(Collection<Menu> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, menu, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(name).toProperty("name")
            .map(order).toProperty("order")
            .map(url).toProperty("url")
            .map(isParent).toProperty("isParent")
            .map(deleted).toProperty("deleted")
            .map(gmtCreate).toProperty("gmtCreate")
            .map(gmtModified).toProperty("gmtModified")
        );
    }

    /**
     */
    default int insertSelective(Menu record) {
        return MyBatis3Utils.insert(this::insert, record, menu, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(order).toPropertyWhenPresent("order", record::getOrder)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(isParent).toPropertyWhenPresent("isParent", record::getIsParent)
            .map(deleted).toPropertyWhenPresent("deleted", record::getDeleted)
            .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
            .map(gmtModified).toPropertyWhenPresent("gmtModified", record::getGmtModified)
        );
    }

    /**
     * @param completer
     */
    default Optional<Menu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, menu, completer);
    }

    /**
     * @param completer
     */
    default List<Menu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, menu, completer);
    }

    /**
     * @param completer
     */
    default List<Menu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, menu, completer);
    }

    /**
     */
    default Optional<Menu> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @param completer
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, menu, completer);
    }

    /**
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Menu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(parentId).equalTo(record::getParentId)
                .set(name).equalTo(record::getName)
                .set(order).equalTo(record::getOrder)
                .set(url).equalTo(record::getUrl)
                .set(isParent).equalTo(record::getIsParent)
                .set(deleted).equalTo(record::getDeleted)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModified).equalTo(record::getGmtModified);
    }

    /**
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Menu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(name).equalToWhenPresent(record::getName)
                .set(order).equalToWhenPresent(record::getOrder)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(isParent).equalToWhenPresent(record::getIsParent)
                .set(deleted).equalToWhenPresent(record::getDeleted)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(record::getGmtModified);
    }

    /**
     */
    default int updateByPrimaryKey(Menu record) {
        return update(c ->
            c.set(parentId).equalTo(record::getParentId)
            .set(name).equalTo(record::getName)
            .set(order).equalTo(record::getOrder)
            .set(url).equalTo(record::getUrl)
            .set(isParent).equalTo(record::getIsParent)
            .set(deleted).equalTo(record::getDeleted)
            .set(gmtCreate).equalTo(record::getGmtCreate)
            .set(gmtModified).equalTo(record::getGmtModified)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
     */
    default int updateByPrimaryKeySelective(Menu record) {
        return update(c ->
            c.set(parentId).equalToWhenPresent(record::getParentId)
            .set(name).equalToWhenPresent(record::getName)
            .set(order).equalToWhenPresent(record::getOrder)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(isParent).equalToWhenPresent(record::getIsParent)
            .set(deleted).equalToWhenPresent(record::getDeleted)
            .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
            .set(gmtModified).equalToWhenPresent(record::getGmtModified)
            .where(id, isEqualTo(record::getId))
        );
    }
}