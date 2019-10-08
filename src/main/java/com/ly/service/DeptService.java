package com.ly.service;

import com.ly.entity.dto.DeptDTO;
import com.ly.entity.po.DeptPO;
import com.ly.entity.pojo.TreeNode;

import java.util.List;

/**
 * @author xinre
 */
public interface DeptService {

    void saveDept(DeptDTO deptDTO);

    List<TreeNode> listDeptTree();

    List<DeptPO> listDept();

    void updatDeptById(DeptDTO deptDTO);
}
