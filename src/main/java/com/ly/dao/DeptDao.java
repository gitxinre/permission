package com.ly.dao;

import com.ly.entity.po.DeptPO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author xinre
 */
public interface DeptDao {


    void saveDept(DeptPO deptPO);

    @UpdateProvider(type = DeptDaoProvider.class, method = "updatDeptById")
    void updatDeptById(DeptPO deptPO);


    @ResultMap("deptResultMap")
    @Select("select * from demo_dept")
    List<DeptPO> listDept();



    ///////////////////////////////////////////////

    /**
     * 特殊sql拼接
     */
    class DeptDaoProvider {
        public String updatDeptById(DeptPO deptPO) {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE demo_dept SET");
            sql.append(" operate_time_ = #{operateTime},");
            sql.append(" operate_ip_ = #{operateIp},");
            if (StringUtils.isNotBlank(deptPO.getRemark()))
                sql.append(" remark_ = #{remark},");
            if (deptPO.getOrderId() != 0)
                sql.append(" seq_ = #{orderId},");
            if (deptPO.getLevel() != 0)
                sql.append(" level_ = #{level},");
            if (StringUtils.isNotBlank(deptPO.getPId()))
                sql.append(" parent_id_ = #{pId},");
            if (StringUtils.isNotBlank(deptPO.getName())) {
                sql.append(" name_ = #{name},");
                sql.append(" name_head_char_ = #{nameHeadChar},");
            }
            sql.append(" operator_ = #{operator}");
            sql.append(" where");
            sql.append(" id_ = #{id}");
            return sql.toString();
        }
    }
}
